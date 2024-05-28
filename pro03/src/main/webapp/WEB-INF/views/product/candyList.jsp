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
	<title>MAIN</title>
	<style>
		body {
            font-family: Arial, sans-serif;
        }
        .product-list {
            display: flex;
            flex-wrap: wrap;
        }
        .product {
            border: 1px solid #ddd;
            border-radius: 4px;
            margin: 10px;
            padding: 10px;
            width: 200px;
            box-shadow: 2px 2px 6px #ccc;
        }
        .product img {
            max-width: 100%;
            height: auto;
        }
        .product-name {
            font-size: 1.2em;
            margin: 10px 0;
        }
        .product-price {
            color: green;
        }
	</style>
    <jsp:include page="../include/head.jsp"></jsp:include>
</head>
<body>
<div class="full-wrap">
	<header id="hd" class="header">
    	<div class="container">
			<jsp:include page="../include/hd.jsp"></jsp:include>
		</div>
	</header>
	<main class="contents" id="contents">
		<section class="page clr-fix" id="page1">
			<div class="page-wrap">
				<h1>스낵 리스트</h1>
    			<div class="product-list">
    				<c:if test="${not empty categoryList }">
    				<c:forEach var="candy" items="${categoryList }">
			        <div class="product">
			       		<a href="${path2 }/product/getProduct.do?pno=${candy.pno}">
			            	<img src="${path2 }/resources/images/${candy.category }/${candy.img}" alt="${candy.pname }">
			            </a>
			            <div class="product-name">${candy.pname }</div>
			            <div class="product-price">${candy.price }</div>
			        </div>
			        </c:forEach>
			        </c:if>
			        <c:if test="${empty categoryList }">
			        상품이 존재하지 않습니다.
			        </c:if>
			    </div>
			</div>
		</section>	
	</main>
	<footer id="ft">
		<jsp:include page="../include/ft.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>