<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Gestion des produits</title>
</head>
<body>
<table>
<tr>
	<td>Nom Produit</td>
    <td>Prix</td>
    <td>Quantite</td>
    </tr>



<%
    ArrayList<String> listProduit    = (ArrayList<String>)request.getAttribute("listProduit");
    ArrayList<String> listPrix     = (ArrayList<String>)request.getAttribute("listPrix");
    ArrayList<String> listQuantite  = (ArrayList<String>)request.getAttribute("listQuantite");
    if(listProduit==null){
    	
    }
    else{
    	for(int i=0; i<listProduit.size();i++){
    		%>
    		<tr><form action="/ProjetWeb/SupprimerProduit" method="post">
    		<input type=hidden name="produitbefore" value= <%= listProduit.get(i) %> > 
    		<td><input type="text" name="produit"  value=<%= listProduit.get(i) %>> </td>
    		<td><input type="text" name="prix"  value=<%= listPrix.get(i) %> > </td>
    		<td><input type="text" name="quantite"  value=<%= listQuantite.get(i) %>></td>
    		<td><input type="submit"  value="Modifier/supprimer" /></td>
 			</tr></form> <%
    	}
    	%><tr><form action="/ProjetWeb/AjouterProduit" method="post">
		<td><input type="text" name="produit"  > </td>
		<td><input type="text" name="prix"  > </td>
		<td><input type="text" name="quantite"  > </td>
		<td><p><input type="submit"  value="Ajouter" /></p>
		</form> </td></tr><%
	}     
%>
</table>
</body>
</html>