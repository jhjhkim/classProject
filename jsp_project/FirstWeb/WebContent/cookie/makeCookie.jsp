<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 저장
	// 1. 쿠키 객체 생성 -> 2. response.addCookie()
	
	Cookie cookie1 = new Cookie("eName", "SON");
	cookie1.setMaxAge(10);	// 쿠키 유효시간 (초단위)
	
	Cookie c = new Cookie("kName", "손흥민");
	
	response.addCookie(cookie1);
	response.addCookie(c);
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키가 저장되었습니다.</h1>
	<h3>
		<a href="viewCookie.jsp">쿠키 보기</a>
	</h3>

</body>
</html>