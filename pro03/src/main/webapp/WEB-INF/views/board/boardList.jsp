<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path0" value="<%=request.getContextPath() %>" />    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>게시판 목록</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="resources/css/normalize.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation-prototype.min.css">
    <link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.js"></script>
</head>
<body>
<header id="header">
	<a href="${path0 }">메인으로</a>
</header>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">게시판 목록</h3>
			<div>
				<table class="table" id="tb1">
					<thead>
						<tr>
							<th class="item1">번호</th>
							<th class="item2">제목</th>
							<th class="item3">작성일</th>
							<th class="item4">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty boardList }">
							<c:forEach var="dto" items="${boardList }" varStatus="status">
							<tr>
								<td>${fn:length(boardList) - status.count + 1}</td>
								<td>
									<c:if test="${empty memb }">
									<strong>${dto.title }</strong>
									</c:if>
									<c:if test="${not empty memb }">
									<a href="${path0 }/board/getBoard.do?bno=${dto.bno }">${dto.title }</a>
									</c:if>
								</td>
								<td>
									<fmt:parseDate value="${dto.resdate }" var="parsedDate" pattern="yyyy-mm-dd" />
									<fmt:formatDate value="${parsedDate }" var="outputDate" pattern="yyyy년 mm월 dd일"/>
									${outputDate }
								</td>
								<td>${dto.vcnt }</td>
							</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty boardList }">
							<tr>
								<td colspan="4"><strong>공지사항이 존재하지 않습니다.</strong></td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<script>
				$(document).ready(function(){
					$("#tb1").DataTable({
						order:[[0,"desc"]]
					});
				});
				</script>
				<hr>
				<c:if test="${sid.equals('admin') }">
				<div class="btn-group">
				  <a href="${path0 }/board/insBoard.do" class="button btn-secondary">글 등록</a>
				</div>
				</c:if>
			</div>
		</div>
	</section>
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>