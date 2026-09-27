<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>

<h2>Registration Details</h2>

<p>Name: <%= session.getAttribute("name") %></p>
<p>Roll No: <%= session.getAttribute("rollno") %></p>
<p>Degree: <%= session.getAttribute("degree") %></p>
<p>Branch: <%= session.getAttribute("branch") %></p>
</body>
</html>