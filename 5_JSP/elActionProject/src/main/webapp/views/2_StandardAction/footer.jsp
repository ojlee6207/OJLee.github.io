<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
	%>
	<%-- scope에 저장된 것이 아니라 param이라는 영역에 전달이 됨. 해당 키값을 찾아야 함. --%>
	test : ${ param.test }
	<br>
	Copyright © 1998-<%= year %> KH Information Educational Institute All Right Reserved	
</body>
</html>