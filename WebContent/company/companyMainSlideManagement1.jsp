<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script type="text/javascript" src="company/js/companyMainSlideManagement1.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<script>
	$(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		  //$('.allList').load('../company/compnayAllList.jsp');
		  $('.allList').load('./compnayAllList.cp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec08">
			<h2>메인슬라이드관리</h2>
			<div class="con">
				<div class="all">
                  <h3>전체목록</h3>
                  <div class="sch">
				    <input type="text">
				    <button><i class="fas fa-search"></i></button>
			       </div>
                  <div class="allList"></div>
				</div>
				<div class="top">
                  <h3>메인배너1</h3>
                  <ul class="push">
                    <li>
                      <input type="radio" name="push" id="auto" value="자동" checked>
                      <label for="auto">자동</label>
                    </li>
                    <li>
                      <input type="radio" name="push" id="man" value="수동">
                      <label for="man">수동</label>
                    </li>
                  </ul>
                   <div class="topList">
                   <input type="button" id="modityBtn" value="수정" style="margin-top:10px;">
	               <input type="submit" id="saveBtn" value="적용" style="margin-left:10px; margin-top:10px;">
                   <form action="">
                     <table>
                     	<tbody id="added_table">
                     		<tr>
	                         <th>번호</th>
	                         <th>상호명</th>
	                         <th>아이디</th>
	                         <th>담당자</th>
	                         <th></th>
	                         <th></th>
	                       </tr>
                     	</tbody>
                     </table>
                     </form>
                   </div>
                </div>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>  
	setTimeout(function () {
	  jQuery('.nav3').trigger('click');
	  jQuery('.nav38').addClass('on');
	}, 500);
	</script>
</body>
</html>