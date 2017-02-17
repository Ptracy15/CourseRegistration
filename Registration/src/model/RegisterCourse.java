package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name="register_course")
@SessionScoped
public class RegisterCourse {

	private String message;
	private String RegisterID;	
    private String major;
    private int capacity;
    private int enrolled;
    int countcheck = 0;
    private List<String> classlist = new ArrayList<String>();
    
    Connection con;
    Statement ps;
    ResultSet rs2;
    ResultSet rs3;
    ResultSet rs4;
    String UpdateTable;
    String SQL;
    String SQL2;
    String SQL3; 
    String SQL4; 

	private UserBean userInfo;
	
	//Register the class to user 
	public Boolean registerCourse() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL="INSERT INTO registration.registration values('"+RegisterID+"','"+userInfo.userID+"');";
            ps.executeUpdate(SQL);
            System.out.println(SQL);
       
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
        	 return false;
        } catch(Exception ex)   {
            ex.printStackTrace();
            message = ("Error.");
            System.out.println("Exception Occur :" + ex);
            
            return false;
            
        } finally {
             try { ps.close(); } catch (Exception e) { /* ignored */ }
             try { con.close(); } catch (Exception e) { /* ignored */ }
        }
    }
	//update capacity
	public void updateCapacity() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            UpdateTable="UPDATE registration.course SET Enrolled = Enrolled + 1 WHERE CourseID='"+RegisterID+"';";
            ps.executeUpdate(UpdateTable);      
            
        }  catch(Exception ex)   {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
            
        } finally {
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

	//Check if major matches
	public void majorCheck() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL2="SELECT * from registration.course where CourseID = '"+RegisterID+"';";
            rs2=ps.executeQuery(SQL2);
            
            while (rs2.next()) {
            	major=rs2.getString(4).toString();
            	capacity=rs2.getInt(5);
            	enrolled=rs2.getInt(6);

            }
        } 
		catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
        } finally {
            if (rs2 != null) {
                try {
                    rs2.close();
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

	//Check Total number of classes 
	public void numberCheck() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL3="SELECT COUNT(*) AS countcheck FROM registration.registration WHERE userID="+userInfo.userID+";";
            rs3=ps.executeQuery(SQL3);
            
            while (rs3.next()){
                countcheck = rs3.getInt(1);
                
                CourseBean courseBean = new CourseBean();
                courseBean.setTotalCourse(rs3.getInt(1));
            }
            
		}  catch(Exception ex)   {
        ex.printStackTrace();
        System.out.println("Exception Occur :" + ex);        
		} finally {
            if (rs3 != null) {
                try {
                    rs3.close();
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
	
	public void checkExist() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		userInfo = (UserBean) m.get("userBean");
		try
        {
		 	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL4="SELECT courseID from registration.course;";
            rs4=ps.executeQuery(SQL4);
            ResultSetMetaData rsmd = rs4.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            while (rs4.next()){
            	for(int i=1; i<=columnsNumber; i++){
            		classlist.add(rs4.getString(1));
            	}
            }
            
		}  catch(Exception ex)   {
        ex.printStackTrace();
        System.out.println("Exception Occur :" + ex);    
		} finally {
            if (rs4 != null) {
                try {
                    rs4.close();
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
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRegisterID() {
		return RegisterID;
	}

	public void setRegisterID(String registerID) {
		RegisterID = registerID;
	}
	
	public int getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}
	public int getTotalClasses() {
		numberCheck();
		return countcheck;
	}
	public String checkRegistration() {
		numberCheck();
		if (countcheck < 5) {
			checkExist();
			if (classlist.contains(RegisterID)) {
				majorCheck();
				if (major.contains(userInfo.major) && capacity > enrolled) {
					if(registerCourse() == true) {
						registerCourse();
						updateCapacity();
						FacesContext.getCurrentInstance().addMessage("registerform:registerbutton", new FacesMessage("Successful Registration."));
						return "valid"; }
					else {
						FacesContext.getCurrentInstance().addMessage("registerform:registerbutton", new FacesMessage("You are already registered for that course."));
						return "invalid";
					}
				} else {
					FacesContext.getCurrentInstance().addMessage("registerform:registerbutton", new FacesMessage("Invalid Major or The Class is full."));
					return "invalid";
				}
			} else {
				FacesContext.getCurrentInstance().addMessage("registerform:registerbutton", new FacesMessage("Course ID Does not Exist."));
			return "invalid";	
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("registerform:registerbutton", new FacesMessage("You are Already Registered to 5 Classes."));
          	return "invalid";
		} 
	}

	public int getCountcheck() {
		return countcheck;
	}

	public void setCountcheck(int countcheck) {
		this.countcheck = countcheck;
	}
}
