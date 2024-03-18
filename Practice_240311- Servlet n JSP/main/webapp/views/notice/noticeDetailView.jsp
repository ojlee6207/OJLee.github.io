<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.Notice" %>
<%
    Notice n = (Notice)request.getAttribute("notice");
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
        <h2 align="center">공지사항 상세보기</h2>
        <br>
        
        <table>
            <tr>
                <th width="70">제목</th>
                <td colspan="3" width="400"><%= n.getNoticeTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= n.getNoticeWriter() %></td>
                <th>작성일</th>
                <td><%= n.getDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height: 150px"><%= n.getNoticeContent() %></p>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>