<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox = new CookieBox(request);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%= request.getContextPath() %> --%>
	
	<form action="<%= request.getContextPath() %>/cookie/member/login.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%= cookieBox.exists("SAVEID") ? cookieBox.getValue("SAVEID"): "" %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="saveId" id="saveId" value="on" <%= cookieBox.exists("SAVEID") ? "checked" : "" %>> 
					<label for="saveId">ID 저장하기</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>