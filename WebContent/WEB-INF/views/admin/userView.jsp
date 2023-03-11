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
					<li class="breadcrumb-item">Admin</li>
					<li class="breadcrumb-item active">User Views</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Danh sách người sử dụng</h5>
							

							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Email</th>
										<th scope="col">Phone</th>
										<th scope="col">Tên đăng nhập</th>
										<th scope="col">Tên đầy đủ</th>
										<th scope="col">Địa chỉ</th>
										<th scope="col" colspan=2>Thực hiện</th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach items="${listUser}" var="item">
											<tr>
											<th scope="row">${item.user_id }</th>
											<td>${item.user_email }</td>
											<td>${item.user_phone }</td>
											<td>${item.user_name }</td>
											<td>${item.user_fullname }</td>
											<td>${item.user_address }</td>
											
											<td><a href="/JewelryShop/quan-tri/user/profile?id=${ item.user_id}" class="btn btn-primary btn-sm"><i class="fa-solid fa-user-pen"></i></a></td>
											
											<c:if test="${User.user_id==item.user_id}">
												<td><button disabled class="btn btn-danger btn-sm "><i class="fa-solid fa-trash-can"></i></button></td>
											</c:if>
											<c:if test="${User.user_id!=item.user_id}">
											<td><a href="#" data-bs-toggle="modal" data-bs-target="#modal${item.user_id }" class="btn btn-danger btn-sm "><i class="fa-solid fa-trash-can"></i></a></td>
											</c:if>
											<!-- Modal -->
											<div class="modal fade" id="modal${item.user_id }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
											  <div class="modal-dialog">
											    <div class="modal-content">
											      <div class="modal-header">
											        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
											        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
											      </div>
											      <div class="modal-body">
											       Bạn có muốn xóa ${item.user_fullname }(${item.user_name }) không?
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
											        <a href="/JewelryShop/quan-tri/user/delete?id=${ item.user_id}" class="btn btn-primary">Save changes</a>
											      </div>
											    </div>
											  </div>
											</div>
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

