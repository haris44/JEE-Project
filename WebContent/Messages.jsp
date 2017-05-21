<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.Message"%>
<%@page import="fr.epsi.myEpsi.beans.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome <% out.println(request.getAttribute("username")); %>
	<br>
	<br>
	
	 <% 
 	List<Message> messages = (List<Message>) request.getAttribute("messages");
	for(Message message : messages){
		%> <h3> <% 
	   		 out.println( message.getId() + " - " + message.getTitle());
		%> </h3> <% 
		%> <p> <% 
			out.println(message.getContent());
		%> </P> <% 
	}
%>

<hr>
<h1>Ajouter un message</h1>
<form action="Message" method="post">
   <label>Titre</label><input type="text" name="title">
   <label>Contenu</label><input type="textarea" name="content">
   <label>Status</label>
   <select name="status">
   <% 
   List<Status> statusList = (List<Status>) request.getAttribute("status");
   for(Status status : statusList){ 
		out.println("<option>" + status.toString() + "</option>");
   }%>
   </select>
    <input type="submit" value="Ajouter">
</form>


</body>
</html>