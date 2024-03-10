<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01 Scripting Element</title>

<style>
	h1 {color:red;}
</style>
</head>
<body>
	<h1>스크립팅 원소</h1>
	<!-- HTML 주석 : 개발자도구 창에서 소스(Elements)에 표시 됨 -->
	<%-- JSP 주석  : 개발자도구 창에서 소스에 표시되지 않음 --%>
	
	<%
		// 스크립트릿 : 이 영역에서는 일반적인 자바코드 작성(변수 선언/초기화/제어문 등)
		// 1부터 100까지 더해서 콘솔창에 "계산결과 = xx"(반복문)
		int sum = 0;
		for(int i=1; i<101; i++) {
			sum += i;
		}
		System.out.println("계산 결과 : "+sum);
	%>
	<p>계산결과 : <%= sum %> </p>
	
	<p>
		브라우저 창에 출력하고자 한다면 <br>
		스크립트릿을 사용하여 출력 가능 :  <% out.println(sum); %> <br>
		표현식(출력식)을 사용하여 출력 가능 : <%= sum %>
	</p>
	
	<%
		// 문자열 배열에 좋아하는 음식 5가지 정도 초기화
		String[] food = {"칼국수", "피자", "양갈비", "사과", "부대찌개"};
	%>
	<h5>배열의 길이 : <%= food.length %></h5>
	<h5>배열에 담긴 값 : <%= String.join("-", food) %></h5>
	
	<h5>반복문을 사용하여 html 요소를 반복적으로 화면에 출력</h5>
	<ol>
		<% for(String foods : food) { %>
			<li><%= foods %></li>
		<% } %>
	</ol>
	
	<!-- 메소드 정의 : 현재 jsp 페이지 내에서만 사용할 수 있는 메소드 정의-->
	<%!  
		public void test() {
			System.out.println("test 메소드 정리, 누군가 호출...");
		}
	%>
	<!-- 메소드 호출 -->
	<% test(); %>
</body>
</html>