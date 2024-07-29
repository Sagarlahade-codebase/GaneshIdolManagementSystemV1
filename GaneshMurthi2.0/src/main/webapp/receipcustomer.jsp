<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Receipt</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container" style="padding-right: 35px; padding-left: 35px;margin-right: auto;margin-left: auto;">>
<h3 style="text-align:center">ORDER RECEIPT</h3>
<table class="table table-bordered">
  <tr>
    <th>Customer Name</th>
    <th>Customer Sirname</th>
    <th>Customer Address</th>
    <th>Customer email</th>
     <th>Customer Mobile </th>
    
  </tr>
  <tr>
    <td>${orderData.getCustomer().getName() }</td>
    <td>${orderData.getCustomer().getSirname() }</td>
        <td>${orderData.getCustomer().getAddress() }</td>
        <td>${orderData.getCustomer().getEmail() }</td>
        <td>${orderData.getCustomer().getMobile() }</td>
      </tr>
     
  <tr>
     <th>Idol Image</th>
    <th>Idol Type</th>
    <th>Idol Price</th>
    <th>Idol Size</th>
     <th>Idol Color </th>
  </tr>
  <tr>
  <td><img src="data:image/jpeg;base64,${orderData.getImage().getImageString()}" style="width:200px; height:200px;"></td>

  <td>${orderData.getImage().description}</td>
  <td>${orderData.getIdol().getPriceofidol()}</td>
  <td>${orderData.getIdol().sizeofidol}</td>
  <td>${orderData.getIdol().colorofidol}</td> 
  </tr>
  
   <tr>
       <th>Vendor Name</th>
    <th>Vendor Sirname</th>
    <th>Vendor Address</th>
    <th>Vendor email</th>
     <th>Vendor Mobile </th>
   
   </tr>
  <tr>
        <td>${orderData.getVendor().getName() }</td>
        <td>${orderData.getVendor().getSirname() }</td>
        <td>${orderData.getVendor().getAddress() }</td>
        <td>${orderData.getVendor().getEmail() }</td>
        <td>${orderData.getVendor().getMobile() }</td>
  </tr>
   <tr>
      <th>PAYMENT ID</th>
      <th>PAYMENT DATE</th>
      <th>APP ORDER ID</th>
      <th>PAYMENT ORDER ID</th>
    
   
   </tr>
  <tr>
  <td>${orderData.getPaymentBean().paymentId}</td>
  <td>${orderData.getPaymentBean().date}</td>
  <td>${orderData.getPaymentBean().orderId}</td>
  <td>${orderData.getPaymentBean().porderid}</td>
  </tr>
</table>
    <div class="col text-center">
        <button class="btn btn-primary" onclick="window.print()">Print Receipt
</button>
    </div>
    <br>
</div>

</body>
</html>