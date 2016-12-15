
<%@include file="/WEB-INF/header.jsp" %>

<%

String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();

for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}



%>

	
<h3>Hi <%=userName %>, Login Berhasilll!!!.</h3>


</body>
</html>