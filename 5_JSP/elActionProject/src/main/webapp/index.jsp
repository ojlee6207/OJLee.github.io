<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> * EL (Expression Language) 표현언어 </h1>
	<p>
		기존에 사용했던 출력식(표현식) &lt;%= 변수 %&gt;와 같이<br>
		JSP 상에서 표현하고자 하는 값을 \${ 변수 } 의 형식으로 표현하여 작성하는 것
	</p>
	
	<h4><a href="el.do">01_EL 기본 문법</a></h4>
	<br>
	<h4><a href="operation.do">02_EL 연산자</a></h4>
	<hr>
	<%--
		* JSP를 이루는 구성인자
		1. 스크립팅 원소 : JSP페이지에서 자바코드를 직접 기술할 수 있게 하는 기능
						ex) 스크립트릿, 표현식
		2. 지시어 : JSP페이지 정보에 대하여 내용을 표현하거나 또 다른 페이지를 포함할 때 사용하는 문법
				  JSP 기능을 확장시키는 라이브러리를 등록할 때도 사용
				  ex) page, include, taglib 지시어
		3. 액션태그 : 표준액션태그, 커스텀액션태그
					xml 기술을 이용하여 기존의 JSP문법을 확장하는 태그
					> 표준액션태그 : JSP페이지에서 바로 사용 가능
								  모든 태그명 앞에 jsp: 접두어 사용
					> 커스텀액션태그 : JSP페이지에서 바로 사용 불가능 => 별도로 라이브러리 필요!
									모든 태그명 앞에 jsp: 외에 다른 접두어가 붙음 (종류 다양함)
									가장 대표적인 라이브러리 : JSTL
	 --%>
	 <h1>JSP Action Tag</h1>
	 <p>
	 	XML 기술을 이용하여 기존의 JSP문법을 확장시키는 기술을 제공하는 태그
	 </p>
	 
	 <h3>1. 표준액션태그</h3>
	 <a href="views/2_StandardAction/01_include.jsp">01_jsp:include</a><br>
	 <a href="views/2_StandardAction/02_forward.jsp">02_jsp:forward</a><br>
	 <br>
	 <h3>2. 커스텀액션태그 (JSTL)</h3>
	 <a href="views/3_CustomAction/jstl.jsp">JSTL</a>
</body>
</html>









