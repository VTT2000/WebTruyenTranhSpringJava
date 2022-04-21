<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Quản lý truyện</h1>
          </div>
      
        </div>
      </div><!-- /.container-fluid -->
    </section>
        <section class="content">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-6">
                    <div class="card card-primary">
                      <div class="card-header">     
                          <h3 class="card-title">Thêm truyện</h3>     
                      </div>
                      <!-- /.card-header -->   
                              <form method="POST" action="../admin/comic_insert">      
                              <div class="card-body">
	                                <div class="form-group">
	                                  <label for="0">Tên truyện</label>
	                                  <input id="0" type="text" class="form-control" name="comic" placeholder="Tên truyện"/>                            
	                                </div>
	                                <div class="form-group">
	                                  <label for="1">IDauthor</label>
	                                  <input id="1" type="text" class="form-control" name="IDauthor" placeholder="IDauthor"></input>
	                                </div>  
	                                <div class="form-group">
	                                  <label for="2">Mô tả</label>
	                                  <textarea id="2" type="text" class="form-control" name="description" placeholder="Mô tả"></textarea>
	                                </div>
	                                <div class="form-group">
	                                  <label for="3">ImageLink</label>
	                                  <input id="3" type="text" class="form-control" name="ImageLink" placeholder="ImageLink"></input>
	                                </div>
                                </div>                          
                                  <label style="color:red;">${ error }</label>
                              <div class="card-footer">
                                <a href="../admin/comic" class="btn btn-primary">trở về </a>
                                <button type="submit" class="btn btn-primary">Thêm</button>
                              </div>
                            </form>
                      <!-- /.card-body -->
                    </div>
                    <!-- /.card -->   
                  </div>
                  <!-- /.col -->
                </div>
                <!-- /.row -->
              </div>
              <!-- /.container-fluid -->
            </section>
            
       </div>
      </div><!-- /.container-fluid -->
    </section>
     <!-- Main content -->
     
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->