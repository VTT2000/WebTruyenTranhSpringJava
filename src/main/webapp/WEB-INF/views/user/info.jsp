
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<!-- section list -->
	<div class="section section-item ">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-xs-4">
					<nav class="nav-sidebar">
						<ul class="nav">
							<li class="active"><a href="../User/Info">Thông tin</a></li>
							<li><a href="../User/ComicHistory">Lịch sử xem truyện</a></li>
							<li><a href="../User/TheoDoi">Lưu truyện</a></li>
							<li><a href="../User/LogOut">Đăng Xuất</a></li>
						</ul>
					</nav>
				</div>
<style>
.error {
	color: red
}
</style>
				<!--user content-->
				<div class="col-md-7 col-xs-6">
					<div class="box user-content">
						<form:form modelAttribute="user" action="../User/Update"
							class="form-horizontal" method="POST">
							<div class="form-group">
								<label for="first_name" class="col-xs-3 control-label">Họ
									tên</label>
								<div class="col-xs-9">
									<form:input value="${ user.getUsername() }" path="username"
										type="text" class="form-control" />
									
								</div>
								
							</div>
							<div class="form-group">
								<label for="last_name" class="col-xs-3 control-label">Gmail</label>
								<div class="col-xs-9">
									<form:input value="${ user.getMail() }" path="mail" type="text"
										class="form-control" />
									
								</div>
							</div>
							<div class="form-group">
								<label for="last_name" class="col-xs-3 control-label">Password</label>
								<div class="col-xs-9">
									<form:input value="${ user.getPassword() }" path="password"
										type="text" class="form-control" />
									
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-3 col-xs-9">
									<button type="submit" class="btn btn-default">Lưu</button>
								</div>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
