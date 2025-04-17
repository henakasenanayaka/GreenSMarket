<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Tstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
<%@include file="header.jsp" %>%>
        <main>
        <section class="categories" id="categories">
        <h1 align="center" class="text">Our Categories</h1>
        
        <%
            List<Map<String, String>> categories = (List<Map<String, String>>) request.getAttribute("categories");
            
        %>
        
        <div class="box-container">
        <div class="box-container">
                <div class="box">
                    <img src="images/all.jpg">
                    <h3>All Products</h3>
                    <a href="productServlet?c=all" class="btn">Shop Now </a>
                </div>
        </div>
        <% for (Map<String, String> category : categories) { %>
            
            <a href="<%= "productServlet?c=" + category.get("category_name") %>">
                    
                    <div class="box">
                    <img src="<%= category.get("image") %>">
                    <h3><%= category.get("category_name") %></h3>
                    <button class="btn">Shop Now</button>
                    </div>
                </a>
            
            
        <% } %>
    
    </div>
    </section>
        
        
        
        </main>
        <%@include file="footer.jsp"%>
        <script src="Tscript.js"></script>
        
    </body>
</html>
