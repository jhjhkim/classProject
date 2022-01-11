<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}">HOME</a></li>
		<li><a href="${pageContext.request.contextPath}/member/reg">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/member/manager/list">회원 리스트</a></li>
		<li><a href="${pageContext.request.contextPath}/member/my/mypage">마이페이지</a></li>
		<li><a href="${pageContext.request.contextPath}/guestbook/list">방명록 보기</a></li>

		<c:if test="${empty loginInfo}">
			<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
		</c:if>

		<c:if test="${not empty loginInfo}">
		<li><a href="${pageContext.request.contextPath}/guestbook/write">방명록 쓰기</a></li>
			<li><a
				href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
		</c:if>
	</ul>
</nav>