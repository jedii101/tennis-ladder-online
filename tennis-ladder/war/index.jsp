<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.will.service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//String redirectURL =(String) application.getAttribute("redirectURL");
DataStoreService service=new DataStoreService();
PingService pingService=new PingService();
String redirectURL=service.getRedirectURL();
System.out.println("redirectURL"+redirectURL);
if(redirectURL!=null&&pingService.ping(5000,redirectURL)){

response.sendRedirect(redirectURL);
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Stephen Leacock Ladder Championship site<br>
<%=service.getMainTitle()%>
</title>
</head>
<body>
This site is currently under maintenance, please try again later.
<br><br>
<%=service.getMainMessage()%>
<div id="ft">
� 2010 Will Han |
<a href="http://code.google.com/appengine/terms.html">Terms of Service</a>
| <a href="http://code.google.com/appengine/privacy.html">Privacy Policy</a>
| <a href="http://googleappengine.blogspot.com">Blog</a>
| <a href="http://groups.google.com/group/google-appengine">Discussion Forums</a>
</div>
</body>
</html>