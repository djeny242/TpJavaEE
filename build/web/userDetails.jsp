<%-- 
    Document   : userDetail.jsp
    Created on : 16 juin 2025, 10:31:51
    Author     : djeny
--%>

<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%  
   // on va recuperer l'utilisateur
   User utilisateur= (User) session.getAttribute("utilisateur");
   
   // on va recuper la liste d'utilisateur
   List<User> users =(List<User>) session.getAttribute("users");
   
  //redirection vers le formulaire si c'est vide
   if(utilisateur ==null || users==null){
      response.sendRedirect("userForm.jsp");
      return;
    }

%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails Utilisateurs</title>
         <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="page">
        <div class="container">
        <h1>Utilisateur courant</h1>
        <p><strong>Nom : </strong> <%= utilisateur.getNom()%></p>
        <p><strong>Prenom : </strong> <%= utilisateur.getPrenom()%></p>
        <p><strong>Email : </strong> <%= utilisateur.getEmail()%></p>
        
        <hr>
        
        <h2>Liste des utilisateurs enregistrés :</h2>
        <ul>
            <% for (User u : users){ %>
            <li><%= u.getNom() %> -- <%=u.getPrenom()%> -- <%=u.getEmail()%></li>
            <% } %>
  
        </ul>
       </div> 
    </body>
</html>
