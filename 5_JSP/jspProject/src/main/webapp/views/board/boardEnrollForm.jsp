<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.Category" %>
<%
	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("category");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer { background: black; color:white;
    	     width:1000px; height: 600px; margin:auto; margin-top: 50px;} 
    form table { border: 1px solid white; }
    form input, form textarea { width:100%
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="outer" align="center">
        <br>
        <h2>일반 게시글 작성하기</h2>
        <br>

        <form action="<%= contextPath %>/insert.bo" method="post" enctype="multipart/form-data"> <!-- enctype= 이 양식에는 어떤 형태가 포함되어 있다 -->
            <table>
            	<tr>
            		<th>카테고리</th>
            		<td>
            			<%-- Category에서 조회된 항목 표시 --%>
            			<% if(!categoryList.isEmpty()) { %>
	            			<select name="category">
	            			<% for (Category ca : categoryList) { %>
	            				<option value="<%= ca.getCategoryNo() %>"><%= ca.getCategoryName() %></option>
	            			<% } %>	
	            			</select>
	            		<% } %>
            		</td>
            	</tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" rows="10" style="resize:none;" required></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input type="file" name="upfile" /><td>
                </tr>
            </table>
            <br><br>
            <div>
                <button type="submit">등록하기</button>
                <button type="reset">초기화</button>
                <button type="button" onclick="history.back()">뒤로가기</button>
            </div>
        </form>
    </div>

<body>

</body>
</html>
</body>
</html>