package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean
@SessionScoped
public class UserBean implements HttpSessionBindingListener {
	
	public String firstname;
	public String lastname;
	public String userID;
	public String major;
	
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	// All logins.
    private static Map<UserBean, HttpSession> logins = new ConcurrentHashMap<>();

    @Override
    public boolean equals(Object other) {
        return (other instanceof UserBean) && (userID != null) ? userID.equals(((UserBean) other).userID) : (other == this);
    }

    @Override
    public int hashCode() {
        return (userID != null) ? (this.getClass().hashCode() + userID.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = logins.remove(this);
        if (session != null) {
            session.invalidate();
        }
        logins.put(this, event.getSession());
        System.out.println(logins);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logins.remove(this);
    }
}
