package model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name ="registeredcourse")
@SessionScoped
public class RegisteredCourseBean {
	
	public String courseID;
	public String courseName;
	
	
	ViewRegistered vr = new ViewRegistered();
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	public ArrayList<RegisteredCourseBean> getMessages() {
        return vr.getRegisteredCourse();
    }


}
