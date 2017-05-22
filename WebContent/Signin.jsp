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

<h1>Créer un compte :</h1>
<form action="Users" method="post">
	<label>Login</label><input name="login" type="text"/>
	<label>Password</label><input name="password" type="password"/>
	<label>Retapez password</label><input name="repassword" type="password"/>
	<label>Admin</label><input type="hidden" value="false" name="admin"><br>
	<input type="submit" value="Ajouter un utilisateur"/>
</form>
</body>
</html>