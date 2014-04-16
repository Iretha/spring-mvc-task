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

	<table>
		<tr style="background-color: #D3D3D3">
			<th>IP Address</th>
			<th>Browser</th>
			<th>Time</th>
		</tr>
		<tr>
			<td>${ip}</td>
			<td>${userAgent}</td>
			<td>${time}</td>
		</tr>
	</table>

	<h2 style="color: ${success ? '#609060' : '#FF0000'}">${message}</h2>
</body>
</html>