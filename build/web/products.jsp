<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset="utf-8">
            <title>Store By NSBM</title>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="Tstyle.css">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <%@include file="header.jsp" %>
    <main>
        <section class="categories" id="categories">
        <h1 align="center" class="text">Our Products</h1>
        <%
            
            String categoryName = (String) request.getParameter("c");
            session.setAttribute("categoryName", categoryName);
            List<Map<String, String>> productList = (List<Map<String, String>>) request.getAttribute("productList");
        %>
        
        <h2 align="center">Products for <%= categoryName %></h2>
        <%
            String msg = request.getParameter("msg");
            if("added".equals(msg)){
        %>
        <h3 align="center" style="color: red">Added to cart</h3>
        <%}%>
        
        <%
            if("allreadyadded".equals(msg)){
        %>
        <h3 align="center" style="color: red">All ready it is in the Cart</h3>
        <%}%>
        <%
            if("fail".equals(msg)){
        %>
        <h3 align="center" style="color: red">Something Went Wrong</h3>
        <%}%>
    <table>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Prize</th>
            <th>Add to Cart</th>
        </tr>
        
        <% for (Map<String, String> product : productList) { %>
            
                <tr>
            <td><%= product.get("image") %></td>
            <td><%= product.get("pName") %></td>
            <td>Rs. <%= product.get("price") %>/=</td>
            <td> <a href="addtocartServlet?p=<%= product.get("id") %>" class="btn">Add To Cart</a></td>
        </tr>
    
        <% } %>
        </table>
        
    
    </main>
        <script src="Tscript.js"></script>
        <%@include file="footer.jsp" %>
        
    </body>
</html>
