<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.customer.dto.inquiryBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script src="customer/js/inquiryBoard.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<script>
		$(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		});
	</script>
	<%
		ArrayList<inquiryBoard> inquiryList = (ArrayList<inquiryBoard>)request.getAttribute("inquiryBoardList");
		String category = request.getParameter("category");
		String categroyFlag = request.getParameter("categroyFlag");
		String searchID =request.getParameter("searchID");
	%>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec14">
			<h2>1:1문의 게시판</h2>
			<div class="sch">
				<select id = 'selectID' name = 'selectID' title='아이디검색'>
					<option value = '0'>- 전체 -</option>
					<option value = '1'>아이디</option>
				</select>
				<input id = 'searchID' name = 'searchID' type="text" onkeydown='javascript:if(event.keyCode==13){func.searchEnter({}); return false;}' maxlength='10'>
				<button onclick = "btnIdsearch()"><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
			  <ul class="tab">
			    <li id = button1 class="on" value = "0" onclick = "category(this.value)">전체</li>
				<li id = button2 value = "1" onclick = "category(this.value)">답변완료</li>
				<li id = button3 value = "2" onclick = "category(this.value)">미완료</li>						
				<input type="hidden" id="cate_color" name="cate_color" value="${category}">
				<input type="hidden" id="hiddensearchID" name="hiddensearchID" value="${searchID}">
			  </ul>
			  	<c:if test = "${category == '0'}">
			  		<table>
				  		<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>등록날짜</th>
							<th>답변여부</th>
						</tr>
						<c:forEach var = "inquiryBoardList" items="${inquiryBoardList}" varStatus="status" >
		  				<tr>
			  				<td>${status.count}</td>
			  				<td onclick="window.open('./inquiryAnswerForm.cu?idx=${inquiryBoardList.idx}','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">${inquiryBoardList.title}</td>															
							<td>${inquiryBoardList.id}<br>(${inquiryBoardList.name})</td>																
							<td>${inquiryBoardList.reg_date_time}</td>															
							<c:choose>
								<c:when test = "${inquiryBoardList.qna_reply != null}">
									<td>답변완료</td>
								</c:when>
								<c:otherwise>
								<td>미답변</td>
								</c:otherwise>
							</c:choose>
						</tr>
			  			</c:forEach>
			  		</table>			  					  	
					<c:if test="${count > 0}">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
							<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
								<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>
								<c:if test="${numPageGroup > 1}">
								<b><a href="./inquiryBoard.cu?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
							<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./inquiryBoard.cu?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
							</c:if>
					</c:if>
				</c:if>
			  	<c:if test = "${category == '1'}">
			  		<table>
				  		<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>등록날짜</th>
							<th>답변여부</th>
						</tr>
						<c:forEach var = "inquiryBoardList" items="${inquiryBoardList}" varStatus="status" >
		  				<tr>
			  				<td>${status.count}</td>
			  				<td onclick="window.open('./inquiryAnswerForm.cu?idx=${inquiryBoardList.idx}','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">${inquiryBoardList.title}</td>															
							<td>${inquiryBoardList.id}<br>(${inquiryBoardList.name})</td>																
							<td>${inquiryBoardList.reg_date_time}</td>								
							<td>답변완료</td>
						</tr>
			  			</c:forEach>
			  		</table>			  					  	
					<c:if test="${count > 0}">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
							<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
								<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>
								<c:if test="${numPageGroup > 1}">
								<b><a href="./inquiryBoard.cu?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
							<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./inquiryBoard.cu?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
							</c:if>
					</c:if>
				</c:if>
				<c:if test = "${category == '2'}">
			  		<table>
				  		<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>등록날짜</th>
							<th>답변여부</th>
						</tr>
						<c:forEach var = "inquiryBoardList" items="${inquiryBoardList}" varStatus="status" >
		  				<tr>
			  				<td>${status.count}</td>
			  				<td onclick="window.open('./inquiryAnswerForm.cu?idx=${inquiryBoardList.idx}','자주묻는질문','width=820,height=760,top=0,left=0,scrollbars=yes');">${inquiryBoardList.title}</td>															
							<td>${inquiryBoardList.id}<br>(${inquiryBoardList.name})</td>																
							<td>${inquiryBoardList.reg_date_time}</td>								
							<td>미답변</td>
						</tr>
			  			</c:forEach>
			  		</table>			  					  	
					<c:if test="${count > 0}">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
							<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
								<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>
								<c:if test="${numPageGroup > 1}">
								<b><a href="./inquiryBoard.cu?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./inquiryBoard.cu?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
							<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./inquiryBoard.cu?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
							</c:if>
					</c:if>
				</c:if>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		
		
/* $(function(){
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
     
}); */
		
setTimeout(function () {
	   jQuery('.nav4').trigger('click');
		jQuery('.nav43').addClass('on');
	}, 500);
	</script>
</body>
</html>