package com.action;

import com.bean.BookBean;
import com.bean.BorrowinfoBean;
import com.bean.StudentBean;
import com.dao.BookDao;
import com.dao.BorrowinfoDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 米泽双 on 2015/12/16.
 */
public class Borrow extends ActionSupport{
    private String Book_ID;

    public String getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(String book_ID) {
        Book_ID = book_ID;
    }

    public String execute()throws Exception {

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
        List<BorrowinfoBean> list=new BorrowinfoDao().GetList("Book_ID='"+Book_ID+"' and Student_ID='"+session.getAttribute("id")+"'", "");
        if(list.size()>0) {
            out.print("<script language='javascript'>alert('你已经借阅了此书！不能在借阅此书');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }

        //查看该登陆学生借书是否达到上限
        StudentBean cnbean2=new StudentDao().GetBean(Integer.parseInt((String)session.getAttribute("id")));
        if(cnbean2.getStudent_Up()==0){
            out.print("<script language='javascript'>alert('你借阅书籍已达上限！无法在进行借阅书籍！');history.back(-1);</script>");
            out.flush();
            out.close();
            return null;
        }
        BookBean cnbean1=new BookDao().GetBean(Integer.parseInt(Book_ID));
        cnbean1.setBook_Balance(cnbean1.getBook_Balance()-1);
        new BookDao().Update(cnbean1);
        cnbean2.setStudent_Up(cnbean2.getStudent_Up()-1);
        new StudentDao().Update(cnbean2);
        BorrowinfoBean cnbean3=new BorrowinfoBean();
        cnbean3.setBook_ID(cnbean1.getBook_ID());
        cnbean3.setBook_Isbn(cnbean1.getBook_Isbn());
        cnbean3.setBook_Name(cnbean1.getBook_Name());
        cnbean3.setBook_Type(cnbean1.getBook_Type());
        cnbean3.setStudent_ID(cnbean2.getStudent_ID());
        cnbean3.setStudent_Username(cnbean2.getStudent_Username());
        cnbean3.setStudent_Name(cnbean2.getStudent_Name());
        new BorrowinfoDao().Add(cnbean3);

        out.print("<script language='javascript'>alert('借书成功！');window.location='BorrowManager.action';</script>");
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
