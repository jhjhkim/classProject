<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h1>회원가입</h1>
	<hr>
	<form action="#" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" id="userid" placeholder="아이디를 입력해주세요."></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요."></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="rePassword" id="rePassword" placeholder="비밀번호를 다시 입력해주세요."></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="username" id="username" placeholder="이름을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"> <input type="reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>