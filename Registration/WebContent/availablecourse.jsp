<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Courses</title>
	
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

	<h:dataTable value="#{course.messages}" var="o" border="1"
	         styleClass="styleTable"
         headerClass="styleTableHeader"
         rowClasses="styleableOddRow,styleTableEvenRow">
	<f:facet name="header">
        <h:outputText value="Available Courses for 2016" />
    </f:facet>
   		<h:column>
   		 <f:facet name="header">
            <h:outputText value="Course ID" />
        </f:facet>
    <h:outputText value="#{o.courseID}"/>
    	</h:column>
    	<h:column>
    	<f:facet name="header">
            <h:outputText value="Course Name" />
        </f:facet>
    <h:outputText value="#{o.courseName}"/>
   		 </h:column>
    	<h:column>
     	<f:facet name="header">
            <h:outputText value="Semester" />
        </f:facet>   	
    <h:outputText value="#{o.semester}"/>
   		 </h:column>
        <h:column>
    	<f:facet name="header">
            <h:outputText value="Year" />
        </f:facet>        
    <h:outputText value="#{o.year}"/>
   		 </h:column>
        <h:column>
    	<f:facet name="header">
            <h:outputText value="Requirement" />
        </f:facet>
    <h:outputText value="#{o.requirement}"/>
   		 </h:column>
        <h:column>
    	<f:facet name="header">
            <h:outputText value="Capacity" />
        </f:facet>
    <h:outputText value="#{o.capacity}"/>
   		 </h:column>
        <h:column>
    	<f:facet name="header">
            <h:outputText value="Enrolled" />
        </f:facet>
    <h:outputText value="#{o.enrolled}"/>
   		 </h:column>
</h:dataTable>
<br />

		<h:form id="registerform">
	<h:outputLabel>Enter Course ID to Register:</h:outputLabel>

                  <tr>
                    <td><h:inputText id="registerID" value="#{register_course.registerID}" required="true" onblur="value=value.toUpperCase()" styleClass="input_text"/></td>
                  </tr>		
				
				  <tr>
                      <td colspan="2" align="center">
                          <h:commandButton id="registerbutton" action="#{register_course.checkRegistration}" value="Submit" type="submit"/>
                          <h:message for="registerbutton" /></td>
                  </tr>
	</h:form>		
	
	<h:form>
	<br />
		<h:commandButton id="back" value="Back"
					action="#{ac.goBackToMainMenu}" />
					
	</h:form>
	
	</center>				
</f:view>
</body>
</html>