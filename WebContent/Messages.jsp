<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.Message"%>
<%@page import="fr.epsi.myEpsi.beans.Status"%>
<%@page import="fr.epsi.myEpsi.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  User connected = (User) request.getAttribute("user"); %>
	Welcome <% connected.getId(); %>
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
		%> <i> <% 
			out.println("<br>date : " + message.getCreationDate());
			out.println("<br>status : " + message.getStatus());
		%> </i> <%
		%> </p> <%
			if(connected.getAdministrator() || connected.getId() == message.getAuthor().getId()){
		%><a href='Message?id=<% out.println(message.getId()); %>'>Voir d'avantage</a> <%
			} 
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

<%
	if(connected.getAdministrator()){
%>
<hr>
<a href='Users'>Gérez les utilisateurs</a>
<% } %>
</body>
</html>