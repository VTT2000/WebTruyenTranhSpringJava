<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
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
									
										<div class="col-md-3 col-xs-3">
											<div class="card card-member">
												<div class="content">
													<div class="avatar avatar-danger">
													<a href="../Comic/Index?IDcomic=${ item.IDcomic }">
														<img alt="${ item.comic }" class=""
															src="${ item.getImageLink() }" />
															</a>
													</div>
													<div class="description">									
													<h3 class="title"><a href="../Comic/Index?IDcomic=${ item.IDcomic }">${ item.comic }</a>
														</h3>
													</div>
												</div>
											</div>
										</div>
									
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	