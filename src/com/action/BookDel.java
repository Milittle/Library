package com.action;

import com.bean.BorrowinfoBean;
import com.dao.BookDao;
import com.dao.BorrowinfoDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 米泽双 on 2015/12/14.
 */
public class BookDel extends ActionSupport {
    private String Book_ID;
    private List<BorrowinfoBean> list;

    public List<BorrowinfoBean> getList() {
        return list;
    }

    public void setList(List<BorrowinfoBean> list) {
        this.list = list;
    }

    public String getBook_ID() {return Book_ID;}

    public void setBook_ID(String book_ID) {Book_ID = book_ID;}
    public String execute() throws Exception {

        //解决乱码，用于页面输出
        HttpServletResponse response=null;
        response= ServletActionContext.getResponse();
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
        //验证是否被借出去
        list=new BorrowinfoDao().GetList("Book_ID='"+Book_ID+"'","");
        if(list.size()>0)
        {
            out.print("<script language='javascript'>alert('图书有借出记录！无法进行删除！');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        //删除
        new BookDao().Delete("Book_ID='"+Book_ID+"'");
        out.println("<script language='javascript'>alert('删除成功!');window.location='BookManager.action';</script>");
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
