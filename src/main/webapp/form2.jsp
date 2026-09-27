<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Form</title>
</head>
<body>

    <h4>Enter your name:</h4>
    <form method="post">

        <input type="text" name="name">

        <h4>Roll No:</h4>
        <input type="text" name="rollno">

        <br><br>
        <button type="submit">Submit</button>

    </form>

    <%
        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");

        if (name != null && rollno != null) {

            if (name.equals("") || rollno.equals("")) {
    %>

                <h3>Please enter name and roll no</h3>

    <%
            } else {
    %>

                <h3>Name: <%= name %></h3>
                <h3>Roll No: <%= rollno %></h3>

    <%
            }
        }
    %>

</body>
</html>