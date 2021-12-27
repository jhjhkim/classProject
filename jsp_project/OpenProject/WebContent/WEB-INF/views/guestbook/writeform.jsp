<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}
#content>form input[type=text] {
	width: 300px;
}
#content>form textarea {
	width: 300px;
	padding: 5px;
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	$(document).ready(function(){
		
		$('#writeajax').click(function(){
			
			console.log($('#writeform').serializeArray());
			
			$.ajax({
				url : '${pageContext.request.contextPath}/guestbook/writeajax.do',
				type : 'post',
				data : $('#writeform').serializeArray(),
				success : function(data){
					if(data == "Y"){
						alert('방명록을 등록하였습니다.');
						location.href='${pageContext.request.contextPath}/guestbook/list.do';
					} else {
						console.log('방명록 등록 실패');
					}
				},
				error : function(){
					console.log('비동기 통신 오류 발생');
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
		<h3>방명록 쓰기</h3>
	<hr>
	<form id="writeform" method="post">
	<input type="hidden" name="memberidx" value="${loginInfo.idx}">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="5" cols="20"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input type="submit" value="방명록 남기기">
				<input type="reset">
				
				<input type="button" id="writeajax" value="ajax로 게시물 입력">
				</td>
			</tr>
		</table>
	</form>
	
	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>