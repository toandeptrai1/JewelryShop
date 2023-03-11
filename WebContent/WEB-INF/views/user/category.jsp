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
				<li>Category</li>
			</ul>
		</div>
		<!-- / container -->
	</div>
	<div id="body">
		<div class="container">
		
			
			<div class="products-wrap">
				<aside id="sidebar" style="color: aliceblue;">
					<h3>LOẠI SẢN PHẨM</h3>
						<ul >
						
							<li><a href="/JewelryShop/category?cid=1" style="color: aliceblue;"><span
								> Đồng hồ  </span></a></li>
								
						
							<li><a href="/JewelryShop/category?cid=3" style="color: aliceblue;"><span
								> Bông tai  </span></a></li>
								
						
							<li><a href="/JewelryShop/category?cid=2" style="color: aliceblue;"><span
								> Nhẫn  </span></a></li>
								
						
							<li><a href="/JewelryShop/category?cid=5" style="color: aliceblue;"><span
								> Vòng cổ</span></a></li>
								
						
							<li><a href="/JewelryShop/category?cid=4" style="color: aliceblue;"><span
								> Dây chuyền  </span></a></li>
								
							
						</ul>
					
				</aside>
				<div id="content">
					<section class="products">
						
						<c:forEach items="${ListP}" var="item">
							<article>
								<a href="/JewelryShop/product?pid=${item.product_id }"><img src="/JewelryShop/assets/images/${item.product_img }" alt="" style="width: -webkit-fill-available;"></a>
								<h3><a href="/JewelryShop/product?pid=${item.product_id }">${item.product_name }</a></h3>
								<h4><a href="/JewelryShop/product?pid=${item.product_id }"><fmt:formatNumber type="number" groupingUsed="true" value="${item.product_price }" />₫</a></h4>
								<a href="/JewelryShop/cart/add/${item.product_id }" class="btn-add">Thêm giỏ hàng</a>
							</article>
						
						</c:forEach>
					</section>
				</div>
				<!-- / content -->
			</div>
			
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->

	



</body>


