 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <!-- section list -->
    <div class="section section-item ">
        <div class="container">
            <div class="row">
                <div class="col-md-2 col-xs-4">
                    <nav class="nav-sidebar">
                        <ul class="nav">
                            <li><a href="../User/Info">Thông tin</a></li>
							<li><a href="../User/ComicHistory">Lịch sử xem truyện</a></li>
							<li class="active"><a href="../User/TheoDoi">Lưu truyện</a></li>
							<li><a href="../User/LogOut">Đăng Xuất</a></li>
                        </ul>
                    </nav>
                </div>
            <!--user content-->
            <!--  ông sửa lại tên nhé -->
                <div class="col-md-7 col-xs-6">
                    <div class="box user-content">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Tên truyện</th>
                                    <th>Trạng thái</th>
                                    <th>Mô tả</th>
                                    <th>Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${ not empty comics }">
								<c:forEach var="item" items="${ comics }">
								<tr>
                                    <td>
                                    <a href="../Comic/Index?IDcomic=${ item.IDcomic }">
                                    	${ item.comic }
                                    </a>
                                    </td>
                                    <td>${ item.status }</td>
                                    <td>${ item.description }</td>
                                    
                                    <td>
                                         <button onclick="location.href='../User/BoTheoDoi?IDcomic=${ item.getIDcomic() }';" type="" class="btn btn-default"> Bỏ lưu</button>
                                    </td>
                                    
                                </tr>	
								</c:forEach>
							</c:if>   
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
