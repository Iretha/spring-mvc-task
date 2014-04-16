<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web-task</title>
</head>
<body>
	<h2>Example Spring MVC</h2>
	<h2 style="color: #609060">${message}</h2>

	<table>
		<tr><td><a href="<%=request.getContextPath()%>/connection">Save Connection</a></td></tr>
		<tr><td><a href="<%=request.getContextPath()%>/connections-list">View Connections</a></td></tr>
	</table>
</body>
</html>