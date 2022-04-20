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
            <h1>Quản lý chapter</h1>
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
                          <h3 class="card-title">Sửa chapter truyện</h3>     
                      </div>
                      <!-- /.card-header -->
                          <form method="POST" action="../admin/chapter_edit" >
                                <input name="IDchapter" value="${ temp.IDchapter }" type="hidden" />
                              <div class="card-body">
                                <div class="form-group">
                                  <label for="0">chapter</label>
                                  <input value="${temp.chapter }" id="0" type="text" class="form-control" name="chapter" placeholder="chapter"/>                            
                                </div>
                                <div class="form-group">
                                  <label for="1">IDcomic</label>
                                  <input id="1" type="text" class="form-control" name="IDcomic" placeholder="Mô tả" value="${temp.IDcomic}" />
                                </div>                             
                                  <label style="color:red;">${ error }</label>                           
                              </div>    
                              <div class="card-footer">
                                <a href="../admin/chapter"class="btn btn-primary">trở về </a>
                                <button type="submit" class="btn btn-primary">Cập nhật</button>
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