<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<!-- <script type="text/javascript" src="member/js/memberList.js"></script> -->
	<script type="text/javascript" src="./js/listSearching.js"></script>
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
		<section id="sec01">
			<h2>회원리스트</h2>
			<div class="sch">
				<select id="search_type">
					<option value="0">- 선택 -</option>
					<option value="1">아이디</option>
					<option value="2">이름</option>
					<option value="3">E-mail</option>
					<option value="4">전화번호</option>
				</select>
				<input id="search_word" type="text">
				<button id="search"><i class="fas fa-search"></i></button>
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
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td>${member.mb_idx }</td>
							<td onclick="window.open('./memberDetail.mb?mb_idx=${member.mb_idx}','이름(아이디)','width=640,height=720,top=0,left=0,scrollbars=yes');">${member.mb_id }</td>
							<td>${member.mb_email }</td>
							<td>${member.mb_name }</td>
							<td>${member.mb_phone }</td>
							<td>${member.mb_recommend }</td>
						</tr>
					</c:forEach>
				</table>
				<a href="./memberList.mb?page=${current_page - 1}&search_type=${search_type}&search_word=${search_word}" class="prev"><i class="fas fa-caret-left"></i></a>
				<ul class="pager">
					<c:forEach var="i" begin="${current_min_page }" end="${current_max_page }">
						<c:choose>
							<c:when test="${ i eq current_page}">
								<li class="on"><a href="./memberList.mb?page=${i }&search_type=${search_type}&search_word=${search_word}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="./memberList.mb?page=${i }&search_type=${search_type}&search_word=${search_word}">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				<a href="./memberList.mb?page=${current_page + 1}&search_type=${search_type}&search_word=${search_word}" class="next"><i class="fas fa-caret-right"></i></a>
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