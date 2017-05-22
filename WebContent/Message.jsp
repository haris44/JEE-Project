<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.Message"%>
<%@page import="fr.epsi.myEpsi.beans.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="https://unpkg.com/material-components-web@0.11.1/dist/material-components-web.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/CSS/app.css" rel="stylesheet">
<title>Message</title>

</head>
<body>
<header class="mdc-toolbar">

  <div class="mdc-toolbar__row">
    <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
      
      <span class="mdc-toolbar__title">
      	<a href="Messages"><img alt="" src="${pageContext.request.contextPath}/IMG/logo.png" class="helper logo"></a>
     	 Modifier ce message
      </span>

    </section>
     <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
     </section>
  </div>

</header>

<br>
 <% 
 	Message message = (Message) request.getAttribute("message");

		%>
		
<div class="mdc-card">
  <section class="mdc-card__primary">
    <h1 class="mdc-card__title mdc-card__title--large"> <% 
	   		 out.println(message.getTitle());
		%></h1>
    <h2 class="mdc-card__subtitle"><% out.println(message.getId()); %></h2>
  </section>
  <section class="mdc-card__supporting-text">

	  <% 
		%> <p> <% 
			out.println(message.getContent());
		%> </p> 
		
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
    <input type="submit" value="Modifier">
</form>


<hr>

  </section>
    <section class="mdc-card__actions">
  		<form action="Message" method="post">
			<input name="action" type="hidden" value="DELETE"/>
			<input name="id" type="hidden" value="<% out.print( message.getId()); %>"/>
			<input class="mdc-button mdc-button--compact mdc-card__action" type="submit" value="Supprimer ce post"/>
		</form>

  </section>
</div>



</body>
</html>