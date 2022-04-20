<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Admin</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

  <!-- Font Awesome Icons -->
  <link href="../assets/fonts/fontawesome-free/css/all.min.css" rel="stylesheet">
  
  <!-- DataTables -->
  <link rel="stylesheet" href="../assets/css/admincss/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="../assets/css/admincss/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="../assets/css/admincss/buttons.bootstrap4.min.css">

  <!-- IonIcons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../assets/css/admincss/adminlte.min.css">
  <style>
    img {
      width: 200px;
      height: 200px;
      object-fit: cover;
    }

    .task {
      display: flex;
      width: 100px
    }
  </style>
</head>
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
            <a href="../admin/category" class="nav-link">
              <i class="nav-icon fas fa-object-group"></i>
              <p>
                Quản lý thể loại
              </p>
            </a>
           </li>         
          <li class="nav-item">
            <a href="../admin/comic" class="nav-link">
              <i class="nav-icon fas fa-book"></i>
              <p>
               Quản lý truyện tranh
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="../admin/imagechapter" class="nav-link">
              <i class="nav-icon fas fa-image"></i>
              <p>
                Quản lý ảnh chapter
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="../admin/chapter" class="nav-link">
              <i class="nav-icon fas fa-list"></i>
              <p>
                Quản lý chapter
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="../admin/user" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Quản lý người dùng
              </p>
            </a>       
          </li>
          <li class="nav-item">
            <a href="../admin/author" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Quản lý tác giả
              </p>
            </a>
           </li>                 
           <li class="nav-item">
            <a href="../home/index" class="nav-link">
            <i class="nav-icon fas fa-home"></i> 
              <p>
                trở về trang chủ
              </p>
            </a>
           </li> 
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <aside class="control-sidebar control-sidebar-dark">
  </aside>
  	<decorator:body></decorator:body>	
 
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="../assets/js/adminjs/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../assets/js/adminjs/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="../assets/js/adminjs/adminlte.js"></script>
<!-- DataTables  & Plugins -->
<script src="../assets/js/adminjs/jquery.dataTables.min.js"></script>
<script src="../assets/js/adminjs/dataTables.bootstrap4.min.js"></script>
<script src="../assets/js/adminjs/dataTables.responsive.min.js"></script>
<script src="../assets/js/adminjs/responsive.bootstrap4.min.js"></script>
<script src="../assets/js/adminjs/dataTables.buttons.min.js"></script>
<script src="../assets/js/adminjs/buttons.bootstrap4.min.js"></script>
<script src="../assets/js/adminjs/jszip.min.js"></script>
<script src="../assets/js/adminjs/pdfmake.min.js"></script>
<script src="../assets/js/adminjs/vfs_fonts.js"></script>
<script src="../assets/js/adminjs/buttons.html5.min.js"></script>
<script src="../assets/js/adminjs/buttons.print.min.js"></script>
<script src="../assets/js/adminjs/buttons.colVis.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../assets/js/adminjs/demo.js"></script>
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