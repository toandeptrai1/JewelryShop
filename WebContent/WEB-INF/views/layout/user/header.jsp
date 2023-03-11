<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header id="header">
	<div class="container">
		<a href="index.html" id="logo" title="Diana’s jewelry">Diana’s
			jewelry</a>
		<div class="right-links">
			<ul>
				<c:if test="${User.user_role== 1 }">
					
					<li><a href="/JewelryShop/quan-tri/"><span class="ico-signout"></span>Quản trị</a></li>
				</c:if>
				<li><a href="/JewelryShop/cart"><span class="ico-products"></span>${Cart.size() }
						products,<c:if test="${User!=null }"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPrice}" /> ₫ </a></c:if>
						<c:if test="${User==null&&Cart==null }">0 ₫ </a></c:if>
						<c:if test="${User==null&&Cart!=null }"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPrice}" /> ₫ </a></c:if>
						</li>
				
				<c:if test="${User!= null }">
					<li><a href="/JewelryShop/profile"><span class="ico-account"></span>Hello ${User.user_name }</a></li>
					<li><a href="/JewelryShop/dang-xuat"><span class="ico-signout"></span>Đăng xuất</a></li>
				</c:if>
				<c:if test="${User== null }">
					
					<li><a href="/JewelryShop/dang-nhap"><span class="ico-signout"></span>Đăng Nhập</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- / container -->
</header>
<!-- / header -->


<nav id="menu">
	<div class="container">
		<div class="trigger"></div>
		<ul>
			<li><a href="/JewelryShop/">Trang chủ</a></li>
			<c:forEach items="${listC }" var="item">
				<li><a href="/JewelryShop/category?cid=${item.category_id}" >${item.category_name}</a></li>
			</c:forEach>
		</ul>
	</div>
	<!-- / container -->
</nav>
<!-- / navigation -->
