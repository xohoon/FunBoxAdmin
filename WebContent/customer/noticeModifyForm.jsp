<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>자주묻는질문1</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec13_view">
	<form id="noticeModifyForm" enctype="multipart/form-data" method="post" action="./noticeModify.cu">
	  <div>
	  <label>제목</label><textarea class="tit" id="title" name="title">${notice.title}</textarea>
    </div>
	  <div>
	    <label>글쓴이</label><input type="text" value="${notice.mb_name }">
    </div>
    <div>
	    <label>날짜</label><input type="text" value="${notice.reg_date_time }">
	  </div>
	  <textarea id="content" name="content">${notice.content }</textarea>
	  <input type="hidden" id="notice_idx" name="notice_idx" value="${notice.idx }">
	  <input type="file" name="uploadfile" id="uploadfile">${notice.alias_uploadfile }
	  <a href="./fileDownAction.cu?idx=${notice.idx }&fileName=${notice.alias_uploadfile }"><i class="fas fa-save"></i> 첨부파일 다운로드</a>
	  <button type="button" class="submit rec">수정하기</button>
	  <button type="button" class="submit save" onclick="noticeSave();">등록하기</button>
	  <button type="button" class="submit cancel">취소</button>
	  </form>
	</div>
	<script src="customer/js/noticeModifyForm.js"></script>
</body>
</html>