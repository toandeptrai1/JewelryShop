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
					<li class="breadcrumb-item">Category</li>
					<li class="breadcrumb-item active">Category Views</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Category Views</h5>
							

							<table class="table table-striped table-lg w-25 table-bordered">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Category Name</th>
										
										<th scope="col" colspan=2>Thực hiện</th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach items="${listCate}" var="item">
											<tr>
											<th scope="row">${item.category_id }</th>
											<td>${item.category_name }</td>
											
											<td  ><a href="/JewelryShop/quan-tri/category/edit?id=${item.category_id}" class="btn btn-primary btn-sm"><i class="fa-solid fa-user-pen"></i></a></td>
											

										
											<td ><a href="#"  data-bs-toggle="modal" data-bs-target="#modal${item.category_id }"  class="btn btn-danger btn-sm "><i class="fa-solid fa-trash-can"></i></a></td>
												<!-- Modal -->
											<div class="modal fade" id="modal${item.category_id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
											  <div class="modal-dialog">
											    <div class="modal-content">
											      <div class="modal-header">
											        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
											        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
											      </div>
											      <div class="modal-body">
											       Bạn có muốn xóa thể loại ${item.category_name } không?
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
											        <a href="/JewelryShop/quan-tri/category/delete?id=${ item.category_id}" class="btn btn-primary">Save changes</a>
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

