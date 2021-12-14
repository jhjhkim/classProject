<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not loginChk}">
	<script>
		alert('로그인이 필요한 페이지입니다.');
		location.href = '${pageContext.request.contextPath}/member/loginform.do';
	</script>
</c:if>

<c:if test="${loginChk}">
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
</head>
<body>

	<h1>My Page</h1>
	<hr>
	<h3>${msg}</h3>
	<h3>${loginInfo.name}(${loginInfo.nick}) 님, 반갑습니다.</h3>

</body>
</html>
</c:if>