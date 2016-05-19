package com.action;

/**
 * Created by 米泽双 on 2015/12/13.
 */
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;

public class BookAddSave extends ActionSupport {
    //下面是Action内用于封装用户请求参数的属性
    private String Book_Isbn;
    private String Book_Name;
    private String Book_Type;
    private String Book_Price;
    private String Book_Balance;
    private String Book_Author;

    public String getBook_Isbn() {return Book_Isbn;}

    public void setBook_Isbn(String book_Isbn) {Book_Isbn = book_Isbn;}

    public String getBook_Name() {return Book_Name;}

    public void setBook_Name(String book_Name) {Book_Name = book_Name;}

    public String getBook_Type() {return Book_Type;}

    public void setBook_Type(String book_Type) {Book_Type = book_Type;}

    public String getBook_Price() {return Book_Price;}

    public void setBook_Price(String book_Price) {Book_Price = book_Price;}

    public String getBook_Balance() {return Book_Balance;}

    public void setBook_Balance(String book_Balance) {Book_Balance = book_Balance;}

    public String getBook_Author() {return Book_Author;}

    public void setBook_Author(String book_Author) {Book_Author = book_Author;}

    //处理用户请求的execute()方法
    public String execute() throws Exception{
        HttpServletResponse response=null;
        response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=Utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();

        //创建session对象
        HttpSession session=ServletActionContext.getRequest().getSession();
        //验证是否正常登录
        if(session.getAttribute("id")==null){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();out.close();return null;
        }

        //查询图书名和ISBN是否存在
        List<BookBean> list=new BookDao().GetList("Book_Isbn='"+Book_Isbn+"'", "");
        if(list.size()>0)
        {
            out.print("<script language='javascript'>alert('该图书已存在！');history.back(-1);</script>");
            out.flush();out.close();return null;
        }
        //添加
        BookBean cnbean=new BookBean();
        cnbean.setBook_Isbn(Book_Isbn);
        cnbean.setBook_Name(Book_Name);
        cnbean.setBook_Type(Book_Type);
        cnbean.setBook_Price(Double.parseDouble(Book_Price));
        cnbean.setBook_Balance(Integer.parseInt(Book_Balance));
        cnbean.setBook_Author(Book_Author);
        new BookDao().Add(cnbean);

        //跳转
        out.print("<script language='javascript'>alert('添加成功！');window.location='BookManager.action';</script>");
        out.flush();out.close();return null;
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
