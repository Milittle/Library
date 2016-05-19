package com.bean;

/**
 * Created by 米泽双 on 2015/12/16.
 */
public class BorrowinfoBean {
    private int Book_ID;
    private int Student_ID;
    private String Book_Isbn;
    private String Book_Name;
    private String Book_Type;
    private String Student_Username;
    private String Student_Name;

    public int getBook_ID() {return Book_ID;}

    public void setBook_ID(int book_ID) {Book_ID = book_ID;}

    public int getStudent_ID() {return Student_ID;}

    public void setStudent_ID(int student_ID) {Student_ID = student_ID;}

    public String getBook_Isbn() {
        return Book_Isbn;
    }

    public void setBook_Isbn(String book_Isbn) {
        Book_Isbn = book_Isbn;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getBook_Type() {
        return Book_Type;
    }

    public void setBook_Type(String book_Type) {
        Book_Type = book_Type;
    }

    public String getStudent_Username() {
        return Student_Username;
    }

    public void setStudent_Username(String student_Username) {
        Student_Username = student_Username;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }
}
