<%@include file="header.jsp" %>
<div class="container">
  <div class="well well-big" >
 
              <div class="row">
            <div class="span15">

                <div class="col-lg-8 col-lg-offset-2">
<center>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-10 clearfix" id="checkout">

<!--                         <div class="box"> -->
                            <form method="post" action="shop-checkout4.html">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="<c:url value="/previous"/>"></a><i class="fa fa-map-marker"></i><br>Billing Adress</a></li>
                                    <li class="active"><a href="<c:url value="/pay"/>"><i class="fa fa-money"></i><br>Confirm Your Order</a></li>
                                    <li class="disabled"><a href="<c:url value="/orderconfirmation"/>"><i class="fa fa-eye"></i><br>Shipment Address</a></li>
                                </ul>

<!--                                 <div class="container"> -->
<!--                                    <div class="row"> -->
                                       
<!--                                             <div class="box payment-method"> -->
											<center>
                                                <h4>Billing Address</h4>
                                                <table class="table" style="border: 1px solid black; border-collapse: collapse;">
                                               
		                                     <tr style="border: 1px solid black; border-collapse: collapse;"><td style="border: 1px solid black; border-collapse: collapse;">   <p>BillName: </p></td>
		                                     <td style="border: 1px solid black; border-collapse: collapse;">   <p>${billing.getBillName()} </p></td></tr>
                                             <tr style="border: 1px solid black; border-collapse: collapse;padding: 15px">  <td style="border: 1px solid black; border-collapse: collapse;"> <p>Bill Address: </p></td>
                                             <td style="border: 1px solid black; border-collapse: collapse;"> <p>${billing.getBillAddress()} </p></td></tr>
                                              <tr style="border: 1px solid black; border-collapse: collapse;"> <td style="border: 1px solid black; border-collapse: collapse;"> <p>PhoneNo: </p></td>
                                              <td style="border: 1px solid black; border-collapse: collapse;"> <p>${billing.getBillPhno()} </p></td></tr>
                                                <tr style="border: 1px solid black; border-collapse: collapse;"><td style="border: 1px solid black; border-collapse: collapse;"><p>Country: </p></td>
                                                <td style="border: 1px solid black; border-collapse: collapse;"><p>${billing.getCountry()} </p></td></tr>
                                                 <br></center>
                                           </table>
                                        </div>
                                        <div class="col-sm-6">
<!--                                             <div class="box payment-method"> -->
											<center>
                                                <h4>Shipment Address</h4>
                                               <table class="table" style="border: 1px solid black; border-collapse: collapse;">
                                                <tr style="border: 1px solid black; border-collapse: collapse;"><td style="border: 1px solid black; border-collapse: collapse;"><p>Name:</td><td style="border: 1px solid black; border-collapse: collapse;">${shippingAddress.getShipName()} .</p></td></tr>
                                               <tr style="border: 1px solid black; border-collapse: collapse;"><td style="border: 1px solid black; border-collapse: collapse;"> <p>Address:</td><td style="border: 1px solid black; border-collapse: collapse;">${shippingAddress.getAddress()} .</p></td></tr>
                                                <tr style="border: 1px solid black; border-collapse: collapse;"><td style="border: 1px solid black; border-collapse: collapse;"><p>Phone:</td><td style="border: 1px solid black; border-collapse: collapse;">${shippingAddress.getPhno()} .</p></td></tr>
                                                
                                            
                                            </div>
                                        </div>
</center>
                                        
                                        </div>
                                    </div>
									
                                    <!-- /.row -->
									<div class="content">
									<div class="row">
									<div class="col-lg-8 col-lg-offset-2">
									<table style="border: 1px solid black" >
    <thead style="border: 1px solid black">
      <tr style="background-color: #eee">
      <th style="border: 1px solid black">Product Image</th>
        <th style="border: 1px solid black">Product Name</th>
<!--         <th>Description</th> -->
        <th style="border: 1px solid black">Category Name</th>
        <th style="border: 1px solid black">Seller Name</th>
        <th style="border: 1px solid black">Price</th>
      </tr>
    </thead>
    <tbody>
   
    <c1:if test="${prot!=null}">
      <tr>
        <td style="border: 1px solid black"><img src="<c:url value='/resources/images/${prot.getProductId()}.jpg'/>" width=150px height=200px></td>
        <td style="border: 1px solid black">${prot.getProductName()}</td>
<%--         <td>${product.getDes()}</td> --%>
        <td style="border: 1px solid black">${prot.getCategory().getCatName()}</td>
        <td style="border: 1px solid black">${prot.getSupplier().getSupplierName()}</td>
        <td style="border: 1px solid black">${prot.getProductPrice()}</td>
      </tr>
      </c1:if>
    <c1:if test="${prot==null}">
     <c1:forEach items="${cartItems}" var="c1">
      <tr>
        <td style="border: 1px solid black"><img src=""></td>
        <td style="border: 1px solid black">${c1.getProduct().getProductName()}</td>
<%--         <td>${c1.getproduct.getDes()}</td> --%>
        <td style="border: 1px solid black">${c1.getProduct().getCategory().getCatName()}</td>
        <td style="border: 1px solid black">${c1.getProduct().getSupplier().getSupplierName()}</td>
        <td style="border: 1px solid black">${c1.getProduct().getProductPrice()}</td>
      </tr>
      </c1:forEach>
      </c1:if>
   

  </tbody>
 </table>
     <p calss="pull-left">Total price=Rs${prot.getProductPrice()}</p>
			<h2> Order will Be delivered to You with in 7 busisness days</h2>						
			</div>
									</div>
									</div>
                                <div class="box-footer">
                                         <div class="pull-left">
                                        <a href="<c:url value="/previous"/>" class="btn btn-default"><i class="fa fa-chevron-left"></i>previous</a>
                                        </div>
                                         <div class="pull-right">
                                        <a href="<c:url value="/pay"/>"  class="btn btn-template-main"><i class="fa fa-chevron-right">Pay</i></a>
                                        </button>
                                        </div>
                                     </div>
                                </div>
                                <!-- /.content -->
                                
                                

    </div>
</table>

    

