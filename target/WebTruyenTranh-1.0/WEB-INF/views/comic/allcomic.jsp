
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- section list -->
	<div class="section section-list ">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2 col-xs-2">
					<nav class="nav-sidebar">
						<ul class="nav">
							<c:if test="${ not empty catergorys }">
								<c:forEach var="item" items="${ catergorys }">

									<c:choose>
										<c:when
											test="${ item.getIDcatergory() == Long.parseLong(IDcatergory) }">
											<li class="active"><a
												href="../Comic/AllComic?IDcatergory=${ item.getIDcatergory() }">${ item.getCatergory() }</a>
											</li>
										</c:when>
										<c:otherwise>
											<li><a
												href="../Comic/AllComic?IDcatergory=${ item.getIDcatergory() }">${ item.getCatergory() }</a>
											</li>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</c:if>

						</ul>
					</nav>
				</div>
				<div class="col-md-8 col-xs-6">
					<div class="main-content">
						<div class="row">

							<c:if test="${ not empty comics }">
								<c:forEach var="item" items="${ comics }">
									<a href="../Comic/Index?IDcomic=${ item.IDcomic }">
										<div class="col-md-4 col-xs-3">
											<div class="card card-member">
												<div class="content">
													<div class="avatar avatar-danger">
														<img alt="${ item.getComic() }" class=""
															src="${ item.getImageLink() }" />
													</div>
													<div class="description">
														<h3 class="title">${ item.getComic() }</h3>
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
