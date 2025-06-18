<%-- 
    Document   : userForm.jsp
    Created on : 16 juin 2025, 09:32:08
    Author     : djeny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>Formulaire utilisateur</h1> 
      
        <div class="formulaire">
            
           <%
              String erreur = (String) request.getAttribute("Erreur");
              if (erreur != null) {
           %>
             <div class="message-erreur"><%= erreur %></div>
        <%
          }
        %>
    
            <form action="UserServlet"  method="post" required>
            <div>
               <label>Nom</label> 
               <input type="text" name="nom" required>
            </div>
                
            <div>     
               <label>Prenom</label> 
               <input type="text" name="prenom" required>  
            </div>  
                
            <div>     
               <label>Email</label> 
               <input type="email" name="email" required=>  
            </div>   
               
            <button type="submit">Enregistrer</button>
                
            </form>
        </div>
    </body>
</html>
