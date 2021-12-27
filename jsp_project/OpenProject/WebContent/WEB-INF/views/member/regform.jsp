<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}

#msg {
	display: none;
}

.text_red {
	color: red;
}
.text_blue {
	color: blue;
}
</style>
<script>

	$(document).ready(function(){
		
		$('#userid').focusin(function(){
			
			$('#msg').css('display', 'none');
			$('#msg').removeClass('text_blue');
			$('#msg').removeClass('text_red');
			$('#msg').text('');
			
		});
		
		$('#userid').focusout(function(){
					
			$.ajax({
				url : 'checkid.do',
				type : 'get',
				data : {
					userid : $('#userid').val()
				},
				success : function(data){
					// Y | N
					if(data == 'Y'){
						// 사용 가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').addClass('text_blue');
						$('#msg').text('사용할 수 있습니다.');
					} else {
						// 사용 불가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').addClass('text_red');
						$('#msg').text('사용중이거나 탈퇴한 아이디입니다.');
					}
				},
				error : function(){
					console.log('비동기 통신 오류');
				}
			});
			
		});
		
	});

</script>

</head>
<body>

	<!-- 헤더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 헤더 끝 -->

	<!-- 내비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 내비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>회원 가입</h3>
		<hr>
		<!-- form 경로와 처리 경로가 동일 -> method 로 구분 -->
		<!-- action="reg.do" 생략 가능 -->
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td>
					<!-- http://localhost:8080/op/member/checkid.do?userid=test@gmail.com -->
						<input type="text" name="userid" id="userid">
						<div id="msg"></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="회원가입"> <input type="reset"></td>
				</tr>
			</table>
		</form>
	
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>