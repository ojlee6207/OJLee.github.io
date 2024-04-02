<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연산 </h1>
	
	<h3>1. 산술 연산</h3>
	기존 방식 (el 사용하지 않음) :
		<%= (int)request.getAttribute("big") %> + <%= (int)request.getAttribute("small") %>
		= <%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %>
	<br><br>
	EL 방식 <br>
	<%-- EL 사용 시 형변환이 필요 없음! 알아서 형변환을 해줌 --%>
	${ big } + ${ small } = ${ big + small } <br>
	${ big } - ${ small } = ${ big - small } <br>
	${ big } x ${ small } = ${ big * small } <br>
	${ big } / ${ small } = ${ big / small } 또는 ${ big div small }<br>
	${ big } % ${ small } = ${ big % small } 또는 ${ big mod small }<br>
	<br>
	
	<h3>2. 대소 비교 연산</h3>
	<%-- greater than / less than --%>
	${ big } &gt; ${ small } => ${ big > small } 또는 ${ big gt small }<br>
	${ big } &lt; ${ small } => ${ big < small } 또는 ${ big lt small }<br>
	${ big } &gt;= ${ small } => ${ big >= small } 또는 ${ big ge small }<br>
	${ big } &lt;= ${ small } => ${ big <= small } 또는 ${ big le small }<br>
	<%-- if문에 해당하는 action태그 사용 시 조건식으로 쓰여질 것이다. --%>
	<br>
	
	<h3>3. 동등 비교 연산</h3>
	<%-- EL에서는 문자열을 비교할 때 ==를 사용하면 자바에서의 equals()와 같은 동작을 함 --%>
	str1과 str2가 일치하는 지? ${ str1 == str2 } 또는 ${ str1 eq str2 }<br>
	str1과 str2가 일치하지 않는지? ${ str1 != str2 } 또는 ${ str1 ne str2 }<br>
	
	big에 담긴 값이 10000과 일치하는 지? ${ big == 10000 } 또는 ${ big eq 10000 }<br>
	
	str1에 담긴 값이 "반가워요"와 일치하는 지? ${ str1 == '반가워요' } 또는 ${ str1 eq "반가워요" }<br>
	<%-- EL에서 구문에서는 문자열 리터럴 사용 시 작은따옴표(''), 큰따옴표("")를 구분하지 않음 --%>
	
	<h3>4. 객체가 null인지 또는 리스트가 비어있는 지 비교</h3>
	
	p1이 null인가? ${ p1 == null } 또는 ${ empty p1 }<br>
	p2가 null인가? ${ p2 == null } 또는 ${ empty p2 }<br>
	
	list1이 비어있는 지? ${ empty list1 }<br>
	list2가 비어있는 지? ${ empty list2 }<br>
	
	<h3>5. 논리 연산자</h3>
	${ true && true } 또는 ${ true and true }<br>
	${ true || true } 또는 ${ true or true }<br>
	<br>
	
	<%-- big이 small보다 크고 list1이 비어있는가? --%>
	* big이 small보다 크고 list1이 비어있는가? <%-- <%= (big > small) && (list1.isEmpty()) --%> <br>
										 ${ (big gt small) and (empty list1) } <br>
</body>
</html>












