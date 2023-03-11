<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<body>
	<main id="main" class="main">

    <div class="pagetitle">
      <h1>Add User</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Users</li>
          <li class="breadcrumb-item active">Add User</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
      	 <div class="col-lg-8">
      	 	        <div class="card">
            <div class="card-body">
              <h5 class="card-title">Add User</h5>

              <!-- Floating Labels Form -->
              <form class="row g-3" method="post" action="/JewelryShop/quan-tri/user/add">
                <div class="col-md-12">
                  <div class="form-floating">
                    <input type="text" class="form-control" name="fullname" id="floatingName" placeholder="Your Name" required="required">
                    <label for="floatingName">Your Name</label>
                  </div>
                </div>
                 <div class="col-md-12">
                  <div class="form-floating">
                    <input type="text" class="form-control" name="username" id="floatingName" placeholder="User Name">
                    <label >User Name</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input type="email" name="email" class="form-control" id="floatingEmail" placeholder="Your Email">
                    <label for="floatingEmail">Your Email</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-floating">
                    <input type="password" name="pass" class="form-control" id="floatingPassword" placeholder="Password" required="required">
                    <label for="floatingPassword">Password</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-floating">
                    <textarea class="form-control" name="address" placeholder="Address" id="floatingTextarea" style="height: 100px;"></textarea>
                    <label for="floatingTextarea">Address</label>
                  </div>
                </div>
                
                <div class="col-md-4">
                  <div class="form-floating mb-3">
                    <select class="form-select" name="role" id="floatingSelect" aria-label="State" required="required">
                      
                      <option value="0" selected>User</option>
                      <option value="1">Admin</option>
                    </select>
                    <label for="floatingSelect">Role</label>
                  </div>
                </div>
               
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Add</button>
                  <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
              </form><!-- End floating Labels Form -->

            </div>
          </div>
      	 
      	 	
      	 
      	 
      	 
      	 </div>
      	 
       

       
      </div>
    </section>

  </main><!-- End #main -->

</body>

