<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis Project</title>
</head>
<body>
	<%--
		* FrameWork
		 - 개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 툴, 뼈대
		 - 소프트웨어 개발 시 공통적으로 사용되는 라이브러리/개발도구/인터페이스 등을 의미함
		 
		* 프레임워크 필요성
		 - 규모가 큰 프로젝트 작업 시 많은 개발자가 필요함에 따라
		   => 개발자들이 "통일성"있고 "빠르고", "안정적"으로 개발하기 위해 도움을 준다.
		   => 생산성 증대
		   
		* 특징
		 - 개발자들이 따라야 하는 가이드라인 제공 => 자유롭게 설계 또는 구현 X, 가이드라인대로 설계/구현해야 함
		 - 개발 범위가 정해져 있음
		 - 개발자들을 위한 다양한 도구들이 지원
		 
		* 장점 : 개발 시간 단축, 유지보수 용이
		* 단점 : 숙달화 과정 김, 프레임워크 의존 시 개발 능력 하향
		
		* 종류
			- 영속성 : 데이터 관련 CRUD 기능 제공, 좀 더 편리하게 작업할 수 있도록 도와주는 프레임워크
					ex) mybatis, hibernate, jpa, ...
			- 자바 : 웹 어플리케이션에 초점을 두고 필요한 요소들을 모듈화해서 제공해주는 프레임워크
					ex) spring(boot)
			- 화면구현 : Front-end를 보다 쉽게 구현할 수 있도록 제공해주는 프레임워크
					ex) bootstrap
			- 기능 및 지원 : 특정 기능이나 수행 업무에 도움을 줄 수 있는 프레임워크
					ex) log4j  
	 --%>
	 여기는 index.jsp입니다.
	 <%-- WEB-INF 폴더는 WAS가 관리하는 폴더로 포워딩 방식을 통해 접근 가능 --%>
	 <jsp:forward page="WEB-INF/views/main.jsp" />
</body>
</html>