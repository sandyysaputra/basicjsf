<%@page import="java.text.SimpleDateFormat"%>
<%@page import="id.co.skyforce.basicjsf.domain.Customer"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Input your data</h1>
	<form action="crud" method="post">
		<%
			Customer customer = (Customer) request.getAttribute("customer");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			String tanggal = formatter.format(customer.getBirthDate());
		%>
		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="idCustomer" value= <%=customer.getId()%> />
		<pre>
First Name 	 <input type="text" name="firstName" value="<%=customer.getFirstName()%>">
Last Name	 <input type="text" name="lastName" value="<%=customer.getLastName()%>">
Email    	 <input type="text" name="email"  value="<%=customer.getEmail()%>">
Password	 <input type="password" name="password" value="<%=customer.getPassword()%>">
Home Phone 	 <input type="text" name="homePhone" value="<%=customer.getHomePhone()%>">
Mobile Phone     <input type="text" name="mobilePhone" value="<%=customer.getMobileNo()%>">
Birthdate 	 <input type="text" name="birthDate" value="<%=tanggal%>">
Street	 	 <input type="text" name="street" value="<%=customer.getAddress().getStreet()%>">
City   		 <input type="text" name="city" value="<%=customer.getAddress().getCity()%>">
Postal Code	 <input type="text" name="postalCode" value="<%=customer.getAddress().getPostalCode()%>">
<button type="submit">Update</button>
	</pre>
	</form>
</body>
</html>