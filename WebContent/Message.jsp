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

<form action="Message" method="post">
	<input name="action" type="hidden" value="DELETE"/>
	<input name="id" type="hidden" value="<% out.print( message.getId()); %>"/>
	<input type="submit" value="Supprimer ce post"/>
</form>

<h1>Modifier ce message</h1>
<form action="Message" method="post">
   <input name="action" type="hidden" value="PUT"/>
   <input name="id" type="hidden" value="<% out.print( message.getId()); %>"/>
   <label>Status</label>
   <select name="status">
   <% 
   List<Status> statusList = (List<Status>) request.getAttribute("status");
   for(Status status : statusList){ 
		out.println("<option>" + status.toString() + "</option>");
   } %>
   </select>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>