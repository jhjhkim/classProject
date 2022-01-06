<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리포트 등록 결과</title>
</head>
<body>

	<h1>리포트 등록 결과 : @RequestParam 이용</h1>
	<hr>

		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno" value="${sno}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname" value="${sname}"></td>
			</tr>
			<tr>
				<td>리포트 파일</td>
				<td><input type="text" name="report" value="${report}"></td>
			</tr>
		</table>

</body>
</html>