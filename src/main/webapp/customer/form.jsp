<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<h1>Input your data</h1>
	<form action="crud" method="post">
	<input type="hidden" name="action" value="create" />
		<pre>
		
First Name 	 <input type="text" name="firstName">
Last Name	 <input type="text" name="lastName">
Email    	 <input type="text" name="email">
Password	 <input type="password" name="password">
Home Phone 	 <input type="text" name="homePhone">
Mobile Phone     <input type="text" name="mobilePhone">
Birthdate 	 <input type="text" name="birthDate">
Street	 	 <input type="text" name="street">
City   		 <input type="text" name="city">
Postal Code	 <input type="text" name="postalCode">
<button type="submit">Kirim</button>
	</pre>
	</form>
</body>
</html>