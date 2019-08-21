<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>기업명</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec05_1">
		<div class="name">
			<input type="text" value="${companyApplicationDetail.app_cp_name }" readonly="readonly" size="1">
			<input type="text" value="(${companyApplicationDetail.mb_id })" readonly="readonly" size="1">
		</div>
		<div>
			<label>담당자</label>
			<input type="text" value="${companyApplicationDetail.app_cp_manager }" readonly="readonly" size="1">
		</div>
		<div>
			<label>연락처</label>
			<input type="text" value="${companyApplicationDetail.app_cp_hp }" readonly="readonly" size="1">
		</div>
		<div>
			<label>소재지</label>
			<input type="text" value="(${companyApplicationDetail.app_cp_num })" readonly="readonly" size="1">
			<input type="text" value="${companyApplicationDetail.app_cp_ch }" readonly="readonly" size="1"><br>
			<input type="text" value="${companyApplicationDetail.app_cp_more }" readonly="readonly" class="adr1" size="1">
			<input type="text" value="${companyApplicationDetail.app_cp_extra }" readonly="readonly" size="1">
		</div>
		<div>
			<label>업종</label>
			<input type="text" value="${companyApplicationDetail.app_cp_sector }" readonly="readonly" size="1">
		</div>
		<div>
			<label>오픈상태</label>
			<c:choose>
				<c:when test="${companyApplicationDetail.app_cp_status eq true }">
					<input type="text" value="운영중(${companyApplicationDetail.app_cp_open_date_time })" readonly="readonly" size="1">
				</c:when>
				<c:otherwise>
					<input type="text" value="오픈예정(${companyApplicationDetail.app_cp_open_date_time })" readonly="readonly" size="1">
				</c:otherwise>
			</c:choose>			
		</div>
		<div>
			<label>기업임대정보</label>
      <p><span>권리금</span> <input type="text" value="${companyApplicationDetail.app_cp_prestige }원" readonly="readonly" size="1" class="incomma"></p>
      <p><span>보증금</span> <input type="text" value="${companyApplicationDetail.app_cp_deposit }원" readonly="readonly" size="1" class="incomma"></p>
      <p><span>월세</span> <input type="text" value="${companyApplicationDetail.app_cp_monthly }원" readonly="readonly" size="1" class="incomma"></p>
		</div>
		<div>
			<label>목표투자금액</label>
			<input type="text" value="${companyApplicationDetail.app_cp_goal_amount }원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>평균월매출액</label>
			<input type="text" value="${companyApplicationDetail.app_cp_avg_monthly_profit }원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>월수익률</label>
			<input type="text" value="${companyApplicationDetail.app_cp_monthly_profit }%" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>투자모집기간</label>
			<input type="text" value="${companyApplicationDetail.app_cp_during }일" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>투자최소금액</label>
			<input type="text" value="${companyApplicationDetail.app_cp_inv_min_amount }원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>기업소개</label><textarea readonly="readonly">${companyApplicationDetail.app_cp_introduction }</textarea>
		</div>
		<div>
			<label>투자모집목적</label><textarea readonly="readonly">${companyApplicationDetail.app_cp_purpose }</textarea>
		</div>
		<div>
			<label>투자포인트</label><textarea readonly="readonly">${companyApplicationDetail.app_cp_point }</textarea>
		</div>
		<div>
		  <label>제출서류</label>
      <p><span>사업자등록증</span> <a href="#" download>사업자등록증.jpg<i class="fas fa-download"></i></a></p>
      <p><span>재무제표</span> <a href="#" download>재무제표.pdf<i class="fas fa-download"></i></a></p>
      <p><span>부동산계약서</span> <a href="#" download>부동산계약서.pdf<i class="fas fa-download"></i></a></p>
      <p class="cf">
        <span>매장사진</span>
        <a href="#" download>1.jpg<i class="fas fa-download"></i></a>
        <a href="#" download>2.jpg<i class="fas fa-download"></i></a>
        <a href="#" download>3.jpg<i class="fas fa-download"></i></a>
      </p>
      <p class="cf">
        <span>기타서류</span>
        <a href="#" download>정관.pdf<i class="fas fa-download"></i></a>
        <a href="#" download>결산장부.pdf<i class="fas fa-download"></i></a>
      </p>
		</div>
	</div><!--.sec05_1-->
	<script>
		$(function() {
			  $('input').on('keyup', function (e){
				  $(this).width( this.scrollWidth );
          $('.incomma').each(function(){
         var incomma = $(this).val();
        $(this).val(numberWithCommas(incomma));
      });
			  });
			  $('input').keyup();
      
      $('.point').each(function(){
         var point = $(this).text();
        $(this).text(numberWithCommas(point));
      });
      
		});		
    
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
	</script>
</body>
</html>