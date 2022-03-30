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
	href='https://fonts.googleapis.com/css?family=Cambo|Poppins:400,600'
	rel='stylesheet' type='text/css'>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../assets/css/fonts/pe-icon-7-stroke.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/share/header.jsp"%>
	<!-- section list -->
	<div class="section section-item ">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<div class="box">
						<div class="row">
							<div class="col-md-3  col-xs-12">
								<div class="image-cover">
									<img alt="${ comic.getComic() }" class="item-image"
										style="margin-top: 10px;" src="${ comic.getImageLink() }" />
								</div>
							</div>
							<div class="col-md-4  col-xs-12">
								<div class="comic ">
									<h2 class="title">${ comic.getComic() }</h2>
									<div class="comic-info">
										<div class="row">
											<label style="margin-left: 10px;">Tác giả:</label> <a
												href="#">${ author.getAuthor() }</a>
										</div>
										<div class="row">
											<label style="margin-left: 10px;">Thể loại:</label> <span>
												<c:if test="${ not empty catergorys }">
													<c:forEach var="item" items="${ catergorys }">
														<a href="${ item.getIDcatergory() }">${ item.getCatergory() },</a>
													</c:forEach>
												</c:if>

											</span>
										</div>
										<button type="submit" class="btn btn-primary"
											style="background-color: red; color: black;">Lưu</button>
									</div>
								</div>
							</div>

						</div>
						<div class="item-decription">
							<h2>Mô tả</h2>
							<p>${ comic.getDescription() }</p>
						</div>

					</div>
					<br>
					<div class="box">
						<table class=" table chap-info">
							<thead>
								<tr>
									<th>Tên chap</th>
									<th style="float: right;">Ngày đăng</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${ not empty chapters }">
									<c:forEach var="item" items="${ chapters }">
										<tr>
											<td><a href="#"> ${ item.getChapter() }</a></td>
											<td style="float: right;">${ item.getCreated() }</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>

				</div>
				<!--comic content-->


			</div>
		</div>
	</div>
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
<script type="text/javascript" src="../assets/js/gaia.js"></script>
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