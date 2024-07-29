<%@page import="ganeshmurthi.model.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
      
      <title>Ganesh Idol Project</title>
   </head>
   <body>
<div class="container" style="padding-right: 35px; padding-left: 35px;margin-right: auto;margin-left: auto;">
     <div class="card text-center">
  	<div class="card-header">
    ${customerData.name} ${customerData.sirname}
  </div>
  <div class="card-body">
    <h5 class="card-title">Customer Details</h5>
    <p class="card-text">OID: ${orderData.oid}</p>
    <p class="card-text">VID: ${orderData.vid}</p>
    <p class="card-text">CID: ${orderData.cid}</p>
    <p class="card-text">QRID: ${orderData.qrid}</p>
    <p class="card-text">CUSTOMER NAME: ${customerData.name} ${customerData.sirname} </p>
    <p class="card-text">CUSTOMER MOBILE NUMBER: ${customerData.mobile}</p>
    <p class="card-text">CUSTOMER EMAIL: ${customerData.email}</p>
    <p class="card-text">CUSTOMER ADDRESS: ${customerData.address}</p>
    <p class="card-text">ORDER STATUS: ${orderData.orderstatus}</p>
    
  </div>

</div>
<br>
   <div class="card text-center">
  	<div class="card-header">
   ${vendorData.name} ${vendorData.sirname}
  </div>
  <div class="card-body">
    <h5 class="card-title">Vendor Details</h5>
    
    <p class="card-text">VENDOR NAME: ${vendorData.name} ${vendorData.sirname} </p>
    <p class="card-text">VENDOR MOBILE NUMBER: ${vendorData.mobile}</p>
    <p class="card-text">VENDOR EMAIL: ${vendorData.email}</p>
    <p class="card-text">VENDOR ADDRESS: ${vendorData.address}</p>
    
    
  </div>

</div>
<br>

   <div class="card text-center">
  	<div class="card-header">
    Idol Details
  </div>
  <div class="card-body">
    <h5 class="card-title">Idol Details</h5>
   	<p class="card-text">IDOL ID: ${idolData.idolid}</p>
    <p class="card-text">IDOL PRICE: ${idolData.priceofidol}</p>
    <p class="card-text">IDOL COLOR: ${idolData.colorofidol}</p>
    <p class="card-text">IDOL SIZE: ${idolData.sizeofidol}</p>
    <p class="card-text">IDOL CONTENTS: ${contentData.contents}</p>
    <p class="card-text">IDOL IS DISPOSABLE: ${idolData.isdisposable}</p>
    
  </div>

</div>
</div>

      
 <div class="container">
  <div class="row">
    <div class="col text-center">
       <button class="btn btn-primary"onclick="acceptIdol(${idolData.idolid})">Accept Idol</button>
    </div>
  </div>
</div>
     
   </body>
  
</html>