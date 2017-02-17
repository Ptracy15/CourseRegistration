<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Number of Registered Classes</title>
	
	<style>
	body {
  font-family: 'Helvetica Neue', Helvetica, Arial;
  font-size: 14px;
  line-height: 20px;
  font-weight: 400;
  color: #333;
  -webkit-font-smoothing: antialiased;
  font-smoothing: antialiased;
  background: #fff;
	}
		.styleTable{   
   border-collapse:collapse;
   border:1px solid #fff;
	}

	.styleTableHeader{
   text-align:center;
   font-weight: 900;
   color: #ffffff;
   background: #ea6153;
   border-bottom:1px solid #fff;  
   padding:2px;
	}

	.styleableOddRow{
   text-align:center;
   color: #3b3b3b;
   background: #e9e9e9; 
	}

	.styleTableEvenRow{
   text-align:center;
   color: #3b3b3b;
   background: #f6f6f6;
	}
	</style>

	
</head>
<body>

<f:view>
<center>

<h:dataTable value="#{course.userTotalCourse}" var="a" border="1"
	         styleClass="styleTable"
         headerClass="styleTableHeader"
         rowClasses="styleableOddRow,styleTableEvenRow">
	<f:facet name="header">
        <h:outputText value="Total Courses" />
    </f:facet>
    <h:column>
    <h:outputText value="#{a.totalCourse}"/>
    	</h:column>
</h:dataTable>

	<h:form>
	<br />
		<h:commandButton id="back" value="Back"
					action="#{ac.goBackToMainMenu}" />
					
	</h:form>
	
	</center>				
</f:view>
</body>
</html>