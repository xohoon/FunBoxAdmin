<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.finance.dto.Point"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		ArrayList<Point> token = (ArrayList<Point>)request.getAttribute("pointTransfer");
		String category = request.getParameter("category");
		String categroyFlag = request.getParameter("categroyFlag");
		String searchID =request.getParameter("searchID");
		
	%>
	<script>
		function category(button){
			var selectOption = document.getElementById("selectID").value;
			var searchID = document.getElementById("hiddensearchID").value;
			console.log(searchID);
			var category = button;
			location.href='./tokenExchangeList.fn?category='+category+"&searchID="+searchID;
				
		}
		
		function btnIdsearch(){
			var selectOption = document.getElementById("selectID").value;
			var searchID =  document.getElementById("searchID").value;

			if(selectOption == '0'){				
				location.href='./tokenExchangeList.fn?category='+0;
			}else{
				location.href='./tokenExchangeList.fn?searchID='+searchID;
			}
		}
		
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec04">
			<h2>포인트 환전 내역</h2>
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
					<ul class="tab">
						<li id = button1 class="on" value = "0" onclick = "category(this.value)">전체</li>
						<li id = button2 value = "1" onclick = "category(this.value)">환전</li>
						<li id = button3 value = "2" onclick = "category(this.value)">충전</li>
						<input type="hidden" id="cate_color" name="cate_color" value="${category}">
						<input type="hidden" id="hiddensearchID" name="hiddensearchID" value="${searchID}">
					</ul>
				</ul>
				<c:if test = "${category == '0'}">
					<table>
						<tr>						
							<th>순번</th>
							<th>아이디</th>
							<th>구분</th>						
							<th>환전포인트</th>
							<th>코인수량</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "pointTransfer" items="${pointTransfer}" varStatus="status" >
						<tr>
							<td>${status.count}</td>
							<c:choose>
								<c:when test="${pointTransfer.po_category == '2'}">								
									<td>${pointTransfer.mb_id}</td>
									<td>환전</td>									
									<td>${pointTransfer.tk_amount}</td>
									<td>${pointTransfer.po_amount}</td>												
									<th>${pointTransfer.po_date_time}</th>
								</c:when>
								<c:otherwise>
									<td>${pointTransfer.mb_id}</td>
									<td>충전</td>									
									<td>${pointTransfer.tk_amount}</td>
									<td>${pointTransfer.po_amount}</td>												
									<th>${pointTransfer.po_date_time}</th>
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
								<b><a href="./tokenExchangeList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenExchangeList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
								</c:if>
						</c:if>
					</c:if>
					<c:if test = "${category == '1'}">
					<table>
						<tr>						
							<th>순번</th>
							<th>아이디</th>
							<th>구분</th>						
							<th>환전포인트</th>
							<th>코인수량</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "pointTransfer" items="${pointTransfer}" varStatus="status" >
						<tr>
							<td>${status.count}</td>															
							<td>${pointTransfer.mb_id}</td>
							<td>환전</td>									
							<td>${pointTransfer.tk_amount}</td>
							<td>${pointTransfer.po_amount}</td>												
							<td>${pointTransfer.po_date_time}</td>						
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
								<b><a href="./tokenExchangeList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenExchangeList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
								</c:if>
						</c:if>
					</c:if>
					<c:if test = "${category == '2'}">
					<table>
						<tr>						
							<th>순번</th>
							<th>아이디</th>
							<th>구분</th>						
							<th>환전포인트</th>
							<th>코인수량</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "pointTransfer" items="${pointTransfer}" varStatus="status" >
						<tr>
							<td>${status.count}</td>															
							<td>${pointTransfer.mb_id}</td>
							<td>충전</td>									
							<td>${pointTransfer.tk_amount}</td>
							<td>${pointTransfer.po_amount}</td>												
							<td>${pointTransfer.po_date_time}</td>						
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
								<b><a href="./tokenExchangeList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}&searchID=${searchID}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenExchangeList.fn?pageNum=${i}&category=${categroyFlag}&searchID=${searchID}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenExchangeList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}&searchID=${searchID}" class="next">▶</a></b>
								</c:if>
						</c:if>					
				</c:if>				
		</section>
		<footer></footer>
	</div>
	<script>
		
		
	$(function(){
      var tdA = $('td:contains("충전")');
      var tdB = $('td:contains("환전")');
      $(tdA).css('color','#73a6d6');
    //  $(tdA).siblings('td').eq(3).css('color','#73a6d6');
      $(tdB).css('color','#ff9124');
    //  $(tdB).siblings('td').eq(3).css('color','#ff9124');
      
      
	/* $('.pager li').click(function(){
		$('.pager li').removeClass('on');
		$(this).addClass('on');
	}); */
      
   
      
     /*  $('.tab li').click(function(){
				$('.tab li').removeClass('on');
				$(this).addClass('on');
			});
      
      $('.tab li').eq(1).click(function(){
        $('tr').show();
        $('td:contains("환전")').parent().hide();
      });
      
	  $('.tab li').eq(2).click(function(){
        $('tr').show();
        $('td:contains("충전")').parent().hide();
      });
	  
	  $('.tab li').eq(0).click(function(){
		$('tr').show();
	  });*/
	}); 
		

		$(function(){
		  if($('#cate_color').val() == '0'){
			  $('.tab li').removeClass('on');
			  	$('#button1').addClass('on');
		  }
		  else if($('#cate_color').val() == '1'){
			  $('.tab li').removeClass('on');
			  $('#button2').addClass('on');
	 	  }
		  else if($('#cate_color').val() == '2'){
			  $('.tab li').removeClass('on');
			  $('#button3').addClass('on');
		  }
		
	  });
		
	   $('.incomma').each(function(){
	     var incomma = $(this).text();
	     $(this).text(numberWithCommas(incomma));
	    });
    
    function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
    setTimeout(function () {
		   jQuery('.nav2').trigger('click');
		   jQuery('.nav23').addClass('on');
		}, 500);
	</script>
</body>
</html>