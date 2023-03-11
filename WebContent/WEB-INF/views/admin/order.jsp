<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>

<title>Admin</title>
<body>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>User Managerment</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">Order</li>
					<li class="breadcrumb-item active">Order Views</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Order Views</h5>
							

							<table class="table table-striped table-lg w-25 table-bordered">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Total</th>
										<th scope="col">Phone</th>
										<th scope="col">Address</th>
										<th scope="col">Notes</th>
										
										
										<th scope="col" colspan=2>Thực hiện</th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach items="${listOrder}" var="item">
											<tr>
											<th scope="row">${item.order_id}</th>
											<td><fmt:formatNumber type="number" groupingUsed="true" value="${item.order_amount }" /></td>
											<td>${item.order_phone }</td>
											<td>${item.order_ship_address }</td>
											<td>${item.order_notes }</td>
										
											<td  ><a href="/JewelryShop/quan-tri/order/view" class="btn btn-primary btn-sm"><i class="fa-solid fa-user-pen"></i></a></td>
											

										
											<td ><a href="#"  class="btn btn-danger btn-sm "><i class="fa-solid fa-trash-can"></i></a></td>
									
										
											
										</tr>
									</c:forEach>

								</tbody>
							</table>

						</div>
					</div>








				</div>

			</div>
		</section>

	</main>
	<!-- End #main -->


</body>

