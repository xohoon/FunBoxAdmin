<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>이름(아이디)</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script type="text/javascript" src="member/js/memberDetail.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec01_1">
		<div class="name">
			<input id="mb_name" type="text" value="${member.mb_name }" size="1">
			<input id="mb_id" type="text" value="${member.mb_id }" size="1">
		</div>
		<div>
			<label>E-mail</label>
			<input id="mb_email" type="text" value="${member.mb_email }" size="1">
		</div>
		<div>
			<label>휴대전화번호</label>
			<input id="mb_phone" type="text" value="${member.mb_phone }" size="1">
		</div>
		<div>
			<label>주소</label>
			<input id="mb_add_num" type="text" value="${member.mb_add_num }" size="1">
			<input id="mb_add_ch" type="text" value="${member.mb_add_ch}" size="1"><br>
			<input id="mb_add_more" type="text" value="${member.mb_add_more}" class="adr1" size="1">
			<input id="mb_add_extra" type="text" value="${member.mb_add_extra}" size="1">
		</div>
		<div>
			<label>추천인ID</label>
			<input id="mb_recommend" type="text" value="${member.mb_recommend }" size="1">
		</div>
		<div>
			<label>예상투자금액</label>
			<input id="" type="text" value="이게모야 ? 1000만원" size="1">
		</div>
		<div>
			<label>보유포인트</label>
			<input id="mb_point" type="text" value="${member.mb_point }" size="1" class="incomma"> <span>Point</span>
		</div>
		<div>
			<label>보유토큰</label>
			<input id="mb_token" type="text" value="${member.mb_token }" size="1" class="incomma"> <span>FBX</span>
		</div>
		<p>최근투자내역</p>
		<table>
			<tr>
				<th>기업명</th>
				<th>투자포인트</th>
				<th>구좌</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="memberLateInvested" items="${memberLateInvestedList}">
				<tr>
					<td>${memberLateInvested.mi_name }</td>
					<td class="point">${memberLateInvested.mi_point }</td>
					<td>${memberLateInvested.mi_hoiling_stock }</td>
					<td>${memberLateInvested.mi_reg_date_time }<br>12:55:20</td>
				</tr>
			</c:forEach>
		</table>
		<button class="submit out">탈퇴하기</button>
		<button class="submit rec">수정하기</button>
    	<button id="save" class="submit save">저장하기</button>
		<button class="submit cancel">취소</button>
		<input type="hidden" id="mb_idx" value="${mb_idx }" />
	</div><!--.sec01_1-->
	<script>
		$(function(){
      
			  $('input').each(function(){
				  $(this).width(this.scrollWidth );
        });
      /* $('.incomma').each(function(){
          var num = $(this).val();
          var numPar = Number(num.replace(/\,/g, "") || 0);
              numPar = numPar.toFixed();
             numPar = numberWithCommas(numPar);
        
          $(this).val(numPar);
            
        }); */
    
    $('.point').each(function(){
          var num = $(this).text();
          var numPar = Number(num.replace(/\,/g, "") || 0);
              numPar = numPar.toFixed();
             numPar = numberWithCommas(numPar);
        
          $(this).text(numPar);
            
        });
       $('input').prop('readonly',true);
      $('.save').hide();
      $('.cancel').hide();
      
      $('.rec').on('click', function(){
        $('input').css('border','1px solid #ddd');        
        $('input').prop('readonly',false);
        $('input').width(160);
        $(this).hide();
        $('.out').hide();
        $('.save').show();
        $('.cancel').show();
      });
      
      $('.cancel').click(function(){
         location.reload();
      });
      
      /* $('input').on('change', function(){
        var num = $(this).val();
          var numPar = Number(num.replace(/\,/g, "") || 0);
              numPar = numPar.toFixed();
             numPar = numberWithCommas(numPar);
        
          $(this).val(numPar);
      }); */
      
 });
			  
      
      	
    
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
	</script>
</body>
</html>