<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Votre panier</title>
</head>
<body>
<%
	ArrayList<String> name = (ArrayList<String>)request.getAttribute("listProduit");
	ArrayList<Integer> quantite = (ArrayList<Integer>)request.getAttribute("listQuantite");
	ArrayList<Integer> prix = (ArrayList<Integer>)request.getAttribute("listPrix");

%>
<table>
	<tr>
		<td>Nom</td>
		<td>Prix</td>
		<td>Quantité</td>
	</tr>
	<%
		for(int i = 0; i < name.size(); i++){
			%>
			<tr><form method="post" action="/ProjetWeb/SupprimerPanier">
			
		    <td><input type="text" id="nom" name="produit" value="<%=name.get(i) %>"> </td>
    		<td><input type="text"  id="prix" name="prix" value="<%=prix.get(i) %>"> </td>
    		<td><input type="number" id="quantite" name="quantite" min="0" max="10" value= <%= quantite.get(i) %>></td>
			<input type=hidden name="quantitebefore" value= <%= quantite.get(i) %> >
		
		<td><input type="submit" value="Modifier/Supprimer"></td> 
		</form>
	</tr><% 
		}
	%>
</table>

</body>
</html>