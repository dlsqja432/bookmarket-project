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
        
        .rating {
		    float: none;
		    width: 200px;
		    display: flex;
		}
		.ratingContainer {
			display:flex;
			align-items: center;
		}
		.text-content {
		    margin-left: 20px; 
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
					<c:if test="${not empty review }">
				        <img src="${path2 }/resources/upload/${product.img2}" alt="${product.pname }">
				        <c:if test="${sid.equals('admin') }">
				        <div class="product-name">상품번호 : ${product.pno }</div>
				        </c:if>
				        <div class="product-name">${product.pname }</div>
				        <div class="product-price">${product.price }원</div>
				        <input type="hidden" id="star" name="star" value="${review.star }">
				        <div class="ratingContainer">
				            <div class="rating" id="rating"></div>
				            <div class="text-content">
						        ${review.star }점
						    </div>
			            </div> 
				        <div class="product-description">${review.content }</div>
			        </c:if>
			        <c:if test="${empty review }">
			        	<p>리뷰를 찾을 수 없습니다.</p>
			        </c:if>
			        <c:if test="${sid.equals(review.id) or sid.equals('admin') }">
				        <a href="${path2 }/review/editReview.do?rno=${review.rno }" class="button is-warning">리뷰 수정</a>
				        <a href="${path2 }/review/delReview.do?rno=${review.rno }" class="button is-danger is-dark">리뷰 삭제</a>
			        </c:if>
			        <a href="${path2 }/review/reviewList.do" class="button is-warning">리뷰 목록</a>
			    </div>
			    <script>
			    	function fnc() {
			    		alert("로그인 후 구매 가능합니다.")
			    	}
			    </script>
			    <script>
				    const ratingDiv = document.getElementById('rating');
					const value = parseFloat(document.getElementById('star').value);
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