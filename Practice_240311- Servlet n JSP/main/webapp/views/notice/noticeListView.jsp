<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, java.sql.Date, com.kh.notice.model.vo.Notice" %>

<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer { background: black; color:white;
			 width:1000px; height: 500px; margin:auto; margin-top: 50px;} 
	.list-area { border : 1px solid white; text-align: center; color:white; }
	.list-area>tbody>tr:hover { background:darkgray; cursor:pointer; }
</style>
</head>
<body>
	<%-- menubar.jsp 파일 포함시키기 --%>
	<%@ include file="../common/menubar.jsp" %>

	<div class="outer">
		<table class="list-area" align="center">
			<thead>
				<th>글번호</th>
				<th width="400">글제목</th>
				<th width="100">작성자</th>
				<th>조회수</th>
				<th width="100">작성일</th>
			</thead>
			<tbody>
				<%-- 공지사항이 없을 경우 --%>
				<% if (list.isEmpty()) { %>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr>
				<% } else { %>
				<%-- 공지사항이 있을 경우 --%> 
				<% for(Notice n : list) { %>
				<tr>
					<td><%= n.getNoticeNo() %></td>
					<td><%= n.getNoticeTitle() %></td>
					<td><%= n.getNoticeWriter() %></td>
					<td><%= n.getCount() %></td>
					<td><%= n.getDate() %></td>
				</tr>
				<% } %>
			<% } %>
			</tbody>
		</table>
	</div>
	<script>
		const trList = document.querySelectorAll(".list-area>tbody>tr");
		for (const tr of trList) {
			tr.onclick = function() {
				const noticeNo = this.childNodes[1].innerText;
				// console.log(noticeNo);
				
				// get 요청 => 요청 url ? 키값 = 밸류값 & 키값 = 밸류값;
				location.href = "<%= contextPath %>/detail.no?num="+noticeNo;
				//				=> /jsp/detail.no?num=2
			}
		}
	</script>
</body>
</html>