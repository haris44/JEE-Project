<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	Liste des utilisateur

 <% 
 	List<User> attribut = (List<User>) request.getAttribute("user");
	for(User user : attribut){
	    out.println( user.getId() + user.getPassword());
	}

%>

</body>
</html>