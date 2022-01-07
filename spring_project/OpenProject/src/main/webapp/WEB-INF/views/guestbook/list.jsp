<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>방명록</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#listInfo{
	border: 1px solid #aaa;
	width: 870px;
}

#content>div {
	padding: 15px;
}
#content>table{
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
	
	text-align: center;
}
#content>table td:first-child {
	width: 50px;
}
#content>table td:last-child {
	width: 180px;
}
#content>table img {
	height: 30px;
	border: 2px solid #aaa;
	border-radius: 50%;
}

#paging {
	overflow: hidden;
}
#paging>a {
	display: block;
	
	width: 30px;
	height: 30px;
	
	border: 1px solid #aaa;
	
	text-align: center;
	line-height: 30px;
	
	float: left;
	
	margin-right: 5px;
	
	text-decoration: none;
}

#paging>a:hover {
	background-color: #ff0;
	color: #00f;
}

.curPage {
	background-color: #333;
	color: #fff;
}

</style>

</head>
<body>

	<!-- 헤더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 헤더 끝 -->

	<!-- 내비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 내비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>방명록 리스트</h3>
		<hr>
		<div id="listInfo">
			전체 게시물 수: ${listView.totalCount}개 , 현재 페이지: ${listView.currentPage}/${listView.totalPageCount}
		</div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일시</th>
			</tr>
			
			<c:if test="${empty listView.list}">
			<tr>
				<td colspan="4">등록된 방명록이 없습니다.</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty listView.list}">
			<c:forEach items="${listView.list}" var="message">
			<tr>
				<td>${message.idx}</td>
				<td>
					<a href="view.do?idx=${message.idx}">${message.subject}</a>
				</td>
				<td>
					<img src="${pageContext.request.contextPath}/uploadfile/${message.photo}">
					${message.username}
				</td>
				<td>${message.regdate}</td>
			</tr>
			</c:forEach>
			</c:if>
		</table>
		<div id="paging">
			<c:if test="${listView.totalPageCount > 0}">
			
			<c:forEach begin="1" end="${listView.totalPageCount}" var="pnum">
				<a href="list.do?p=${pnum}" class="${listView.currentPage eq pnum ? 'curPage' : ''}">${pnum}</a>  
			</c:forEach>
			
			</c:if>
		</div>
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>