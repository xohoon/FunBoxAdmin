<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>자주묻는질문 등록</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script src="customer/js/noticeRegister.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec15_new">
	  <h3>공지사항 등록하기</h3>
	  <form id="noticeRegisterForm" enctype="multipart/form-data" method="post" action="./noticeRegisterForm.cu">
	  <label>제목</label>
	  <textarea class="tit" id="title" name="title"></textarea>
	  <textarea id="content" name="content"></textarea>
	  <input type="file" name="uploadfile" id="uploadfile">
	  <button type="button" class="submit" onclick="register();">등록하기</button>
	  </form>
	</div>
</body>
</html>