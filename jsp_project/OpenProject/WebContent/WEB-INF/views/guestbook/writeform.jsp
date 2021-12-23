<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}
#content>form input[type=text] {
	width: 300px;
}
#content>form textarea {
	width: 300px;
	padding: 5px;
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
		<h3>방명록 쓰기</h3>
	<hr>
	<form method="post">
	<input type="hidden" name="memberidx" value="${loginInfo.idx}">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="5" cols="20"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="방명록 남기기"></td>
			</tr>
		</table>
	</form>
	
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>