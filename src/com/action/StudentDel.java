package com.action;
/**
 * Created by 米泽双 on 2015/12/13.
 */
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class StudentDel extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Student_ID ;
	private List<BorrowinfoBean> list;

	public List<BorrowinfoBean> getList() {
		return list;
	}

	public void setList(List<BorrowinfoBean> list) {
		this.list = list;
	}

	public String getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(String userID) {
		Student_ID = userID;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		//验证读者是否有借书记录，如果有不能删除读者
		list=new BorrowinfoDao().GetList("Student_ID='"+Student_ID+"'","");
		if(list.size()>0)
		{
			out.println("<script language='javascript'>alert('此读者有借书记录！不能删除！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		
		//删除
		new StudentDao().Delete("Student_ID="+Student_ID);
		out.println("<script language='javascript'>alert('删除成功！');window.location='StudentManager.action';</script>");
		out.flush();
		out.close();
		return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
