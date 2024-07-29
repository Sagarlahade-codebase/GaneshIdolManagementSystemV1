<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      <%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>   
      <%@ page import="com.fasterxml.jackson.databind.ObjectWriter" %>   
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> customer order status</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
  <!--  -->
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css"/>
  <link rel="stylesheet" type="text/css" href="tp.css">
  <link rel="stylesheet" type="text/css" href="./assets/css/contact.css">

  <link rel="stylesheet" type="text/css" href="./assets/css/footer.css">
  <link rel="stylesheet" href="style.css"/>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif&family=Rubik&display=swap" rel="stylesheet">
 
   <%@ page import="com.google.gson.*" %>
      <style>
          .col1{
      border-radius : 15px;
  -webkit-box-shadow: 4px 6px 5px 0px rgba(0,0,0,0.75);
-moz-box-shadow: 4px 6px 5px 0px rgba(0,0,0,0.75);
box-shadow: 4px 6px 5px 0px rgba(0,0,0,0.75);

 transition: all 0.2s ease;
    cursor: pointer
  }
  
  .col1:hover {
   
    transform: scale(1.1)
}

h2,p{
font-family: 'Noto Serif', serif;
text-transform: uppercase;
font-weight : bold;
}
      
      </style>   
</head>
<body style=" background-color :#20bf55;
background-image :linear-gradient(315deg, #20bf55 0%, #01baef 74%);">
  <!-- Navbar -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar" style="background-color:#090721">
    <div class="container-fluid">

      <!-- Brand -->
      <a class="navbar-brand" href="https://mdbootstrap.com/docs/jquery/" target="_blank">
        <!-- <strong>MDB</strong> -->
        <!-- <img src="assets/logo.png" style="width: 170px;"> -->
      </a>

      <!-- Collapse -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <!-- Left -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="LandingPage2.html">HOME
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./CustomerDashboard.html" >Dashboard </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./login.html" >Logout</a>
          </li>
          
        </ul>

        <!-- Right -->
        <ul class="navbar-nav nav-flex-icons">
          <li class="nav-item">
            <a href="https://www.facebook.com/mdbootstrap" class="nav-link" target="_blank">
              <i class="fa fa-facebook-f"></i>
            </a>
          </li>
          <li class="nav-item">
            <a href="https://twitter.com/MDBootstrap" class="nav-link" target="_blank">
              <i class="fa fa-twitter"></i>
            </a>
          </li>
          <li class="nav-item">
            <a href="https://twitter.com/MDBootstrap" class="nav-link" target="_blank">
              <i class="fa fa-linkedin"></i>
            </a>
          </li>
          <li class="nav-item">
            <a href="https://twitter.com/MDBootstrap" class="nav-link" target="_blank">
              <i class="fa fa-instagram"></i>
            </a>
          </li>
        </ul>

      </div>
    </div>
  </nav>
  
<div class="container" >
<br>
<br>

	<h2 style="color: white;text-align: center; margin: 20px; padding: 10px;text-shadow : 1px 1px #000000;text-transform:uppercase;">web based tool for idol immersion management and analysis</h2>
   <h3 style="color: white;text-align: center; margin: 20px; padding: 20px;text-shadow : 1px 1px #000000;text-transform:uppercase;">Vendor details</h3>
 
			 <c:forEach items="${orderData}" var="custOrd">
<div class="container" style="padding-right: 35px; padding-left: 35px;margin-right: auto;margin-left: auto;">
<div class="card bg-light mb-3 card text-center col1 " style="max-width: 100%; width: 100%;">
<div class="card-header ">${custOrd.getImage().description}
</div>
  <div class="row no-gutters" >
    <div class="col-md-4">
      <img src="data:image/jpeg;base64,${custOrd.getImage().getImageString()}" class="rounded mx-auto d-block img-fluid" alt="...">
    </div>
   
    <div class="col-md-8">
    
    
      <div class="card-body">
        <p class="card-text" style="font-size:15px">Vendor Name:${custOrd.getVendor().name} ${custOrd.getVendor().sirname}    </p>
        <p class="card-text" style="font-size:15px">Vendor Email:${custOrd.getVendor().email}  </p>
        <p class="card-text" style="font-size:15px">Vendor Address:${custOrd.getVendor().address}  </p>
        <p class="card-text" style="font-size:15px">Vendor Mobile:${custOrd.getVendor().mobile}  </p>
        <p class="card-text" style="font-size:15px">Vendor Status:${custOrd.getOrder().orderstatus}  </p>
         <c:set var = "payid" scope = "session" value = "${custOrd.getPaymentBean().getPaymentId()}"/>	
                             <c:set var = "porderid" scope = "session" value = "${custOrd.getPaymentBean().getPorderid()}"/>						
                             	
                             <c:choose>
							    <c:when test="${empty payid}">
							    ${custOrd.getPaymentBean().getPorderid()}
							    <button id="${porderid}" class="payB btn btn-primary btn-lg" onclick="paymoney(this,${custOrd.getOrder().oid},${custOrd.getIdol().getPriceofidol()})">pay</button>
							         
							    </c:when>
							    <c:otherwise>
			    <c:set var = "tmp" scope = "session" value = "${custOrd}"/>	
			<a method="post" href="./GenReceipt?apporderId=<c:out value="${custOrd.getOrder().oid}"/>"> Receipt </a>
                
							    
							    </c:otherwise>
							</c:choose>
        
        
      </div>
    </div>
  </div>
</div>
</div>
<br>

</c:forEach>

</div>



	
	<!-- 
	<table class="table table-bordered table-hover table-primary"  >
         <thead>
            <tr>
               <th>OID</th>
               <th>DESCRIPTION</th>
               <th>IMAGE</th>
                <th>VENDOR NAME </th>
                <th>VENDOR SIRNAME</th>
                <th>VENDOR EMAIL</th>
                 <th>VENDOR ADDRESS</th>
                 <th>VENDOR MOBILE </th>
                 <th>STATUS</th>  
                   <th>PAYMENT</th>      
            </tr>
         </thead>
         <tbody>
         <c:forEach items="${orderData}" var="custOrd">
          <tr>
                         <td>${custOrd.getOrder().oid}</td>
                         <td>${custOrd.getImage().description}</td>
                         <td><img src="data:image/jpeg;base64,${custOrd.getImage().getImageString()}" style="width:200px; height:200px;"></td>
                         <td>${custOrd.getVendor().name}</td>
                           <td>${custOrd.getVendor().sirname}</td>
                             <td>${custOrd.getVendor().email}</td>
                               <td>${custOrd.getVendor().address}</td>
                                 <td>${custOrd.getVendor().mobile}</td>
					         <td>${custOrd.getOrder().orderstatus}</td>
		                   <td>
                             <c:set var = "payid" scope = "session" value = "${custOrd.getPaymentBean().getPaymentId()}"/>	
                             <c:set var = "porderid" scope = "session" value = "${custOrd.getPaymentBean().getPorderid()}"/>						
                             	
                             <c:choose>
							    <c:when test="${empty payid}">
							    ${custOrd.getPaymentBean().getPorderid()}
							    <button id="${porderid}" class="payB" onclick="paymoney(this,${custOrd.getOrder().oid},${custOrd.getIdol().getPriceofidol()})">pay</button>
							         
							    </c:when>
							    <c:otherwise>
			    <c:set var = "tmp" scope = "session" value = "${custOrd}"/>	
			<a method="post" href="./GenReceipt?apporderId=<c:out value="${custOrd.getOrder().oid}"/>"> Receipt </a>
                
							    
							    </c:otherwise>
							</c:choose>
									                      
		                   
		                   </td>
            </tr>
        </c:forEach>
           
         </tbody>
 </table> -->	

<footer>
  <div class="container-fluid fc " >
    <div class="row">
      <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 segment-one">
        <h3>Website</h3>
        <p class="footer-p1">provides the best source of learning and experienced faculties.</p>
        <div class="dis ">
        
        <a href="#" class="icon1"><i class="fa fa-facebook icon"></i></a>
        <a href="#" class="icon3"  ><i class="fa fa-instagram icon"></i></a>
        <a href="#" class="icon4" ><i class="fa fa-linkedin icon"></i></a>
        </div>
      </div>
      <div class=" col-lg-4 col-md-6 col-sm-12 col-xs-12 segment-two ">
        <h2>Quick Links</h2>
        <ul>
            <li><a href="LandingPage2.html">Home</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="guidelines.html">Guidelines</a></li>
            <li><a href="login.html">Login/Register</a></li>
        </ul>
      </div>
      
      <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 segment-four ">
        <h2>Contact.</h2>
        <p  class="footer-p"><i class="fa fa-map-marker" aria-hidden="true"></i>
        Nigdi, Pune-411044.
        </p>

        <a href="tel:8416521879"><i class="fa fa-phone" aria-hidden="true"></i>
  +917987167487</a><br>
 
  <a href="#"><i class="fa fa-envelope" aria-hidden="true"></i>
  contact@ganeshidol.com</a><br>
 

      </div>   
    </div>
  </div>
  <p class="footer-bottom m-0">All Right reserved by ©  </p>
</footer> 

	

     <script src="https://checkout.razorpay.com/v1/checkout.js"></script> 

<script type="text/javascript">
function receipt(apporderId){
	alert(apporderId);
	var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {

         }
    };
    xhttp.open("POST", "./GenReceipt?apporderId="+apporderId, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
	
}

function paymoney(refere,appOrderId,priceofidol){
 	alert("in paymoney");
 	  var porderid;
      var pamount;
 	 var xhttp = new XMLHttpRequest();
	    xhttp.onreadystatechange = function() {
	         if (this.readyState == 4 && this.status == 200) {

			alert("click pay on button again");
			j=JSON.parse(this.responseText)
			porderid=j['modelJson']['map']['id'];
			pamount=j['modelJson']['map']['amount'];
			finalizePayment(refere,pamount,porderid,j);
	         }
	    };
	    xhttp.open("POST", "./PaymentGateway?appOrderId="+appOrderId+"&priceofidol="+priceofidol, false);
	    xhttp.setRequestHeader("Content-type", "application/json");
	    xhttp.send();
 	 
 	 		
 		        						
 		        				
 }
 
 function finalizePayment(refere,pamount,porderid,porderdata){
	 PaymentDataSet={};
	 PaymentDataSet["appOrderId"]=porderdata["appOrderId"];
	 PaymentDataSet["created_at"]=porderdata["modelJson"]["map"]["created_at"];
	 PaymentDataSet["porderid"]=porderid;

	 
	 var options = {
			    "key": "rzp_test_lZmuryZn8heqcu", 
			    "amount": "NA", 
			    "currency": "INR",
			    "name": "GaneshIdol Project",
			    "description": "Test Transaction",
			    "image": "https://example.com/your_logo",
			    "order_id": "NA", 
			    "handler": function (response){
			        
			        PaymentDataSet["payid"]= response.razorpay_payment_id;
			        
			        PaymentDataSet["signature"]= response.razorpay_signature;
			        alert("payment done");
			        window.location.href = "./customerGetOrderStatus";

			        var xhttp = new XMLHttpRequest();
				    xhttp.onreadystatechange = function() {
				         if (this.readyState == 4 && this.status == 200) {
			
				         }
				    };
				    xhttp.open("POST", "./PaymentSuccess", false);
				    xhttp.setRequestHeader("Content-type", "application/json");
				    xhttp.send(JSON.stringify(PaymentDataSet));
			    },
			    "prefill": {
			        "name": "Sagar Lahade",
			        "email": "sl@example.com",
			        "contact": "9766180110"
			    },
			   
			    "notes": {
			        "address": "Razorpay Corporate Office"
			    },
			    "theme": {
			        "color": "#3399cc"
			    }
			};

			options['amount']=pamount;
			options['order_id']=porderid;
			var rzp1 = new Razorpay(options);
			rzp1.on('payment.failed', function (response){
			        alert(" payment failed ");
			        
			        PaymentDataSet["paymentFailedReson"]=response.error.reason;
			        
			        
			});
			
			refere.onclick = function(e){
			    rzp1.open();
			    e.preventDefault();
			}
	
 }
</script>
</body>
</html>