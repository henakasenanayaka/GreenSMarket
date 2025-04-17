<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Ustyle.css">
    <title>Shopping Cart</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="cart" style="padding-top: 60px;">
                <h1>Shopping Cart</h1>
                <%
                  String msg = request.getParameter("msg");
                  if("done".equals(msg)){
                %>
                <h3 align="center" style="color: red">Cart Updated</h3>
                <%}%>
                <%
                  if("fail".equals(msg)){
                %>
                <h3 align="center" style="color: red">Something Went Wrong!! Try again!</h3>
                <%}%>
                <%
                  if("orderdone".equals(msg)){
                %>
                <h3 align="center" style="color: red">Order added Successfully. Go to Order Page!</h3>
                <%}%>
                <%
                  if("servererror".equals(msg)){
                %>
                <h3 align="center" style="color: red">Cannot Connect With DataBase!</h3>
                <%}%>
                <%
                  if("orderin".equals(msg)){
                %>
                <h3 align="center" style="color: red">Proceed with the previous order. And add another Order!</h3>
                <%}%>
                <%
                  if("prodel".equals(msg)){
                %>
                <h3 align="center" style="color: red">Product Deleted From The Cart!</h3>
                <%}%>
        <%
            List<Map<String, String>> cartdets = (List<Map<String, String>>) request.getAttribute("cartdets");
            double total = 0.00;
            
        %>
        
        <table>
            <tr>
                    <th>image</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Cart Added date</th>
                    <th>Total Price</th>
                    <th>Delete the Product</th>
                </tr>
        
        <% for (Map<String, String> cartdet : cartdets) { %>
        <tr>
            <td><img src="<%= cartdet.get("im") %>"></td>
        <td><%= cartdet.get("pn") %></td>
        <td>Rs. <%= cartdet.get("pr") %>/=</td>
        <td >
            <script>
                function validateQuantity() {
                    var quantityInput = document.getElementById("quantity");
                    var quantityValue = parseInt(quantityInput.value);

                    if (isNaN(quantityValue) || quantityValue < 0) {
                        alert("Quantity must be a non-negative numeric value");
                        return false; // Prevent form submission
                    }

                    return true; // Allow form submission
                }
            </script>
            <form action="updatequantityServlet" method="post" onsubmit="return validateQuantity()">
                <input type="hidden" name="productId" value="<%= cartdet.get("productId") %>">
                <input type="text" name="quantity" id="quantity" value="<%= cartdet.get("qu") %>">
                <input type="submit" value="Update" onclick="return validateQuantity()">
            </form></td>
        <td><%= cartdet.get("da") %></td>
        <td>Rs. <%= Double.parseDouble(cartdet.get("pr")) * Integer.parseInt(cartdet.get("qu")) %>/=</td>
        <td><form action="deletecartproServlet" method="post">
                <input type="hidden" name="productId" value="<%= cartdet.get("productId") %>">
                <input type="submit" name="sumbmit" id="quantity" value="Delete Product">
            </form></td>
        </tr>
        <% total=total+(Double.parseDouble(cartdet.get("pr")) * Integer.parseInt(cartdet.get("qu")));%>
        <% } %>
        
        </table>
        
        <div class="checkout">
            <form action="orderdetServlet" method="post">
            <table>
                <tr>
                    <td><h2>Product Cost: </h2></td><td><h2><span class="total">Rs. <%= String.format("%.2f", total) %>/=</span></h2></td>
                </tr>
                <tr>
                    <td><h2>Delivery : </h2></td><td><h2>Rs. 300.00/=</h2></td>
                </tr>
                <tr>
                    <td><h2 style="color:red;">Total : </h2></td><td><h2 style="color:red;">Rs. <%= String.format("%.2f", total + 300) %>/=</h2></td>
                </tr>
            </table>
                <input type="hidden" name="total" value="<%= String.format("%.2f", total) %>">
                <input type="submit" name="submit">
            </form>
            
        </div>
        </div>
        </main>
        <script src="Uscript.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
