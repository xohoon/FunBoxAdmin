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
	<script type="text/javascript" src="company/js/companyInvestedList.js"></script>
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
	        		<li>대기(심사중)</li> 
	        	</c:when>
	        	<c:when test="${funding_status eq '12'}">
	        		<li>전체 </li>
	        		<li class="on">펀딩진행</li>
	        		<li>펀딩완료</li>
	        		<li>대기(심사중)</li> 
	        	</c:when>
	        	<c:when test="${funding_status eq '11'}">
	        		<li>전체 </li>
	        		<li>펀딩진행</li>
	        		<li class="on">펀딩완료</li>
	        		<li>대기(심사중)</li> 
	        	</c:when>
	          	<c:otherwise>
	          		<li>전체 </li>
	        		<li>펀딩진행</li>
	        		<li>펀딩완료</li>
	        		<li class="on">대기(심사중)</li>
	          	</c:otherwise>
	        </c:choose>
        </ul>
        <br>      				   
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
              <th>연채상태</th>
              <th></th>
            </tr>
            <c:forEach var="companyInvested" items="${companyInvestedList }" varStatus="status">
            	<tr>
            	<c:choose>
         			<c:when test="${companyInvested.cp_funding_status == 11}">
         				<td onclick="window.open('./companyInvestDetailFunded.cp?cp_idx=${companyInvested.cp_idx}','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">${companyInvested.cp_name }</td>
         				<input type="hidden" id="cp_${status.count}" value="${companyInvested.cp_idx}">         				
         			</c:when>
         			<c:otherwise>
         				<td onclick="window.open('./companyInvestedDetail.cp?cp_idx=${companyInvested.cp_idx}','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">${companyInvested.cp_name }</td>
         				<input type="hidden" id="cp_${status.count}" value="${companyInvested.cp_idx}">
         			</c:otherwise>
         		</c:choose>
					<td>${companyInvested.mb_id }</td>
					<td>${companyInvested.cp_manager }</td>
					<td>${companyInvested.cp_phone }</td>
					<td>D-${companyInvested.d_day }</td>
					<td>${companyInvested.cp_monthly_profit}%</td>
					<td>${companyInvested.result}</td>				
				<c:choose>
					<c:when test="${companyInvested.cp_funding_status == 10}">
					<td>
						<select id = "fund_state_${status.count}" >
		                  <option value ="">- 펀딩상태 -</option>
		                  <option value ="10" selected="selected">대기중</option>
		                  <option value ="11">펀딩중</option>
		                  <option value ="12">펀딩완료</option>
	                	</select>
	                </td>
					</c:when>
					<c:when test="${companyInvested.cp_funding_status == 11}">
					<td>
						<select id = "fund_state_${status.count}" >
		                  <option value ="">- 펀딩상태 -</option>
		                  <option value ="10">대기중</option>
		                  <option value ="11" selected="selected">펀딩중</option>
		                  <option value ="12">펀딩완료</option>
	                	</select>
	                </td>
					</c:when>
					<c:when test="${companyInvested.cp_funding_status == 12}">
					<td>
						<select id = "fund_state_${status.count}" >
		                  <option value ="">- 펀딩상태 -</option>
		                  <option value ="10">대기중</option>
		                  <option value ="11">펀딩중</option>
		                  <option value ="12" selected="selected">펀딩완료</option>
	                	</select>
	                </td>
					</c:when>
					<c:otherwise>
					<td>
						<select id = "fund_state_${status.count}" >
		                  <option value =""  selected="selected">- 펀딩상태 -</option>
		                  <option value ="10">대기중</option>
		                  <option value ="11">펀딩중</option>
		                  <option value ="12">펀딩완료</option>
	                	</select>
	                </td>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${companyInvested.cp_revenue_distribution_status == 21}">
					 <td>
	                <select id = "give_state_${status.count}">
	                  <option value ="">- 지급상태 - </option>
	                  <option value ="21"  selected="selected">수익분배중</option>
	                  <option value ="22">분배완료</option>	                  
	                </select>
              	  	</td>
					</c:when>
					<c:when test="${companyInvested.cp_funding_status == 22}">
					<td>
	                <select id = "give_state_${status.count}">
	                  <option value ="" >- 지급상태 - </option>
	                  <option value ="21">수익분배중</option>
	                  <option value ="22" selected="selected">분배완료</option>	                  
	                </select>
              	  	</td>
					</c:when>
					<c:otherwise>
					<td>
	                <select id = "give_state_${status.count}">
	                  <option value ="" selected="selected">- 지급상태 - </option>
	                  <option value ="21">수익분배중</option>
	                  <option value ="22">분배완료</option>	                  
	                </select>
              	  	</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${companyInvested.cp_overdue_status == 30}">
				   <td>
	                <select id = "arrears_state_${status.count}">
	                  <option value = "">- 연채상태 - </option>
	                  <option value ="30" selected="selected">연채중</option>
	                </select>
              	  </td>
					</c:when>
					<c:otherwise>
					<td>
	                <select id = "arrears_state_${status.count}">
	                  <option value = "" selected="selected">- 연채상태 - </option>
	                  <option value ="30">연채중</option>
	                </select>
              	  </td>
					</c:otherwise>
				</c:choose>              	  
              	  <td class="selfix"><li value="${status.count}" onclick = "replybtn(this.value)">수정</td>
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
        <div class="doneGroup"></div>
	</div>
		</section>
		<footer></footer>
	</div>
	<script>  
/*     setTimeout(function () {
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
    
 */
    
	</script>
</body>
</html>