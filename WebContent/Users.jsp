<%@page import="java.util.List"%>
<%@page import="fr.epsi.myEpsi.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="https://unpkg.com/material-components-web@0.11.1/dist/material-components-web.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="${pageContext.request.contextPath}/CSS/app.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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

</head>
<body>

<header class="mdc-toolbar">

  <div class="mdc-toolbar__row">
    <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
      
      <span class="mdc-toolbar__title">
      	<a href="Messages"><img alt="" src="${pageContext.request.contextPath}/IMG/logo.png" class="helper logo"></a>
     	
          Gerez les utilisateur
      </span>

    </section>
     <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
     </section>
  </div>

</header>

	<div class="messagesList">

 <% 
 	List<User> attribut = (List<User>) request.getAttribute("user");
	for(User user : attribut){
		%>
		
	<div class="mdc-card card-message">
	  <section class="mdc-card__primary">
	    <h1 class="mdc-card__title mdc-card__title--large">
	    <% out.println(user.getId()); %>
	      </h1>
	    <h2 class="mdc-card__subtitle">
	    <% 
		%><p> Mots de passe : <% out.println(user.getPassword()); %> </p>
	    </h2>
	  </section>
	  <section class="mdc-card__supporting-text">
		<u>Modification : </u>
		<br>
		<form action="Users" method="post">
			<input name="action" type="hidden" value="PUT"/>
			<input name="login" value="<% out.print(user.getId()); %>" type="hidden"/>
			<label>Mots de passe : </label><input name="password" type="password" value="<% out.print(user.getPassword()); %>"/>
			<br><label>Mots de passe : </label><input name="repassword" type="password"/>
			<br><label>Admin</label><input type="checkbox" name="admin" <%  if(user.getAdministrator()){ out.print("checked='true'"); }%>"><br>
			<input type="submit" class="mdc-button mdc-button--compact" value="Modifier un utilisateur"/>
		</form>
		
		<% 
		%>	  </section>
		 <section class="mdc-card__actions">
		<form action="Users" method="post">
			<input name="action" type="hidden" value="DELETE"/>
			<input name="login" type="hidden" value="<% out.print(user.getId()); %>"/>
			<input type="submit" class="mdc-button mdc-button--accent mdc-card__action" value="Supprimer cet utilisateur"/>
		</form>
		 </section>
	</div>
		 <%  
	}
	%>
	</div>	

	
<aside id="newUsers"
  style="visibility:hidden"
  class="mdc-dialog"
  role="alertdialog"
  aria-labelledby="my-mdc-dialog-label"
  aria-describedby="my-mdc-dialog-description">

	<form action="Users" method="post">
  <div class="mdc-dialog__surface">
    <section id="my-mdc-dialog-description" class="mdc-dialog__body">

	<h1> Ajouter un utilisateur </h1>

		<label>Login</label><input name="login" type="text"/>
		<label>Password</label><input name="password" type="password"/>
		<label>Retapez password</label><input name="repassword" type="password"/>
		<label>Admin</label><input type="checkbox" name="admin"><br>
		<input type="submit" value="Ajouter un utilisateur"/>
   
    </section>
    <footer class="mdc-dialog__footer">
        <button type="submit" class="mdc-button mdc-dialog__footer__button mdc-dialog__footer__button--cancel" >Ajouter</button>
    </footer>
  </div>
  <div class="mdc-dialog__backdrop"></div>
</form>
</aside>
		
		<button id="newUsersButton" class="mdc-fab app-fab--absolute" aria-label="Edit">
  <span class="mdc-fab__icon">
    <svg width="24" height="24" viewBox="0 0 24 24">
      <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
    </svg>
  </span>
</button>
				
			
<script>
	
	var dialog = new mdc.dialog.MDCDialog(document.querySelector('#newUsers'));

	dialog.listen('MDCDialog:accept', function() {
	  console.log('accepted');
	})

	dialog.listen('MDCDialog:cancel', function() {
	  console.log('canceled');
	})

	document.querySelector('#newUsersButton').addEventListener('click', function (evt) {
	  dialog.lastFocusedTarget = evt.target;
	  dialog.show();
	})
	
</script>	


</body>
</html>