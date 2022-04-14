<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Web Truyen Tranh</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<link href="../assets/css/gaia.css" rel="stylesheet" />

<!--     Fonts and icons     -->
<link
	href='https://fonts.googleapis.com/css?family=Cambo|Poppins:400,600'
	rel='stylesheet' type='text/css'>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../assets/css/fonts/pe-icon-7-stroke.css" rel="stylesheet">
</head>

<body>
	<!--header-->
<nav class="navbar navbar-default navbar-transparent navbar-fixed-top"
	color-on-scroll="200">
	<!-- if you want to keep the navbar hidden you can add this class to the navbar "navbar-burger"-->
	<div class="container">
		<div class="navbar-header">
			<button id="menu-toggle" type="button" class="navbar-toggle"
				data-toggle="collapse" data-target="#example">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar bar1"></span> <span class="icon-bar bar2"></span> <span
					class="icon-bar bar3"></span>
			</button>
			<div class="navbar-brand icon"> 
				<img src="../assets/img/logo.png"/>
			</div>

		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right navbar-uppercase">
				<li><a href="../home/index">Trang chủ</a></li>
				<li><a href="../Comic/AllComic?IDcatergory=1">Loại truyện</a></li>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">tìm kiếm</button>
				</form>

				<c:choose>
					<c:when
						test="${ not empty KhachHangIdKH }">
						<li><a id="modal_trigger" href="../User/Info"
								onclick="refreshNewError();">Chào, ${ KhachHangName }</a></li>
					</c:when>
					<c:otherwise>
						<li><a id="modal_trigger" href="#modal"
								onclick="refreshNewError();">Đăng nhập/Đăng ký</a></li>
					</c:otherwise>
				</c:choose>

				

			</ul>

		</div>

		<!-- /.navbar-collapse -->
	</div>
