<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   	import="java.util.ArrayList"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
<table border=1>
<caption>ListeProduit:</caption>
<%
	ArrayList<String> listNom   =  new ArrayList<String>(); 
 	ArrayList<Integer> listPrix = new ArrayList<Integer>();
    listNom  = (ArrayList<String>) request.getAttribute("listProduit");
    listPrix = (ArrayList<Integer>) request.getAttribute("listPrix");
    listNom.add("test");
    listPrix.add(10);
    
    if(listNom==null){
       
    }else{
    	for(int i=0; i<listNom.size();i++){
    		%><tr><td><%=listNom.get(i) %> </td>
    		<td><%=listPrix.get(i) %> </td></tr><%
    		}
		
    }     
%>
</table>

</body>
</html>