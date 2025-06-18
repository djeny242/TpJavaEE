<%-- 
    Document   : error.jsp
    Created on : 17 juin 2025, 06:51:10
    Author     : djeny
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur ❌</title>
    </head>
    <body>
        <h1>Une erreur s'est produite 😢 </h1>
        
        <p>Désolé, une erreur inattendue est survenue.</p>
        
         <h3>Détails techniques (pour développeur) :</h3>
         
        <!--çà permet d'afficher l'exception et l'exception le message d'erreur -->
          <pre><%= exception %></pre>
          
         <!-- <a href="userForm.jsp">Retour au formulaire</a> -->
    </body>
</html>

