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
            justify-content: center;
    		align-items: center;
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
        .add-product-btn-checked {
            background: linear-gradient(to right, #2196F3, #1E88E5);
            border: none;
            border-radius: 5px;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .add-product-btn-checked:hover {
            background: linear-gradient(to right, #1E88E5, #2196F3);
        }
        
        <!-- 페이지 버튼 -->
        .paginations-container {
		    display: flex;
		    justify-content: center; /* 자식 요소를 중앙 정렬 */
		    align-items: center;
		}
        
        .paginations {
		    display: flex;
		    list-style-type: none;
		    justify-content: center;
		    width: 100%;
		}
		
		.page-link {
		    margin: 0 5px;
		    padding: 5px 10px;
		    text-decoration: none;
		    color: #007bff;
		    border: none;
		    background-color: transparent;
		    font-size: 18px;
		    transition: color 0.3s;
		}
		
		.page-link:hover {
		    color: #0056b3;
		}
		
		.page-link.active {
		    font-weight: bold;
		    color: #000;
		    cursor: default;
		    pointer-events: none;
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
				<div style="margin:10px 0; margin-left:100px;">
					<a href="${path2 }/product/productList.do"><button class="add-product-btn">ALL</button></a>
					<a href="${path2 }/product/categoryList.do?category=snack"><button class="add-product-btn-checked">스낵</button></a>
					<a href="${path2 }/product/categoryList.do?category=choco"><button class="add-product-btn">초코</button></a>
					<a href="${path2 }/product/categoryList.do?category=candy"><button class="add-product-btn">캔디</button></a>
					<h2>스낵 리스트</h2>
				</div>
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
			    <div style="margin:10px 0; margin-left:100px;">
				    <c:if test="${sid.equals('admin') }">
				    <button class="add-product-btn" onclick="location.href='${path2}/product/insProduct.do'" style="margin:10px;">상품 등록</button>
				    </c:if>
				    <a href="${path2 }/product/productList.do" class="button is-warning" style="margin:10px;">상품 목록</a>
			    </div>
			</div>
			<div class="paginations-container">
				<div class="paginations">
			        <a href="?category=snack&page=1" class="page-link">&lt;&lt;</a>
			        <button onclick="goToPreviousPageGroup()" class="page-link">&lt;</button>
			        <c:forEach begin="${pagingBean.getStartPageOfPageGroup()}" end="${pagingBean.getEndPageOfPageGroup()}" var="i">
			            <c:choose>
			                <c:when test="${i == pagingBean.getNowPage()}">
			                    <a href="?category=snack&page=${i}" class="page-link active">${i}</a>
			                </c:when>
			                <c:otherwise>
			                    <a href="?category=snack&page=${i}" class="page-link">${i}</a>
			                </c:otherwise>
			            </c:choose>
			        </c:forEach>
			        <button onclick="goToNextPageGroup()" class="page-link">&gt;</button>
			        <a href="?category=snack&page=${pagingBean.getTotalPage()}" class="page-link">&gt;&gt;</a>
			    </div>
		    </div>
		    <script>
		    	var pageNumberPerPageGroup = ${pagingBean.getPageNumberPerPageGroup()}; //페이지 그룹 당 페이지 수
		    	var totalPage = ${pagingBean.getTotalPage()}; //전체 페이지 수
		    	var nowPage = ${pagingBean.getNowPage()}; //현재 페이지
		    	var startPageOfPageGroup = ${pagingBean.getStartPageOfPageGroup()}; //현재 페이지 그룹의 시작 페이지
		    	
		    	
		    	//페이지 그룹 이동 함수
		    	function goToNextPageGroup() {
		    		var nextPageGroupStart = startPageOfPageGroup + pageNumberPerPageGroup; //다음 페이지 그룹의 시작 페이지
		    		if(nextPageGroupStart <= totalPage) {
		    			window.location.href = "?category=snack&page=" + nextPageGroupStart; //다음 페이지 그룹으로 이동
		    		}
		    	}
		    	
		    	function goToPreviousPageGroup() {
		    		var previousPageGroupStart = startPageOfPageGroup - pageNumberPerPageGroup;
		    		if(previousPageGroupStart >= 1) {
		    			window.location.href = "?category=snack&page=" + previousPageGroupStart;
		    		}
		    	}
		    </script>
		</section>	
	</main>
	<footer id="ft">
		<jsp:include page="../include/ft.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>