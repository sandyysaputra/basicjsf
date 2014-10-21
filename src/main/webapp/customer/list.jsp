<%@page import="java.text.SimpleDateFormat"%>
<%@page import="id.co.skyforce.basicjsf.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Data List</title>
</head>
<h1>Customer Managerment</h1>
<body>
		<table align="center" border="1" width="50%" height="50%">
			<thead>
				<tr>
					<th colspan="14">Data Customer</th>
				</tr>
				<tr>
					<td>No.</td>
					<td>Id Customers</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Password</td>
					<td>Home Phone</td>
					<td>Mobilephone</td>
					<td>Birth Date</td>
					<td>Street</td>
					<td>City</td>
					<td>Postal Code</td>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<%
				int i = 0;
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				List<Customer> customers = (List<Customer>) request.getAttribute("customers");				
				for (Customer call : customers) {
					String tanggal = formatter.format(call.getBirthDate());
			%>
			<tr>
				<td><%=i += 1%></td>
				<td><%=call.getId()%></td>
				<td><%=call.getFirstName()%></td>
				<td><%=call.getLastName()%></td>
				<td><%=call.getEmail()%></td>
				<td><%=call.getPassword()%></td>
				<td><%=call.getHomePhone()%></td>
				<td><%=call.getMobileNo()%></td>
				<td><%=tanggal%></td>
				<td><%=call.getAddress().getStreet()%></td>
				<td><%=call.getAddress().getCity()%></td>
				<td><%=call.getAddress().getPostalCode()%></td>
				<td><a href="crud?action=delete&idCustomer=<%=call.getId()%>">Delete</a></td>
				<td><a href="crud?action=getUser&idCustomer=<%=call.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
	<a href="http://localhost:8080/basicjsf/customer/form.jsp">New
		Customer</a>
</body>
</html>