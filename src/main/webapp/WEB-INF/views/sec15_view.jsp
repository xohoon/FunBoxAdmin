<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>자주묻는질문1</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec13_view">
	  <div>
	  <label>제목</label><textarea class="tit">공지1</textarea>
    </div>
	  <div>
	    <label>글쓴이</label><input type="text" value="아이오">
    </div>
    <div>
	    <label>날짜</label><input type="text" value="2019.07.25 13:28:44">
	  </div>
	  <textarea>공지내용이 들어갑니다</textarea>
	  <input type="file">
	  <a href="#" download><i class="fas fa-save"></i> 첨부파일 다운로드</a>
	  <button class="submit rec">수정하기</button>
	  <button class="submit save">등록하기</button>
	  <button class="submit cancel">취소</button>
	</div>
	<script>
    $(function(){
      $('.save').hide();
      $('.cancel').hide();
      
      $('input').prop('readonly',true);
      $('textarea').prop('readonly',true);
      $('input[type=file]').hide();  
        $('.rec').on('click', function(rectify){
          $('input').css('border','1px solid #ddd');
          $('input').prop('readonly',false);
          $('textarea').prop('readonly',false);
          $('input[type=file]').show();
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
        });
        
        $('.cancel').on('click', function(){
            location.reload();
        });
    });
  </script>
</body>
</html>