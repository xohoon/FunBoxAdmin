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
	<script src="customer/js/noticeBoard.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec15">
			<h2>공지게시판</h2>
			<div class="con">
			<button class="write" onclick="window.open('./noticeRegister.cu','게시물등록','width=840,height=640,top=0,left=0,scrollbars=yes');">게시물등록</button>
			<button id="off_status">비활성화</button>
			<button id="on_status">활성화</button>
				<table>
					<tr>
					  <th></th>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록날짜</th>
						<th>활성여부</th>
					</tr>
					<c:forEach var="noticeInfo" items="${noticeInfo}">
						<tr>
							<td><input type="checkbox" name="status" value="${noticeInfo.idx}"></td>
						  	<td>${noticeInfo.idx }</td>
						  	<td onclick="window.open('./noticeModifyForm.cu?idx=${noticeInfo.idx}','공지','width=800,height=720,top=0,left=0,scrollbars=yes');">${noticeInfo.title }</td>
						 	<td>${noticeInfo.mb_name }</td>
						  	<td>${noticeInfo.reg_date_time }</td>
						  <c:if test="${noticeInfo.status == 1}">
						  <td>Yes</td>
						  </c:if>
						  <c:if test="${noticeInfo.status == 0}">
						  <td>No</td>
						  </c:if>
						</tr>
					</c:forEach>
				</table>
				<ul class="pager">
				<c:if test="${count > 0}">
					<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" /> 
					<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
					<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
					<c:if test="${numPageGroup > 1}">
						<li><a href="./noticeBoard.cu?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a></li>
					</c:if>
					
					<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<li><b><a class="on" href="./noticeBoard.cu?pageNum=${i}"><font size=3>${i}</font></a></b></li>
								</c:when>
								<c:otherwise>
									<li><a class="on" href="./noticeBoard.cu?pageNum=${i}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
					
					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./noticeBoard.cu?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
					</c:if>
				</c:if>
			</ul><!--.pager-->
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