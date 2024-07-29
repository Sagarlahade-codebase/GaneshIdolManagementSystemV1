<%@page import="ganeshmurthi.model.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="./assets/css/footer.css">
      
      <title>Ganesh Idol Project</title>
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
            <a class="nav-link" href="./VendorDashboard.html" >Dashboard </a>
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
   <h3 style="color: white;text-align: center; margin: 20px; padding: 20px;text-shadow : 1px 1px #000000;text-transform:uppercase;">Customer  details</h3>

   <h3 style="color: white;text-align: center; margin: 20px; padding: 20px;text-shadow : 1px 1px #000000;text-transform:uppercase;">Total number of order recieved: ${custOrd.size()}</h3>
			 <c:forEach items="${custOrd}" var="custOrd">
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
        <p class="card-text" style="font-size:15px">CUSTOMER Name:${custOrd.getCustomer().name} ${custOrd.getCustomer().sirname}    </p>
        <p class="card-text" style="font-size:15px">CUSTOMER Email:${custOrd.getCustomer().email}  </p>
        <p class="card-text" style="font-size:15px">CUSTOMER Address:${custOrd.getCustomer().address}  </p>
        <p class="card-text" style="font-size:15px">CUSTOMER Mobile:${custOrd.getCustomer().mobile}  </p>
        <p class="card-text" style="font-size:15px">CUSTOMER Status:${custOrd.getOrder().orderstatus}  </p>
        
        
        
      </div>
    </div>
  </div>
</div>
</div>
</c:forEach>
</div>

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

   
   
  
      <script type="text/javascript">
      function updateStatus(orderid,ostatus) {
    	  var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		         if (this.readyState == 4 && this.status == 200) {
		        	
		        	 window.location ="./getReceivedOrderStatus";
		         }
		    };
		    xhttp.open("POST", "<%=request.getContextPath()%>/updateStatus?oid="+orderid+"&status="+ostatus, true);
		    xhttp.setRequestHeader("Content-type", "application/json");
		    xhttp.send();
      }
      </script>
     
   </body>
  
</html>