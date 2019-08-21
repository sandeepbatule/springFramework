<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color: #8080800d;
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<div class="container">
<br>
<a href="view">Add Student</a>
<br></br>
<table id="customers">
<tr>
<th>Sr.No</th>
<th>Name</th>
<th>Salary</th>
<th>Designation</th>
<th>Update</th>
<th>Delete</th>
</tr>

<c:if test="${empty list}">
	<tr><td colspan="6">No Data found</td></tr>
</c:if>

<c:if test="${!empty list}">
   <c:forEach var="student" items="${list}" varStatus="counter">
<tr>
<td>${counter.count}</td>
<td>${student.name}</td>
<td>${student.salary}</td>
<td>${student.designation}</td>
<td><a  href="editForm/${student.id}">Update</a></td>
<td><a href="deleteForm/${student.id}">Delete</a></td>
</tr>
</c:forEach>
</c:if>

</table>
</div>

</body>
</html>