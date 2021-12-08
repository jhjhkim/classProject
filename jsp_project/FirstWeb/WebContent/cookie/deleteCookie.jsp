<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키값 삭제</h1>
	<hr>
	<h3>
		<%
			// 쿠키 검색 -> 쿠키 삭제 (유효시간=0)
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("kName")) {
						Cookie c = new Cookie("kName", "이강인");
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
			}
		%>
		
		<a href="viewCookie.jsp">쿠키 보기</a>
	</h3>

</body>
</html>