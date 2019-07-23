<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="java.sql.*,java.io.*,java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="dbConnection" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="system" password="ibm"/>
	<sql:transaction dataSource="${dbConnection}">
	
	<sql:query var="rs" > select * from railway</sql:query>
	</sql:transaction>
	<table border="2" width="100%">
	<tr>
	<th>TRAINNO</th>
	<th>TRAINNAME</th>
	<th>SOURCE</th>
	<th>DESTINATION</th>
	<th>DEPARTURE</th>
	<th>ARRIVAL</th>
	<th>DATE</th>
	</tr>
	<c:forEach var="t" items="${rs.rows}" >
	<tr>
	<td><c:out value="${ t.trainno}"></c:out></td>
	<td><c:out value="${ t.trainname}"></c:out></td>
	<td><c:out value="${ t.source}"></c:out></td>
	<td><c:out value="${ t.destination}"></c:out></td>
	<td><c:out value="${ t.departure}"></c:out></td>
	<td><c:out value="${ t.arrival}"></c:out></td>
	<td><c:out value="${ t.dates}"></c:out></td>
	</tr>
	</c:forEach>
	</table><br>
	<br><a href=Admin.html>Go Back</a>
</body>
</html>