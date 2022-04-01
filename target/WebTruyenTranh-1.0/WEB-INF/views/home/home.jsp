<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>web</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<link href="../assets/css/gaia.css" rel="stylesheet" />

<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Cambo|Poppins:400,600"
	rel='stylesheet' type='text/css'>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../assets/css/fonts/pe-icon-7-stroke.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/share/header.jsp" %>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="section section-small section-get-started">
					<div class="parallax filter">
						<div class="image"
							style="background-image: url('../assets/img/banner1.jpg')">
						</div>
						<div class="container">
							<div class="title-area">
								<h2 class="text-white">Thế giới manga</h2>
								<div class="separator line-separator">♦</div>
								<p class="description">Truyện hay mỗi ngày</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="section section-small section-get-started">
					<div class="parallax filter">
						<div class="image"
							style="background-image: url('../assets/img/banner2.jpg')">
						</div>
						<div class="container">
							<div class="title-area">
								<h2 class="text-white">Thế giới manga</h2>
								<div class="separator line-separator">♦</div>
								<p class="description">Truyện hay mỗi ngày</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			...
		</div>


		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>



	<div class="section section-our-team-freebie">
		<div class="container">
			<div class="content">
				<div class="row">
					<div class="title-area">
						<h2>Truyện mới</h2>
						<div class="separator separator-danger">✻</div>
					</div>
					<div class="team">
						<div class="row">
							<c:if test="${ not empty listComics }">
								<c:forEach var="item" items="${ listComics }">
									<a href="../Comic/Index?IDcomic=${ item.IDcomic }">
										<div class="col-md-3 col-xs-3">
											<div class="card card-member">
												<div class="content">
													<div class="avatar avatar-danger">
														<img alt="${ item.comic }" class=""
															src="${ item.getImageLink() }" />
													</div>
													<div class="description">
														<h3 class="title">${ item.comic }</h3>
													</div>
												</div>
											</div>
										</div>
									</a>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/share/footer.jsp" %>
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