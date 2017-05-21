<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.Message"%>
<%@page import="fr.epsi.myEpsi.beans.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
</head>
<body>

	 <% 
 	Message message = (Message) request.getAttribute("message");

		%> <h3> <% 
	   		 out.println( message.getId() + " - " + message.getTitle());
		%> </h3> <% 
		%> <p> <% 
			out.println(message.getContent());
		%> </p> 

<hr>

</body>
</html>