</nav>
<!--login form-->
<div id="modal" class="popupContainer" style="display: none;">
	<header class="popupHeader">
		<span class="header_title">Login</span> <span class="modal_close"><i
			class="fa fa-times"></i></span>
	</header>
	<section class="popupBody">
		<div class="social_login">
			<div class="clearfix">
				<a class="social_box fb" href="#"><span class="icon_title">Connect
						with Facebook</span></a> <a class="social_box google" href="#"><span
					class="icon_title">Connect with Google</span></a>
			</div>

			<div class="centeredText">
				<span>Or use your Email address</span>
			</div>

			<div class="action_btns">
				<div class="one_half">
					<a class="btn" href="#" id="login_form" name="login_form">Login</a>
				</div>

				<div class="one_half last">
					<a class="btn" href="#" id="register_form" name="register_form">Sign up</a>
				</div>
			</div>
		</div>
		<div class="user_login">
			<form>
				<label>Email</label> <input id="emailDangNhap" type="text"><br>
				<label>Password</label> <input id="passDangNhap" type="password"><br>
				<p id="showErrorDangNhap" style="color: red"></p>

				<div class="checkbox">
					<input id="rememberDangNhap" checked="false" type="checkbox">
					<label for="remember">Remember me on this computer</label>
				</div>

				<div class="action_btns">
					<div class="one_half">
						<a class="btn back_btn" onclick="refreshNewError();">Back</a>
					</div>

					<div class="one_half last">
						<a type="button" class="btn btn_red" onclick="Login();">Login</a>
					</div>
				</div>
				<script type="text/javascript">
					function refreshNewError() {
                       var loiDangNhap = document.getElementById("showErrorDangNhap");
                       loiDangNhap.innerHTML = "";
                       var loiDangKy = document.getElementById("showErrorDangKy");
                       loiDangKy.innerHTML = "";
                    }

                    function Login() {
                    var loiDangNhap = document.getElementById("showErrorDangNhap");
                                                            loiDangNhap.innerHTML = "";

                                                            var emailDangNhap = document.getElementById("emailDangNhap").value;
                                                            var passDangNhap = document.getElementById("passDangNhap").value;
                                                            if (emailDangNhap.length == 0 || passDangNhap.length == 0) {
                                                                loiDangNhap.innerHTML = "Bạn hãy nhập đầy đủ Email và Password";
                                                                return;
                                                            }

                                                            var rememberDangNhap = document.getElementById("rememberDangNhap").checked;

                                                            var urlDangNhap = location.origin + "/WebTruyenTranh/api/DangNhapKH";
                                                            var taiKhoan = {
                                                                "email": emailDangNhap,
                                                                "pass": passDangNhap,
                                                                "remember": rememberDangNhap
                                                            };
                                                            const options = {
                                                                method: 'POST',
                                                                headers: {
                                                                    'Accept': 'application/json',
                                                                    'Content-Type': 'application/json'
                                                                },
                                                                body: JSON.stringify(taiKhoan)
                                                            };

                                                            fetch(urlDangNhap, options)
                                                                .then(response => response.text())
                                                                .then(response => {
                                                                    // Do something with response.
                                                                    // alert(response);
                                                                    if (response == "OK") {
                                                                        location.href = location.href;
                                                                    }
                                                                    else {
                                                                        loiDangNhap.innerHTML = response;
                                                                    }

                                                                })
                                                                .catch(error => alert(error));
                                                        }
                                                    </script>
			</form>

			<a class="forgot_password" href="#">Forgot password?</a>
		</div>
		<div class="user_register">
			<form>
				<label>Full Name</label> <input id="tenDangKy" type="text"><br>
				<label>Email Address</label> <input id="emailDangKy" type="email"><br>
				<label>Password</label> <input id="passDangKy" type="password"><br>
				<p id="showErrorDangKy" style="color: red"></p>

				<div class="checkbox">
					<input id="send_updates" type="checkbox"> <label
						for="send_updates">Send me occasional email updates</label>
				</div>

				<div class="action_btns">
					<div class="one_half">
						<a class="btn back_btn" onclick="refreshNewError();">Back</a>
					</div>

					<div class="one_half last">
						<a type="button" class="btn btn_red" onclick="Register();">Register</a>
					</div>

					<script type="text/javascript">

                                                        function Register() {
                                                            var loiDangKy = document.getElementById("showErrorDangKy");
                                                            loiDangKy.innerHTML = "";

                                                            var tenDangKy = document.getElementById("tenDangKy");
                                                            var emailDangKy = document.getElementById("emailDangKy");
                                                            var passDangKy = document.getElementById("passDangKy");
                                                            if (tenDangKy.value.length == 0 || emailDangKy.value.length == 0 || passDangKy.value.length == 0) {
                                                                loiDangKy.innerHTML = "Bạn hãy nhập đầy đủ FullName, Email và Password";
                                                                return;
                                                            }

                                                            var urlDangKy = location.origin + "/WebTruyenTranh/api/DangKyKH";
                                                            var khachHang = {
                                                                "email": emailDangKy.value,
                                                                "password": passDangKy.value,
                                                                "name": tenDangKy.value
                                                            };

                                                            const options = {
                                                                method: 'POST',
                                                                headers: {
                                                                    'Accept': 'application/json',
                                                                    'Content-Type': 'application/json'
                                                                },
                                                                body: JSON.stringify(khachHang)
                                                            };

                                                            fetch(urlDangKy, options)
                                                                .then(response => response.text())
                                                                .then(response => {
                                                                    // Do something with response.
                                                                    if (response == "OK") {
                                                                        alert("Đăng ký tài khoản thành công");
                                                                        tenDangKy.value = "";
                                                                        emailDangKy.value = "";
                                                                        passDangKy.value = "";
                                                                    }
                                                                    else {
                                                                        loiDangKy.innerHTML = response;
                                                                    }

                                                                })
                                                                .catch(error => alert(error));
                                                        }
                                                    </script>
				</div>
			</form>
		</div>
	</section>
</div>
<!--login form-->
<!--header-->
		<decorator:body></decorator:body>
	<%@ include file="/WEB-INF/views/share/footer.jsp"%>
</body>

<!--   core js files    -->
<script src="../assets/js/jquery.min.js" type="text/javascript"></script>
<script src="../assets/js/jquery.leanModal.min.js"
	type="text/javascript"></script>
<script src="../assets/js/bootstrap.js" type="text/javascript"></script>

<!--  js library for devices recognition -->
<script type="text/javascript" src="../assets/js/modernizr.js"></script>

<!--  script for google maps   -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!--   file where we handle all the script from the Gaia - Bootstrap Template   -->
<script type="text/javascript" src="../assets/js/my.js"></script>
<script type="text/javascript">
	// Plugin options and our code
	$("#modal_trigger").leanModal({
		top : 100,
		overlay : 0.6,
		closeButton : ".modal_close"
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