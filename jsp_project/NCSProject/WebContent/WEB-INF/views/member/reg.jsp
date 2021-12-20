<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result<1}">
<script>
	alert('${msg}');
	history.go(-1);
</script>
</c:if>

<c:if test="${result eq 1}">

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<h3>회원가입 완료</h3>
	<hr>
	${userid} 님, 환영합니다.

</body>
</html>
</c:if>