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
	<script type="text/javascript" src="./js/listSearching.js"></script>
	<script type="text/javascript" src="company/js/companyInvestApplyList.js"></script>
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
				<select id="search_type">
					<option value="0">- 선택 -</option>
					<option value="1">아이디</option>
					<option value="2">기업명</option>
					<option value="3">담당자</option>
				</select>
				<input id="search_word" type="text">
				<button id="search"><i class="fas fa-search"></i></button>
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
					<c:forEach var="companyApplication" items="${companyApplicationList }">
						<tr>
							<td onclick="window.open('./companyInvestApplyDetail.cp?app_cp_idx=${companyApplication.app_cp_idx}','dkdlel','width=640,height=720,top=0,left=0,scrollbars=yes');">${companyApplication.app_cp_name }</td>
							<td>${companyApplication.mb_id }</td>
							<td>${companyApplication.app_cp_manager }</td>
							<td>${companyApplication.app_cp_hp }</td>
							<td>${companyApplication.app_cp_ch }</td>
							<td>${companyApplication. app_cp_sector}</td>
							<c:choose>
								<c:when test="${companyApplication.app_cp_status }">
									<td>운영중(${companyApplication.app_cp_open_date_time })</td>
								</c:when>
								<c:otherwise>
									<td>오픈예정(${companyApplication.app_cp_open_date_time })</td>
								</c:otherwise>
							</c:choose>
							<!-- <td>운영중(2019.07.24)</td> -->
							<td><button onclick="confirmDeleteApply(${companyApplication.app_cp_idx},'${companyApplication.app_cp_name}');"><i class="fas fa-times" ></i></button></td>
						</tr>
					</c:forEach>
				</table>
				<a href="./companyInvestApplyList.cp?page=${current_page - 1 }&search_type=${search_type}&search_word=${search_word}" class="prev"><i class="fas fa-caret-left"></i></a>
				<ul class="pager">
					<c:forEach var="i" begin="${current_min_page }" end="${current_max_page }">
						<c:choose>
							<c:when test="${ i eq current_page}">
								<li class="on"><a href="./companyInvestApplyList.cp?page=${i }&search_type=${search_type}&search_word=${search_word}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="./companyInvestApplyList.cp?page=${i }&search_type=${search_type}&search_word=${search_word}">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				<a href="./companyInvestApplyList.cp?page=${current_page + 1 }&search_type=${search_type}&search_word=${search_word}" class="next"><i class="fas fa-caret-right"></i></a>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		setTimeout(function () {
		   jQuery('.nav3').trigger('click');
			jQuery('.nav32').addClass('on');
		}, 500);
		
		/* $(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
      
      $('td button').click(function(){
        $(this).parents('tr').remove();
      });
		});  */
	</script>
</body>

</html>