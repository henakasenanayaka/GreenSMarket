<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Tstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <%@ include file="header.jsp" %>
        <main>
            <%
                String msg = request.getParameter("msg");
                if("orderplaced".equals(msg)){
            %>
            <h1 align="center" style="color: red">Order Placed Successfully!</h1>
            <%}%>
            <%
                if("orderdeleted".equals(msg)){
            %>
            <h1 align="center" style="color: red">Order Deleted Successfully!</h1>
            <%}%>
            <%
                if("nouser".equals(msg)){
            %>
            <h1 align="center" style="color: red">Sign in First!!!!</h1>
            <%}%>
    <section class="home" id="home">
        <div class="content">
            <h3>Fresh And <span>Organic</span> Products For You</h3>
            <p>This Website Is Designed By NSBM Green University Students As Their Assignment</p>

            <a href="#categories" class="btn">Shop Now</a>
        </div>
    </section>
                <section class="features" id="features">
        <h1 class="heading">Our <span>  Features</span></h1>

        <div class="box-container">
            <div class="box">
                <img src="images\banner-img.jpg">
                <h3>Fresh and Organic</h3>

                <p>Our shelves offer a diverse selection of locally sourced organic produce, including fruits, vegetables, meats, and dairy, showcasing our commitment to quality</p>
                </div>
        
            <div class="box">
                <img src="images\dilivery-img.webp">
                <h3>Free Dilivery</h3>

                <p>We’re dedicated to delivering high-quality, fresh, and sustainable products to your doorstep.</p>

                <!-- a href="#" class="btn">read more </a> -->
            </div>
        
            <div class="box">
                <img src="images\payment-img.jpg">
                <h3>Easy Payment</h3>

                <p>Our payment processing system simplifies shopping, offering a hassle-free checkout experience through various payment methods like cash, credit/debit cards payment.</p>

                <!-- a href="#" class="btn">read more </a> -->
            </div>
        </div>
    </section>
            <section class="categories" id="categories">
        <h1 class="heading">Our <span>  Categories</span></h1>

        <div class="box-container">
            <div class="box">
                <img src="images\nathalia-rosa-rWMIbqmOxrY-unsplash.jpg">
                <h3>Categories</h3>
                <a href="categoryServlet" class="btn">Shop Now</a>
            </div>
        </div>
    </section>
        </main>
<%@ include file="footer.jsp" %>
<script src="Tscript.js"></script>
    </body>
</html>
