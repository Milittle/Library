package com.dao;

import com.bean.BookBean;
import com.bean.StudentBean;
import com.db.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 米泽双 on 2015/12/13.
 */
public class BookDao {

    //获取数据列表
    public List<BookBean> GetList(String strwhere,String strorder){
        String sql="select * from bookinfo";
        if(!(isInvalid(strwhere)))
        {
            sql+=" where "+strwhere;
        }
        if(!(isInvalid(strorder)))
        {
            sql+=" order by "+strorder;
        }
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        List<BookBean> list=new ArrayList<BookBean>();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                BookBean cnbean=new BookBean();
                cnbean.setBook_ID(rs.getInt("Book_ID"));
                cnbean.setBook_Isbn(rs.getString("Book_Isbn"));
                cnbean.setBook_Name(rs.getString("Book_Name"));
                cnbean.setBook_Balance(rs.getInt("Book_Balance"));
                cnbean.setBook_Type(rs.getString("Book_Type"));
                cnbean.setBook_Price(rs.getDouble("Book_Price"));
                cnbean.setBook_Author(rs.getString("Book_Author"));
                list.add(cnbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //获取指定ID的实体Bean
    public BookBean GetBean(int id){
        String sql="select * from bookinfo where Book_ID="+id;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        BookBean cnbean=new BookBean();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cnbean.setBook_ID(rs.getInt("Book_ID"));
                cnbean.setBook_Isbn(rs.getString("Book_Isbn"));
                cnbean.setBook_Name(rs.getString("Book_Name"));
                cnbean.setBook_Type(rs.getString("Book_Type"));
                cnbean.setBook_Price(rs.getDouble("Book_Price"));
                cnbean.setBook_Balance(rs.getInt("Book_Balance"));
                cnbean.setBook_Author(rs.getString("Book_Author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cnbean;
    }

    //添加
    public void Add(BookBean cnbean){
        String sql="insert into bookinfo(";
        sql+="Book_Isbn,Book_Name,Book_Type,Book_Price,Book_Balance,Book_Author";
        sql+=") values(";
        sql+="'"+cnbean.getBook_Isbn()+"','"+cnbean.getBook_Name()+"','"+cnbean.getBook_Type()+"',"+cnbean.getBook_Price()+","+cnbean.getBook_Balance()+",'"+cnbean.getBook_Author()+"'";
        sql+=")";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //修改
    public void Update(BookBean cnbean){
        String sql="update bookinfo set ";
        sql+="Book_Isbn='"+cnbean.getBook_Isbn()+"',";
        sql+="Book_Name='"+cnbean.getBook_Name()+"',";
        sql+="Book_Type='"+cnbean.getBook_Type()+"',";
        sql+="Book_Balance='"+cnbean.getBook_Balance()+"',";
        sql+="Book_Price='"+cnbean.getBook_Price()+"',";
        sql+="Book_Author='"+cnbean.getBook_Author()+"'";

        sql+=" where Book_Id='"+cnbean.getBook_ID()+"'";
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //删除
    public void Delete(String strwhere){
        String sql="delete from bookinfo where ";
        sql+=strwhere;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
