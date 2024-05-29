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
    		<h2 class="page-title">상품 정보 수정</h2>
    		<hr>
    		<div class="page-wrap">
            	<form name="frm1" id="frm1" action="${path2 }/product/editProductPro.do" method="post" enctype="multipart/form-data">
                	<table class="table" id="table1">
	                    <tbody>
	                    <tr>
	                        <th style="background-color:#dcdcdc">카테고리</th>
	                        <td>
								<select name="category" id="category">
									<option value="snack" ${product.category == 'snack' ? 'selected' : ''}>스낵</option>
									<option value="choco" ${product.category == 'choco' ? 'selected' : ''}>초코</option>
									<option value="candy" ${product.category == 'candy' ? 'selected' : ''}>캔디</option>
								</select>	                            
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">제품이름</th>
	                        <td>
	                        	<input type="hidden" name="pno" id="pno" value="${product.pno }">
	                            <input type="text" name="pname" id="pname" placeholder="제품이름 입력" maxlength="100" class="input" value="${product.pname }" required >
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">설명</th>
	                        <td>
	                            <input type="text" name="com" id="com" placeholder="제품 설명" maxlength="1000" class="input" value="${product.com }" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">가격</th>
	                        <td>
	                            <input type="number" min="0" step="100" value="${product.price }" name="price" id="price" placeholder="가격 입력" class="input" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">상품 썸네일 이미지</th>
	                        <td>
	                            <input type="file" name="img" id="img" accept="image/*" value="${product.img }">
	                            <br>현재 이미지 : <img src="${path2 }/resources/upload/${product.img}" width="100">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">상품 상세 이미지</th>
	                        <td>
	                            <input type="file" name="img2" id="img2" accept="image/*" value="${product.img2 }">
	                            <br>현재 이미지 : <img src="${path2 }/resources/upload/${product.img}" width="100">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                        	<div class="buttons">
		                            <input type="submit" class="button is-danger" value="제품수정" >
		                            <input type="reset" class="button is-info" value="취소" >
		                            <a href="${path2 }/product/productList.do" class="button is-warning">상품 목록</a>
	                            </div>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
	                <script>
	                $("input[type='file']").on("change", function(e){
						let fileInput = $('input[name="img"]');
						let fileList = fileInput[0].files;
						let fileObj = fileList[0];
						
						if(!fileCheck(fileObj.name, fileObj.size)) {
							return false;
						}
						
						alert("통과");
	                });
	                
	                // var, method related with attachFile
	                let regex = new RegExp("(.*?)\.(jpg|png)$");
	                let maxSize = 10485760; //10MB
	                
	                function fileCheck(fileName, fileSize) {
	                	if(fileSize >= maxSize) {
	                		alert("파일 사이즈 초과");
	                		return false;
	                	}
	                	
	                	if(!regex.test(fileName)) {
	                		alert("해당 종류의 파일은 업로드 할 수 없습니다.");
	                		return false;
	                	}
	                	
	                	return true;
	                }
	                </script>
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