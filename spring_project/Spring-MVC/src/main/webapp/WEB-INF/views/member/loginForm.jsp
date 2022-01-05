<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<h1>로그인 폼</h1>
	<hr>
	<form method="post">
	<input type="hidden" name="url" value="${url}">
		<table>
			<tr>
				<td>아이디</td>
				<td> <input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td> <input type="password" name="pw"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>