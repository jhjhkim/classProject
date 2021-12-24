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
#content>table{
	border: 0;
	border-collapse: collapse;
	
	width: 600px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
}
#content>table img {
	height: 30px;
	border: 2px solid #aaa;
	border-radius: 50%;
}

#regdate {
	float: right;
	text-align: right;
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
	
		<table>
			<tr>
				<th>${message.subject}</th>
			</tr>
			<tr>
				<td>
					<img src="${pageContext.request.contextPath}/uploadfile/${message.photo}">
					${message.username}
					<div id="regdate">
						작성일시 ${message.regdate}
						<c:if test="${message.updatedate != null}">
						<br>
						최근수정일시 ${message.updatedate}
						</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td>${message.content}</td>
			</tr>
			<tr>
				<td>댓글 영역입니다.</td>
			</tr>
			
		</table>
		
		<!-- 수정/삭제 버튼 -->
		<c:if test="${message.memberidx eq loginInfo.idx}">
			<a href="edit.do?idx=${message.idx}">수정</a>
			<a href="delete.do?idx=${message.idx}">삭제</a>
		</c:if>
	
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>