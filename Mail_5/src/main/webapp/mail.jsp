<!DOCTYPE html>
<html>
<head>
    <title>Send Email</title>
</head>
<body>

<h2>Send Email</h2>

<form action="MailServlet" method="post">

    To:
    <input type="email" name="to" required>
    <br><br>

    Subject:
    <input type="text" name="subject" required>
    <br><br>

    Message:
    <textarea name="message" rows="5" cols="30" required></textarea>
    <br><br>

    <input type="submit" value="Send Email">

</form>

<%
String msg = (String) request.getAttribute("msg");

if (msg != null) {
%>

<h3><%= msg %></h3>

<%
}
%>

</body>
</html>