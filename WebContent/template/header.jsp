<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<script type="text/javascript" src="template/js/headerGetout.js"></script>
</head>
<body>
	<input type="hidden" id="sessionValue" value="<%=session.getAttribute("adminId") %>">
		<h1 class="logo">
			<a href="./index.jsp">
				<img src="img/logo.svg" alt="로고">
			</a>
		</h1>
		<button type="button" onclick="location.href='./LogoutAction.ad' ">LOGOUT</button>
</body>
</html>