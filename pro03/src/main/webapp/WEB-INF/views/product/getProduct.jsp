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
        .product-detail {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-shadow: 2px 2px 6px #ccc;
        }
        .product-detail img {
            max-width: 100%;
            height: auto;
        }
        .product-name {
            font-size: 2em;
            margin: 10px 0;
        }
        .product-price {
            color: green;
            font-size: 1.5em;
        }
        .product-description {
            margin: 20px 0;
        }
        .back-link {
            display: block;
            margin: 20px 0;
            text-align: center;
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
				<div class="product-detail">
					<c:if test="${not empty product }">
				        <img src="${path2 }/resources/upload/${product.img2}" alt="${product.pname }">
				        <c:if test="${sid.equals('admin') }">
				        <div class="product-name">상품번호 : ${product.pno }</div>
				        </c:if>
				        <div class="product-name">${product.pname }</div>
				        <div class="product-price">${product.price }원</div>
				        <div class="product-description">${product.com }</div>
			        </c:if>
			        <c:if test="${empty product }">
			        	<p>상품을 찾을 수 없습니다.</p>
			        </c:if>
			        <c:if test="${sid.equals('admin') }">
				        <a href="${path2 }/product/editProduct.do?pno=${product.pno }" class="button is-warning">상품 수정</a>
				        <a href="${path2 }/product/delProduct.do?pno=${product.pno }" class="button is-danger is-dark">상품 삭제</a>
			        </c:if>
			        <c:if test="${not empty memb }">
			        	<a href="${path2 }/sales/insSales.do?pno=${product.pno}" class="button is-success">상품 구매</a>
			        </c:if>
			        <c:if test="${empty memb }">
			        	<a href="${path2 }/member/login.do">
			        		<button type="button" class="button is-success" onclick="fnc()">상품 구매</button>
			        	</a>
			        </c:if>
			        <a href="${path2 }/product/productList.do" class="button is-warning">상품 목록</a>
			    </div>
			    <script>
			    	function fnc() {
			    		alert("로그인 후 구매 가능합니다.")
			    	}
			    </script>
			</div>
		</section>	
	</main>
	<footer id="ft">
		<jsp:include page="../include/ft.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>