
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>

<h2>Employee Registration Form</h2>

<form action="EmployeeServlet" method="post">

    <input type="hidden" name="action" value="register">

    Employee No:
    <input type="text" name="empno" required><br><br>

    Name:
    <input type="text" name="name" required><br><br>

    Salary:
    <input type="number" name="salary" required><br><br>

    <input type="submit" value="Register">

</form>

<br>

<form action="EmployeeServlet" method="get">
    <input type="hidden" name="action" value="view">
    <input type="submit" value="View Employee">
</form>

<%
String message = (String) request.getAttribute("message");

if (message != null) {
%>
    <h3><%= message %></h3>
<%
}

List<?> employees =
    (List<?>) request.getAttribute("employees");

if (employees != null) {
%>

<h2>Employee Details</h2>

<table border="1">
    <tr>
        <th>Employee No</th>
        <th>Name</th>
        <th>Salary</th>
    </tr>

    <%
    for (Object obj : employees) {
    %>
    <tr>
        <td><%= obj.getClass().getMethod("getEmpno").invoke(obj) %></td>
        <td><%= obj.getClass().getMethod("getName").invoke(obj) %></td>
        <td><%= obj.getClass().getMethod("getSalary").invoke(obj) %></td>
    </tr>
    <%
    }
    %>
</table>

<%
}
%>

</body>
</html>
