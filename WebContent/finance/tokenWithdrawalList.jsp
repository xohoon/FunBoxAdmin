<%@page import="net.customer.dto.Token"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<link href="./css/txaddress.css" rel="stylesheet">
	<script>
		$(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		});
	</script>
	<%
		ArrayList<Token> token = (ArrayList<Token>)request.getAttribute("tokenTransfer");
		String category = request.getParameter("category");
		String categroyFlag = request.getParameter("categroyFlag");
	%>
	<script>
		function category(button){
			var category = button;
			location.href='./tokenWithdrawalList.fn?category='+category;
				
		}
		
		function btnIdsearch(){
			var selectOption = document.getElementById("selectID").value;
			var searchID =  document.getElementById("searchID").value;
			
			
			if(selectOption == '0'){ 
				alert('찾고자 하는 옵션을 선택해주세요.');
			}else{
				 $.ajax({
					url : './tokenWithdrawalSearch.fn', 
					type : 'POST',
					data: {"searchID":searchID},	    			
	    			dataType : 'json',
		    			success:function(data){
		    				$('table').remove();
		    				$('#pagers').remove();
		    				
		    				var tablefrom;
		    				var count = "1";
		    				tablefrom = "<table>";
		    				tablefrom += "<tr><th>번호</th><th>아이디</th><th>구분</th><th>TX Hash</th><th>수량</th><th>상태</th><th>날짜</th></tr>";
		    				tablefrom += "<tr>";
		    				for (var i = 0; i < data.length; i++) {
		    					
		    		         	tablefrom +="<th>"+ count +"</th>";
		    		         	if(data[i].td_to_address == 'durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'){
		    		         		tablefrom +="<th>"+ data[i].mb_id +"</th>";
		    		         		tablefrom +="<td>입금</td>";
		    		         		tablefrom +="<td>"+ data[i].td_from_address +"</td>";
		    		         		tablefrom +="<td>"+ data[i].td_amount +"</td>";
		    		         		if(data[i].td_status == "0"){
		    		         			tablefrom +="<td>대기</td>";	
		    		         		}else if(data[i].td_status == "1"){
		    		         			tablefrom +="<td>수락</td>";
		    		         		}else if(data[i].td_status == "2"){
		    		         			tablefrom +="<td>취소</td>";
		    		         		}
		    		         		tablefrom +="<th>"+ data[i].td_date_time +"</th>";
		    		         	}else{
		    		         		tablefrom +="<td>"+ data[i].mb_id +"</td>";
		    		         		tablefrom +="<td>출금</td>";
		    		         		tablefrom +="<td>"+ data[i].td_from_address +"</td>";
		    		         		tablefrom +="<td>"+ data[i].td_amount +"</td>";
		    		         		if(data[i].td_status == "0"){
		    		         			tablefrom +="<td>대기</td>";	
		    		         		}else if(data[i].td_status == "1"){
		    		         			tablefrom +="<td>수락</td>";
		    		         		}else if(data[i].td_status == "2"){
		    		         			tablefrom +="<td>취소</td>";
		    		         		}
		    		         		tablefrom +="<th>"+ data[i].td_date_time +"</th>";
		    		         	}
		    		         	count++;
		    		         	tablefrom +="</tr>";
		    		        }
		    				
		    				tablefrom += "</table>";
		    				console.log(tablefrom);
		    				 $( '#searchpostion' ).append( tablefrom );
		    				 
	    				},error:function(data){
	    					alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
	    				}
				});
			} 
			
		}
		
		function showSerchFrom(obj){			
		
		}
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec03">
			<h2>토큰 입출금 내역</h2>
			<div class="sch">
				<select id = 'selectID' name = 'selectID' title='아이디검색'>
					<option value = '0'>- 선택 -</option>
					<option value = '1'>아이디</option>
				</select>
				<input id = 'searchID' name = 'searchID' type="text" onkeydown='javascript:if(event.keyCode==13){func.searchEnter({}); return false;}' maxlength='10'>
				<button onclick = "btnIdsearch()"><i class="fas fa-search"></i></button>
			</div>
			<div class="con">
				<ul class="tab">
					<ul class="tab">
						<li id = button1 class="on" value = "0" onclick = "category(this.value)">전체</li>
						<li id = button2 value = "1" onclick = "category(this.value)">입금</li>
						<li id = button3 value = "2" onclick = "category(this.value)">출금</li>
						<input type="hidden" id="cate_color" name="cate_color" value="${category}">
					</ul>
				</ul>
				<div id = "searchpostion"></div>
				<c:if test = "${category == '0'}">
					<table>
						<tr>						
							<th>번호</th>
							<th>아이디</th>
							<th>구분</th>
							<th>TX Hash</th>
							<th>수량</th>
							<th>상태</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "tokenTransfer" items="${tokenTransfer}" varStatus="status" >
						<tr>
							<th>${status.count}</th>
							<c:choose>
								<c:when test="${tokenTransfer.td_to_address == 'durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'}">								
									<th>${tokenTransfer.mb_id}</th>
									<td>입금</td>
									<td>${tokenTransfer.td_from_address}</td>
									<td>${tokenTransfer.td_amount}</td>								
									<c:if test="${tokenTransfer.td_status == '0'}">
										<td>대기</td>
									</c:if>
									<c:if test="${tokenTransfer.td_status == '1'}">
										<td>수락</td>
									</c:if>
									<c:if test="${tokenTransfer.td_status == '2'}">
										<td>취소</td>
									</c:if>
									<th>${tokenTransfer.td_date_time}</th>
								</c:when>
								<c:otherwise>
									<th>${tokenTransfer.mb_id}</th>
									<td>출금</td>
									<td>${tokenTransfer.td_from_address}</td>
									<td>${tokenTransfer.td_amount}</td>								
									<c:if test="${tokenTransfer.td_status == '0'}">
										<td>대기</td>
									</c:if>
									<c:if test="${tokenTransfer.td_status == '1'}">
										<td>수락</td>
									</c:if>
									<c:if test="${tokenTransfer.td_status == '2'}">
										<td>취소</td>
									</c:if>
									<th>${tokenTransfer.td_date_time}</th>
								</c:otherwise>
							</c:choose>
							
						</tr>	
						</c:forEach>					
					</table>
					<div id = pagers>
						<c:if test="${count > 0}">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
							<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
								<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>
								<c:if test="${numPageGroup > 1}">
								<b><a href="./tokenWithdrawalList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenWithdrawalList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a></b>
								</c:if>
						</c:if>
					</div>
					</c:if>
					<c:if test = "${category == '1'}">
					<table>
						<tr>						
							<th>번호</th>
							<th>아이디</th>
							<th>구분</th>
							<th>TX Hash</th>
							<th>수량</th>
							<th>상태</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "tokenTransfer" items="${tokenTransfer}" varStatus="status" >
						<tr>
							<th>${status.count}</th>															
							<th>${tokenTransfer.mb_id}</th>
							<td>입금</td>
							<td>${tokenTransfer.td_from_address}</td>
							<td>${tokenTransfer.td_amount}</td>								
							<c:if test="${tokenTransfer.td_status == '0'}">
								<td>대기</td>
							</c:if>
							<c:if test="${tokenTransfer.td_status == '1'}">
								<td>수락</td>
							</c:if>
							<c:if test="${tokenTransfer.td_status == '2'}">
								<td>취소</td>
							</c:if>
							<th>${tokenTransfer.td_date_time}</th>							
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
								<b><a href="./tokenWithdrawalList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenWithdrawalList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a></b>
								</c:if>
						</c:if>
					</c:if>
					<c:if test = "${category == '2'}">
					<table>
						<tr>						
							<th>번호</th>
							<th>아이디</th>
							<th>구분</th>
							<th>TX Hash</th>
							<th>수량</th>
							<th>상태</th>
							<th>날짜</th>
						</tr>
						<c:forEach var = "tokenTransfer" items="${tokenTransfer}" varStatus="status" >
						<tr>
							<th>${status.count}</th>															
							<th>${tokenTransfer.mb_id}</th>
							<td>출금</td>
							<td>${tokenTransfer.td_from_address}</td>
							<td>${tokenTransfer.td_amount}</td>								
							<c:if test="${tokenTransfer.td_status == '0'}">
								<td>대기</td>
							</c:if>
							<c:if test="${tokenTransfer.td_status == '1'}">
								<td>수락</td>
							</c:if>
							<c:if test="${tokenTransfer.td_status == '2'}">
								<td>취소</td>
							</c:if>
							<th>${tokenTransfer.td_date_time}</th>							
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
								<b><a href="./tokenWithdrawalList.fn?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a></b>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./tokenWithdrawalList.fn?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<b><a href="./tokenWithdrawalList.fn?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a></b>
								</c:if>
						</c:if>					
				</c:if>				
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
	
	$(function(){
      var tdA = $('td:contains("입금")');
      var tdB = $('td:contains("출금")');
      $(tdA).css('color','#73a6d6');
      //$(tdA).siblings('td').eq(3).css('color','#73a6d6');
      $(tdB).css('color','#ff9124');
      //$(tdB).siblings('td').eq(3).css('color','#ff9124');
      
      /* 
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
			
			$('.tab li').click(function(){
				$('.tab li').removeClass('on');
				$(this).addClass('on');
			});
			 */
	/* 	$('.tab li').eq(1).click(function(){
        	$('tr').show();
        	$('td:contains("출금")').parent().hide();
      	});
		$('.tab li').eq(2).click(function(){
        	$('tr').show();
        	$('td:contains("입금")').parent().hide();
      	});
		$('.tab li').eq(0).click(function(){
			$('tr').show();
		}); */

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