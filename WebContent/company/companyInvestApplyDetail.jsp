<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>기업명</title>
<<<<<<< HEAD
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">
=======
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/admin.css" rel="stylesheet">
>>>>>>> branch 'master' of https://github.com/xohoon/FunBoxAdmin.git
</head>

<body>
	<div class="sec05_1">
		<div class="name">
			<input type="text" value="바른생선회" readonly="readonly" size="1">
			<input type="text" value="(아이디)" readonly="readonly" size="1">
		</div>
		<div>
			<label>담당자</label>
			<input type="text" value="바른생선회" readonly="readonly" size="1">
		</div>
		<div>
			<label>연락처</label>
			<input type="text" value="010-1234-5678" readonly="readonly" size="1">
		</div>
		<div>
			<label>소재지</label>
			<input type="text" value="(우편번호)" readonly="readonly" size="1">
			<input type="text" value="부산시 금정구" readonly="readonly" size="1"><br>
			<input type="text" value="금사로 160" readonly="readonly" class="adr1" size="1">
			<input type="text" value="참조" readonly="readonly" size="1">
		</div>
		<div>
			<label>업종</label>
			<input type="text" value="일반음식점" readonly="readonly" size="1">
		</div>
		<div>
			<label>오픈상태</label>
			<input type="text" value="운영중(2019.07.04)" readonly="readonly" size="1">
		</div>
		<div>
			<label>기업임대정보</label>
      <p><span>권리금</span> <input type="text" value="1000000000원" readonly="readonly" size="1" class="incomma"></p>
      <p><span>보증금</span> <input type="text" value="1000000000원" readonly="readonly" size="1" class="incomma"></p>
      <p><span>월세</span> <input type="text" value="1000000000원" readonly="readonly" size="1" class="incomma"></p>
		</div>
		<div>
			<label>목표투자금액</label>
			<input type="text" value="10000000000원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>평균월매출액</label>
			<input type="text" value="10000000000원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>월수익률</label>
			<input type="text" value="40%" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>투자모집기간</label>
			<input type="text" value="30일" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>투자최소금액</label>
			<input type="text" value="10000원" readonly="readonly" size="1" class="incomma">
		</div>
		<div>
			<label>기업소개</label><textarea readonly="readonly"></textarea>
		</div>
		<div>
			<label>투자모집목적</label><textarea readonly="readonly"></textarea>
		</div>
		<div>
			<label>투자포인트</label><textarea readonly="readonly"></textarea>
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