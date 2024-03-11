<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Do you want Pizza?</title>
</head>
<body>
	<% 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy년 MM월 dd일");
		String today = sdf.format(date);
	%>
	<h2>피자 주문하기</h3>
	<h3>현재 날짜</h3>
	<%= today %>
	<br>
	<form action="/2_JSP/orderPizza.do" method="get">
		<fieldset>
			<legend for="customer_info">주문자 정보</legend>
		 	<table>
		 		<tr>
		 			<td>이름</td>
		 			<td><input type="text" placeholder="주문자명" name="name" required /></td>
		 		</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" placeholder="연락처" name="phone" required/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" placeholder="주소 입력" name="address" required/></td>
				</tr>
				<tr>
					<td>요청사항</td>
					<td><textarea placeholder="내용을 입력하세요" name="detail"></textarea></td>
				</tr>
			</table>
		</fieldset>
			
	
		<fieldset>
			<legend for="order_info">주문 정보</legend>
			<table>
				<tr>
					<td>피자</td>
					<td>
						<select name="menu">
							<option value="pepperonni">페퍼로니</option>
							<option value="supersupreme">슈퍼슈프림</option>
							<option value="corncheese">콘치즈</option>
							<option value="bulgogi">불고기</option>
							<option value="hotchicken">핫치킨</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>토핑</td>
					<td>
						<input type="checkbox" name="topping" value="olive" />올리브
						<input type="checkbox" name="topping" value="bacon" />베이컨
						<input type="checkbox" name="topping" value="cheese" />치즈<br>
						<input type="checkbox" name="topping" value="ham" />햄
						<input type="checkbox" name="topping" value="onion" />양파
						<input type="checkbox" name="topping" value="hallapeno" />할라피뇨
					</td>
				<tr>
				
				<tr>
					<td>사이드</td>
					<td>
						<input type="checkbox" name="sidemenu" value="coke" />콜라
						<input type="checkbox" name="sidemenu" value="ovenPasta" />오븐 스파게티
						<input type="checkbox" name="sidemenu" value="rosePasta" />로제 파스타<br>
						<input type="checkbox" name="sidemenu" value="wing" /> 멕시칸윙
						<input type="checkbox" name="sidemenu" value="tender" />치킨텐더
					</td>
				</tr>
			</table>
		</fieldset>
		<button type="submit">주문</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>