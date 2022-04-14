<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
