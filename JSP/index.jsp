<!DOCTYPE html>
<html>
<head>
    <title>JSP Form Example</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="result.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Age: <input type="number" name="age"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
