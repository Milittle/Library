package com.action;

import com.bean.BookBean;
import com.bean.StudentBean;
import com.dao.BookDao;
import com.dao.BorrowinfoDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by 米泽双 on 2015/12/17.
 */
public class Return extends ActionSupport {
    private String Book_ID;

    public String getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(String book_ID) {
        Book_ID = book_ID;
    }
    public String execute()throws Exception{

        HttpServletResponse response=null;
        response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();

        //创建会话
        HttpSession session=ServletActionContext.getRequest().getSession();

        //验证是否正常登陆
        if(session.getAttribute("id")==null) {
            out.println("<script language='javascript'>alert('请重新登陆！');windows.location='Login.jsp';</script>");
            out.flush();
            out.close();
            return null;
        }
        StudentBean cnbean1=new StudentDao().GetBean(Integer.parseInt((String) session.getAttribute("id")));
        cnbean1.setStudent_Up(cnbean1.getStudent_Up()+1);
        new StudentDao().Update(cnbean1);
        BookBean cnbean2=new BookDao().GetBean(Integer.parseInt(Book_ID));
        cnbean2.setBook_Balance(cnbean2.getBook_Balance() + 1);
        new BookDao().Update(cnbean2);
        new BorrowinfoDao().Delete("Book_ID='"+Book_ID+"'");

        out.println("<script language='javascript'>alert('还书成功！');window.location='ReturnManager.action';</script>");
        out.flush();
        out.close();
        return null;
    }
}
