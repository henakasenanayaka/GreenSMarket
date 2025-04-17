<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
        <main>
            <div class="stock-container">
        <%
            List<Map<String, String>> orderpros = (List<Map<String, String>>) request.getAttribute("orderpros");
            List<Map<String, String>> adminorderuserlist = (List<Map<String, String>>) request.getAttribute("adminorderuserlist");
            double total = 0.00;
            int o_id = Integer.parseInt(request.getParameter("msg"));
        %>
        <table>
            <tr>
                <th>First Name</th>
                <td><%=adminorderuserlist.get(0).get("fname")%></td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td><%=adminorderuserlist.get(0).get("lname")%></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%=adminorderuserlist.get(0).get("email")%></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%=adminorderuserlist.get(0).get("address")%></td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td><%=adminorderuserlist.get(0).get("phone")%></td>
            </tr>
        </table>
        <h1>Order ID : <%=o_id%></h1>
        
        
        <table>
            <tr>
                <th>Product Name</th>
                <th>Qyantity</th>
                <th>Total Price</th>
            </tr>
                <% for (Map<String, String> orderpro : orderpros) { %>
            <tr>
                <td><%= orderpro.get("pname") %></td>
                <td><%= orderpro.get("quantity") %></td>
                <td>Rs. <%= Double.parseDouble(orderpro.get("price")) * Integer.parseInt(orderpro.get("quantity")) %>/=</td>
                <%total = total + (Double.parseDouble(orderpro.get("price")) * Integer.parseInt(orderpro.get("quantity")));%>
                <%}%>
            </tr>
        </table>
                <h3 style="color: #45a049">Total = Rs. <%=total%>/=<br>Delivery = Rs. 300.00/=<br>Grand Total = <span style="color: red;">Rs. <%=total+300.00%></span>/=</h3>
            </main>
            <script src="Lscript.js"></script>
            <%@include file="adfooter.jsp" %>
    </body>
</html>
