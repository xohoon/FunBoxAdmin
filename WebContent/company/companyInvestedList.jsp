<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		  //$('.doneGroup').load('../company/companyInvestedDoneList.jsp');
		  //$('.doneGroup').load('./companyInvestedDoneList.cp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec07">
			<h2>투자기업목록</h2>
			<div class="con">
        <ul class="tab">
	      <c:choose>
	      		<c:when test="${funding_status eq '0'}">
	        		<li class="on">전체 </li>
	        		<li>펀딩진행</li>
	        		<li>펀딩완료</li>
	        		<li>대기</li> 
	        	</c:when>
	        	<c:when test="${funding_status eq '12'}">
	        		<li>전체 </li>
	        		<li class="on">펀딩진행</li>
	        		<li>펀딩완료</li>
	        		<li>대기</li> 
	        	</c:when>
	        	<c:when test="${funding_status eq '11'}">
	        		<li>전체 </li>
	        		<li>펀딩진행</li>
	        		<li class="on">펀딩완료</li>
	        		<li>대기</li> 
	        	</c:when>
	          	<c:otherwise>
	          		<li>전체 </li>
	        		<li>펀딩진행</li>
	        		<li>펀딩완료</li>
	        		<li class="on">대기</li>
	          	</c:otherwise>
	        </c:choose>
	          <!-- <li class="on">전체</li>
	          <li>펀딩진행</li>
	          <li>펀딩완료</li>
	          <li>대기</li> -->
        </ul>
        <br>
        <c:choose>
      		<c:when test="${funding_status eq '11'}">
      		<div class="ingGroup">
          <table>
              <tr>
              <th>상호명</th>
              <th>아이디</th>
              <th>담당자</th>
              <th>연락처</th>
              <th>마감</th>
              <th>월수익률</th>
              <th>잔여구좌</th>
              <th>펀딩상태</th>
              <th>지급상태</th>
              <th></th>
            </tr>
            <c:forEach var="companyInvested" items="${companyInvestedList }" >
            	<tr>
            		<td onclick="window.open('./companyInvestedDetail.cp?cp_idx=${companyInvested.cp_idx}','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">${companyInvested.cp_name }</td>
					<td>${companyInvested.mb_id }</td>
					<td>${companyInvested.cp_manager }</td>
					<td>${companyInvested.cp_phone }</td>
					<td>D-${companyInvested.d_day }</td>
					<td>${companyInvested.cp_monthly_profit}%</td>
					<td>${companyInvested.result}</td>
					<td>
	                <select>
	                  <option>- 펀딩상태 -</option>
	                  <option>대기중</option>
	                  <option>펀딩중</option>
	                  <option>펀딩완료</option>
	                </select>
	              </td>
	              <td>
	                <select>
	                  <option>- 지급상태 - </option>
	                  <option>수익분배중</option>
	                  <option>분배완료</option>
	                  <option>연체중</option>
	                </select>
              	  </td>
              	  <td class="selfix">수정</td>
            	</tr>
            </c:forEach>
          </table>
          <a href="./companyInvestedList.cp?page=${current_page-1 }&funding_status=${funding_status}" class="prev"><i class="fas fa-caret-left"></i></a>
          <ul class="pager">
            <c:forEach var="i" begin="${current_min_page }" end="${current_max_page }">
            	<c:choose>
           			<c:when test="${ i eq current_page}">
						<li class="on"><a href="./companyInvestedList.cp?page=${i }&funding_status=${funding_status}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./companyInvestedList.cp?page=${i }&funding_status=${funding_status}">${i }</a></li>
					</c:otherwise>
            	</c:choose>
			</c:forEach>
          </ul>
          <a href="./companyInvestedList.cp?page=${current_page+1 }&funding_status=${funding_status}" class="next"><i class="fas fa-caret-right"></i></a>
        </div>
      		</c:when>
      		<c:otherwise>
      				   
		<div class="ingGroup">
          <table>
              <tr>
              <th>상호명</th>
              <th>아이디</th>
              <th>담당자</th>
              <th>연락처</th>
              <th>마감</th>
              <th>월수익률</th>
              <th>잔여구좌</th>
              <th>펀딩상태</th>
              <th>지급상태</th>
              <th></th>
            </tr>
            <c:forEach var="companyInvested" items="${companyInvestedList }" >
            	<tr>
            		<td onclick="window.open('./companyInvestedDetail.cp?cp_idx=${companyInvested.cp_idx}','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">${companyInvested.cp_name }</td>
					<td>${companyInvested.mb_id }</td>
					<td>${companyInvested.cp_manager }</td>
					<td>${companyInvested.cp_phone }</td>
					<td>D-${companyInvested.d_day }</td>
					<td>${companyInvested.cp_monthly_profit}%</td>
					<td>${companyInvested.result}</td>
					<td>
	                <select>
	                  <option>- 펀딩상태 -</option>
	                  <option>대기중</option>
	                  <option>펀딩중</option>
	                  <option>펀딩완료</option>
	                </select>
	              </td>
	              <td>
	                <select>
	                  <option>- 지급상태 - </option>
	                  <option>수익분배중</option>
	                  <option>분배완료</option>
	                  <option>연체중</option>
	                </select>
              	  </td>
              	  <td class="selfix">수정</td>
            	</tr>
            </c:forEach>
          </table>
          <a href="./companyInvestedList.cp?page=${current_page-1 }&funding_status=${funding_status}" class="prev"><i class="fas fa-caret-left"></i></a>
          <ul class="pager">
            <c:forEach var="i" begin="${current_min_page }" end="${current_max_page }">
            	<c:choose>
           			<c:when test="${ i eq current_page}">
						<li class="on"><a href="./companyInvestedList.cp?page=${i }&funding_status=${funding_status}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./companyInvestedList.cp?page=${i }&funding_status=${funding_status}">${i }</a></li>
					</c:otherwise>
            	</c:choose>
			</c:forEach>
          </ul>
          <a href="./companyInvestedList.cp?page=${current_page+1 }&funding_status=${funding_status}" class="next"><i class="fas fa-caret-right"></i></a>
        </div>
      		</c:otherwise>      		
	   </c:choose>

        <div class="doneGroup"></div>
	</div>
		</section>
		<footer></footer>
	</div>
	<script>  
    setTimeout(function () {
      jQuery('.nav3').trigger('click');
      jQuery('.nav34').addClass('on');
    }, 500);
    
    $(function(){
    	console.log("test");
      $('.tab li').click(function(){
	 		$('.tab li').removeClass('on');
				$(this).addClass('on');
	  });
      
      $('.tab li').eq(0).click(function(){
    	 window.location.href="./companyInvestedList.cp?page=1&funding_status=0";
        //$('.ingGroup').show();
        //$('.doneGroup').hide();
      });
      
      $('.tab li').eq(1).click(function(){
    	  window.location.href="./companyInvestedList.cp?page=1&funding_status=12";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.tab li').eq(2).click(function(){
    	  window.location.href="./companyInvestedList.cp?page=1&funding_status=11";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.tab li').eq(3).click(function(){
    	  //window.location.href="./companyInvestedList.cp?page=1&funding_status=11";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
    });
    

    
	</script>
</body>
</html>