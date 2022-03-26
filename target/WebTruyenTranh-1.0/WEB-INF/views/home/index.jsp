<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%--
		<%@ tablib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
		<%@ tablib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	--%>
	
	
	${message}
	<br/>
	Home page ${ cate }/ ${ cate0 } / ${go} / ${ go0}
	<br/>
	<c:if test="${ not empty listCatergory }">
		<c:forEach var="item" items="${ listCatergory }" >
			<tr style="border:1px black solid">
				<td>${ item.IDcatergory }</td>
				<td>${ item.catergory }</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ not empty listComic }">
		<c:forEach var="item" items="${ listComic }" >
			<tr style="border:1px black solid">
				<td>${ item.IDcomic }</td>
				<td>${ item.comic }</td>
			</tr>
		</c:forEach>
	</c:if>
	
</body>
</html>