<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<body>
	<main id="main" class="main">

    <div class="pagetitle">
      <h1>Product</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Product</li>
          <li class="breadcrumb-item active">Edit Product</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">


                <li class="nav-item">
                  <button class="nav-link active " data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Product</button>
                </li>

              </ul>
              <div class="tab-content pt-2">

                

                <div class="tab-pane fade show active profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form action="/JewelryShop/quan-tri/product/uploadFile" enctype="multipart/form-data" method="post">
                  	<div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Product Image</label>
                      <input type="hidden" name="id" value="${Product.product_id }" />
                      <div class="col-md-8 col-lg-9">
                      	<c:choose>
                      		<c:when test="${FileName!=null}">
                      			    <img src="/JewelryShop/assets/images/${FileName}" alt="Profile">
                      		</c:when>
                      		<c:otherwise>
                      			<img src="/JewelryShop/assets/images/${Product.product_img}" alt="Profile">
                      			
                      		</c:otherwise>
                      	</c:choose>
                    
                        <div class="input-group mt-3">
						  <input type="file" name="multipartFile"  class="form-control" id="inputGroupFile02">
						  <button class="input-group-text" type="submit">Upload</button>
						</div>
                      </div>
                    </div>
                  </form>
                  
                  
                  <form method="post" action="/JewelryShop/quan-tri/product/edit">
                   <div class="row mb-3">
                 
                    <label class="col-md-4 col-lg-3 col-form-label">Category ID</label>
                     <div class="col-md-8 col-lg-9">
                    <select class="form-select" name="cateID" id="floatingSelect" aria-label="State" required="required">
                     
                      		
                      	   <option value="1" ${Product.product_category_id==1?'selected':'' }>Đồng hồ</option>
               	     		<option value="2" ${Product.product_category_id==2?'selected':'' }>Nhẫn</option>
                   	       <option value="3" ${Product.product_category_id==3?'selected':'' }>Bông tai</option>
                  	         <option value="4" ${Product.product_category_id==4?'selected':'' }>Dây chuyền</option>
                  	           <option value="5" ${Product.product_category_id==5?'selected':'' }>Vòng cổ</option>
                  	             
                     
                      
                    </select>
                      </div>
                
                </div>
                    

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Product Name</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="pname" type="text" class="form-control" id="fullName" value="${Product.product_name }">
                      </div>
                    </div>

                  

                  

                    

                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Price</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="price" type="text" class="form-control" id="Address" value="${Product.product_price }">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Decription</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="desc" type="text" class="form-control" id="Phone" value="${Product.product_long_desc }">
                      </div>
                    </div>

                    
                    <input name="id" type="hidden" class="form-control" id="Email" value="${Product.product_id}">
                    <c:choose>
                      		<c:when test="${FileName!=null}">
                      			   
                      			    <input name="img" type="hidden" class="form-control" id="Email" value="${FileName}">
                      		</c:when>
                      		<c:otherwise>
                      			
                      			<input name="img" type="hidden" class="form-control" id="Email" value="${Product.product_img}">
                      		</c:otherwise>
                     </c:choose>
                     

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

                </div>



              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

</body>

