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
            <h1>Quản lý truyện-thể loại</h1>
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
                          <h3 class="card-title">Sửa truyện</h3>     
                      </div>
                      <!-- /.card-header -->
                          <form method="POST" action="../admin/comiccatergory_edit" >
                                <input name="id" value="${ temp.id }" type="hidden" />
                              <div class="card-body">
                                <div class="form-group">
                                  <label for="0">IDcomic</label>
                                  <input value="${temp.IDcomic }" id="0" type="text" class="form-control" name="IDcomic" placeholder="IDcomic"/>                            
                                </div>
                                <div class="form-group">
                                  <label for="1">IDcatergory</label>
                                  <input value="${temp.IDcatergory }" id="1" type="text" class="form-control" name="IDcatergory" placeholder="IDcatergory"/>                            
                                </div>  
                                  <label style="color:red;">${ error }</label>                           
                              </div>    
                              <div class="card-footer">
                                <a href="../admin/comiccatergory"class="btn btn-primary">trở về </a>
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
    <!-- /.content-wrapper -->