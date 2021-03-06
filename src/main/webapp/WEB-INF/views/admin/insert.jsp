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
  
  <!-- IonIcons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/css/admincss/adminlte.min.css">
</head>
!--
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
               Qu???n l?? th??nh vi??n
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Qu???n l?? kh??ch h??ng
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Qu???n l?? th???c ??n
              </p>
            </a>         
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-tree"></i>
              <p>
                Qu???n l?? th???c u???ng
              </p>
            </a>       
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Qu???n l?? ????n h??ng
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
            <h1>Qu???n l?? th???c ??n</h1>
          </div>
      
        </div>
      </div><!-- /.container-fluid -->
    </section>
     <!-- Main content -->
     <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-6">
              <div class="card card-primary">
                <div class="card-header">     
                    <h3 class="card-title">Th??m th???c ph???m</h3>     
                </div>
                <!-- /.card-header -->
                    <form>
                        <div class="card-body">
                          <div class="form-group">
                            <label for="">T??n th???c ??n</label>
                            <input type="name" class="form-control" id="exampleInputEmail1" placeholder="g?? t??n th???c ??n">
                          </div>
                          <div class="form-group">
                            <label for="">???nh th???c ??n</label>
                            <input type="name" class="form-control" id="exampleInputPassword1" placeholder="link ???nh">
                          </div>
                       
                          <div class="form-group">
                            <label for="">Th??? lo???i</label>
                            <select class="custom-select form-control-border" >
                                <option>m??n ngon</option>
                                <option>g??</option>
                                <option>th???t</option>
                              </select>
                          </div>
                          <div class="form-group">
                            <label for="">Gi?? ti???n</label>
                            <input type="number" class="form-control" id="exampleInputPassword1" placeholder="gi?? ti???n">
                          </div>
                        </div>
                        <!-- /.card-body -->
        
                        <div class="card-footer">
                          <button type="submit" class="btn btn-primary">Th??m</button>
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
<!-- AdminLTE for demo purposes -->
<script src="assets/js/adminjs/demo.js"></script>
</body>
</html>