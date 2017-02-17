package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name ="vr")
@SessionScoped
public class ViewRegistered {	
	
	private UserBean userInfo;
	private String message;
    Connection con;
    Statement ps;
    ResultSet rs;
    String SQL_Str;
    
	public ArrayList<RegisteredCourseBean> getRegisteredCourse() {
        
		ArrayList<RegisteredCourseBean> al = new ArrayList<RegisteredCourseBean>();

	    FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");

	    try
        {
		  Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
          ps = con.createStatement();
          SQL_Str="SELECT a.CourseID, a.CourseName FROM registration.course a INNER JOIN registration.registration o ON o.UserID="+userInfo.getUserID()+" and o.CourseID=a.CourseID;";

          rs=ps.executeQuery(SQL_Str);
          boolean found = false;
          
          while (rs.next()) {
        	  
        	RegisteredCourseBean courseBean = new RegisteredCourseBean();
      		courseBean.setCourseID(rs.getString(1).toString());
      		courseBean.setCourseName(rs.getString(2).toString());
      		al.add(courseBean);
      		
      		found = true;
          	}
          try { rs.close(); } catch (Exception e) { /* ignored */ }
          try { ps.close(); } catch (Exception e) { /* ignored */ }
          try { con.close(); } catch (Exception e) { /* ignored */ }
            if (found) {
                return al;
            } else {
            	message = ("You are not registerd for any courses"); 
                return null; // no entires found
            }
          }  catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
            return (null);
        } 
    }
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
	public String goBackToMainMenu() {
		return "mainmenu";
	}
	   
}
