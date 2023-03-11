<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<body>
	<link rel="stylesheet" media="all" href="/JewelryShop/assets/css/bootstrap.min.3.2.0.css">
	<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="trang-chu.htm">Home</a></li>
				<li>CheckOut</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	 <br>
	  <br>
	   <br>
<div class="container wrapper">
         
           
            <div class="row cart-body">
                 
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                    <!--REVIEW ORDER-->
                    <div class="panel panel-info">
                        <div class="panel-heading panel-primary" style="background-image: linear-gradient(to bottom, #555 0px, #888 100%); color: white;">
                            Xem lại đơn đặt hàng <div class="pull-right"><small><a class="afix-1" style="color: white;" href="/JewelryShop/cart">Sửa Giỏ Hàng</a></small></div>
                        </div>
                        <div class="panel-body form-horizontal">
                      
                       
                        <c:forEach items="${Cart}" var="item">
                        	 <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="/JewelryShop/assets/images/${item.value.product.product_img }"/>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">${item.value.product.product_name }</div>
                                     
                                    <div class="col-xs-12"><small>Số lượng:<span>${item.value.quantity}</span></small></div>
                                   
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><fmt:formatNumber type="number" groupingUsed="true" value="${item.value.getTotalPrice()}" /> VNĐ</h6>
                                </div>
                                 
                            </div>
                           <hr>
                        </c:forEach>
                     
                          
                            
                            
                       
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Tổng tiền đơn hàng</strong>
                                    <div class="pull-right colordo"><span><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPrice}"/> VNĐ</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--REVIEW ORDER END-->
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-info">
                        <div class="panel-heading" style="background-image: linear-gradient(to bottom, #555 0px, #888 100%); color: white;">Đơn đặt hàng</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <h4>Thanh toán đơn hàng</h4>
                                </div>
                            </div>
                            <div class="form-group">
                               
                            </div>
                   <form action="/JewelryShop/thanhtoan" method="POST"  class="form-horizontal">
                   			 <div class="form-group">
                                <div class="col-md-12"><strong>Họ và tên:</strong></div>
                                <div class="col-md-12">
                                  <input type="text" class="form-control" name="hoten" placeholder="Họ và tên" value="${User.user_fullname }" />  
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Số điện thoại:</strong></div>
                                <div class="col-md-12">
                                  <input type="text" class="form-control" name="sdt" placeholder="Nhập số điện thoại" value="${User.user_phone }" />  
                                </div>
                            </div>
                            
                              <div class="form-group">
                                <div class="col-md-12"><strong>Phương thức thanh toán:</strong></div>
                                <div class="col-md-12">
                                  <select name ="thanhtoan">
                                  <option value="1">Thanh toán khi nhận hàng</option>
                                  </select>
                                </div>
                            </div>
                                <div class="form-group">
                                <div class="col-md-12"><strong>Địa chỉ nhận hàng:*</strong></div>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Nhập địa chỉ nhận hàng" name="diachi" class="form-control" value="${User.user_address }"/>
                                    <errors path="diaChiNhanHang" class="text-danger"/>
                                </div>
                            </div>
                              
                                  <div class="form-group">
                                <div class="col-md-12"><strong>Ghi Chú:</strong></div>
                                <div class="col-md-12">
                                    <textarea type="text" path="ghiChu" name="notes"  class="form-control " cols="100" rows="4" ></textarea>
                                </div>
                            </div>
                            <div class="form-group test">
                            <div class="col-xs-12">
                                
                             
  
   							<button type="submit" class="btn btn-primary btn-submit-fix center-block" onclick="alert('Thanh toán thành công')">Thanh toán</button>
  

  
                             
                               
                                
 							</div>
                            </div>
                            </form>
                        </div>
                    </div>
                    <!--SHIPPING METHOD END-->
                    <!--CREDIT CART PAYMENT-->
                    
                
                    <!--CREDIT CART PAYMENT END-->
                </div>
                
             	
            </div>
            <div class="row cart-footer">
        
            </div>
            
    </div>

</body>


