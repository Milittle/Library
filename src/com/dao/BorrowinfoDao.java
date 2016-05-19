package com.dao;

import com.bean.*;
import com.db.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 米泽双 on 2015/12/16.
 */

public class BorrowinfoDao {

    //获取列表
    public List<BorrowinfoBean> GetList(String strwhere,String strorder){
        String sql="select * from borrowinfo";
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
        List<BorrowinfoBean> list=new ArrayList<BorrowinfoBean>();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                BorrowinfoBean cnbean=new BorrowinfoBean();
                cnbean.setBook_ID(rs.getInt("Book_ID"));
                cnbean.setBook_Isbn(rs.getString("Book_Isbn"));
                cnbean.setBook_Name(rs.getString("Book_Name"));
                cnbean.setBook_Type(rs.getString("Book_Type"));
                cnbean.setStudent_ID(rs.getInt("Student_ID"));
                cnbean.setStudent_Username(rs.getString("Student_Username"));
                cnbean.setStudent_Name(rs.getString("Student_Name"));
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
    public BorrowinfoBean GetBean(int id){
        String sql="select * from borrowinfo where Book_ID="+id;
        Statement stat = null;
        ResultSet rs = null;
        Connection conn = new DBHelper().getConn();
        BorrowinfoBean cnbean=new BorrowinfoBean();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cnbean.setBook_ID(rs.getInt("Book_ID"));
                cnbean.setBook_Isbn(rs.getString("Book_Isbn"));
                cnbean.setBook_Name(rs.getString("Book_Name"));
                cnbean.setBook_Type(rs.getString("Book_Type"));
                cnbean.setStudent_ID(rs.getInt("Student_ID"));
                cnbean.setStudent_Username(rs.getString("Student_Username"));
                cnbean.setStudent_Name(rs.getString("Student_Name"));
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
    public void Add(BorrowinfoBean cnbean){
        String sql="insert into borrowinfo(";
        sql+="Book_ID,Book_Isbn,Book_Name,Book_Type,Student_ID,Student_Username,Student_Name";
        sql+=") values(";
        sql+=cnbean.getBook_ID()+",'"+cnbean.getBook_Isbn()+"','"+cnbean.getBook_Name()+"','"+cnbean.getBook_Type()+"',"+cnbean.getStudent_ID()+",'"+cnbean.getStudent_Username()+"','"+cnbean.getStudent_Name()+"'";
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
    public void Update(BorrowinfoBean cnbean){
        String sql="update borrowinfo set ";
        sql+="Book_ID='"+cnbean.getBook_ID()+"',";
        sql+="Book_Isbn='"+cnbean.getBook_Isbn()+"',";
        sql+="Book_Name='"+cnbean.getBook_Name()+"',";
        sql+="Book_Type='"+cnbean.getBook_Type()+"',";
        sql+="Student_ID='"+cnbean.getStudent_ID()+"',";
        sql+="Student_Username='"+cnbean.getStudent_Name()+"',";
        sql+="Student_Name='"+cnbean.getStudent_Name()+"'";

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
        String sql="delete from borrowinfo where ";
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
