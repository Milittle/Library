package com.bean;

/**
 * Created by 米泽双 on 2015/12/13.
 */
public class StudentBean {

    private int Student_ID ;
    private String Student_Username ;
    private String Student_Password ;
    private String Student_Name ;
    private String Student_Sex ;
    private String Student_Professional ;
	private int Student_Up;

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int studentID) {
		Student_ID = studentID;
	}

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String studentUsername) {Student_Username = studentUsername;}

	public String getStudent_Password() {
		return Student_Password;
	}

	public void setStudent_Password(String studentPassword) {
		Student_Password = studentPassword;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String studentName) {
		Student_Name = studentName;
	}

	public String getStudent_Sex() {
		return Student_Sex;
	}

	public void setStudent_Sex(String studentSex) {
		Student_Sex = studentSex;
	}

	public String getStudent_Professional() {return Student_Professional;}

	public void setStudent_Professional(String studentProfessional) {
		Student_Professional = studentProfessional;
	}

	public int getStudent_Up() {return Student_Up;}

	public void setStudent_Up(int student_Up) {Student_Up = student_Up;}
}
