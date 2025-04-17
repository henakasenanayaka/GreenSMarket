<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="Ustyle.css">
    <title>Edit Customer Details</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container" style="padding-top: 60px;">
                <h1>Edit Customer Details</h1>
        <%
            String msg = request.getParameter("msg");
            if("fail".equals(msg)){
        %>
        <h1>Your Request failed</h1>
        <%}%>
    <c:forEach var="row" items="${userDetails}">
        <c:set var="id" value="${row.id}"></c:set>
        <c:set var="fname" value="${row.fName}"></c:set>
        <c:set var="lname" value="${row.lName}"></c:set>
        <c:set var="email" value="${row.email}"></c:set>
        <c:set var="pass" value="${row.password}"></c:set>
        <c:set var="add" value="${row.add}"></c:set>
        <c:set var="mobile" value="${row.mobile}"></c:set>
            <table>
            <tr>
                <th>User ID</th>
                <td>${row.id}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${row.fName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${row.lName}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${row.email}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${row.password}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${row.add}</td>
            </tr>
            <tr>
                <th>Mobile No.</th>
                <td>${row.mobile}</td>
            </tr>
        </table>
        
    </c:forEach>
    <c:url value="updateuser.jsp" var="userupdate">
        <c:param name="id" value="${id}"/>
        <c:param name="fname" value="${fname}"/>
        <c:param name="lname" value="${lname}"/>
        <c:param name="email" value="${email}"/>
        <c:param name="pass" value="${pass}"/>
        <c:param name="add" value="${add}"/>
        <c:param name="mobile" value="${mobile}"/>
    </c:url>
    <div class="button-container">
            <a href="${userupdate}">
                <button>Edit Details</button>
            </a></div></div>
            </main>
    <script src="Tscript.js"></script>
<%@include file="footer.jsp" %>
    </body>
</html>
