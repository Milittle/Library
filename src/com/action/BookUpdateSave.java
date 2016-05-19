package com.action;

import com.bean.BookBean;
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
 * Created by 米泽双 on 2015/12/13.
 */
public class BookUpdateSave extends ActionSupport {
    private String Book_ID;
    private String Book_Isbn;
    private String Book_Name;
    private String Book_Balance;
    private String Book_Type;
    private Double Book_Price;

    public String getBook_ID() {return Book_ID;}

    public void setBook_ID(String book_ID) {Book_ID = book_ID;}

    public String getBook_Isbn() {return Book_Isbn;}

    public void setBook_Isbn(String book_Isbn) {Book_Isbn = book_Isbn;}

    public String getBook_Name() {return Book_Name;}

    public void setBook_Name(String book_Name) {Book_Name = book_Name;}

    public String getBook_Balance() {return Book_Balance;}

    public void setBook_Balance(String book_Balance) {Book_Balance = book_Balance;}

    public String getBook_Type() {return Book_Type;}

    public void setBook_Type(String book_Type) {Book_Type = book_Type;}

    public Double getBook_Price() {return Book_Price;}

    public void setBook_Price(Double book_Price) {Book_Price = book_Price;}

    public String execute() throws Exception {
        HttpServletResponse response = null;
        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //创建session对象
        HttpSession session = ServletActionContext.getRequest().getSession();

        //验证是否正常登录
        if (session.getAttribute("id") == null) {
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }

        //查询图书名是否存在
        List<BookBean> list=new BookDao().GetList("Book_Isbn='"+Book_Isbn+"' and "+"Book_ID!='"+Book_ID+"'", "");
        if(list.size()>0) {
            out.print("<script language='javascript'>alert('图书已经存在！不能修改与它相同的属性！');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }

        //更新bookinfo表中的数据
        BookBean cnbean=new BookBean();
        cnbean=new BookDao().GetBean(Integer.parseInt(Book_ID));
        cnbean.setBook_Isbn(Book_Isbn);
        cnbean.setBook_Name(Book_Name);
        cnbean.setBook_Type(Book_Type);
        cnbean.setBook_Balance(Integer.parseInt(Book_Balance));
        cnbean.setBook_Price(Book_Price);
        new BookDao().Update(cnbean);

        //如果借书表里有该书信息，更新Borrowinfo表里的信息
        List<BorrowinfoBean> list1;
        list1=new BorrowinfoDao().GetList("Book_ID='"+Book_ID+"'","");
        if(list1.size()>0)
        {
            for(int i=0;i<list1.size();i++)
            {
                BorrowinfoBean cnbean1=new BorrowinfoBean();
                cnbean1=list1.get(i);
                cnbean1.setBook_Isbn(Book_Isbn);
                cnbean1.setBook_Name(Book_Name);
                cnbean1.setBook_Type(Book_Type);
                new BorrowinfoDao().Update(cnbean1);
            }
        }

        //跳转
        out.print("<script language='javascript'>alert('修改成功！');window.location='BookManager.action';</script>");
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
