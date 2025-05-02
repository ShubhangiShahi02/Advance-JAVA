<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Data Result</title>
</head>
<body>
    <h2>Submitted Data</h2>
    <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Email:</strong> <%= request.getParameter("email") %></p>
    <p><strong>Age:</strong> <%= request.getParameter("age") %></p>
</body>
</html>
