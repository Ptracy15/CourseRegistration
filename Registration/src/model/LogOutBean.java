package model;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

//Created By: Paul Tracy, Jingsha Ni, Nathan Gill 

@ManagedBean(name="LogOutBean")
public class LogOutBean {

    
	public LogOutBean() {
		// TODO Auto-generated constructor stub
	}


	public String goLoginPage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.removeAttribute("UserID");
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	Map<String, Object> sessionMap = externalContext.getSessionMap();
    	sessionMap.remove("UserID");
    	
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index?faces-redirect=true";

	}

}
