<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<form id="faqModifyForm" enctype="multipart/form-data" method="post" action="./faqModify.cu">
	  <div>
	  <label>제목</label><textarea class="tit" id="title" name="title">${faq.title}</textarea>
    </div>
    <div>
    <label>카테고리</label>
    <select id="selectBox" name="selectBox">
    	<c:choose>
    		<c:when test="${faq.category == 1 }">
			    <option value="1" selected>입출금</option>
			    <option value="2">투자</option>
			    <option value="3">기타</option>
	    	</c:when>
	    	<c:when test="${faq.category == 2 }">
			    <option value="1">입출금</option>
			    <option value="2" selected>투자</option>
			    <option value="3">기타</option>
	    	</c:when>
	    	<c:otherwise>
	    		<option value="1">입출금</option>
			    <option value="2">투자</option>
			    <option value="3" selected>기타</option>
	    	</c:otherwise>
	    </c:choose>
	  </select>
	  </div>
	  <div>
	    <label>글쓴이</label><input type="text" value="${faq.mb_name }">
    </div>
    <div>
	    <label>날짜</label><input type="text" value="${faq.reg_date_time }">
	  </div>
	  <textarea id="content" name="content">${faq.content }</textarea>
	  <input type="hidden" id="faq_idx" value="${faq.idx }">
	  <input type="file" name="uploadfile" id="uploadfile">
	  <a href="./fileDownAction.cu?idx=${faq.idx }&fileName=${faq.alias_uploadfile }"><i class="fas fa-save"></i> 첨부파일 다운로드</a>
	  <button type="button" class="submit out" onclick="faqDel();">삭제하기</button>
	  <button type="button" class="submit rec">수정하기</button>
	  <button type="button" class="submit save" onclick="faqSave();">저장하기</button>
	  <button type="button" class="submit cancel">취소</button>
	  </form>
	</div>
	<script src="customer/js/faqModifyForm.js"></script>
</body>
</html>