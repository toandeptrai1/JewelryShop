<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<!-- / navigation -->

	<div id="breadcrumbs">
		<div class="container">
			<ul>
				<li><a href="#">Home</a></li>
				<li>Cart</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			<div id="content" class="full">
				<div class="cart-table">
					<table>
						<tr>
							<tr>
								<th class="items">SẢN PHẨM</th>
								<th class="price">GIÁ</th>
								<th class="qnt">SỐ LƯỢNG</th>
								<th class="total">TỔNG TIỀN</th>
								<th class="edit">SỬA</th>
								<th class="edit">XÓA</th>
							</tr>
						</tr>
						<c:forEach items="${Cart}" var="item">
							<tr>
								<td class="items">
									<div class="image">
										<img src="/JewelryShop/assets/images/${item.value.product.product_img }" alt="">
									</div>
									<h3><a href="#">${item.value.product.product_name }</a></h3>
									<p>${item.value.product.product_long_desc }</p>
								</td>
								<td class="price"><fmt:formatNumber type="number" groupingUsed="true" value="${item.value.product.product_price}" />₫</td>
								<td class="qnt"><input type="number" min="1" max="100" class="span1" style="max-width:70px" placeholder="1" id="quanty-cart-${item.value.product.product_id}" size="16" type="text" value="${item.value.quantity}"></td>
								<td class="total"><fmt:formatNumber type="number" groupingUsed="true" value="${item.value.getTotalPrice()}" />₫</td>
								<td class="sua"><button data-id="sadsa"
											class="edit-cart" type="button" onclick="edit(${item.value.product.product_id})">Sửa</button></td>
								<td class="xoa"><button data-id="ewqe "
										class="delete-cart ico-del" type="button"  onclick="del(${item.value.product.product_id})"></button></td>
							</tr>
						
						
						</c:forEach>
						
						
					</table>
				</div>
				<c:if test="${TotalPrice!=null&&User!=null}">
					<div class="total-count">
					
					<h3>Tổng tiền: <strong><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPrice}" /> VNĐ</strong></h3>
					<a href="/JewelryShop/checkout" class="btn-grey">Xem đơn hàng</a>
				</div>
					
				</c:if>
					<c:if test="${TotalPrice!=null&&User==null}">
					<div class="total-count">
					
					<h3>Tổng tiền: <strong><strong><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPrice}" /> VNĐ</strong></h3>
					<a href="/JewelryShop/dang-nhap" class="btn-grey">Đăng nhập để mua hàng</a>
				</div>
					
				</c:if>
				<c:if test="${TotalPrice==null&&User==null}">
					<div class="total-count">
					
					<h3>Tổng tiền: <strong><strong>0 VNĐ</strong></h3>
					<a href="/JewelryShop/" class="btn-grey">Tiếp tục mua hàng</a>
				</div>
					
				</c:if>
				<c:if test="${TotalPrice==null&&User!=null}">
					<div class="total-count">
					
					<h3>Tổng tiền: <strong><strong>0 VNĐ</strong></h3>
					<a href="/JewelryShop/" class="btn-grey">Tiếp tục mua hàng</a>
				</div>
					
				</c:if>

				
		
			</div>
			<!-- / content -->
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->
	<script type="text/javascript">
		function edit(id){
			
			let quanty=document.getElementById("quanty-cart-"+id).value;
			window.location="/JewelryShop/cart/edit/"+id+"/"+quanty;
		}
		function del(id) {
			window.location="/JewelryShop/cart/delete/"+id;
		}
		
	
	</script>



</body>


