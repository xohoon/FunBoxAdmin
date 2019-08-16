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
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<script>
		$(function() {
		  $('header').load('../template/header.jsp');
		  $('#gnb').load('../template/categoryTemplate.jsp');
		  $('footer').load('../template/footer.jsp');
		});	
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec15">
			<h2>공지게시판</h2>
			<div class="con">
			<button class="write" onclick="window.open('./noticeRegisterForm.cu','게시물등록','width=840,height=640,top=0,left=0,scrollbars=yes');">게시물등록</button>
			<button>비활성화</button>
			<button>활성화</button>
				<table>
					<tr>
					  <th></th>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록날짜</th>
						<th>활성여부</th>
					</tr>
					<tr>
            <td><input type="checkbox"></td>
					  <td>1</td>
					  <td onclick="window.open('./noticeModifyForm.cu','공지','width=800,height=720,top=0,left=0,scrollbars=yes');">공지1</td>
					  <td>아이오</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td>Yes</td>
					</tr>
					<tr>
            <td><input type="checkbox"></td>
					  <td>1</td>
					  <td onclick="window.open('./noticeModifyForm.cu','공지','width=800,height=720,top=0,left=0,scrollbars=yes');">공지1</td>
					  <td>아이오</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td></td>
					</tr>
					<tr>
            <td><input type="checkbox"></td>
					  <td>1</td>
					  <td onclick="window.open('./noticeModifyForm.cu','공지','width=800,height=720,top=0,left=0,scrollbars=yes');">공지1</td>
					  <td>아이오</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td></td>
					</tr>
				</table>
				<a href="#" class="prev"><i class="fas fa-caret-left"></i></a>
				<ul class="pager">
					<li class="on"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
				</ul>
				<a href="#" class="next"><i class="fas fa-caret-right"></i></a>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		setTimeout(function () {
		   jQuery('.nav4').trigger('click');
			jQuery('.nav44').addClass('on');
		}, 500);
		
		$(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
		});
	</script>
</body>
</html>