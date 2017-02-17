package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name ="ac")
@SessionScoped
public class AvailableCourse {
	private UserBean userInfo;
    Connection con;
    Statement ps;
    ResultSet rs1;
    String SQL1;
    
	public ArrayList<CourseBean> getCourse() {
	
		ArrayList<CourseBean> al = new ArrayList<CourseBean>();
		
	    Connection con;
	    Statement ps;
	    ResultSet rs;
	    String SQL_Str;
	    try
        {
		  Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
          ps = con.createStatement();
          SQL_Str="Select * from registration.course";
          rs=ps.executeQuery(SQL_Str);
          boolean found = false;
          
          
          while (rs.next()) {
        	  
      		CourseBean courseBean = new CourseBean();
      		courseBean.setCourseID(rs.getString(1).toString());
      		courseBean.setSemester(rs.getString(2).toString());
      		courseBean.setYear(rs.getString(3).toString());
      		courseBean.setRequirement(rs.getString(4).toString());
      		courseBean.setCapacity(rs.getString(5).toString());
      		courseBean.setEnrolled(rs.getString(6).toString());
      		courseBean.setCourseName(rs.getString(7).toString());
      		al.add(courseBean);
      		
      		found = true;
          	}
        	    try { rs.close(); } catch (Exception e) { /* ignored */ }
        	    try { ps.close(); } catch (Exception e) { /* ignored */ }
        	    try { con.close(); } catch (Exception e) { /* ignored */ }
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
          }  catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
            return (null);
        } 
    }
	
	public ArrayList<CourseBean> getUserTotalCourse() {
	    
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		ArrayList<CourseBean> count = new ArrayList<CourseBean>();
		
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL1="SELECT COUNT(*) AS countcheck FROM registration.registration WHERE userID="+userInfo.userID+";";
            rs1=ps.executeQuery(SQL1);
            boolean found = false;
            
            while (rs1.next()){
                CourseBean courseBean2 = new CourseBean();
           		courseBean2.setTotalCourse(rs1.getInt(1));
           		count.add(courseBean2);
                
                found = true;
            } if (found) {
                return count;
            } else {
                return count; // no entires found
            }
            
		}  catch(Exception ex)   {
        ex.printStackTrace();
        System.out.println("Exception Occur :" + ex); 
        return count;
		} finally {
            if (rs1 != null) {
                try {
                    rs1.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }
	
	public String goBackToMainMenu() {
		return "mainmenu";
	}
}
