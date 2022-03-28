 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Admin</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

  <!-- Font Awesome Icons -->
  <link href="assets\fonts\fontawesome-free\css\all.min.css" rel="stylesheet">
  
  <!-- DataTables -->
  <link rel="stylesheet" href="assets/css/admincss/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="assets/css/admincss/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="assets/css/admincss/buttons.bootstrap4.min.css">

  <!-- IonIcons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/css/admincss/adminlte.min.css">
</head>
<!--
`body` tag options:

  Apply one or more of the following classes to to the body tag
  to get the desired effect

  * sidebar-collapse
  * sidebar-mini
-->
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fa fa-bars"></i></a>
      </li>
    </ul>

  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <span class="brand-text font-weight-light">Admin</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
     
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->        
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
               Quản lý thành viên
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Quản lý khách hàng
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Quản lý thức ăn
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-tree"></i>
              <p>
                Quản lý thức uống
              </p>
            </a>       
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Quản lý đơn hàng
              </p>
            </a>          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Quản lý thức ăn</h1>
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
                 <button class=" btn btn-primary" style="float:right; margin-right: 10px; width: 100px;">thêm</button>
                <table id="data" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>ID</th>
                    <th>Tên món ăn</th>
                    <th>Ảnh món ăn</th>
                    <th>Mô tả</th>
                    <th>Giá tiền</th>
                    <th>Tác vụ</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>1</td>
                    <td>
                       Gà chiên 
                    </td>
                    <td></td>
                    <td>ngon</td>
                    <td>12000đ</td>
                    <td>
                        <i class="fas fa-wrench"></i>

                        <i class="fas fa-times"></i>                    
                    </td>
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>
                       Gà chiên 
                    </td>
                    <td>chưa có</td>
                    <td>ngon</td>
                    <td>12000đ</td>
                    <td>
                        <i class="fas fa-wrench"></i>
                        <i class="fas fa-times"></i>                    
                    </td>
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>
                       Gà chiên 
                    </td>
                    <td>chưa có</td>
                    <td>ngon</td>
                    <td>12000đ</td>
                    <td>
                        <i class="fas fa-wrench"></i>

                        <i class="fas fa-times"></i>                    
                    </td>
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>
                       Gà chiên 
                    </td>
                    <td>chưa có</td>
                    <td>ngon</td>
                    <td>12000đ</td>
                    <td>
                        <i class="fas fa-wrench"></i>
                        <i class="fas fa-times"></i>                    
                    </td>
                  </tr>           
                  </tbody>           
                </table>
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

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2014-2021 <a href="#">Ryuu</a>.</strong>
    All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="assets/js/adminjs/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="assets/js/adminjs/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="assets/js/adminjs/adminlte.js"></script>
<!-- DataTables  & Plugins -->
<script src="assets/js/adminjs/jquery.dataTables.min.js"></script>
<script src="assets/js/adminjs/dataTables.bootstrap4.min.js"></script>
<script src="assets/js/adminjs/dataTables.responsive.min.js"></script>
<script src="assets/js/adminjs/responsive.bootstrap4.min.js"></script>
<script src="assets/js/adminjs/dataTables.buttons.min.js"></script>
<script src="assets/js/adminjs/buttons.bootstrap4.min.js"></script>
<script src="assets/js/adminjs/jszip.min.js"></script>
<script src="assets/js/adminjs/pdfmake.min.js"></script>
<script src="assets/js/adminjs/vfs_fonts.js"></script>
<script src="assets/js/adminjs/buttons.html5.min.js"></script>
<script src="assets/js/adminjs/buttons.print.min.js"></script>
<script src="assets/js/adminjs/buttons.colVis.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/js/adminjs/demo.js"></script>
<!-- Page specific script -->
<script>
    $(function () {    
      $('data').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "responsive": true,
      });
    });
  </script>
</body>
</html>
