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
		<section id="sec14">
			<h2>1:1문의 게시판</h2>
			<div class="sch">
				<select>
					<option>- 선택 -</option>
					<option>아이디</option>
					<option>이름</option>
				</select>
				<input type="text">
				<button><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
			  <ul class="tab">
			    <li class="on">전체</li>
			    <li>미답변</li>
			    <li>답변완료</li>
			  </ul>
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록날짜</th>
						<th>답변여부</th>
					</tr>
					<tr>
					  <td>1</td>
					  <td onclick="window.open('./sec14_view.html','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">일대일 문의입니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ</td>
					  <td>아이오<br>(아이디)</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td>Yes</td>
					</tr>
					<tr>
					  <td>2</td>
					  <td onclick="window.open('./sec14_view.html','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">일대일 문의입니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ</td>
					  <td>아이오<br>(아이디)</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td></td>
					</tr>
					<tr>
					  <td>3</td>
					  <td onclick="window.open('./sec14_view.html','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">일대일 문의입니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ</td>
					  <td>아이오<br>(아이디)</td>
					  <td>2019.07.25<br>12:10:55</td>
					  <td>Yes</td>
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
			jQuery('.nav43').addClass('on');
		}, 500);
		
		$(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
      $('.tab li').click(function(){
        $('.tab li').removeClass('on');
        $(this).addClass('on');
      });
      
      $('.tab li').eq(0).click(function(){
        $('tr').show();
      });
      $('.tab li').eq(1).click(function(){
        $('tr').show();
        $('td:contains("Yes")').parent().hide();
      });
      $('.tab li').eq(2).click(function(){
        $('tr').hide();
        $('td:contains("Yes")').parent().show();
        $('tr:has(th)').show(); 
      });
      
		});
	</script>
</body>
</html>