<%@ page import="controller.auth" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Connexion</title>
</head>
<body>
<form action="/ProjetWeb/auth"  method="post">
           <p>Nom : <input type="text" name="nom" /></p>
           <p>Mot de Passe : <input type="text" name="mdp" /></p>
           <p><input type="submit"  value="Connexion" /></p>
        </form>
</body>
</html>