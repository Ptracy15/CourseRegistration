<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css' />
	<link rel="stylesheet" href="css/style2.css" />
	
    <body>
          <f:view>
  <div class="login">
    <div class="login-screen">
      <div class="app-title">
        <h1>Login Menu</h1>
      </div>

      <div class="login-form">
        <div class="control-group">
            <h:form id="login_frm">
                  <tr>
                      <td colspan="2">
                            <h:message for="username" styleClass="errorMsg"/><br>
                            <h:message for="password" styleClass="errorMsg"/>
                        </td>
                  </tr>
        <div class="control-group">
        			<label for="username"  style="login-link">User ID</label>
			<br/>
         <h:inputText id="username" value="#{login_bean.username}" required="true" styleClass="login-field"/>
			
			</div>
        <div class="control-group">
      			 	<label for="password" style="login-link">Password</label>
			<br/>
                    <h:inputSecret id="password" value="#{login_bean.password}" required="true" styleClass="login-field"/>
                    
			</div>
                  <tr>
                      <td colspan="2" align="center">
                          <h:commandButton action="#{login_bean.checkValidUser}" styleClass="btn btn-primary btn-large btn-block" value="Login" type="submit"/></td>
                  </tr>

			<div>
				<p class="login-link">Not registered? <a href="register.jsp">Create an account</a></p>
                <h:outputText styleClass="login-link" value="Status: " />
				<h:outputText styleClass="login-link-red" value="#{login_bean.message}" />
            </div>
            </h:form>
        </div>
  	</div>
     </div>
	</div>
        </f:view>
        
    </body>
</html>