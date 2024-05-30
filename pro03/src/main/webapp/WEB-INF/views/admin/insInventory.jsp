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
	<title>회원 가입</title>
	<jsp:include page="../include/head.jsp"></jsp:include>
	<style>
	.title { padding-top:36px; padding-bottom:20px; }
    .agree_fr { width: 900px; white-space:pre-wrap; margin: 10px auto;
            padding: 24px; border:2px solid #eee; height:600px; overflow-y:auto; }
    input[type="date"] {
    	width:200px;
    	height:40px;
    	font-size:16px;
    	border: 1px solid #ccc;
    	text-align:center;
    }
    .table tr td {
    	width:1000px;
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
			    <li><a href="${path2 }">Member</a></li>
			    <li class="is-active"><a href="#" aria-current="page">Join Form</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">재고 등록</h2>
    		<hr>
    		<div class="page-wrap">
            	<form name="frm1" id="frm1" action="${path2 }/inventory/insInventoryPro.do" method="post">
                	<table class="table" id="table1">
	                    <tbody>
	                    <tr>
	                        <th style="background-color:#dcdcdc">제품번호</th>
	                        <td>
	                            <input type="number" name="pno" id="pno" min="0" value="1" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">입고가</th>
	                        <td>
	                            <input type="number" name="inprice" id="inprice" min="0" step="100" value="1000" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">출고가</th>
	                        <td>
	                            <input type="number" min="0" step="100" value="1000" name="outprice" id="outprice" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">수량</th>
	                        <td>
	                            <input type="number" name="amount" id="amount" min="0" value="0" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">리마크</th>
	                        <td>
	                            <input type="text" name="remark" id="remark" placeholder="리마크 입력">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                        	<div class="buttons">
		                            <input type="submit" class="button is-danger" value="제품등록" >
		                            <input type="reset" class="button is-info" value="취소" >
		                            <a href="${path2 }/inventory/inventoryList.do" class="button is-warning">상품 목록</a>
	                            </div>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
	            </form>
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