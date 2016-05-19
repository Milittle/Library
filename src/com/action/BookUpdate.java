package com.action;

import com.bean.BookBean;
import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

/**
 * Created by 米泽双 on 2015/12/13.
 */
public class BookUpdate extends ActionSupport {
    //下面是Action内用于封装用户请求参数的属性
    private String Book_ID;
    private BookBean cnbean;
    public String getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(String BookID) {
        Book_ID = BookID;
    }

    public BookBean getCnbean() {
        return cnbean;
    }

    public void setCnbean(BookBean cnbean) {
        this.cnbean = cnbean;
    }

    //处理用户请求的execute方法
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
            out.flush();
            out.close();
            return null;
        }

        //查询
        cnbean=new BookDao().GetBean(Integer.parseInt(Book_ID));
        return SUCCESS;

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
