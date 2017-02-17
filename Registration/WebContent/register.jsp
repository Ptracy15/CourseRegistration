<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Menu</title>
    </head>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css' />
	<link rel="stylesheet" href="css/style2.css" />
	
    <body> 

        <f:view>
        <div class="login">
    <div class="login-screen">
      <div class="app-title">
        <h1>Register Menu</h1>
      </div>

      <div class="login-form">
        <div class="control-group">
            <h:form id="register_form">
                <!--  First Name -->
      			  <div class="control-group">
        			<label for="firstname"  style="login-link">First Name</label>
						<br/>
			<h:inputText id="firstname" value="#{register_bean.firstname}" required="true" styleClass="login-field">
                        <f:validateLength minimum="1" maximum="15" />
                    </h:inputText>
                    <h:message for="firstname" style="color:red" />
          </div>
				<!--  Last Name -->                 
      			  <div class="control-group">
        			<label for="lastname"  style="login-link">Last Name</label>
						<br/>
                    <h:inputText id="lastname" value="#{register_bean.lastname}" required="true" styleClass="login-field">
 						 <f:validateLength minimum="1" maximum="15" />
                    </h:inputText>
                    <h:message for="lastname" style="color:red" />
          </div>
				<!--  UserID -->                    
      			  <div class="control-group">
        			<label for="userID"  style="login-link">User ID</label>
						<br/>
						<h:inputText id="userID" value="#{register_bean.userID}" required="true" styleClass="login-field">
                    <f:validateLength minimum="6" maximum="12" />
                    </h:inputText>
                    <h:message for="userID" style="color:red" />
          </div>
 				<!--  Password -->                  	
       			  <div class="control-group">
        			<label for="password"  style="login-link">Password</label>
						<br/>
						<h:inputSecret id="password" value="#{register_bean.password}" required="true" styleClass="login-field">
                    <f:validateLength minimum="6" maximum="12" />
                    </h:inputSecret>
                    <h:message for="password" style="color:red" />
          </div>
 				<!--  Major -->                  	
                  <tr>
                    <td><h:outputText value="Major: "/></td>
                    <td>
                    <h:selectOneMenu value="#{register_bean.major}">
						<f:selectItem itemValue="Accounting" itemLabel="Accounting"/>
						<f:selectItem itemValue="Finance" itemLabel="Finance"/>
						<f:selectItem itemValue="Marketing" itemLabel="Marketing"/>
					</h:selectOneMenu>
                    </td>
                  </tr>
                  <br />
                  <br />
                  <tr>
                      <td colspan="2" align="center">
                          <h:commandButton action="#{register_bean.register}" styleClass="btn btn-primary btn-large btn-block" value="Register" type="submit"/></td>
                  </tr>
                  
                  <p class="login-link">Already registered? <a href="login.jsp">Sign In</a></p>
                  <h:outputText styleClass="login-link" value="Status: " />
                  <h:outputText styleClass="login-link-red" value="#{register_bean.message}" />
            </h:form>
                    </div>
  		</div>
     </div>
	</div>
        </f:view>
        
</body>
</html>