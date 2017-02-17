package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.*;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name="register_bean")
@RequestScoped
public class Register {

	private String firstname;
	private String lastname;
	private int userID;
	private String password;
	private String major;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	Connection con;
    Statement ps;
    int rs;
    String SQL;
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	 public String register() {
		 try
	        {
			 	Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
	            ps = con.createStatement();
	            SQL="INSERT INTO registration.users(UserID,FirstName,LastName,Password,Major)" +
                " VALUES('"+userID+"','"+firstname+"','"+lastname+"','"+password+"','"+major+"');";
                ps.executeUpdate(SQL);
                
	            return "valid";
	        } catch (SQLIntegrityConstraintViolationException e) {
	        	 message = ("Duplicate ID. Please Login or enter another User ID");
	        	 return "invalid";    
	        }  catch(Exception ex)   {
	            ex.printStackTrace();
	            System.out.println("Exception Occur :" + ex);
	            return "invalid";
	        } finally {
	             try { ps.close(); } catch (Exception e) { /* ignored */ }
	             try { con.close(); } catch (Exception e) { /* ignored */ }
	        }
	    }
	 }

