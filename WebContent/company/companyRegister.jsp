<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/admin.css" rel="stylesheet">
	<script>
		$(function() {
		  $('header').load('../template/header.jsp');
		  $('#gnb').load('../template/categoryTemplate.jsp');
		  $('footer').load('../template/footer.jsp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec06">
			<h2>기업등록</h2>
			<div class="con">
			<form name="corForm">
				<div>
					<h3>기업이름</h3>
					<select>
						<option>- 구분 -</option>
						<option>일반음식점</option>
						<option>카페</option>
						<option>등등</option>
					</select>
					<input type="text" placeholder="브랜드명">
					<input type="text" placeholder="지점">
			   </div>
			   <div>
					<h3>기본정보</h3>
					<p><span>대표자</span>
            <input type="text"></p>
					<p><span>사업자등록번호</span>
            <input type="text"></p>
					<p><span>자본금</span>
            <input type="text"></p>
					<p><span>본사주소</span>
					<input type="text"></p>
			  </div>
			  <div>
					<h3>투자정보</h3>
            <p><span>월수익률</span><input type="text"> %</p>
            <p><span>투자계약기간</span><input type="text"> 개월</p>
            <p><span>최소투자금액</span><input type="text"> Point</p>
            <p><span>모집구좌</span><input type="text"> 구좌</p>
            <p><span>총모집금액</span><input type="text"> Point</p>
            <p><span>모집기간</span><input type="text"> 일</p>
			  </div>
				<div>
					<h3>사진등록</h3>
					<p><span>썸네일</span><input type="file">
          <span>910px * 780px :: 상호나 간판이 정중앙에 오도록 편집 후 업로드 ::</span></p>
					<p><span>매장사진1</span><input type="file">
          <span>930px * 310px</span></p>
					<p><span>매장사진2</span><input type="file">
          <span>930px * 310px</span></p>
					<p><span>매장사진3</span><input type="file">
          <span>445px * 310px</span></p>
					<p><span>매장사진4</span><input type="file">
          <span>445px * 310px</span></p>
					<p><span>기업PR배경</span><input type="file">
          <span>930px * 780px</span></p>
          <p><span>매장PR타이틀</span><input type="text"></p>
					<span>매장PR내용</span>
          <p><textarea></textarea>
          <span>250자 내외</span></p>
				</div>
				<div class="plan">
					<h3>사업계획서</h3>
					<p><input type="file"><input type="button" class="add add1" value="+"></p>
				</div>
			  <div>
          <h3>참고자료</h3>
          <p><span>재무제표</span><input type="file"></p>
          <p><span>해당 업종 자격증 사본</span><input type="file"></p>
          <p><span>부동산 임대차 계약서 사본</span><input type="file"></p>
          <p><span>사업자 등록증 사본</span><input type="file"></p>
			  </div>
			  <div class="table1">
			  	<h3>손익상세</h3>
			  	<table>
            <tr>
              <td>기준년월</td>
              <td><input type="text" size="4" placeholder="19" maxlength="2"> 년 <input type="text" size="1"> 월</td>
            </tr>
			  	  <tr>
			  	    <td>매출</td>
			  	    <td><input type="text" size="13" name="calA"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>원재료</td>
			  	    <td><input type="text" size="13" name="calB" > 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>인건비</td>
			  	    <td><input type="text" size="13" name="calC" > 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>임대비</td>
			  	    <td><input type="text" size="13" name="calD" > 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>운영비</td>
			  	    <td><input type="text" size="13" name="calE" > 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>순수익</td>
			  	    <td><input type="text" size="13" name="calT"> 원</td>
			  	  </tr>
			  	</table>
			  </div>
			  <div class="table2">
			    <h3>월 평균 수익금(1구좌당)</h3>
			    <table>
			      <tr>
			  	    <td>현금배당률</td>
			  	    <td>순수익의 <input type="text" size="1" name = "cal1" class="per"> %</td>
			  	     <td><input type="text" size="13" name = "cal2"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>지분</td>
			  	    <td><input type="text" size="1" name = "cal3" class="per"> %</td>
			  	    <td><input type="text" size="13" name = "cal4"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>플랫폼이용료</td>
			  	    <td>지분의 10.5%</td>
			  	    <td><input type="text" size="13" name = "cal5"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>예상수익금</td>
			  	    <td>지분 - 플랫폼이용료</td>
			  	    <td><input type="text" size="13" name = "cal6"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td colspan="2">월평균</td>
			  	    <td><input type="text" size="13" name = "cal7"> 원</td>
			  	  </tr>
			    </table>
			  </div>
			  <div class="table3">
			    <h3>예상지급스케쥴</h3>
			    <table>
              <tr>
                <th>지급회차</th>
                <th>예상 지급일</th>
                <th>원금</th>
                <th>지급이자</th>
                <th>플랫폼 이용료</th>
                <th>실 지급금액</th>
                <th>실 수익률</th>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr>
                <td><input type="text" size="1"> 회차</td>
                <td><input type="text" size="13" class="date"></td>
                <td><input type="text" size="13" name="sum1"> 원</td>
                <td><input type="text" size="13" name="sum2"> 원</td>
                <td><input type="text" size="13" name="sum3"> 원</td>
                <td><input type="text" size="13" name="sum4"> 원</td>
                <td><input type="text" size="2" name="sum5" class="per"> %</td>
              </tr>
              <tr class="sum">
                <td>총 합계</td>
                <td>-</td>
                <td><input type="text" size="13"name="tot1"> 원</td>
                <td><input type="text" size="13" name="tot2"> 원</td>
                <td><input type="text" size="13" name="tot3"> 원</td>
                <td><input type="text" size="13" name="tot4"> 원</td>
                <td><input type="text" size="2" name="tot5" class="per"> %</td>
              </tr>
            </table>
            <input type="button" class="add add2" value="+">
            <input type="button" class="del del2" value="-">
			  </div>
        </form>
			  <button class="submit">등록하기</button>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
      setTimeout(function () {
        jQuery('.nav3').trigger('click');
        jQuery('.nav33').addClass('on');
      }, 500);
      
      $(function(){
        $('table input').on('keyup input', function(){
          corCalculate();
        });
        
        $('table input').on('change', function(){
           var num = $(this).val();
            var numPar = Number(num.replace(/\,/g, "") || 0);
                numPar = numPar.toFixed();
                numPar = numberWithCommas(numPar);
          var numDate = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3');
            var numFix = Number(num.replace(/\,/g, "") || 0);
                numFix = numFix.toFixed(2);

            if($(this).hasClass('per')){
              $(this).val(numFix)
            }else if($(this).hasClass('date')){
              $(this).val(numDate);
            }else{
              $(this).val(numPar);
            }
            return false;
    });
        
        $('table').focusout(function(){
          $('table input').trigger('change');
        })
        
        
        //사업계획서추가
          $('.add1').click(function(){
            $(".plan").append("<p><input type='file'><input type='button' value='-' class='del del1'></p>");
          });
        //지급스케쥴 행추가
          $('.add2').click(function(){
            var cln = $('.sum').prev('tr').clone();
                cln.find('input').val('');
            $('.sum').before(cln);
          });
        //지급스케쥴 행삭제
         $('.del2').click(function(){
            $('.sum').prev('tr').remove();
          });
      });
      
      //사업계획서삭제
      $(document).on('click', '.del1', function(){
        $(this).parent('p').remove();
      });
      
      function corCalculate(){
        calA = Number(corForm.calA.value.replace(/\,/g, "") || 0);
        calB = Number(corForm.calB.value.replace(/\,/g, "") || 0);
        calC = Number(corForm.calC.value.replace(/\,/g, "") || 0);
        calD = Number(corForm.calD.value.replace(/\,/g, "") || 0);
        calE = Number(corForm.calE.value.replace(/\,/g, "") || 0);
        calT = Number(corForm.calT.value.replace(/\,/g, "") || 0);

        corForm.calT.value = calA - (calB+calC+calD+calE);

        cal1 = Number(corForm.cal1.value.replace(/\,/g, "") || 0);
        cal2 = Number(corForm.cal2.value.replace(/\,/g, "") || 0);
        cal3 = Number(corForm.cal3.value.replace(/\,/g, "") || 0);
        cal4 = Number(corForm.cal4.value.replace(/\,/g, "") || 0);
        cal5 = Number(corForm.cal5.value.replace(/\,/g, "") || 0);
        cal6 = Number(corForm.cal6.value.replace(/\,/g, "") || 0);
        cal7 = Number(corForm.cal7.value.replace(/\,/g, "") || 0);
        tot1 = Number(corForm.tot1.value.replace(/\,/g, "") || 0);
        

        corForm.cal2.value = (calT*cal1)/100;
        corForm.cal4.value = (cal2*cal3)/100;
        corForm.cal5.value = cal4*0.105;
        corForm.cal6.value = cal4 - cal5;
        corForm.cal7.value = cal6/12;
        
        
        sum1 = $('input[name=sum1]');
        sum2 = $('input[name=sum2]');
        sum3 = $('input[name=sum3]');
        sum4 = $('input[name=sum4]');
        sum5 = $('input[name=sum5]');
        res1 = 0;
        res2 = 0;
        res3 = 0;
        res4 = 0;
        res5 = 0;
        
        var i;
        
         for(i=0; i<sum1.length; i++) {
          var val = sum1.eq(i).val();
              val = Number(val.replace(/\,/g, "") || 0);
          res1 += val;
        }
        corForm.tot1.value = res1;
        for(i=0; i<sum2.length; i++) {
          var val2 = sum2.eq(i).val();
              val2 = Number(val2.replace(/\,/g, "") || 0);
          res2 += val2;
        }
        corForm.tot2.value = res2;
        for(i=0; i<sum3.length; i++) {
          var val3 = sum3.eq(i).val();
              val3 = Number(val3.replace(/\,/g, "") || 0);
          res3 += val3;
        }
        corForm.tot3.value = res3;
        for(i=0; i<sum4.length; i++) {
          var val2 = sum2.eq(i).val();
              val2 = Number(val2.replace(/\,/g, "") || 0);
          var val3 = sum3.eq(i).val();
              val3 = Number(val3.replace(/\,/g, "") || 0);
          var val4 = sum4.eq(i).val();
              val4 = Number(val4.replace(/\,/g, "") || 0);
          res4 += val4;
          sum4.eq(i).val(val2-val3);
        }
        corForm.tot4.value = res4;
        for(i=0; i<sum5.length; i++) {
          var val4 = sum4.eq(i).val();
              val4 = Number(val4.replace(/\,/g, "") || 0);
          var val5 = sum5.eq(i).val();
              val5 = Number(val5.replace(/\,/g, "") || 0);
          res5 += val5;
          sum5.eq(i).val(val4/tot1*100);
        }
        corForm.tot5.value = res5;       
        
          
   }

    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
	</script>
</body>
</html>