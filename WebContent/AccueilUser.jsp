<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Accueil utilisateur</title>
</head>
<body>
<form action="/ProjetWeb/RecupeProduitForUser" method="post">
<p><input type="submit"  value="Voir la liste des produits disponibles" ></p>
</form> 
<form action="/ProjetWeb/RecupPanier" method="post">
<p><input type="submit"  value="Accéder à mon panier" ></p>
</form> 
</body>
</html>