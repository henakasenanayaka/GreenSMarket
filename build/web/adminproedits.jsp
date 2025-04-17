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
            List<Map<String, String>> adminproedits = (List<Map<String, String>>) request.getAttribute("adminproedits");
        %>
        <form action="adminprosaveServlet" method="post">
    <table>
            <tr>
                <th>Image Link</th>
                <th>Product Name</th>
                <th>Stock</th>
                <th>Price</th>
                <th>Availability</th>
            </tr>
            
            <% for (Map<String, String> adminproedit : adminproedits) { %>
            <tr>
                <td><input type="text" name="img" value="<%= adminproedit.get("img") %>" required></td>
                <td><input type="text" name="name" value="<%= adminproedit.get("name") %>"></td>
                <td><input type="text" name="stock" value="<%= adminproedit.get("stock") %>"></td>
                <td><input type="text" name="price" value="<%= adminproedit.get("price") %>"></td>
                <td>
                    <%= adminproedit.get("availability") %>:
                    <select name="availability">
                        <option value="YES">YES</option>
                        <option value="NO">NO</option>
                    </select>
                </td>
            </tr>
            
            
            </table>
            
                <input type="hidden" name="p_id" value="<%= adminproedit.get("id") %>">
                <input type="submit" value="Save" class="btn">
            </form>
            <%}%>
            <script src="Lscript.jsp"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
