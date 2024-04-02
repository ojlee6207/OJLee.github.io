<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Standard Action Tag</title>
</head>
<body>
	<h1>Standard Action Tag</h1>
	<br>
	
	<h3>jsp:include</h3>
	<p>
		또 다른 페이지를 포함하고자 할 때 사용하는 태그
	</p>
	
	<h4>* 기존의 include 지시어를 이용한 방식 (정적 include 방식 == 컴파일 시 애초에 포함되어 있는 방식)</h4>
	<%-- footer.jsp 파일 include 시키기 --%>
	<%--
	<%@ include file="footer.jsp" %>
	<br>

	- 특징: include하고 있는 페이지 상에 선언되어 있는 변수를 현재 페이지에서 사용 가능
	include한 페이지의 year 변수의 값 : <%= year %><br>
	=> 단, 현재 페이지에서 동일한 이름의 변수를 선언할 수 없음<br>
	<% int year = 2024; %>
	--%>
	
	<h4>* JSP 표준액션태그를 이용한 방식 (동적 include 방식 == 런타임 시 포함되는 형태)</h4>
	<hr>
	<jsp:include page="footer.jsp" />
	<hr>
	<br>
	
	- 특징: 1) include 하고 있는 페이지에 선언된 변수를 공유하지 않음<br>
	=> 동일한 이름의 변수로 선언이 가능<br>
	<% int year = 2024; %>
	<br>
	- 특징: 2) 포함시키는 페이지로 값을 전달할 수 있음<br>
	<hr>
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Hello!" />
	</jsp:include>
	<hr>
	<hr>
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Bye" />
	</jsp:include>
	<hr>
</body>
</html>




