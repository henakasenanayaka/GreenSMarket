<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Order Details</title>
        <link rel="stylesheet" href="Ustyle.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <%
                
            List<Map<String, String>> orders = (List<Map<String, String>>) request.getAttribute("orders");
            %>
            <div class="container" style="padding-top: 60px;">
                <h1>Order Details</h1>
                <h3 style="color:greenyellow;">Orders will be delivered in 3 - 4 working days!</h3>
                <table>
                    <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Price</th>
                    <th>Order Status</th>
                    </tr>
            <% for (Map<String, String> order : orders) { %>
                    <tr onclick="window.location='ordersdetServlet?msg=<%= order.get("o_id") %>'" style="cursor: pointer;">
                        <td><%= order.get("o_id") %></td>
                        <td><%= order.get("date") %></td>
                        <td>Rs. <%=String.format("%.2f", Double.parseDouble(order.get("total")))%>/=</td>
                        <td><%= order.get("orderstatus") %></td>
                    </tr>
            <% } %>
                </table>
            </div>
        </main>
        <script src="Uscript.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
