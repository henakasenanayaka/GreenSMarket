<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Ustyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Order Details</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container" style="padding-top: 60px;">
                <h1>Order Details</h1>
        <%
            List<Map<String, String>> orderdets = (List<Map<String, String>>) request.getAttribute("orderdets");
            double total = 0.00;
        %>
        <table>
            <tr>
                <th>Date</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            <% for (Map<String, String> orderdet : orderdets) { %>
            <tr>
                <td><%= orderdet.get("date") %></td>
                <td><%= orderdet.get("pname") %></td>
                <td><%= orderdet.get("quantity") %></td>
                <td>Rs. <%= orderdet.get("total") %>/=</td>
        </tr>
        <%total = total +  Double.parseDouble(orderdet.get("total")); %>
        <% } %>
        <tr class="total-row">
                <td colspan="3">Total</td>
                <td>Rs. <%=total%>/= + 300/=(delivery)</td>
            </tr>
        
        </table>
            </div>
            <div class="checkout">
            <a href="orderdoneServlet"><button>Check Out</button></a>
            </div><br>
            
            <div class="checkout">
            <a href="orderdelServlet"><button>Delete Current Order</button></a>
            </div>
        </main>
                <%@include file="footer.jsp" %>
                <script src="Uscript.js"></script>
    </body>
</html>
