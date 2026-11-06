
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>

<h2>Employee Registration Form</h2>

<form action="${pageContext.request.contextPath}/EmployeeServlet"
      method="post">

    Employee No:
    <input type="number" name="empno" required><br><br>

    Name:
    <input type="text" name="name" required><br><br>

    Salary:
    <input type="number" step="any" name="salary" required><br><br>

    <input type="submit" value="Register">
</form>

<br>

<form action="${pageContext.request.contextPath}/EmployeeServlet"
      method="get">

    <input type="submit" value="View Employee">
</form>

<h3>${message}</h3>

<%
List<?> list = (List<?>) request.getAttribute("employees");

if (list != null) {
%>

<h2>Employee Details</h2>

<table border="1">
    <tr>
        <th>Employee No</th>
        <th>Name</th>
        <th>Salary</th>
    </tr>

    <%
    for (Object e : list) {
    %>

    <tr>
        <td><%= e.getClass().getMethod("getEmpno").invoke(e) %></td>
        <td><%= e.getClass().getMethod("getName").invoke(e) %></td>
        <td><%= e.getClass().getMethod("getSalary").invoke(e) %></td>
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
