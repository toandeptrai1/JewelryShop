<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<body>
	<main id="main" class="main">

    <div class="pagetitle">
      <h1>Product</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Product</li>
          <li class="breadcrumb-item active">Product View</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="row">
      	<!-- Top Selling -->
            <div class="col-12">
              <div class="card top-selling overflow-auto">

                

                <div class="card-body pb-0">
                  <h5 class="card-title">Products View</h5>

                  <table class="table table-borderless w-50 table-bordered">
                    <thead>
                      <tr>
                      
                        <th scope="col">Image</th>
                        <th scope="col">Product ID</th>
                       
                        <th scope="col">Product Name</th>
                        <th scope="col">Price</th>
                        
                        <th scope="col" colspan="2">Thực Hiện</th>
                      </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="item" items="${ListP }">
                    	<tr>
                        <th scope="row"><a href="#"><img src="<%=request.getContextPath()%>/assets/images/${item.product_img}" alt=""></a></th>
                         <td class="fw-bold">${item.product_id }</td>
                    		
                      
                        <td>${item.product_name }</td>
                        <td class="fw-bold">${item.product_price }</td>
                       
                        <td><a href="/JewelryShop/quan-tri/product/edit?id=${ item.product_id}" class="btn btn-primary btn-sm"><i class="fa-solid fa-user-pen"></i></a></td>
                        <td><button class="btn btn-danger btn-sm " data-bs-toggle="modal" data-bs-target="#modal${item.product_id }"><i class="fa-solid fa-trash-can"></i></button></td>
                      </tr>
                     

						<!-- Modal -->
						<div class="modal fade" id="modal${item.product_id }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						       Bạn có muốn xóa ${item.product_name } không?
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						        <a href="/JewelryShop/quan-tri/product/delete?id=${ item.product_id}"  class="btn btn-primary">Save changes</a>
						      </div>
						    </div>
						  </div>
						</div>
                    	</c:forEach>
                     
                     
                    </tbody>
                  </table>

                </div>

              </div>
            </div><!-- End Top Selling -->
    
      	 
       

       
      </div>
    </section>

  </main><!-- End #main -->

</body>

