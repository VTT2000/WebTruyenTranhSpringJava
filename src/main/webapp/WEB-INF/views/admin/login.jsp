 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 <div class="login-box">
      <div class="login-logo">
        	<b>Admin</b>
      </div>
      <!-- /.login-logo -->
      <div class="card">
        <div class="card-body login-card-body">
          <p class="login-box-msg">Đăng nhập admin</p>

          <form method="POST" action="../admin/login" enctype="application/json">
            <div class="input-group mb-3">
              <input value="${ mail }" name="email" type="email" class="form-control" placeholder="Email" required/>
              <div class="input-group-append">
                <div class="input-group-text">
                  <span class="fas fa-envelope"></span>
                </div>
              </div>
            </div>
            <div class="input-group mb-3">
              <input value="${ pass }" name="pass" type="password" class="form-control" placeholder="Password" required/>
              <div class="input-group-append">
                <div class="input-group-text">
                  <span class="fas fa-lock"></span>
                </div>
              </div>
            </div>
            <div class="input-group mb-3">
              <label id="error" style="color:red;">${ error }</label>
            </div>
            <div class="row">
              <div class="col-8">
                <div class="icheck-primary">
                <c:choose>
					<c:when
						test="${ check == true }">
						<input name="remember" type="checkbox" id="remember" checked />
					</c:when>
					<c:otherwise>
						<input name="remember" type="checkbox" id="remember" />
					</c:otherwise>
				</c:choose>
                  
                  <label for="remember">
                    Nhớ đăng nhập
                  </label>
                </div>
              </div>
              <!-- /.col -->
              <div class="col-4">
                <button type="submit" class="btn btn-primary btn-block" style="width:100px;">Đăng nhập</button>
              </div>
              <!-- /.col -->
            </div>
          </form>
       
        </div>
        <!-- /.login-card-body -->
      </div>
    </div>
    <!-- /.login-box -->