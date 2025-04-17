<%-- 
    Document   : adminpros
    Created on : Dec 31, 2023, 5:20:28 AM
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
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
            <a href="adminaddproServlet"><button class="btn" >Add Product</button></a><br><br>
            <%
            List<Map<String, String>> adminpros = (List<Map<String, String>>) request.getAttribute("adminpros");
            %>
            <%
                String msg = request.getParameter("msg");
                if("done".equals(msg)){
            %>
            <h3 align="center" style="color: red">Updated Successfully!</h3>
            <%}%>
            <%
                if("fail".equals(msg)){
            %>
            <h3 align="center" style="color: red">Something Went WRONG!</h3>
            <%}%>
            <%
                if("del".equals(msg)){
            %>
            <h3 align="center" style="color: red">Deleted Successfully!</h3>
            <%}%>
            <%
                if("notdel".equals(msg)){
            %>
            <h3 align="center" style="color: red">Something Went WRONG!</h3>
            <%}%>
            <%
                if("save".equals(msg)){
            %>
            <h3 align="center" style="color: red">Product Added Successfully!</h3>
            <%}%>
            <%
                if("notsave".equals(msg)){
            %>
            <h3 align="center" style="color: red">Something Went WRONG!</h3>
            <%}%>
            <table>
                <tr>
                    <th>Image</th>
                    <th>Product Name</th>
                    <th>Stock</th>
                    <th>Price</th>
                    <th>Availability</th>
                    <th>Category Name</th>
                    <th></th>
                </tr>
                <% for (Map<String, String> adminpro : adminpros) { %>
                <tr>
                    <td><img src="<%= adminpro.get("img") %>"></td>
                    <td><%= adminpro.get("name") %></td>
                    <td><%= adminpro.get("stock") %></td>
                    <td><%= adminpro.get("price") %>/=</td>
                    <td><%= adminpro.get("availability") %></td>
                    <td><%= adminpro.get("c_name") %></td>
                    <td>
                        <form action="adminproedit" method="post">
                            <input type="hidden" name="p_id" value="<%= adminpro.get("id") %>">
                            <input type="submit" value="EDIT" class="btn">
                        </form>
                        <form action="adminprodelServlet" method="post">
                            <input type="hidden" name="p_id" value="<%= adminpro.get("id") %>">
                            <input type="submit" value="DELETE" class="btn">
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
