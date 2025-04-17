<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Dstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container" style="padding-top:120px;"></div>

        <h2>Frequently Asked Questions</h2>

        
            
            <div class="faq-question" onclick="toggleAnswer('faq1')">How can I track my order?</div>
            <div class="faq-answer" id="faq1">You can track your order by logging into your account and
                checking the order status in the order history section.</div>

            <div class="faq-question" onclick="toggleAnswer('faq2')">What payment methods do you accept?</div>
            <div class="faq-answer" id="faq2">We accept credit cards, debit cards, and PayPal for online
                payments.</div>
            <div class="faq-question" onclick="toggleAnswer('faq3')">To complete my order, I have to use my credit card. How secure is my information?,</div>
            <div class="faq-answer" id="faq3">Your Visa, Master and American Express payments are going through secure payment gateways operated by the respective banks. Your card details will be securely transmitted to the Bank for transaction authorization using SSL 128bit encryption.
            </div>
            <div class="faq-question" onclick="toggleAnswer('faq4')">How can I return a product?</div>
            <div class="faq-answer" id="faq4">To return a product, please contact our customer service
                within 14 days of receiving the item.</div>
            
            <div class="faq-question" onclick="toggleAnswer('faq5')">Can I purchase any amount of fresh produce?</div>
            <div class="faq-answer" id="faq5">Fresh produce can currently be ordered in multiples of the weight or quantity, though for some products this is set.</div>

            <div class="faq-question" onclick="toggleAnswer('faq6')">Can I shop online and find everything in the store?</div>
            <div class="faq-answer" id="faq6">While availability and product selection differ from location to store, at least 95% of the products at our stores are now reflected in our online selection.</div>

            <div class="faq-question" onclick="toggleAnswer('faq7')">Can I purchase a certain amount of things online?</div>
            <div class="faq-answer" id="faq7">This may vary according on the circumstances, as some product types or promotions may be subject to limitations.</div>
            <div class="faq-question" onclick="toggleAnswer('faq8')">Is there a price difference for things purchased online and in stores? </div>
            <div class="faq-answer" id="faq8">Both online and in-store prices are displayed. But, our suppliers also regularly adjust their prices, so these prices may momentarily differ depending on the stock levels at each store and the pricing adjustments. Online and in-store promotions can differ as well.</div>

            <div class="faq-question" onclick="toggleAnswer('faq9')">Is there a daily limit on the number of orders I can place? </div>
            <div class="faq-answer" id="faq9">Right now, there is no limit on how many orders a person may place each day. However, this rule may be changed at any time without prior notice if changes are necessary due to external environmental conditions. In the event that Keells is judged to be abusing the website in any manner, they have the right to refuse any orders.</div>
            
        </main>
        
        <script src="Dscript.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
