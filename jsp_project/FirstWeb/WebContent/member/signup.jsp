<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 한글 인코딩 처리 --%>
<% request.setCharacterEncoding("utf-8"); %>

<%-- 데이터 받기 --%>
<%
	String userid = request.getParameter("userid");
	String password = request.getParameter("pw");
	String username = request.getParameter("username");
	String comment = request.getParameter("comment");
	String gender = request.getParameter("gender");
	String[] interests = request.getParameterValues("interest");
	String byear = request.getParameter("byear");
%>

<h1>
User Id : <%= userid %> <br>
Password : <%= password %> <br>
이름 : <%= username %> <br>
자기소개 : <%= comment %> <br>
성별 : <%= gender %> <br>
<%
	if(interests != null) {
		for(int i=0; i<interests.length; i++) {
			out.println("관심사 : " + interests[i] + " <br>");
		}
	} else {
		out.println("관심사 : 선택된 관심사가 없습니다. <br>");
	}
%>
태어난 년도 : <%= byear %>
</h1>

</body>
</html>