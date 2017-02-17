package model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name ="course")
@SessionScoped
public class CourseBean {

	public String courseID;
	public String semester;
	public String year;
	public String requirement;
	public String capacity;
	public String enrolled;
	public String courseName;
	public int totalCourse;
	
	AvailableCourse ac = new AvailableCourse();
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(String enrolled) {
		this.enrolled = enrolled;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTotalCourse() {
		return totalCourse;
	}
	public void setTotalCourse(int totalCourse) {
		this.totalCourse = totalCourse;
	}
	public ArrayList<CourseBean> getMessages() {
        return ac.getCourse();
    }
	
	public ArrayList<CourseBean> getUserTotalCourse() {
		return ac.getUserTotalCourse();
	}


}
	
