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
        .product-amount {
            color: blue;
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
					<a href="${path2 }/product/categoryList.do?category=snack"><button class="add-product-btn">스낵</button></a>
					<a href="${path2 }/product/categoryList.do?category=candy"><button class="add-product-btn">캔디</button></a>
					<a href="${path2 }/product/categoryList.do?category=choco"><button class="add-product-btn">초코</button></a>
				</div>
				<h1>상품 재고 리스트</h1>
    			<div class="product-list">
    				<c:if test="${not empty inventoryList }">
    				<c:forEach var="inventory" items="${inventoryList }" varStatus="status">
			        <div class="product">
			        	<a href="${path2 }/inventory/getInventory.do?ino=${inventory.ino}">
			            	<img src="${path2 }/resources/upload/${productList[status.index].img}" alt="${productList[status.index].pname }">
			            </a>
			            <div class="product-name">${productList[status.index].pname }</div>
			            <div class="product-price">입고가 : ${inventory.inprice }원</div>
			            <div class="product-price">출고가 : ${inventory.outprice }원</div>
			            <div class="product-amount">수량 : ${inventory.amount }개</div>
			        </div>
			        </c:forEach>
			        </c:if>
			        <c:if test="${empty inventoryList }">
			        	상품이 존재하지 않습니다.
			        </c:if>
			    </div>
			    <c:if test="${sid.equals('admin') }">
			    <button class="add-product-btn" onclick="location.href='${path2}/inventory/insInventory.do'">재고 등록</button>
			    </c:if>
			</div>
		</section>	
	</main>
	<footer id="ft">
		<jsp:include page="../include/ft.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>