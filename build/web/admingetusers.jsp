<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Lstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <%@include file="adheader.jsp" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
        <%
        List<Map<String, String>> showusers = (List<Map<String, String>>) request.getAttribute("showusers");
        %>
        
        <table>
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Mobile</th>
                <th></th>
            </tr>
            <% for (Map<String, String> showuser : showusers) { %>
            <tr>
                <td><%= showuser.get("u_id") %></td>
                <td><%= showuser.get("fname") %></td>
                <td><%= showuser.get("lname") %></td>
                <td><%= showuser.get("email") %></td>
                <td><%= showuser.get("pass") %></td>
                <td><%= showuser.get("add") %></td>
                <td><%= showuser.get("phone") %></td>
                <td>
                    <form action="adminedituserServlet" method="get">
                    <input type="hidden" name="id" value="<%= showuser.get("u_id") %>">
                    <input type="submit" name="submit" value="EDIT" class="btn">
                    </form>
                </td>
            </tr>
            
            
            <%}%>
        </table>
        <script src="Lscript.jsp"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
