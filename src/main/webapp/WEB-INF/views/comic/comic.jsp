<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<div class="col-md-9  col-xs-12">
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


										<c:choose>
											<c:when test="${ not empty KhachHangIdKH }">
												<button
													onclick="location.href='../Comic/TheoDoi?IDcomic=${ comic.getIDcomic() }';"
													type="submit" class="btn btn-primary"
													style="background-color: red; color: black;">${ theodoi }</button>
											</c:when>
											<c:otherwise>
												<button
													onclick="alert('Đăng nhập để lưu truyện');"
													type="submit" class="btn btn-primary"
													style="background-color: red; color: black;">Lưu</button>
											</c:otherwise>
										</c:choose>

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
											<td><a
												href="../Comic/Chapter?IDcomic=${ comic.getIDcomic() }&IDchapter=${ item.getIDchapter() }">
													${ item.getChapter() }</a></td>
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
	