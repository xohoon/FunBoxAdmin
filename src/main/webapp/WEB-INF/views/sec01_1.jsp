<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>이름(아이디)</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">
</head>

<body>
	<div class="sec01_1">
		<div class="name">
			<input type="text" value="이름" size="1">
			<input type="text" value="(아이디)" size="1">
		</div>
		<div>
			<label>E-mail</label>
			<input type="text" value="asdr@iolab.kr" size="1">
		</div>
		<div>
			<label>휴대전화번호</label>
			<input type="text" value="010-1234-5678" size="1">
		</div>
		<div>
			<label>주소</label>
			<input type="text" value="(우편번호)" size="1">
			<input type="text" value="부산시 금정구" size="1"><br>
			<input type="text" value="금사로 160" class="adr1" size="1">
			<input type="text" value="참조" size="1">
		</div>
		<div>
			<label>추천인ID</label>
			<input type="text" value="cncjsdls" size="1">
		</div>
		<div>
			<label>예상투자금액</label>
			<input type="text" value="1000만원" size="1">
		</div>
		<div>
			<label>보유포인트</label>
			<input type="text" value="100000000" size="1" class="incomma"> <span>Point</span>
		</div>
		<div>
			<label>보유토큰</label>
			<input type="text" value="10000000000" size="1" class="incomma"> <span>FBX</span>
		</div>
		<p>최근투자내역</p>
		<table>
			<tr>
				<th>기업명</th>
				<th>투자포인트</th>
				<th>구좌</th>
				<th>날짜</th>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
			<tr>
				<td>바른생선회</td>
				<td class="point">10000000000</td>
				<td>5</td>
				<td>2019.07.22<br>12:55:20</td>
			</tr>
		</table>
		<button class="submit out">탈퇴하기</button>
		<button class="submit rec">수정하기</button>
    <button class="submit save">저장하기</button>
		<button class="submit cancel">취소</button>
	</div><!--.sec01_1-->
	<script>
		$(function(){
      
			  $('input').each(function(){
				  $(this).width(this.scrollWidth );
        });
      $('.incomma').each(function(){
          var num = $(this).val();
          var numPar = Number(num.replace(/\,/g, "") || 0);
              numPar = numPar.toFixed();
             numPar = numberWithCommas(numPar);
        
          $(this).val(numPar);
            
        });
    
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
      
      $('input').on('change', function(){
        var num = $(this).val();
          var numPar = Number(num.replace(/\,/g, "") || 0);
              numPar = numPar.toFixed();
             numPar = numberWithCommas(numPar);
        
          $(this).val(numPar);
      });
      
 });
			  
      
      	
    
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
	</script>
</body>
</html>