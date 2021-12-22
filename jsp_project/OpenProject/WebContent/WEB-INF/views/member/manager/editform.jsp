<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 수정</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}

#oldfile {
	height: 50px;
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
		<h3>회원 수정</h3>
		<hr>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="hidden" name="idx" value="${member.idx}">
						<input type="text" name="userid" value="${member.userid}" readonly>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" value="${member.pw}"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" value="${member.pw}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="username" value="${member.username}"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
						현재 파일 : 
						<c:if test="${not empty member.photo}">
						<img id="oldfile" src="${pageContext.request.contextPath}/uploadfile/${member.photo}"><br>
						</c:if>
						<input type="hidden" name="oldfile" value="${member.photo}">
						<input type="file" name="photo">
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="수정"> <input type="reset"></td>
				</tr>
			</table>
		</form>
	
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>