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
    <title>myEPSI</title>
</head>

<body>

    <div class="mdc-layout-grid">

        <div class="mdc-layout-grid__cell"></div>
        <div class="mdc-layout-grid__cell">

            <div class="mdc-card demo-card">
                <form action="Signin" method="post">
                    <section class="mdc-card__media demo-card__16-9-media"></section>
                    <section class="mdc-card__primary">
                        <h1>Se connecter</h1>
                        
                        
                        <label class="mdc-textfield">
						 	<input class="mdc-textfield__input" 
                         			 type="text" name="username">
						  <span class="mdc-textfield__label">Login</span>
						</label>
                        
                        <label class="mdc-textfield">
							<input id="password" class="mdc-textfield__input"  type="password" name="password">
						  <span class="mdc-textfield__label">Mot de passe</span>
						</label>
                                                                 
                        <span class="error">${error}</span>
                    </section>
                    <section class="mdc-card__actions">
                        <input type="submit" class="mdc-button mdc-button--compact mdc-card__action"></input>
                    </section>
                </form>
            </div>

        </div>
        <div class="mdc-layout-grid__cell"></div>

    </div>

    <div class="mdc-layout-grid">

        <div class="mdc-layout-grid__cell"></div>

        <div class="mdc-layout-grid__cell">

            <div class="mdc-card demo-card">
                    <form action="Users" method="post">
                <section class="mdc-card__media demo-card__16-9-media"></section>
                <section class="mdc-card__primary">
                    <h1>Creer un compte :</h1>
                    
                        <label  class="mdc-textfield">Login
                        	<input  class="mdc-textfield__input" name="login" type="text" /></label>
                        <label  class="mdc-textfield">Password
                        	<input  class="mdc-textfield__input" name="password" type="password" /></label>
                        <label  class="mdc-textfield">Retapez password
                        	<input  class="mdc-textfield__input" name="repassword" type="password" /></label>
                       
                        
                </section>
                <section class="mdc-card__actions">
                    <input  class="mdc-button mdc-button--compact mdc-card__action" type="submit" value="Ajouter un utilisateur" />

                </section>
                    </form>
            </div>

        </div>

        <div class="mdc-layout-grid__cell">


        </div>

        <div class="mdc-layout-grid__cell"></div>

    </div>

    <div class="mdc-layout-grid"></div>

    <script>
        mdc.autoInit()
    </script>
</body>

</html>