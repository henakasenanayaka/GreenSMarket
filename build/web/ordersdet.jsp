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
            List<Map<String, String>> ordersdets = (List<Map<String, String>>) request.getAttribute("ordersdets");
            double total=0.0;
            %>
            <div class="container" style="padding-top: 60px;">
                <h1>Order Details</h1>
                <h3 style="color:greenyellow;">Orders will be delivered in 3 - 4 working days!</h3>
                <table>
                    <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price (Rs)</th>
                    </tr>
            <% for (Map<String, String> ordersdet : ordersdets) { %>
                    <tr>
                        <td><%= ordersdet.get("pname") %></td>
                        <td><%= ordersdet.get("quantity") %></td>
                        <td><%= String.format("%.2f", Double.parseDouble(ordersdet.get("price")))%> X <%= ordersdet.get("quantity") %> = <%= String.format("%.2f", Double.parseDouble(ordersdet.get("price")) * Integer.parseInt(ordersdet.get("quantity"))) %></td>
                    </tr><%total = total +Double.parseDouble(ordersdet.get("price")) * Integer.parseInt(ordersdet.get("quantity"));%>
                                        
            <% } %>
                </table>
                <h3 style="color: #45a049">Total = Rs. <%=total%>/=<br>Delivery = Rs. 300.00/=<br>Grand Total = <span style="color: red;">Rs. <%=total+300.00%></span>/=</h3>
                
            </div>
        </main>
        <script src="Uscript.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
