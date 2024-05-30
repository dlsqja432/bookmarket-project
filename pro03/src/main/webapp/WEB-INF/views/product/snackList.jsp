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
        .add-product-btn {
            background: linear-gradient(to right, #4CAF50, #45A049);
            border: none;
            border-radius: 5px;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .add-product-btn:hover {
            background: linear-gradient(to right, #45A049, #4CAF50);
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
				<div style="margin:10px 0">
					<a href="${path2 }/product/productList.do"><button class="add-product-btn">ALL</button></a>
					<a href="${path2 }/product/categoryList.do?category=snack"><button class="add-product-btn">스낵</button></a>
					<a href="${path2 }/product/categoryList.do?category=choco"><button class="add-product-btn">초코</button></a>
					<a href="${path2 }/product/categoryList.do?category=candy"><button class="add-product-btn">캔디</button></a>
				</div>
				<h2>스낵 리스트</h2>
    			<div class="product-list">
    				<c:if test="${not empty categoryList }">
    				<c:forEach var="snack" items="${categoryList }">
			        <div class="product">
			        	<a href="${path2 }/product/getProduct.do?pno=${snack.pno}">
			            	<img src="${path2 }/resources/upload/${snack.img}" alt="${snack.pname }">
			            </a>
			            <div class="product-name">${snack.pname }</div>
			            <div class="product-price">${snack.price }원</div>
			        </div>
			        </c:forEach>
			        </c:if>
			        <c:if test="${empty categoryList }">
			        상품이 존재하지 않습니다.
			        </c:if>
			    </div>
			    <c:if test="${sid.equals('admin') }">
			    <button class="add-product-btn" onclick="location.href='${path2}/product/insProduct.do'" style="margin:10px;">상품 등록</button>
			    </c:if>
			    <a href="${path2 }/product/productList.do" class="button is-warning" style="margin:10px;">상품 목록</a>
			</div>
		</section>	
	</main>
	<footer id="ft">
		<jsp:include page="../include/ft.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>