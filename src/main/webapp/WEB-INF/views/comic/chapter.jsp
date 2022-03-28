<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>web</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/gaia.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href='https://fonts.googleapis.com/css?family=Cambo|Poppins:400,600' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/fonts/pe-icon-7-stroke.css" rel="stylesheet">
</head>

<body>  
	<%@ include file="/WEB-INF/views/share/header.jsp" %>
	<div class="section section-chapter ">
        <div class="container">
            <div class="chapter-header">
                <div class="row">
                    <div class="col-md-3 col-xs-4" >
                        <button type="submit" class="btn btn-primary" style="background-color: red; color:black; float:right;">Chap trước</button>
                    </div> 
                    <div class="col-md-6 col-xs-4">
                        <select class="form-control">
                            <Option> chap 1</Option>
                        </select>
                    </div> 
                    <div class="col-md-3 col-xs-2 ">
                        <button type="submit" class="btn btn-primary" style="background-color: red; color:black;">Chap sau</button>
                    </div> 
                </div> 
         </div>  
         <div class="chapter-body">   
            <img src="assets\img\1.jpg">   
            <img src="assets\img\2.jpg">   
            <img src="assets\img\3.jpg">   
            <img src="assets\img\4.jpg"> 
            <img src="assets\img\5.jpg">  
            <img src="assets\img\6.jpg">    
            <img src="assets\img\7.jpg">       
        </div>
   
    <div class="chapter-footer">
        <div class="row">
            <div class="col-md-3 col-xs-4">
                <button type="submit" class="btn btn-primary" style="background-color: red; float:right; color:black;">Chap trước</button>
            </div> 
            <div class="col-md-6 col-xs-4">
                <select class="form-control">
                    <Option> chap 1</Option>
                </select>
            </div> 
            <div class="col-md-3 col-xs-2 ">
                <button type="submit" class="btn btn-primary" style="background-color: red; color:black;">Chap sau</button>
            </div> 
        </div> 
    </div>
 </div>  
</div>
    <%@ include file="/WEB-INF/views/share/footer.jsp" %>
</body>

<!--   core js files    -->
<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.leanModal.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.js" type="text/javascript"></script>

<!--  js library for devices recognition -->
<script type="text/javascript" src="assets/js/modernizr.js"></script>

<!--  script for google maps   -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!--   file where we handle all the script from the Gaia - Bootstrap Template   -->
<script type="text/javascript" src="assets/js/gaia.js"></script>
<script type="text/javascript">
// Plugin options and our code
$("#modal_trigger").leanModal({
      top: 100,
      overlay: 0.6,
      closeButton: ".modal_close"
});

$(function() {
      // Calling Login Form
      $("#login_form").click(function() {
              $(".social_login").hide();
              $(".user_login").show();
              return false;
      });

      // Calling Register Form
      $("#register_form").click(function() {
              $(".social_login").hide();
              $(".user_register").show();
              $(".header_title").text('Register');
              return false;
      });

      // Going back to Social Forms
      $(".back_btn").click(function() {
              $(".user_login").hide();
              $(".user_register").hide();
              $(".social_login").show();
              $(".header_title").text('Login');
              return false;
      });
});
</script>   


</html>