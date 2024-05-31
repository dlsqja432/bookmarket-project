<%@ page language="java" contentType="text/html charset=UTF8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 리스트</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div id="wrap">
		<h2>Socket Test Page</h2>
		<input type="text" id="msg"><br>
		<button type="button" id="btn1">전송</button>
	</div>
	<script>
	#(document).ready(function(){
		var ws = new WebSocket("ws://localhost:8093/socket");
		
		ws.onopen = function(e) { //서버에 연결되면
			console.log("info : connection opened"); //연결 메시지 출력
		}
		
		ws.onmessage = function(e) { //서버로 부터 메시지가 전송되면 
			console.log(e.data);	//전달받은 메시지 출력
		}
		
		ws.onclose = function(e) {
			console.log("info : connection.closed");
		}
		
		ws.onerror = function(e) {
			console.log("error");
		}
		
		$("#btn1").click(function(e){
			e.preventDefault();
			ws.send($("#msg"));
		});
	});
	</script>
</body>
</html>