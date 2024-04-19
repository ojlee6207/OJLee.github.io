<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유 게시판</title>
<style>
    #boardList {text-align: center;}
    #boardList>tbody>tr:hover{cursor:pointer;}

    #pagingArea {width:fit-content; margin:auto;}

    #searchForm {width:80%; margin: auto;}
    #searchForm>* {float:left; margin:5px;}
        
    .select {width:25%;}
    .text {width:48%;}
    .searchBtn{width:20%;}
</style>
</head>
<body>
    <%-- header --%>
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <br><br>
        <div class="innerOuter" style="padding: 5% 10%">
            <h2>게시판</h2>
            <br>

            <%-- 로그인 시에만 글쓰기 버튼 표시 --%>
            <c:if test="${loginUser ne null }">
            	<a href="enrollForm.bo" class="btn btn-secondary" style="float:right">글쓰기</a>
            </c:if>
            <br>
            
            <br>
            <table id="boardList" class="table table-hover" align="center">
                <thead>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>첨부파일</th>
                </thead>

                <tbody>
                    <c:choose>
                    	<c:when test="${ empty blist }">
                    		<tr><td colspan="6">데이터가 없습니다.</td></tr>
                    	</c:when>
                    	<c:otherwise>
                    		<c:forEach var="b" items="${ blist }">
                    			<tr>
                    				<td class="bno">${b.boardNo}</td>
                    				<td>${b.boardTitle}</td>
                    				<td>${b.boardWriter}</td>
                    				<td>${b.count}</td>
                    				<td>${b.createDate}</td>
                    				<td>
	                    				<c:if test="${b.originName ne null}">💾</c:if>
	                    			</td>
                    			</tr>
                    		</c:forEach>
                    	</c:otherwise>
                    </c:choose>                       
                </tbody>
            </table>
            <br>
			<script>
				$(function(){
					$("#boardList>tbody>tr").click(function(){
						location.href = 'detail.bo?bno='+$(this).children(".bno").text();
					})
				})
			</script>


            <div id="pagingArea">
                <ul class="pagination">
	            	<c:if test="${ pi.currentPage gt 1 }">
	            		<li class="page-item"><a href="list.bo?cpage=${ pi.currentPage-1 }" class="page-link">Prev</a></li>
	            	</c:if>
					<c:forEach var ="p" begin="${pi.startPage}" end="${pi.endPage}">
                    	<li class="page-item"><a href="list.bo?cpage=${ p }" class="page-link">${ p }</a></li>
                  	</c:forEach>
                  	<c:if test="${ pi.currentPage lt pi.maxPage }">
                    	<li class="page-item"><a href="list.bo?cpage=${ pi.currentPage+1 }" class="page-link">Next</a></li>
                    </c:if>
                </ul>
            </div>

            <br clear="both">

            <form action="" id="searchForm">
                <div class="select">
                    <select name="condition" id="" class="custom-select form-select">
                        <option value="writer">작성자</option>
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                </div>
                <div class="text">
                    <input type="text" class="form-control" name="keyword">
                </div>
                <button class="searchBtn btn btn-secondary">검색</button>
            </form>
            <br><br>
        </div>
        <br><br>
    </div>

    <%-- footer --%>
    <jsp:include page="../common/footer.jsp" />
</body>
</html>