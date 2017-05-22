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
<style>
html{

  background: url("${pageContext.request.contextPath}/IMG/bg.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
    <div class="mdc-layout-grid">

        <div class="mdc-layout-grid__cell"></div>
        <div class="mdc-layout-grid__cell">

            <div class="mdc-card demo-card">
                <form action="Signin" method="post">
                    <section class="mdc-card__primary">
                    
                        <h1>Se connecter</h1>
                        
                        
                        <div class="mdc-textfield">
						 	<input class="mdc-textfield__input" 
                        			 type="text" name="username"
                        			 placeholder="Login">
					  </div>
						
                        
                      <div class="mdc-textfield">
							<input id="password" class="mdc-textfield__input"  type="password" name="password"
							placeholder="Mot de passe">
                      </div>
						 
					
                                                                 
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
                <section class="mdc-card__primary">
                    <h1>Creer un compte :</h1>
                    
                    
                        <div class="mdc-textfield">
                        	<input placeholder="Login"  class="mdc-textfield__input" name="login" type="text" />
                        </div>
                  <div class="mdc-textfield">
                  <input placeholder="Mot de passe"  class="mdc-textfield__input" name="password" type="password" />
                  </div>
                         <div class="mdc-textfield">
                        
                        	<input placeholder="Mot de passe (encore)" class="mdc-textfield__input" name="repassword" type="password" />
                       </div>
                        
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