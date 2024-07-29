<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>

 <title>Ganesh Idol Project</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
  <link rel="stylesheet" type="text/css" href="../assets/css/contact.css">

  <link rel="stylesheet" type="text/css" href="../assets/css/footer.css">
  <link rel="stylesheet" href="style.css"/>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif&family=Rubik&display=swap" rel="stylesheet">
 
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

h5,p{
font-family: 'Noto Serif', serif;
text-transform: uppercase;
font-weight : bold;
}
  
</style>
</head>
<body onload="updateVendorList()" style=" background-color :#20bf55;
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
            <a class="nav-link" href="../VendorDashboard.html" >Dashboard </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../login.html" >Logout</a>
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
  <!-- Navbar -->
  <br>
  <br>


<div class="container" >
<h2 style="color: white;text-align: center; margin: 20px; padding: 10px;text-shadow : 1px 1px #000000;text-transform:uppercase;">web based tool for idol immersion management and analysis</h2>
  <h3 style="color: white;text-align: center; margin: 20px; padding: 10px;text-shadow : 1px 1px #000000;text-transform:uppercase;">QR Generation</h3>

<div class="row">
  <div class="col-sm-6">
    <div class="card text-center border-dark col1">
      <div class="card-body">
        <h5 class="card-title">Select Vendor Id</h5>
        <p class="card-text">Select specific vendor from various vendors.</p>
         

    <select id="vendorlistdata" name="vendorlist">
        <option value="none" selected disabled hidden>Select Vendor</option> 
    
        <c:forEach items="${vendorList}" var="vendor">
            <option value="${vendor.vid}">${vendor.name}</option>
        </c:forEach>
    </select>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card text-center border-dark col1">
      <div class="card-body">
        <h5 class="card-title">Select Order Number</h5>
        <p class="card-text">Select specific order number from specific vendor</p>
        
 	<select id="orderlistdata" name="orderlist">
 	        <option value="none" selected disabled hidden>Select an Option</option> 
 	
    </select>
      </div>
    </div>
  </div>
</div>
</div>
<br>
<br>

<div >
    
   </div> 
  
    

       
    
    <div id="details">
    </div>
            <img alt="" src="" id="imgshow" class="rounded mx-auto d-block">
    <div class="col text-center">
        <button class="btn btn-primary" onclick="window.print()">Print QR
</button>
    </div>
    
     <div id="detailsnew ">
     
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

    
</body>
 <script language="javascript">
 function updateVendorList() {
	    var xhttp = new XMLHttpRequest();
	    xhttp.onreadystatechange = function() {
	         if (this.readyState == 4 && this.status == 200) {
	        	 document.getElementById('vendorlistdata').innerHTML = this.responseText;
	             alert(this.responseText+"hi sagar");
	         }
	    };
	    xhttp.open("POST", "<%=request.getContextPath()%>/createQRcode", true);
	    xhttp.setRequestHeader("Content-type", "application/json");
	    xhttp.send();
	}
 
 let vendorchangeevent = document.querySelector("#vendorlistdata");
 let orderdata = document.querySelector("#orderlistdata");

	 vendorchangeevent.addEventListener("change", function() {
		  alert("change occured");
		  var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		         if (this.readyState == 4 && this.status == 200) {
		        	 const data = JSON.parse(this.responseText);
		        	    let option;
		        	    for (let i = 0; i < data.length; i++) {
		        	  
		        	      option = document.createElement('option');
		        	      option.text = data[i].oid;
		        	      orderdata.add(option,i);
		        	    }
		        	 
		         }
		    };
		    xhttp.open("POST", "<%=request.getContextPath()%>/getOrdersByVendorServlet?vid="+vendorchangeevent.value, true);
		    xhttp.setRequestHeader("Content-type", "application/json");
		    xhttp.send();
		});
	 

	 document.querySelector("#orderlistdata").addEventListener("change", function() {
			  alert("change occured 2");
			  var xhttp = new XMLHttpRequest();
			    xhttp.onreadystatechange = function() {
			         if (this.readyState == 4 && this.status == 200) {
			        	 document.getElementById('details').innerHTML = this.responseText;

			         }
			    };
			    xhttp.open("POST", "<%=request.getContextPath()%>/QRdataFetch", true);
			    xhttp.setRequestHeader("Content-type", "application/json");
			    xhttp.send(orderdata.value);
			});
	 
	 function getQR(orderid){
		 alert("change occured 3");
		  var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		         if (this.readyState == 4 && this.status == 200) {
		        	 if(!(this.responseText==="QR NOT CREATED")){
		        	 srcc="data:image/png;base64,"+this.responseText;
		        	 document.getElementById('imgshow').src=srcc;
		        	 }else {
			        	 document.getElementById('detailsnew').innerHTML = this.responseText;
 
		        	 }

		         }
		    };
		    xhttp.open("POST", "<%=request.getContextPath()%>/QRCodeCreator?oid="+orderdata.value, true);
		    xhttp.setRequestHeader("Content-type", "application/json");
		    xhttp.send();
	 }
	
    </script>
</html>