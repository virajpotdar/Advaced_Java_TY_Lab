<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voting</title>
</head>
<body>
    <h4>Enter Age:</h4>
    <form method="post">
        <input type="text" name="age">
        <br><br>
        <button type="submit">Check</button>
    </form>
    <%
        String age = request.getParameter("age");
        if (age != null) {
            int a = Integer.parseInt(age);
            if (a >= 18) {
    %>
                <h3>You are eligible for voting</h3>
    <%
            } else {
    %>
                <h3>You are not eligible for voting</h3>
    <%
            }
        }
    %>
</body>
</html>