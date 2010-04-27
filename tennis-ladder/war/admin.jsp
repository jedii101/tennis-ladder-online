<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.will.data.entity.*"%>
<%@page import="com.will.service.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
</head>

<body>
<form name="edit" action="admin" method="post">
<table border="1">
<tbody>
<tr>
<td>Admin::</td>
<td><input type="text" name="password"
value=""></td>
</tr><tr>
<td>Password::</td>
<td><input type="text" name="admin" value=""></td>
</tr>
<%
Map<String,String> values=new DataStoreService().getProperties("");
for (Configuration.PROPERTIES prop : Configuration.PROPERTIES.values()) {
%>
<tr>
<td><%=prop %>:</td>
<td><input type="text" name="<%=prop %>" value="<%=(null==values.get(prop.toString())?"":values.get(prop.toString())) %>"></td>
</tr>
<% }%>
<tr>

<td colspan="2"><input type="submit"
name="btnSave" value="Save"></td>
</tr>

</tbody>
</table>

</form>
</body>
</html>
