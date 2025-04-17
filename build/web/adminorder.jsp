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
        <main>a
            <br>
            <br>
            <br>
            <br>
            
            <%
            List<Map<String, String>> showorders = (List<Map<String, String>>) request.getAttribute("showorders");
        %>
            <h2>Customer Orders</h2>
            <%
                String msg = request.getParameter("msg");
                if("updated".equals(msg)){
            %>
            <h3 align="center" style="color:red">Order Status Updated!</h3>
            <%}%>
            <%
                if("notupdated".equals(msg)){
            %>
            <h3 align="center" style="color:red">Something Went Wrong!!</h3>
            <%}%>
            <div class="stock-container">
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Order Status</th>
                            <th>Action</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                          
        <% for (Map<String, String> showorder : showorders) { %>
        <tr>
            <td><%= showorder.get("o_id") %></td>
            <td><%= showorder.get("date") %></td>
            <td><%= showorder.get("total") %></td>
            <td><%= showorder.get("status") %></td>
            <td>
                <form action="adminorderdet?=msg<%= showorder.get("o_id") %>" method="post">
                    <input type="hidden" name="o_id" value="<%= showorder.get("o_id") %>">
                    <select name="status" class="btn">
                        <option value="Processing">Processing</option>
                        <option value="Order Received">Order Received</option>
                        <option value="Dispatched">Dispatched</option>
                        <option value="Canceled">Canceled</option>
                    </select>
                    <input type="submit" name="submit" value="Update" class="btn">
                </form>
                    
            </td>
            <td>
                <a href="adminorderprolistServlet?msg=<%= showorder.get("o_id") %>"><button>View Order</button></a>
            </td>
        </tr>
        <% } %>
            </table>
            </div>
            <script src="Lscript.js"></script>
        </main>
        
        <%@include file="adfooter.jsp" %>
    </body>
</html>
