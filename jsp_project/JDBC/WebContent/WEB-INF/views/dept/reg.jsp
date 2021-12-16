<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>부서관리 프로그램</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default.css">
<style>
#content {
	padding: 20px;
}

#content>hr {
	border: 0px;
	border-top: 1px solid #aaa;
	margin: 10px 0;
}

#content>table {
	border: 0px;
	border-collapse: collapse;
	width: 400px;
}

#content>table td, #content>table th {
	border: 1px solid #aaa;
	text-align: center;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="content">

		<c:if test="${result>0}">
			<h3>부서 정보 등록 성공</h3>
			<hr>
			<table>
				<tr>
					<td>부서번호</td>
					<td>${dept.deptno}</td>
				</tr>
				<tr>
					<td>부서이름</td>
					<td>${dept.dname}</td>
				</tr>
				<tr>
					<td>부서위치</td>
					<td>${dept.loc}</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${result eq 0}">
			<h3>등록 실패</h3>
			<hr>
			<p>시스템 문제로 등록이 되지 않았습니다. 다시 시도해주세요.</p>
		</c:if>

	</div>


</body>
</html>