<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Signin" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="login">
    <span class="error">${error}</span>
</form>
</body>
</html>