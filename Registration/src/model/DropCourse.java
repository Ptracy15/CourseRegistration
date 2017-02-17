package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name="drop_course")
@SessionScoped
public class DropCourse {

   	private String DropID;
	
    Connection con;
    Statement ps;
    int rs;
    String SQL;
    String SQL2;
    
	private UserBean userInfo;
	
	public String getDropID() {
		return DropID;
	}
	public void setDropID(String dropID) {
		DropID = dropID;
	}

	public String dropCourse() {
	    FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL="DELETE FROM registration.registration WHERE UserID ='"+userInfo.userID+"' AND CourseID ='"+DropID+"';";
            rs=ps.executeUpdate(SQL);
           
            
            if (rs == 0) {
            	   // handle no update
            	FacesContext.getCurrentInstance().addMessage("dropform:dropbutton", new FacesMessage("You are not registered for that Course."));
            	}
            
            else {
            	 SQL2="UPDATE registration.course SET Enrolled = Enrolled - 1 WHERE CourseID='"+DropID+"';";
            	 ps.executeUpdate(SQL2);

             	FacesContext.getCurrentInstance().addMessage("dropform:dropbutton", new FacesMessage("Successful Drop."));
            }
            
            return "valid";
            
        }  catch(Exception ex)   {
            ex.printStackTrace();
        	FacesContext.getCurrentInstance().addMessage("dropform:dropbutton", new FacesMessage("You are not registered for that Course."));
            System.out.println("Exception Occur :" + ex);
            
            return "invalid";
        } finally {
             try { ps.close(); } catch (Exception e) { /* ignored */ }
             try { con.close(); } catch (Exception e) { /* ignored */ }
        }
    }

	public String goBackToMainMenu() {
		return "mainmenu";
	}
 }

