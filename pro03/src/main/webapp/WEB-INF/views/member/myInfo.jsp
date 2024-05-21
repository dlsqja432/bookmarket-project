<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 보기</title>
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
	<a href="${path1 }">메인으로</a>
</header>

<div class="content" id="con">
    <div class="row column text-center">
        <div class="container">
            <div class="table_form_wrap">
                <table class="table_form">
                    <tbody>
	                    <tr>
	                        <th>아이디</th>
	                        <td>${memb.id }</td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>********</td>
	                    </tr>
	                    <tr>
	                        <th>이름</th>
	                        <td>${memb.name }</td>
	                    </tr>
	                    <tr>
	                        <th>이메일</th>
	                        <td>${memb.email }</td>
	                    </tr>
	                    <tr>
	                        <th>전화번호</th>
	                        <td>${memb.tel }</td>
	                    </tr>
	                    <tr>
	                        <th>주소</th>
	                        <td>
	                            ${memb.addr }
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>우편번호</th>
	                        <td>
	                            ${memb.postcode }
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>가입 일시</th>
	                        <td>
	                            <fmt:parseDate value="${memb.resdate }" pattern="yyyy-mm-dd" var="parsedDate" />
	                            <fmt:formatDate value="${parsedDate }" pattern="yyyy년 mm월 dd일" var="outputDate"/>
	                            ${outputDate }
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                            <c:if test="${memb.id=='admin' }">
	                                <a href="${path1 }/admin/memberDelete.do?id=${aid }" class="button btn-primary">직권 강퇴</a>
	                            </c:if>
	                            <c:if test="${!empty mem.id }">
	                            	<a href="${path1 }/member/myUpdate.do" class="button btn-primary">회원정보 수정</a>
	                                <a href="${path1 }/member/memberDelete.do?id=${memb.id }" class="button btn-danger">회원 탈퇴</a>
	                            </c:if>
	                            <c:if test="${memb.id=='admin' }">
	                                <a href="${path1 }/admin/memberList.do" class="button btn-primary">회원 목록</a>
	                            </c:if>
	                        </td>
	                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>