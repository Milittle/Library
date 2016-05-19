package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.dao.*;
import com.bean.*;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 米泽双 on 2015/12/16.
 */
public class ReturnManager extends ActionSupport {
    private List<BorrowinfoBean> list;
    private String SearchRow;
    private String SearchKey;

    public List<BorrowinfoBean> getList() {
        return list;
    }

    public void setList(List<BorrowinfoBean> list) {
        this.list = list;
    }

    public String getSearchRow() {
        return SearchRow;
    }

    public void setSearchRow(String searchRow) {
        SearchRow = searchRow;
    }

    public String getSearchKey() {
        return SearchKey;
    }

    public void setSearchKey(String searchKey) {
        SearchKey = searchKey;
    }

    public String execute()throws Exception {

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

        //查询条件
        String strWhere="1=1";
        if(!(isInvalid(SearchKey)))
        {
            strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
        }
        if(session.getAttribute("type").equals("1"));
        else{
            strWhere+=" and Student_ID='"+session.getAttribute("id")+"'";
        }
        //查询所有
        list=new BorrowinfoDao().GetList(strWhere,"");
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
