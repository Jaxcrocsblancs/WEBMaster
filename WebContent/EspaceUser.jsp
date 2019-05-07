<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   	import="java.util.ArrayList"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>User</title>
</head>
<body>
<table border=1>
<caption>ListeProduit:</caption>
<tr><td>Référence</td>
	<td>Prix</td>
	<td>Quantité</td>
</tr>
<%
	ArrayList<String> listProduit   =  new ArrayList<String>(); 
 	ArrayList<Integer> listPrix = new ArrayList<Integer>();
 	ArrayList<Integer> listQuantite = new ArrayList<Integer>();
    listProduit = (ArrayList<String>) request.getAttribute("listProduit");
    listPrix = (ArrayList<Integer>) request.getAttribute("listPrix");
    listQuantite = (ArrayList<Integer>) request.getAttribute("listQuantite");
    
    
    if(listProduit==null){
       
    }else{
    	for(int i=0; i<listProduit.size();i++){
    		%><tr><form method="post" action="/ProjetWeb/AjouterPanier">
    		<td><input type="text" id="nom" name="produit" value="<%=listProduit.get(i) %>"> </td>
    		<td><input type="text" id="prix" name="prix" value="<%=listPrix.get(i) %>"> </td>
    		<td><input type="number" id="quantite" name="quantite" min="0" max="10"></td>
    		<td><input type="submit" value="Ajouter au panier"> </td></form></tr><%
    		}
		
    }     
%>
</table>

</body>
</html>