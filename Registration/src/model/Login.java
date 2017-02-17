package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Map;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name="login_bean")
@SessionScoped
public class Login {
    private String username;
    private String password;
    private String dbusername;
	private String message;	
    
    public String getDbpassword() {
        return dbpassword;
    }
    public String getDbusername() {
        return dbusername;
    }
 
    private String dbpassword;
    Connection con;
    Statement ps;
    ResultSet rs;
    String SQL_Str;
	
    ResultSet rs2;
    String SQL2;
    
    public void dbData(String UName)
    {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> userdata = context.getExternalContext().getSessionMap();
		
		
        try
        {
    		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://rds.amazonaws.com:3306","UserName","Password");
            ps = con.createStatement();
            SQL_Str="Select * from registration.users where UserID like ('" + UName +"')";
            rs=ps.executeQuery(SQL_Str);
            
            while (rs.next()) {
            dbusername=rs.getString(1).toString();
            dbpassword=rs.getString(4).toString();
           
    		
    		UserBean userBean = new UserBean();
    		userBean.setUserID(rs.getString(1).toString());
    		userBean.setMajor(rs.getString(5).toString());
    		userdata.put("userBean", userBean);
    		
        }
    		

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
        } finally {
        	 try { rs.close(); } catch (Exception e) { /* ignored */ }
             try { ps.close(); } catch (Exception e) { /* ignored */ }
             try { con.close(); } catch (Exception e) { /* ignored */ }
        }
    }
    
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }

    public String checkValidUser()
    {	
        dbData(username);
        if(username.equalsIgnoreCase(dbusername))
        {
 
            if(password.equals(dbpassword)) {

        		FacesContext context = FacesContext.getCurrentInstance();
        		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

            	session.setAttribute("UserID", dbusername);
            	
            	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            	Map<String, Object> sessionMap = externalContext.getSessionMap();
            	sessionMap.put("UserID", dbusername);
                return "valid";

           } else {
            	message = ("Invalid Password");
            	return "invalid";
            }
        } else {
        	message = ("Invalid UserID");
            return "invalid";
        }
    }

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}