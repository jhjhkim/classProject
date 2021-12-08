<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 새로운 페이지(jsp)가 실행되면 새로운 request가 생성되기 때문에 기존의 request 속성값은 없어진다. --%>
 	<h3>request 객체 속성값 : <%= request.getAttribute("num1") %></h3>
	
	<%-- 로그아웃과 함께 session이 소멸되었기 때문에 session 속성값도 null이 된다. --%>
	<h3>session 객체 속성값 : <%= session.getAttribute("id") %></h3>
	
	<h3>application 객체 속성값 : <%= application.getAttribute("num2") %></h3>

</body>
</html>