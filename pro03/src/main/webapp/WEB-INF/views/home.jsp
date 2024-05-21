<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>${serverTime }</h2>
	<h2>${author }</h2>
	<h2>${company }</h2>
	<p>${msg }</p>
	<hr>
	<ul>
		<li><a href="${path2 }/sample/list.do">샘플 리스트</a></li>
	</ul>
	<hr>
	<c:if test="${empty memb}">
	<ul>
		<li><a href="${path2 }/member/login.do">로그인</a></li>
		<li><a href="${path2 }/member/agree.do">회원가입</a></li>
	</ul>
	</c:if>
	<c:if test="${!empty memb}">
	<ul>
		<li><a href="${path2 }/member/myInfo.do">마이페이지</a></li>
		<li><a href="${path2 }/member/myUpdate.do">회원정보수정</a></li>
		<li><a href="${path2 }/member/logout.do">로그아웃</a></li>
	</ul>
	</c:if>	
	<ul>
		<li><a href="${path2 }/board/boardList.do">게시판 목록</a></li>
		<li></li>
	</ul>
	<c:if test="${sid.equals('admin') }">
	<ul>
		<li><a href="${path2 }/admin/memberList.do">회원목록</a></li>
	</ul>
	</c:if>	
</body>
</html>