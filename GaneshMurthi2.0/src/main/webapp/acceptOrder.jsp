<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> order accepted status</title>
</head>
<body>

Your Order Accepted ! And Your OrderId is:  <%= request.getAttribute("orderId") %>
<br>
<br>
<button id="rzp-button1" onclick="paymoney(<%= request.getAttribute("orderId") %>,${idolData.priceofidol } )">pay to confirm order</button>

<br>
</body>
</html>