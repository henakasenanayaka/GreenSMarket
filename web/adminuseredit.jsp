<%-- 
    Document   : adminuseredit
    Created on : Dec 30, 2023, 12:32:53 PM
    Author     : gemba
--%>

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
        <%
            List<Map<String, String>> adminuseredits = (List<Map<String, String>>) request.getAttribute("adminuseredit");
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
            <%
                String msg = request.getParameter("msg");
                if("done".equals(msg)){
            %>
        <h3 align="center" style="color: red">Updated Successfully!</h3>
        <%}%>
        <%
            if("fail".equals(msg)){
        %>
        <h3 align="center" style="color: red">Update Failed!</h3>
        <%}%>
        
        
        <form action="adminusereditServlet" method="post">
        <table>
            <% for (Map<String, String> adminuseredit : adminuseredits) { %>
            <tr>
                <th>User ID</th>
                <td><input type="text" name="u_id" value="<%= adminuseredit.get("u_id") %>" readonly></td>
            </tr>
            <tr>
                <th>First Name</th>
                <td><input type="text" name="fname" value="<%= adminuseredit.get("fname") %>" required></td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td><input type="text" name="lname" value="<%= adminuseredit.get("lname") %>" required></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" value="<%= adminuseredit.get("email") %>" required></td>
            </tr>
            <tr>
                <th>Password</th>
                <td><input type="text" name="pass" value="<%= adminuseredit.get("pass") %>" required></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="add" value="<%= adminuseredit.get("add") %>" required></td>
            </tr>
            <tr>
                <th>Mobile</th>
                <td><input type="text" name="phone" value="0<%= adminuseredit.get("phone") %>" required></td>
            </tr>
            <%}%>
        </table>
        <input type="submit" name="submit" value="Update Data" class="btn">
        </form>
        <script src="Lscript.jsp"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
