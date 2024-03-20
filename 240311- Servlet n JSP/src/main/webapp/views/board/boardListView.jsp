<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
</head>
<style>
    .outer { background: black; color:white;
    		 width:1000px; height: 500px; margin:auto; margin-top: 50px;} 
    .list-area { border : 1px solid white; text-align: center; color:white; }
	.list-area>tbody>tr:hover { background:darkgray; cursor:pointer; }

</style>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">일반 게시판</h2>
        <br>
        <table align="center" class="list-area">
            <thead>
                <tr>
                    <th width="70">글번호</th>
                    <th width="80">카테고리</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th width="50">조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>공통</td>
                    <td>제목1</td>
                    <td>user01</td>
                    <td>100</td>
                    <td>24/03/20</td>
                </tr>
            </tbody>
        </table>
        <br><br>

        <div align="center">
            <button>&lt;</button>
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <button>5</button>
            <button>6</button>
            <button>7</button>
            <button>8</button>
            <button>9</button>
            <button>10</button>
            <button>&gt;</button>
        </div>
    </div>
</body>
</html>