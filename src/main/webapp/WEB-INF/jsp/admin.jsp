<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>HTML Forms</h2>

<form:form action="form" method="post" modelAttribute="adminform" >
  Display Party Results? 
  	<form:radiobutton path="partyResults" value="yes" />Yes 
	<form:radiobutton path="partyResults" value="no" />No <br>
  <br>
  Display Assembly Constituency Results?
  	<form:radiobutton path="acResults" value="yes" />Yes 
	<form:radiobutton path="acResults" value="no" />No <br>
  <br>
  Footer Email ID:
  <form:input type="text" path="emailID" /> 
  <br><br>
  <input type="submit" value="Save" name="Save" />
</form:form> 

<form:form action="reload" method="post" modelAttribute="adminform" >
   
  <br><br>
  <input type="submit" value="Reload Changes" name="Reload Changes" />
</form:form>

</body>
</html>