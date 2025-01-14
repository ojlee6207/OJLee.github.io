<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세보기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    <style>
        .outer {
            background-color: #e7e7e7;
            width: 80%;
            margin: auto;
        }
        .inner-area {
            border: 1px solid #000025;
            width: 80%;
            margin: auto;
            padding: 5% 15%;
            background: #e7ecf7;
        }
        
        table {width:100%;}
        table * {margin:5px;}
    </style>    
</head>
<body>
    <%-- header --%>
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <br><br>
        <div class="inner-area">
            <h2>게시글 상세보기</h2>
            <br>
            <a href="list.bo" class="btn btn-secondary" style="float:right;">목록보기</a>
            <br><br>

            <table align="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">
                        ${blist.boardTitle}
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>
                        ${blist.boardWriter}
                    </td>
                    <th>작성일</th>
                    <td>
                        ${blist.createDate}
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                    	<c:choose>
	                        <c:when test="${empty blist.originName}">
		                    	첨부파일이 없습니다
		                    </c:when>
		                    <c:otherwise>
		                    	<a href="${blist.changeName}" download="${blist.originName}">${blist.originName}</a>
		                    </c:otherwise>
		            	</c:choose>
	                </td>		            
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <p style="height:150px;">
                            ${blist.boardContent}
                        </p>
                    </td>
                </tr>
            </table>
            <br>

            <div align="center">
                <!-- 작성자와 로그인한 계정이 동일한 경우만 표시 -->
                <c:if test="${loginUser.userId == blist.boardWriter}">
                	<a class="btn btn-primary" onclick="postFormSubmit(1);">수정</a>
                	<a class="btn btn-danger" onclick="postFormSubmit(2);">삭제</a>
                </c:if>
            </div>
            <br><br>
            
            <form id="postForm" action="" method="post">
            	<input type="hidden" name="bno" value="${blist.boardNo}" />
            	<input type="hidden" name="filepath" value="${blist.changeName}" />
            </form>
            
            <script>	<!-- function postFormSubmit(type)-->
            	const postFormSubmit = (type) => {
            		if (type == 1) {	// 수정요청
            			$("#postForm").attr("action", "updateForm.bo").submit();
            		} else {	// 삭제요청
            			$("#postForm").attr("action", "delete.bo").submit();
            		}
            	}
            </script>
            
            <table id="replyArea" class="table" align="center">
                <thead>
                	<%--
                		* 로그인한 사용자인 경우에만 댓글 등록 가능하도록
                		  로그인 하지 않은 경우 입력창 부분에 '로그인 후 이용가능합니다' 메세지와 
                		  입력 못하도록 [등록] 버튼 비활성화
                	 --%>
                    <tr>
                    	<c:choose>
                    		<c:when test="${not empty loginUser}">	
                    			<%-- 로그인한 상태 --%>
		                    	<th colspan="2">
				                    <textarea name="replyContent" id="content" cols="55" rows="2" class="form-control" style="resize: none;"></textarea>
				                </th>
				                <th style="vertical-align:middle;">
				              	    <button class="btn btn-secondary" onclick="addReply();" >등록</button>
				                </th>
		                	</c:when>
		                	<c:otherwise>
		                		<th colspan="2">
				                    <textarea cols="55" rows="2" class="form-control" style="resize: none;" readonly>로그인 후 이용가능합니다</textarea>
				                </th>
				                <th style="vertical-align:middle;">
				              	    <button class="btn btn-secondary" disabled>등록</button>
				                </th>
		                	</c:otherwise>
		                </c:choose>
                   	</tr>                    
                    <tr>
                        <td colspan="3">댓글 (<span id="rcount"></span>)</td>
                    </tr>
                </thead>
                <tbody>
                    <!-- <tr>
                        <th>user02</th>
                        <td>댓글-----내용</td>
                        <td>2024-04-15</td>
                    </tr>
                    <tr>
                        <th>user01</th>
                        <td>ㅋㅋㅋㅋㅋㅋㅋ</td>
                        <td>2024-04-13</td>
                    </tr>
                    <tr>
                        <th>admin</th>
                        <td>댓글테스트ㅋㅋ</td>
                        <td>2024-04-07</td>
                    </tr> -->                        
                </tbody> 
            </table>     
            <br><br>
            <script>
            	$(function(){
            		selectReplyList();
            		
            		setInterval(selectReplyList, 1000);
            	});
            	
				const addReply = () => {
            		// 댓글 추가(ajax) : 댓글에 입력값이 있을 경우만 추가할 수 있도록(공백 x)
            		//				   추가할 수 없으면 "내용 작성 후 등록 가능합니다." 메시지 표기
            		if ($("#content").val().trim().length > 0) {
	            		// 댓글 추가 요청
            			$.ajax({
	            			url: "rinsert.bo",
	            			data: {
	            				refBNo: ${blist.boardNo},
	            				replyWriter : "${loginUser.userId}",
	            				replyContent : $("#content").val(),
	            			},
	            			success: function(status) {
	            				if(status === "success") {
	            					// 댓글 추가 성공
	            					$("#content").val("");
	            					selectReplyList();
	            				} else {
	            					// 댓글 추가 실패
	            					alertify.alert("ERROR", "댓글 추가 실패");
	            				}
	            			},
	            			error: function(err){
	            				console.log("댓글 요청 ajax 통신 실패");
	            				console.log(err);
	            			}	            			
	            		})
            		} else {
            			alertify.alert("Warning", "내용 작성 후 등록 가능합니다.");
            		}
            	}
            	
            	const selectReplyList = () => {
            		// 해당 게시글의 추가된 댓글 목록 조회(ajax)
            		$.ajax({
            			url: "rlist.bo",
            			data: {
            				bno: ${blist.boardNo}
            			},
            			success: function(rlist) {
            				console.log(rlist);
            				let value = "";
            				for(let i in rlist){
            					value += "<tr>"
            							+"<th>"+ rlist[i].replyWriter +"</th>"
            							+"<td>"+ rlist[i].replyContent +"</td>"
            							+"<td>"+ rlist[i].createDate +"</td>"
            							+"</tr>"
            				}
            				$("#replyArea > tbody").html(value);
            				$("#rcount").text(rlist.length);
            			},
            			error: function() {
            				console.log("ajax 통신 실패");
            			}
            			
            		});
            	}   
            </script>
            
            
        </div>


    </div>

    <%-- footer --%>
    <jsp:include page="../common/footer.jsp" />    
</body>
</html>