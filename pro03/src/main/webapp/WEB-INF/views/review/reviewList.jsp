<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>공지사항 목록</title>
	<jsp:include page="../include/head.jsp"></jsp:include>
	<style>
	#tb1 { width:1260px; }
	
	.rating {
	    float: none;
	    width: 200px;
	    display: flex;
	}
		
	.star-icon-left, .star-icon-right {
	    width: 20px;
	    height: 40px;
	    display: block;
	    position: relative;
	    left: 0;
	    background-image: url('https://velog.velcdn.com/images/jellykelly/post/9957327f-f358-4c25-9989-5bb3dd5755d6/image.svg');
	    background-repeat: no-repeat;
	    background-size: 40px;
	}
	
	.star-icon-left.filled, .star-icon-right.filled {
	    background-image: url('https://velog.velcdn.com/images/jellykelly/post/10caf033-b0ef-4d58-804b-6e33395e4ea5/image.svg');
	}
	
	.star-icon-right {
	    background-position: right;
	}
	
	.star-icon-left {
	    background-position: left;
	}
	</style>
</head>
<body>
<div class="full-wrap">
    <!-- 헤더 부분 인클루드 -->
    <header id="hd">
    	<div class="container">
    		<jsp:include page="../include/hd.jsp"></jsp:include>
    	</div>
    </header>
    <main id="contents" class="contents">
    	<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px; line-height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path2 }">Home</a></li>
			    <li><a href="${path2 }/board/boardList.do">Notice</a></li>
			    <li class="is-active"><a href="#" aria-current="page">BoardList</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">리뷰 목록</h2>
    		<div class="page-wrap">
	    		<div class="clr-fix">
	    			<br>
					<table class="table" id="tb1">
						<thead>
							<tr>
								<th class="item1">번호</th>
								<th class="item2">내용</th>
								<th class="item3">별점</th>
								<th class="item4">제품번호</th>
								<th class="item5">작성자</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty reviewList }">
								<c:forEach var="dto" items="${reviewList }" varStatus="status">
								<tr>
									<td>${fn:length(reviewList) - status.count + 1 }</td>
									<td>
										<a href="${path2 }/review/getReview.do?rno=${dto.rno}"><strong>${dto.content }</strong></a>
										<input type="hidden" id="star-${dto.rno }" name="star" value="${dto.star }">
									</td>
									<td>
										<div class="rating" id="rating-${dto.rno }">
									    </div>
									</td>
									<td><a href="${path2 }/product/getProduct.do?pno=${dto.pno}">${dto.pno }</a></td>
									<td>${dto.id }</td>
								</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty reviewList }">
								<tr>
									<td colspan="4"><strong>리뷰가 존재하지 않습니다.</strong></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<script>
					$(document).ready(function(){
						<c:forEach var="dto" items="${reviewList}">
					    	updateStars(${dto.rno});
					    </c:forEach>
					});
					</script>
					<hr>
					<div class="buttons">
					  <a href="${path2 }/review/insReview.do" class="button is-danger">리뷰 등록</a>
					</div>
					<script>
						function updateStars(id) {
							const ratingDiv = document.getElementById('rating-' + id);
							const value = parseFloat(document.getElementById('star-' + id).value);
							const totalStars = Math.floor(value * 2);
							
							ratingDiv.innerHTML = '';
							
							for(let i = 0; i<totalStars; i++) {
								const starSpan = document.createElement('span');
								if(i % 2 == 0) {
									starSpan.classList.add('star-icon-left');
								} else {
				                    starSpan.classList.add('star-icon-right');
				                }
								
								starSpan.classList.add('filled');
				                ratingDiv.appendChild(starSpan);
							}
							
							for(let i = totalStars; i<10; i++) {
								const starSpan = document.createElement('span');
								if(i % 2 == 0) {
									starSpan.classList.add('star-icon-left');
								} else {
				                    starSpan.classList.add('star-icon-right');
				                }
								ratingDiv.appendChild(starSpan);
							}
						}
					</script>
				</div>
    		</div>
    	</section>
    </main>
    <!-- 푸터 부분 인클루드 -->
    <footer id="ft">
    	<jsp:include page="../include/ft.jsp"></jsp:include>
    </footer>
    <script>
    $(document).ready(function(){
    	$("#tb1_length, #tb1_filter").css("margin-bottom", "20px");
    });
    </script>
</div>    
</body>
</html>