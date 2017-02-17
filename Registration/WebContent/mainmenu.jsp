<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>

	<link href='http://fonts.googleapis.com/css?family=Quicksand:400,700' rel='stylesheet' type='text/css' />
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet" />
		<!--[if IE 7]>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome-ie7.min.css" rel="stylesheet" />
	<![endif]-->
	<style>
		body {
		background-color: #fff;
		margin:0;
		padding:0;
		font-family:Quicksand;
		font-weight:700;
	}

	ul.form {
		position:relative;
		background:#fff;
		width:300px;
		margin:auto;
		padding:0;
		list-style: none;
		overflow:hidden;
		
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
		border-radius: 5px;	
		
		-webkit-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
		-moz-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
		box-shadow:  1px 1px 10px rgba(0, 0, 0, 0.1);	
	}

	.form li a {
		width:275px;
		padding-left:20px;
		height:50px;
		line-height:50px;
		display:block;
		overflow:hidden;
		position:relative;
		text-decoration:none;
		text-transform:uppercase;
		font-size:14px;
		color:#686868;
		
		-webkit-transition:all 0.2s linear;
		-moz-transition:all 0.2s linear;
		-o-transition:all 0.2s linear;
		transition:all 0.2s linear;			
	}

	.form li a:hover {
		background:#efefef;
	}

	.form li a.profile {
		border-left:5px solid #008747;
	}

	.form li a.messages {
			border-left:5px solid #fecf54;
	}
		
	.form li a.settings {
			border-left:5px solid #cf2130;
	}

	.form li a.logout {
			border-left:5px solid #dde2d5;
	}	

	.form li:first-child a:hover, .form li:first-child a {
		-webkit-border-radius: 5px 5px 0 0;
		-moz-border-radius: 5px 5px 0 0;
		border-radius: 5px 5px 0 0;
	}

	.form li:last-child a:hover, .form li:last-child a {
		-webkit-border-radius: 0 0 5px 5px;
		-moz-border-radius: 0 0 5px 5px;
		border-radius: 0 0 5px 5px;
	}

	.form li a:hover i {
		color:#ea4f35;
	}

	.form i {
		margin-right:15px;
		
		-webkit-transition:all 0.2s linear;
		-moz-transition:all 0.2s linear;
		-o-transition:all 0.2s linear;
		transition:all 0.2s linear;	
	}

	.form em {
		font-size: 10px;
		background: #ea4f35;
		padding: 3px 5px;
		-webkit-border-radius: 10px;
		-moz-border-radius: 10px;
		border-radius: 10px;		
		font-style: normal;
		color: #fff;
		margin-top: 17px;
		margin-right: 15px;
		line-height: 10px;
		height: 10px;		
		float:right;
	}

	.form li.selected a {
		background:#efefef;
	}
			h1 {
		color:#333;
		margin:0 auto;
		margin-top:40px;
		margin-bottom:40px;
		font-size:30px;
		width:300px;
		text-align:center;
	}
	
	p {
		text-align:center;
		position:absolute;
		width:100%;
		bottom:0;
		font-size:12px;
		font-family:Arial, Helvetica;
		color:#fff;
		text-transform:uppercase;
	}
	p a {
		color:#fff;
		text-decoration:none;
	}
	</style>
	
</head>

<body>

		<f:view>
			<div align="center">
			
				<h:form> 
	<h1>Main Menu</h1>

	<ul class="form">
		<li><a class="profile" href="availablecourse.jsp"><i class="icon-user"></i>Available Courses/Register</a></li>
		<li><a class="messages" href="registeredcourse.jsp"><i class="icon-envelope-alt"></i>View Schedule/Drop</a></li>
	 	<li><a class="messages" href="totalclasses.jsp"><i class="icon-envelope-alt"></i>Total Classes</a></li>
		<li><h:commandLink action="#{LogOutBean.goLoginPage}" value="Logout" /> </li>
	</ul>
					</h:form>
	
			</div>
			
			<br />


			
		<div align="center">
       	 <table border="1" cellpadding="5" >
            <caption>Logged In As:</caption>
            <tr>
                <th>ID</th>
                <th>Major</th>
            </tr>
                <tr>
                    <td><h:outputText value="#{userBean.userID}" /></td>
                    <td><h:outputText value="#{userBean.major}" /></td>
                </tr>
       		 </table>
   		 </div>	
				
		</f:view>
		
</body>
</html>