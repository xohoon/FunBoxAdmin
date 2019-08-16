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
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec03">
			<h2>토큰 입출금 내역</h2>
			<div class="sch">
				<select>
					<option>- 선택 -</option>
					<option>아이디</option>
				</select>
				<input type="text">
				<button><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
				<ul class="tab">
					<li class="on">전체</li>
					<li>입금</li>
					<li>출금</li>
				</ul>
				<table>
					<tr>
						<th>순번</th>
						<th>아이디</th>
						<th>구분</th>
						<th>TX Hash</th>
						<th>수량</th>
						<th>상태</th>
						<th>날짜</th>
					</tr>
					<tr>
						<td>1</td>
						<td>아이디1</td>
						<td>입금</td>
						<td>gotlxormekdkdkdkkkddkdkdkddjfakskrlfwldlrj</td>
						<td class="incomma">+ 1000000000</td>
						<td>진행</td>
						<td>2019.07.22<br>16:26:22</td>
					</tr>
					<tr>
						<td>2</td>
						<td>아이디2</td>
						<td>출금</td>
						<td>gotlxormekdkdkdkkkddkdkdkddjfakskrlfwldlrj</td>
						<td class="incomma">- 1000000000</td>
						<td>완료</td>
						<td>2019.07.22<br>16:26:22</td>
					</tr>
					<tr>
						<td>2</td>
						<td>아이디1</td>
						<td>출금</td>
						<td>gotlxormekdkdkdkkkddkdkdkddjfakskrlfwldlrj</td>
						<td class="incomma">- 1000000000</td>
						<td>완료</td>
						<td>2019.07.22<br>16:26:22</td>
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
		$(function(){
      var tdA = $('td:contains("입금")');
      var tdB = $('td:contains("출금")');
      $(tdA).css('color','#73a6d6');
      $(tdA).siblings('td').eq(3).css('color','#73a6d6');
      $(tdB).css('color','#ff9124');
      $(tdB).siblings('td').eq(3).css('color','#ff9124');
      
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
			
			$('.tab li').click(function(){
				$('.tab li').removeClass('on');
				$(this).addClass('on');
			});
			
			$('.tab li').eq(1).click(function(){
        $('tr').show();
        $('td:contains("출금")').parent().hide();
      });
			$('.tab li').eq(2).click(function(){
        $('tr').show();
        $('td:contains("입금")').parent().hide();
      });
			$('.tab li').eq(0).click(function(){
				$('tr').show();
			});
      
      $('.incomma').each(function(){
         var incomma = $(this).text();
        $(this).text(numberWithCommas(incomma));
      });
      
    
			
		});
    
    function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
    
    
		
		setTimeout(function () {
		   jQuery('.nav2').trigger('click');
		   jQuery('.nav22').addClass('on');			
		}, 500);
		
		
	</script>
</body>
</html>