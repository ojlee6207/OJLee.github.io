<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizza Order Result</title>
<style>
	ul { disk-style :}
</style>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		String phone = (String)request.getAttribute("phone");
		String address = (String)request.getAttribute("address");
		String detail = (String)request.getAttribute("detail");
		String menu = (String)request.getAttribute("menu");
		String[] toppings = (String[])request.getAttribute("topping");
		String[] sidemenus = (String[])request.getAttribute("sidemenu");
 	%>
	<h2>피자 주문 내역</h2>
	<h4>주문자 정보</h4>
	<p style="color:blue">
		<%= name %><br><%= phone %><br><%= address %>
	</p>
	<h4>요청 사항</h4>
	<p>
		<% if(detail.isEmpty()) { %>
			없음
		<% } else { %>
			<%= detail %>
		<% } %>
	</p>
	<hr>
	<h4>주문 정보</h4>
	<p>
		<%= menu %> 피자<br>
		<ul>
		<li>
		토핑 추가 항목
		
		<% if(toppings == null) { %>
			추가 항목이 없습니다. <br>
		<% } else { %>
			<ul>
			<% for(String topping : toppings) { %>
				<li><%= topping %></li>
			<% } %>
			</ul>
		<% } %>
		</li>
		</ul>
		<ul>
		<li>
		사이드 선택 항목
		<% if(sidemenus == null) { %>
			추가 사이드메뉴는 없습니다. <br>
		<% } else { %>
			<ul>
			<% for(String sidemenu : sidemenus) { %>
				<li><%= sidemenu %></li>
			<% } %>
			</ul>
		<% } %>
		</li>
		</ul>
	</p>
	<hr>
	<%= name %>님, <span style="color:blue">즐거운 </span>
	<span style="color:red">식사 </span>되세요! <span style="color:yellow">:)</span>
</body>
</html>