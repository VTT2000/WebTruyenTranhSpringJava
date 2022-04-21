<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Quản lý thể loại</h1>
          </div>
      
        </div>
      </div><!-- /.container-fluid -->
    </section>
     <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">          
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                 <a href="../admin/category_insert" class="btn btn-primary" style="float:right; margin:10px; width: 100px;">thêm</a>
				<table id="data" class="table table-bordered table-hover">
					<thead>
					<tr>
						<th>ID</th>
						<th>name</th>
						<th>description</th>
						<th>action</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${listCatergorys}" var="item">
						<tr>
							<td>${item.IDcatergory}</td>
							<td>${item.catergory}</td>
							<td>${item.description}</td>
							<td>
						   		<form action="#" method="Post">
						       		<a href="../admin/category_edit?id=${ item.IDcatergory }" class="fas fa-wrench">Sửa</a>		                      
						        	<a href="../admin/deletecatergory/${item.IDcatergory}" class="fas fa-trash">Xoá</a>
						     	</form>                    
			             	</td>
						</tr>
					</c:forEach>
					</tbody>	
				</table>
				
				<div>
 		 <ul class="pagination">
    	<c:forEach begin="1" end="${ totalPages }" var="i">
    	<li class="page-item">
    		<a class="page-link" href="../admin/category_${ i }">${ i }</a>
    		</li>
    	</c:forEach>
    	</ul>
    </div>
				
				</div>
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
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->