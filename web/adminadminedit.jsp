<%-- 
    Document   : adminuseredit
    Created on : Dec 30, 2023, 12:32:53 PM
    Author     : gemba
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <!--4-->
        <%@include file="adheader.jsp" %>
        <%
            
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
        <form action="admineditadmincheckServlet" method="post">
            <c:forEach var="row" items="${adminadminedit}">
            <c:set var="id" value="${row.a_id}"></c:set>
            <c:set var="email" value="${row.email}"></c:set>
            <c:set var="pass" value="${row.pass}"></c:set>
        <table>
            
            <tr>
                <th>Admin ID</th>
                <td><input type="text" name="id" value="${row.a_id}" readonly></td>
            </tr>
            <tr>
                <th>Admin Email</th>
                <td><input type="text" name="email" value="${row.email}" required></td>
            </tr>
            <tr>
                <th>Password</th>
                <td><input type="text" name="pass" value="${row.pass}" required></td>
            </tr>
            
            
        </table>
            
        <input type="submit" name="submit" value="Update Data" class="btn">
        </c:forEach>
        </form>
        <script src="Lscript.js"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
