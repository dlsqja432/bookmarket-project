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
	<title>리뷰 등록</title>
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
    
    .rating {
    float: none;
    width: 200px;
    display: flex;
	}
	
	.rating__input {
	    display: none;
	}
	
	.rating__label {
	    width: 20px;
	    overflow: hidden;
	    cursor: pointer;
	}
	
	.rating__label .star-icon {
	    width: 20px;
	    height: 40px;
	    display: block;
	    position: relative;
	    left: 0;
	    background-image: url('https://velog.velcdn.com/images/jellykelly/post/9957327f-f358-4c25-9989-5bb3dd5755d6/image.svg');
	    background-repeat: no-repeat;
	    background-size: 40px;
	}
	
	.rating__label .star-icon.filled {
	    background-image: url('https://velog.velcdn.com/images/jellykelly/post/10caf033-b0ef-4d58-804b-6e33395e4ea5/image.svg');
	}
	
	.rating__label--full .star-icon {
	    background-position: right;
	}
	
	.rating__label--half .star-icon {
	    background-position: left;
	}
	
	.rating.readonly .star-icon {
	    opacity: 0.7;
	    cursor: default;
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
    		<h2 class="page-title">리뷰 등록</h2>
    		<hr>
    		<div class="page-wrap">
            	<form name="frm1" id="frm1" action="${path2 }/review/insReviewPro.do" method="post" enctype="multipart/form-data">
                	<table class="table" id="table1">
	                    <tbody>
	                    <tr>
	                        <th style="background-color:#dcdcdc">제품번호</th>
	                        <td>
	                            <input type="number" name="pno" id="pno" maxlength="100" class="input" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">아이디</th>
	                        <td>
	                            <input type="text" name="id" id="id" value="${sid }" maxlength="1000" class="input" required>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">내용</th>
	                        <td>
	                            <input type="text" name="content" id="content" placeholder="리뷰 입력" class="input" >
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">이미지</th>
	                        <td>
	                            <input type="file" name="img" id="img" accept="image/*">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th style="background-color:#dcdcdc">별점</th>
	                        <td>
	                            <div class="rating">
							        <label class="rating__label rating__label--half" for="starhalf">
							            <input type="radio" id="starhalf" class="rating__input" name="star" value="0.5">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--full" for="star1">
							            <input type="radio" id="star1" class="rating__input" name="star" value="1">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--half" for="star1half">
							            <input type="radio" id="star1half" class="rating__input" name="star" value="1.5">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--full" for="star2">
							            <input type="radio" id="star2" class="rating__input" name="star" value="2">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--half" for="star2half">
							            <input type="radio" id="star2half" class="rating__input" name="star" value="2.5">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--full" for="star3">
							            <input type="radio" id="star3" class="rating__input" name="star" value="3">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--half" for="star3half">
							            <input type="radio" id="star3half" class="rating__input" name="star" value="3.5">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--full" for="star4">
							            <input type="radio" id="star4" class="rating__input" name="star" value="4">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--half" for="star4half">
							            <input type="radio" id="star4half" class="rating__input" name="star" value="4.5">
							            <span class="star-icon"></span>
							        </label>
							        <label class="rating__label rating__label--full" for="star5">
							            <input type="radio" id="star5" class="rating__input" name="star" value="5">
							            <span class="star-icon"></span>
							        </label>
							    </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                        	<div class="buttons">
		                            <input type="submit" class="button is-danger" value="리뷰등록" >
		                            <input type="reset" class="button is-info" value="취소" >
		                            <a href="${path2 }/review/reviewList.do" class="button is-warning">리뷰 목록</a>
	                            </div>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
	                <!-- 별점 -->
	                <script>
					const rateWrap = document.querySelectorAll('.rating'),
			        label = document.querySelectorAll('.rating .rating__label'),
			        input = document.querySelectorAll('.rating .rating__input'),
			        labelLength = label.length,
			        opacityHover = '0.5';

					let stars = document.querySelectorAll('.rating .star-icon');
		
					checkedRate();
		
					rateWrap.forEach(wrap => {
					    wrap.addEventListener('mouseenter', () => {
					        stars = wrap.querySelectorAll('.star-icon');
		
					        stars.forEach((starIcon, idx) => {
					            starIcon.addEventListener('mouseenter', () => {
					                initStars(); 
					                filledRate(idx, labelLength); 
		
					                for (let i = 0; i < stars.length; i++) {
					                    if (stars[i].classList.contains('filled')) {
					                        stars[i].style.opacity = opacityHover;
					                    }
					                }
					            });
		
					            starIcon.addEventListener('mouseleave', () => {
					                starIcon.style.opacity = '1';
					                checkedRate(); 
					            });
		
					            wrap.addEventListener('mouseleave', () => {
					                starIcon.style.opacity = '1';
					            });
					        });
					    });
					});
		
					// 주어진 index 까지의 별을 채우는 함수
					function filledRate(index, length) {
					    if (index <= length) {
					        for (let i = 0; i <= index; i++) {
					            stars[i].classList.add('filled');
					        }
					    }
					}
		
					// 체크된 라디오 버튼에 따라 해당하는 별과 그 이전의 별을 채우는 함수
					function checkedRate() {
					    let checkedRadio = document.querySelectorAll('.rating input[type="radio"]:checked');
		
		
					    initStars();
					    checkedRadio.forEach(radio => {
					        let previousSiblings = prevAll(radio);
		
					        for (let i = 0; i < previousSiblings.length; i++) {
					            previousSiblings[i].querySelector('.star-icon').classList.add('filled');
					        }
		
					        radio.nextElementSibling.classList.add('filled');
		
					        // 현재 라디오 버튼의 이전 형제 요소들을 반환하는 함수
					        function prevAll() {
					            let radioSiblings = [],
					                prevSibling = radio.parentElement.previousElementSibling;
		
					            while (prevSibling) {
					                radioSiblings.push(prevSibling);
					                prevSibling = prevSibling.previousElementSibling;
					            }
					            return radioSiblings;
					        }
					    });
					}
		
					// 모든 별에서 'filled' 클래스를 제거하여 초기화하는 함수
					function initStars() {
					    for (let i = 0; i < stars.length; i++) {
					        stars[i].classList.remove('filled');
					    }
					}
					</script>
					
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