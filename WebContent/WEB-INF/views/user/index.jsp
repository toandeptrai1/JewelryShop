<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	
	<div id="slider">
		<ul>
			<li style="background-image: url(assets/images/01.jpeg)">
				<h3>Make your life better</h3>
				<h2>Genuine diamonds</h2> <a href="#" class="btn-more">Read more</a>
			</li>
			<li class="purple" style="background-image: url(assets/images/0.jpeg)">
				<h3>She will say “yes”</h3>
				<h2>engagement ring</h2> <a href="#" class="btn-more">Read more</a>
			</li>
			<li class="yellow" style="background-image: url(assets/images/01.jpeg)">
				<h3>You deserve to be beauty</h3>
				<h2>golden bracelets</h2> <a href="#" class="btn-more">Read more</a>
			</li>
		</ul>
	</div>
	<!-- / body -->

	<div id="body">
		<div class="container">
			<div class="last-products">
				<h2>Sản phẩm mới</h2>
				<section class="products">
					<c:forEach items="${listNewP}" var="item">
						<article >
							<img src="/JewelryShop/assets/images/${item.product_img }" alt="" style="width: inherit;">
							<h3></h3>
							<h4>${item.product_name }</h4>
							<a href="/JewelryShop/cart/add/${item.product_id }" class="btn-add">Thêm giỏ hàng</a>
						</article>
						
					</c:forEach>
					
				</section>
			</div>
			
			<div id="content">
					<section class="products">
						<h3><a href="/JewelryShop/category?cid=1">Đồng Hồ</a></h3>
						<c:forEach items="${listPByCate}" var="item" >
							<article style="margin: 0px 40px 20px 0px;">
								<a href="/JewelryShop/product?pid=${item.product_id }"><img src="/JewelryShop/assets/images/${item.product_img }" alt="" style="width: -webkit-fill-available;"></a>
								<h3><a href="/JewelryShop/product?pid=${item.product_id }">${item.product_name }</a></h3>
								<h4><a href="/JewelryShop/product?pid=${item.product_id }"><fmt:formatNumber type="number" groupingUsed="true" value="${item.product_price }" />₫</a></h4>
								<a href="/JewelryShop/cart/add/${item.product_id }" class="btn-add">Thêm giỏ hàng</a>
							</article>
						
						</c:forEach>
					</section>
			</div>
		</div>
		<!-- / container -->
	</div>
	<!-- / body -->




</body>


