<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
	
		// 쿠키 데이터의 저장
		// 쿠키 이름=값
		
		if(cookies!=null && cookies.length>0){
			for(int i=0; i<cookies.length; i++){
				Cookie c = cookies[i];
				out.println(c.getName()+"="+c.getValue());
			}
		}
	%>
	
	<hr>
	
	<h3>host : <%= request.getHeader("host") %></h3>
	<%
		// enumeration : 컬렉션
		Enumeration headers = request.getHeaderNames();	// header의 전체 이름을 가져오는 메소드
	
		while(headers.hasMoreElements()){
			// 헤더 이름을 가져온다.
			String headerName = (String)headers.nextElement();
			
			// 헤더의 이름으로 헤더의 속성값을 가져온다.
			String value = request.getHeader(headerName);
			
			out.println("<h4>"+headerName+" : "+value+"</h4>");
		}
	%>

</body>
</html>