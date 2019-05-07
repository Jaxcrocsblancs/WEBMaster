<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<%
	 Cookie[] listeCookies = request.getCookies();
	if(listeCookies != null) {
		for(Cookie c: listeCookies) {
			String name = c.getName();
			String value = c.getValue();%>
			
			<%=name%> <%=value %> <br> <%
		}
	}
	%>



        <p>Cookie</p>

        <form action="/ze/cookie"  method="post">
           <p>Nom : <input type="text" name="nom" /></p>
           <p>Value : <input type="text" name="value" /></p>
           <p><input type="submit"  value="valider" /></p>
        </form>


    </body>
</html>