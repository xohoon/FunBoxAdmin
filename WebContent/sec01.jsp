<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">
	<script>
	  $(function() {
		  $('header').load('./header.html')
		  $('#gnb').load('./gnb.html')
		  $('footer').load('./footer.html')
		});	
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec01">
			<h2>회원리스트</h2>
			<div class="sch">
				<select>
					<option>- 선택 -</option>
					<option>아이디</option>
					<option>이름</option>
					<option>E-mail</option>
					<option>전화번호</option>
				</select>
				<input type="text">
				<button><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
				<table>
					<tr>
						<th>순번</th>
						<th>아이디</th>
						<th>E-mail</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>추천인ID</th>
					</tr>
					<tr>
						<td>1</td>
						<td onclick="window.open('./sec01_1.html','이름(아이디)','width=640,height=720,top=0,left=0,scrollbars=yes');">dkdlel</td>
						<td>asdfggg@iolab.kr</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>cncjsdls</td>
					</tr>
					<tr>
						<td>1</td>
						<td onclick="window.open('./sec01_1.html','이름(아이디)','width=640,height=720,top=0,left=0,scrollbars=yes');">dkdlel</td>
						<td>asdfggg@iolab.kr</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>cncjsdls</td>
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
		   jQuery('.nav1').trigger('click');
			jQuery('.nav12').addClass('on');
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