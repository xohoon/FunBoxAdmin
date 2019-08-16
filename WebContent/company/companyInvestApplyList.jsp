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
		<section id="sec05">
			<h2>투자 기업 신청 리스트</h2>
			<div class="sch">
				<select>
					<option>- 선택 -</option>
					<option>아이디</option>
					<option>기업명</option>
					<option>담당자</option>
				</select>
				<input type="text">
				<button><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
				<table>
					<tr>
						<th>상호명</th>
						<th>아이디</th>
						<th>담당자</th>
						<th>연락처</th>
						<th>소재지</th>
						<th>업종</th>
						<th>오픈상태</th>
						<th>삭제</th>
					</tr>
					<tr>
						<!-- <td onclick="window.open('./sec05_1.jsp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td> -->
						<td onclick="window.open('./companyInvestApplyDetail.cp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
						<td>dkdlel</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>부산시금정구어쩌고</td>
						<td>일반음식점</td>
						<td>운영중(2019.07.24)</td>
						<td><button><i class="fas fa-times"></i></button></td>
					</tr>
					<tr>
						<!-- <td onclick="window.open('./sec05_1.jsp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td> -->
						<td onclick="window.open('./companyInvestApplyDetail.cp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
						<td>dkdlel</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>부산시금정구어쩌고</td>
						<td>일반음식점</td>
						<td>오픈예정(2019.07.24)</td>
						<td><button><i class="fas fa-times"></i></button></td>
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
		   jQuery('.nav3').trigger('click');
			jQuery('.nav32').addClass('on');
		}, 500);
		
		$(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
      
      $('td button').click(function(){
        $(this).parents('tr').remove();
      });
		});
	</script>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/admin.css" rel="stylesheet">
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
		<section id="sec05">
			<h2>투자 기업 신청 리스트</h2>
			<div class="sch">
				<select>
					<option>- 선택 -</option>
					<option>아이디</option>
					<option>기업명</option>
					<option>담당자</option>
				</select>
				<input type="text">
				<button><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
				<table>
					<tr>
						<th>상호명</th>
						<th>아이디</th>
						<th>담당자</th>
						<th>연락처</th>
						<th>소재지</th>
						<th>업종</th>
						<th>오픈상태</th>
						<th>삭제</th>
					</tr>
					<tr>
						<!-- <td onclick="window.open('./sec05_1.jsp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td> -->
						<td onclick="window.open('./companyInvestApplyDetail.cp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
						<td>dkdlel</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>부산시금정구어쩌고</td>
						<td>일반음식점</td>
						<td>운영중(2019.07.24)</td>
						<td><button><i class="fas fa-times"></i></button></td>
					</tr>
					<tr>
						<!-- <td onclick="window.open('./sec05_1.jsp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td> -->
						<td onclick="window.open('./companyInvestApplyDetail.cp','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
						<td>dkdlel</td>
						<td>아이오</td>
						<td>010-1234-5678</td>
						<td>부산시금정구어쩌고</td>
						<td>일반음식점</td>
						<td>오픈예정(2019.07.24)</td>
						<td><button><i class="fas fa-times"></i></button></td>
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
		   jQuery('.nav3').trigger('click');
			jQuery('.nav32').addClass('on');
		}, 500);
		
		$(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
      
      $('td button').click(function(){
        $(this).parents('tr').remove();
      });
		});
	</script>
</body>
</html>