<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<tr>
<td>url::</td>
<td><input type="text" name="redirectURL" value=""></td>
</tr><tr>

<td colspan="2"><input type="submit"
name="btnSave" value="Save"></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>
