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
          <li class="breadcrumb-item">Category</li>
          <li class="breadcrumb-item active">Edit Category</li>
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

                 
                  
                  
                  <form method="post" action="/JewelryShop/quan-tri/category/edit">
                  
                
               
                    

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Category Name</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="pname" type="text" class="form-control" id="fullName" value="${Category.category_name }">
                      </div>
                    </div>
                    <input type="hidden" value="${Category.category_id }" name="id">

                  

                  

                    

                   

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

