<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result < 1}">
<script>
	alert('방명록 남기기에 실패했습니다. 다시 시도해주세요.');
	history.go(-1);
</script>
</c:if>

<c:if test="${result eq 1}">
<script>
	alert('방명록을 등록했습니다.');
	location.href='${pageContext.request.contextPath}/guestbook/list.do';
</script>
</c:if>