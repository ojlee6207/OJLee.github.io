<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.Board" %>
<%
	Board b = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
    .outer { background: black; color:white;
    		 width:1000px; height: 500px; margin:auto; margin-top: 50px;} 
    .outer table {
        border:1px solid white; 
        border-collapse: collapse;
    }
    .outer > table tr, .outer > table td {
        border: 1px solid white;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer" align="center">
        <br>
        <h2 align="center">일반게시글 상세보기</h2>
        <br>

        <table>
        	<tr>
        		<th>카테고리</th>
        		<td>@@ 카테고리 정보</td>
        		<th>제목</th>
        		<td>@@ 제목</td>
        	</tr>
            <tr>
                <th>작성자</th>
                <td>@@작성자</td>
                <th>작성일</th>
                <td>@@작성일</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height: 200px">@@ 내용</p>
                </td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td colspan="3">
                	<%-- 첨부파일 X --%>
                	첨부파일이 없습니다.
                	<%-- 첨부 파일 있음 --%>
                    <a href="폴더경로/실제파일명">@@ 원본파일명.확장자</a>
                </td>
            </tr>
        </table>
        <br><br>
       	<div align="center">
       		<a href="" class="btn">목록이동</a>
       		<a href="" class="btn">수정</a>
       		<a href="" class="btn">삭제</a> 
        </div>
   </div>

</body>
</html>