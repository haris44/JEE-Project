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
<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="https://unpkg.com/material-components-web@0.11.1/dist/material-components-web.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="${pageContext.request.contextPath}/CSS/app.css" rel="stylesheet">
</head>
<body>

<header class="mdc-toolbar">

  <div class="mdc-toolbar__row">
    <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
      <span class="mdc-toolbar__title">Messages</span>

    </section>
     <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
     <span>
           <%  User connected = (User) request.getAttribute("user"); %>
	Bienvenue : <% connected.getId(); %>
     </span>
     </section>
  </div>

</header>
	
	<div class="messagesList">

	 <% 
 	List<Message> messages = (List<Message>) request.getAttribute("messages");
	for(Message message : messages){
		%> 
		
		
	<div class="mdc-card card-message">
	  <section class="mdc-card__primary">
	    <h1 class="mdc-card__title mdc-card__title--large">
	    <% 
	   		 out.println( message.getId() + " - " + message.getTitle());
		%> 
	    </h1>
	    <h2 class="mdc-card__subtitle">
	    <% 
			out.println("<br>date : " + message.getCreationDate());
			out.println("<br>status : " + message.getStatus());
		%> 
	    </h2>
	  </section>
	  <section class="mdc-card__supporting-text">
	  	<% 
			out.println(message.getContent());
		%>
		<br>
		<%
			out.println("<br>status : " + message.getStatus());
		%>
		<br> <%
			if(connected.getAdministrator() || connected.getId() == message.getAuthor().getId()){
		%><a href='Message?id=<% out.println(message.getId()); %>'>Voir d'avantage</a> 
		<%
			} %>
	  </section>
	</div>
		
<%
		}
%> 
		</div>	
		
		
<aside id="newMessage"
  style="visibility:hidden"
  class="mdc-dialog"
  role="alertdialog"
  aria-labelledby="my-mdc-dialog-label"
  aria-describedby="my-mdc-dialog-description">
<form action="Message" method="post">
  <div class="mdc-dialog__surface">

    <section id="my-mdc-dialog-description" class="mdc-dialog__body">
      
      <h1>Ajouter un message</h1>
      
	<div class="mdc-textfield">
	  <input type="text" name="title" class="mdc-textfield__input" placeholder="Titre">
	</div>
	
	<div class="mdc-textfield">
	  <input type="textarea" name="content" class="mdc-textfield__input" placeholder="Contenu">
	</div>
		
 
   
   <select class="mdc-select" placeholder="statut" name="status">
   
   <% 
   List<Status> statusList = (List<Status>) request.getAttribute("status");
   for(Status status : statusList){ 
		out.println("<option>" + status.toString() + "</option>");
   }%>
   </select>

      
    </section>
    <footer class="mdc-dialog__footer">
        <button type="submit" class="mdc-button mdc-dialog__footer__button mdc-dialog__footer__button--cancel" >Ajouter</button>
    </footer>
  </div>
  <div class="mdc-dialog__backdrop"></div>
</form>
</aside>
			
			
			
<style>
.app-fab--absolute.app-fab--absolute {
  position: absolute;
  bottom: 1rem;
  right: 1rem;
}

@media(min-width: 1024px) {
   .app-fab--absolute.app-fab--absolute {
    bottom: 3rem;
    right: 5rem;
  }
}
</style>
<button id="newMessageButton" class="mdc-fab app-fab--absolute" aria-label="Edit">
  <span class="mdc-fab__icon">
    <svg width="24" height="24" viewBox="0 0 24 24">
      <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
    </svg>
  </span>
</button>
			
			
<script>
	
	var dialog = new mdc.dialog.MDCDialog(document.querySelector('#newMessage'));

	dialog.listen('MDCDialog:accept', function() {
	  console.log('accepted');
	})

	dialog.listen('MDCDialog:cancel', function() {
	  console.log('canceled');
	})

	document.querySelector('#newMessageButton').addEventListener('click', function (evt) {
	  dialog.lastFocusedTarget = evt.target;
	  dialog.show();
	})
	
	
	
</script>	


<%
	if(connected.getAdministrator()){
%>
<hr>
<a href='Users'>Gérez les utilisateurs</a>
<% } %>
</body>
</html>