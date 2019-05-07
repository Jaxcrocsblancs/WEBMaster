<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Admin</title>
</head>
<body>

<table>
<caption>ListeUserAdmin :</caption>

<%
    ArrayList<String> listUser    = (ArrayList<String>)request.getAttribute("listUser");
    ArrayList<String> listMdp     = (ArrayList<String>)request.getAttribute("listMdp");
    ArrayList<Boolean> listAdmin  = (ArrayList<Boolean>)request.getAttribute("listAdmin");
    if(listUser==null){
    	
    }else{
    	
    	for(int i=0; i<listUser.size();i++){
    		%>
    		<tr><form action="/ProjetWeb/Supprimer" method="post">
    			<input type=hidden name="userbefore" value= <%= listUser.get(i) %> > 
    		<td><input type="text" name="user"  value= <%= listUser.get(i) %>> </td>
    		<td><input type="text" name="mdp"  value= <%= listMdp.get(i) %> > </td>
    		<td><input type="text" name="admin"  value= <%= listAdmin.get(i) %>  > </td>
    		<td><p><input type="submit"  value="Modifier/Supprimer" /></p>
 			</form> </td></tr><%
    	}
    	%><tr><form action="/ProjetWeb/Ajouter" method="post">
		<td><input type="text" name="user"  > </td>
		<td><input type="text" name="mdp"  > </td>
		<td><input type="text" name="admin"  > </td>
		<td><p><input type="submit"  value="Ajouter" /></p>
		</form> </td></tr><%
	}     
%>
</table>


</body>
</html>