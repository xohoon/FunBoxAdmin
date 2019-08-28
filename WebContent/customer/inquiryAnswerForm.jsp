<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.customer.dto.inquiryAnswer"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>1:1문의</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script src="customer/js/inquiryAnswerForm.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec14_view">
	<form name="save" method="post" action="./answerInsert.cu">
		<c:forEach var = "Answer" items="${Answer}">
		<input type="hidden" id="idx" name="idx" value="${Answer.idx}">
		  <div>
		  <label>제목</label><textarea class="tit">${Answer.title}</textarea>
	    </div>
	    <div>
	    <label>질문유형</label>
	    <select  disabled="true">
	   	 <c:choose>
	    		<c:when test="${Answer.category == '가입'}">
				    <option value="1" selected>가입관련</option>
				    <option value="2">투자관련</option>
				    <option value="3">입출금관련</option>
		    	</c:when>
		    	<c:when test="${Answer.category == '투자'}">
				    <option value="1">가입관련</option>
				    <option value="2" selected disabled="true">투자관련</option>
				    <option value="3">입출금관련</option>
		    	</c:when>
		    	<c:otherwise>
		    		<option value="1">가입관련</option>
				    <option value="2">투자관련</option>
				    <option value="3" selected disabled="true">입출금관련</option>
		    	</c:otherwise>
		 </c:choose>
		</select>
		  </div>
		  <div>
		    <label>글쓴이</label><input type="text" value="${Answer.id} (${Answer.name})">
	    </div>
	    <div>
		    <label>날짜</label><input type="text" value="${Answer.reg_date_time}">
		  </div>
		  <textarea>${Answer.content}</textarea>
		  <textarea id="test" name="reply" placeholder="답변내용">${Answer.qna_reply}</textarea>
		  <button type="button" class="submit rec">답변달기</button>
		  <button type="button" class="submit save">등록하기</button>
		  <button type="button" class="submit cancel">취소</button>	  
		</c:forEach>
	</form>	
	</div>
	<script>
    $(function(){
      $('.save').hide();
      $('.cancel').hide();
      
      $('input').prop('readonly',true);
      $('textarea').prop('readonly',true);
      /* $('input[type=file]').hide(); */  
        $('.rec').on('click', function(rectify){
	          $('input').css('border','1px solid #ddd');
	          $('input').prop('readonly',true);
	          $('textarea').prop('readonly',true);
	          $('#test').prop('readonly',false);
	          $('input[type=file]').show();
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
        });
      
        $('.save').on('click', function(){
        	var form = document.save;
        	
        	if(confirm("해당 답변을 적용하시겠습니까?") == true){
        		form.submit();
        	}else{
        		alert("답변을 취소 하였습니다.");
        	}
        }); 
        
        $('.cancel').on('click', function(){
            location.reload();
        });
    });
    
  
  </script>
</body>
</html>