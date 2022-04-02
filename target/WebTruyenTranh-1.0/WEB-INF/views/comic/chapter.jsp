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
	<div class="section section-chapter ">
		<div class="container">
			<div class="chapter-header">
				<div class="row">
					<div class="col-md-3 col-xs-4">
						<c:choose>
							<c:when test="${ not empty previous }">
								<a
									href="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ previous.getIDchapter() }"
									type="submit" class="btn btn-primary"
									style="background-color: red; color: black; float: right;">Chap
									trước</a>
							</c:when>
							<c:otherwise>
								<button disabled type="submit" class="btn btn-primary"
									style="background-color: LightGray; color: black; float: right;">Chap
									trước</button>
							</c:otherwise>
						</c:choose>

					</div>
					<div class="col-md-6 col-xs-4">
						<select class="form-control" onchange="location = this.value;">
							<c:if test="${ not empty chapters }">
								<c:forEach var="item" items="${ chapters }">

									<c:choose>
										<c:when
											test="${ item.getIDchapter() == chapter.getIDchapter() }">
											<Option selected
												value="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ item.getIDchapter() }">
												${ item.getChapter() }</Option>
										</c:when>
										<c:otherwise>
											<Option
												value="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ item.getIDchapter() }">
												${ item.getChapter() }</Option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</c:if>

						</select>
					</div>
					<div class="col-md-3 col-xs-2 ">
						<c:choose>
							<c:when test="${ not empty nexts }">
								<a type="submit" class="btn btn-primary"
									href="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ nexts.getIDchapter() }"
									style="background-color: red; color: black;">Chap sau</a>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-primary" disabled
									style="background-color: LightGray; color: black;">Chap
									sau</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>


			<div class="chapter-body">
				<c:if test="${ not empty listImage }">
					<c:forEach var="item" items="${ listImage }">
						<img src="${ item.getImageLink() }">
					</c:forEach>
				</c:if>
			</div>

			<div class="chapter-footer">
				<div class="row">
					<div class="col-md-3 col-xs-4">
						<c:choose>
							<c:when test="${ not empty previous }">
								<a
									href="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ previous.getIDchapter() }"
									type="submit" class="btn btn-primary"
									style="background-color: red; color: black; float: right;">Chap
									trước</a>
							</c:when>
							<c:otherwise>
								<button disabled type="submit" class="btn btn-primary"
									style="background-color: LightGray; color: black; float: right;">Chap
									trước</button>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-6 col-xs-4">
						<select class="form-control" onchange="location = this.value;">
							<c:if test="${ not empty chapters }">
								<c:forEach var="item" items="${ chapters }">

									<c:choose>
										<c:when
											test="${ item.getIDchapter() == chapter.getIDchapter() }">
											<Option selected
												value="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ item.getIDchapter() }">
												${ item.getChapter() }</Option>
										</c:when>
										<c:otherwise>
											<Option
												value="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ item.getIDchapter() }">
												${ item.getChapter() }</Option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</c:if>

						</select>
					</div>
					<div class="col-md-3 col-xs-2 ">
						<c:choose>
							<c:when test="${ not empty nexts }">
								<a type="submit" class="btn btn-primary"
									href="../Comic/Chapter?IDcomic=${ IDcomic }&IDchapter=${ nexts.getIDchapter() }"
									style="background-color: red; color: black;">Chap sau</a>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-primary" disabled
									style="background-color: LightGray; color: black;">Chap
									sau</button>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
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