package com.action;

/**
 * Created by 米泽双 on 2015/12/13.
 */
import com.bean.BookBean;
import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

public class BookManager extends ActionSupport{
    //下面是Actin内用于封装用户请求参数的属性
    private List<BookBean> list;

    public List<BookBean> getList() {return list;}

    public void setList(List<BookBean> list) {this.list = list;}

    private String SearchRow;
    private String SearchKey;

    public String getSearchRow() {return SearchRow;}

    public void setSearchRow(String searchRow) {SearchRow = searchRow;}

    public String getSearchKey() {return SearchKey;}

    public void setSearchKey(String searchKey) {SearchKey = searchKey;}

    public String execute()throws Exception {
        HttpServletResponse response=null;
        response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //创建session对象
        HttpSession session = ServletActionContext.getRequest().getSession();
        //验证是否正常登录
        if(session.getAttribute("id")==null||!session.getAttribute("type").equals("1")){
            out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
            out.flush();out.close();return null;
        }
        //查询条件
        String strWhere="1=1";
        if(!(isInvalid(SearchKey)))
        {
            strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
        }
        //查询所有
        list=new BookDao().GetList(strWhere,"Book_Name");
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
