<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<%
		// String title = "News";	// 에러 발생 예상! 이름이 같은 변수가 다른 파일에 있기 때문에
		String title2 = "News";
	%>
	<h3><%= title2 %></h3>
	<hr>
	<ul>
	<%
		for(int i=0; i<5; i++){
			out.println("<li>"+i+"</li>");
		}
	%>
	</ul>
</div>