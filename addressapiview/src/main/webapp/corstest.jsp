<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setHeader("Access-Control-Allow-origin", "http://puhu17.cafe24.com");
%>
<!DOCTYPE html>
<html>
<script src="http://puhu17.cafe24.com/addressapi/calljs" charset="utf-8"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="addrapi_postcode" style="width: 250px"
		placeholder="우편번호" maxlength="5" readonly>
	<input type="button" value="주소검색" style="width: 80px"
		onclick="showpopup()">
	<br>
	<input type="text" id="addrapi_address" style="width: 350px"
		placeholder="주소지" readonly>
	<br>
	<input type="text" placeholder="상세주소" style="width: 350px">
	<br>


</body>
<script>
	window.addEventListener('message', function(e) {
		console.log('message', e.data)
		console.log('origin', e.origin)
		console.log('source', e.source)
//		e.source.postMessage('다시 보내요!', 'http://')
	})
</script>
</html>