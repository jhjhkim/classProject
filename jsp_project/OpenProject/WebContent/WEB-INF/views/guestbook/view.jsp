<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>방명록</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#content>table {
	border: 0;
	border-collapse: collapse;
	width: 600px;
}

#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
}

#content>table img {
	height: 30px;
	border: 2px solid #aaa;
	border-radius: 50%;
	vertical-align: middle;
}

#regdate {
	float: right;
	text-align: right;
}

#replyArea {
	width: 600px;
}

div.reply {
	border: 1px solid #aaa;
	overflow: hidden;
	padding: 15px;
	margin-top: 5px;
}

div.reply>div.img {
	width: 50px;
	float: left;
}

div.reply>div.img>img {
	width: 40px;
	height: 40px;
	border: 1px solid #aaa;
	border-radius: 50%;
}

div.reply>div.content {
	width: 480px;
	float: left;
}

div.reply>div.close {
	width: 30px;
	float: right;
}

div.reply>div.close>div {
	width: 25px;
	height: 25px;
	text-align: center;
	line-height: 25px;
	border: 1px solid #aaa;
	background-color: #ccc;
}

#replyWrite {
	width: 600px;
	margin-top: 20px;
}

#replyWrite>h4 {
	margin: 5px 0;
}

#replyWrite textarea {
	width: 100%;
	font-size: 120%;
	padding: 5px;
}

#replyWrite>form {
	text-align: right;
}
</style>

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

		<table>
			<tr>
				<th>${message.subject}</th>
			</tr>
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/uploadfile/${message.photo}">
					${message.username}
					<div id="regdate">
						작성일시 ${message.regdate}
						<c:if test="${message.updatedate != null}">
							<br>
						최근수정일시 ${message.updatedate}
						</c:if>
					</div></td>
			</tr>
			<tr>
				<td>${message.content}</td>
			</tr>

		</table>

		<div id="replyArea">
			<h3>댓글</h3>
			<hr>
			<div id="replyList">
				<c:if test="${not empty replyList}">
					<c:forEach items="${replyList}" var="reply">
						<div id="reply${reply.idx}" class="reply">
							<div class="img">
								<img
									src="${pageContext.request.contextPath}/uploadfile/${reply.photo}">
							</div>
							<div class="content">
								<h4>${reply.userName}</h4>
								<div>
									<pre>${reply.content}</pre>
								</div>
								<div class="regdate">${reply.regdate}</div>
							</div>
							<div class="close">
								<div onclick="deleteReply(${reply.idx})">X</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty replyList}">
				</c:if>
			</div>

			<div id="replyWrite">
				<h4>${loginInfo.userName}</h4>
				<form id="replyWriteForm">
					<textarea name="replyMessage" id="replyMessage" rows="5" cols="30"></textarea>
					<input type="hidden" name="memberIdx" value="${loginInfo.idx}">
					<input type="hidden" name="guestbookIdx" value="${message.idx}">
					<br> <input type="submit" value="작성">
				</form>
			</div>
		</div>

		<!-- 수정/삭제 버튼 -->
		<div class="viewpagemenu">
			<a href="list.do">목록</a>
			<c:if test="${message.memberidx eq loginInfo.idx}">
				<a href="edit.do?idx=${message.idx}">수정</a>
				<a href="javascript:deleteMessage(${message.idx}, ${loginInfo.idx})">삭제</a>
			</c:if>
		</div>

	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>


	<script>
		$(document).ready(function() {

			$('#replyWriteForm').submit(function() {
				
				$.ajax({
					url : 'reply/write3.do',
					type : 'POST',
					data : $(this).serialize(),
					success : function(data) {
						console.log(data);
						$('#replyList').html('');
						
						// 현재 data -> 자바스크립트의 객체
						$.each(data, function(index, item){
							
							var html = '';
							html += '<div id="reply'+item.idx+'" class="reply">';
							html += '<div class="img">';
							html += '	<img src="/op/uploadfile/'+item.photo+'">';
							html += '</div>';
							html += '<div class="content">';
							html += '	<h4>'+item.userName+'</h4>';
							html += '	<div>';
							html += '		<pre>'+item.content+'</pre>';
							html += '	</div>';
							html += '	<div>'+item.regdate+'</div>';
							html += '</div>';
							html += '<div class="close">';
							html += '	<div onclick="deleteReply('+item.idx+')">X</div>';
							html += '</div>';
							html += '</div>';
							
							$('#replyList').append(html);
							$('#replyMessage').val('');
							
						});
						
						// 응답이 html 일때 처리
						//$('#replyList').html(data);

						// 입력처리 여부만 판단 -> view.do
 						/* if (data == '1') {
							alert('등록 성공');
							//location.href = 'view.do?idx=${pageView.idx}';
							// 1. 화면에 출력할 html 응답
							// 2. 화면에 출력할 데이터 JSON 받고 파싱
						} else {
							alert('등록 실패');
						} */
 
					},
					error : function() {
						console.log('연결 오류');
					}
				});

				return false;
			});

		});
		
		function deleteReply(idx){
			
			if(confirm('댓글을 삭제하시겠습니까?')){
				
				//$('#reply'+idx).remove();
				
				$.ajax({
					url : 'reply/delete.do',
					type : 'post',
					data : {idx : idx},
					success : function(data){
						if(data == '1'){
							$('#reply'+idx).remove();
						}
					}
				});
			}
		}
		
		function deleteMessage(idx, memberIdx){
			if(confirm('방명록을 삭제하시겠습니까?')){
				$.ajax({
					url : 'delete.do',
					type : 'post',
					data : {idx : idx, memberIdx : memberIdx},
					success : function(data){
						if(data == '1'){
							alert('방명록이 삭제되었습니다.');
							location.href='list.do';
						}
					},
					error : function(){
						console.log('오류 발생');
					}
				});
			}
		}
	</script>

</body>
</html>