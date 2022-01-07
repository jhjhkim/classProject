<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result < 1}">
<script>
	alert('방명록 수정에 실패했습니다. 다시 시도해주세요.');
	history.go(-1);
</script>
</c:if>

<c:if test="${result eq 1}">
<script>
	alert('방명록을 수정했습니다.');
	location.href='${pageContext.request.contextPath}/guestbook/view.do?idx=${messageidx}';
</script>
</c:if>