<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web-task</title>
</head>
<body>
	<h2>Example Spring MVC</h2>

	<table>
		<tr style="background-color: #D3D3D3">
			<th colspan="3"><form:form method="get" action="listInRange">
					<input type="text" name="from" />
					<input type="text" name="to" />
					<input type="submit" value="Search" />
				</form:form></th>
		</tr>
		<tr style="background-color: #D3D3D3">
			<th>IP Address</th>
			<th>Browser</th>
			<th>Time</th>
		</tr>
		<c:forEach var="conn" items="${connectionsList}">
			<tr>
				<td>${conn.ip}</td>
				<td>${conn.userAgent}</td>
				<td><fmt:formatDate value="${conn.time}"
						pattern="dd.MM.yyyy HH:ss:mm" /></td>
			</tr>
		</c:forEach>
	</table>

	<h2 style="color: ${success ? '#609060' : '#FF0000'}">${message}</h2>
</body>
</html>