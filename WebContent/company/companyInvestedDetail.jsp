<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
</head>

<body>
	<section id="sec06" class="sec07_1">
			<h2>기업정보</h2>
			<div class="con">
			<form name="corForm" action="./modifyCompany.cp" method="post">
				<div>
					<h3>기업이름</h3>
					<select name="cp_sector" id="cp_sector">
						<option>- 구분 -</option>
						<option value="일반음식점">일반음식점</option>
						<option value="카페">카페</option>
						<option value="등등">등등</option>
					</select>
					<input type="text" name="cp_name" placeholder="브랜드명" value="${companyDetail.cp_sector }">
					<input type="text" name="cp_branch" placeholder="지점" value="${companyDetail.cp_branch }">
			   </div>
			   <div>
					<h3>기본정보</h3>
					<p><span>대표자</span>
            <input type="text" name="cp_manager" value="${companyDetail.cp_manager }"></p>
					<p><span>사업자등록번호</span>
            <input type="text" name="cp_number" value="${companyDetail.cp_number }"></p>
					<p><span>자본금</span>
            <input type="text" name="cp_capital" value="${companyDetail.cp_capital }"></p>
					<p><span>본사주소</span>
					<input type="text" name="cp_address" value="${companyDetail.cp_address }"></p>
			  </div>
			  <div>
					<h3>투자정보</h3>
            <p><span>월수익률</span><input type="text" name="cp_monthly_profit" value="${companyDetail.cp_monthly_profit }"> %</p>
            <p><span>투자계약기간</span><input type="text" name="iv_contraction_during" value="${companyDetail.iv_contraction_during }"> 개월</p>
            <p><span>최소투자금액</span><input type="text" name="iv_min_amount" value="${companyDetail.iv_min_amount }"> Point</p>
            <p><span>모집구좌</span><input type="text" name="iv_appl_stock" value="${companyDetail.iv_appl_stock }"> 구좌</p>
            <p><span>총모집금액</span><input type="text" name="iv_goal_amount" value="${companyDetail.iv_goal_amount }"> Point</p>
            <p><span>모집기간</span><input type="text" name="iv_appl_day" value="${companyDetail.iv_appl_day }"> 일</p>
			  </div>
				<div>
					<h3>사진등록</h3>
					<p><span>썸네일</span><input type="file" name="cf_thumbnail"><a href="/CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=2&fileName=${companyDetail.cf_alias_thumbnail}" download>${companyDetail.cf_thumbnail }</a>
          <span>910px * 780px :: 상호나 간판이 정중앙에 오도록 편집 후 업로드 ::</span></p>
          			<div id="cf_store_images">
          				<!-- <p><span>매장사진1</span><input type="file"><a href="#" download>1.jpg</a>
	          <span>930px * 310px</span></p>
						<p><span>매장사진2</span><input type="file"><a href="#" download>1.jpg</a>
	          <span>930px * 310px</span></p>
						<p><span>매장사진3</span><input type="file"><a href="#" download>1.jpg</a>
	          <span>445px * 310px</span></p>
						<p><span>매장사진4</span><input type="file"><a href="#" download>1.jpg</a>
	          <span>445px * 310px</span></p> -->
          			</div>
          			<p id="multi_cf_store_images"></p>
					<p><span>기업PR배경</span><input type="file" name="cf_pr_background"><a href="/CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=2&fileName=${companyDetail.cf_alias_pr_background}" download>${companyDetail.cf_pr_background }</a>
          <span>930px * 780px</span></p>
          <p><span>매장PR타이틀</span><input type="text" name="cp_point_title" value="${companyDetail.cp_intro_headline}"></p>
					<span>매장PR내용</span>
          <p><textarea name="cp_point_content">${companyDetail.cp_intro_content}</textarea>
          <span>250자 내외</span></p>
				</div>
				<div class="plan">
					<h3>사업계획서 파일</h3>
					<p><span>사업계획서</span><input type="file" name="cf_business_plan"><a href="/CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=1&fileName=${companyDetail.cf_alias_business_plan}" download>${companyDetail.cf_business_plan }</a></p>
				</div>
				<div class="plan" id="plan_images">
					<h3>사업계획서 사진</h3>
					<div id="plan"></div>
				</div>
			  <div id="etc">
         		<h3>참고자료</h3>
         		<div id="cf_etc_files"></div>
			  </div>
			  <div class="table1">
			  	<h3>손익상세</h3>
			  	<table>
					<tr>
					  <td>기준년월</td>
					  <td><input type="text" name="pl_year" size="4" placeholder="19" maxlength="2" value="${companyDetail.pl_year }"> 년 <input type="text" name="pl_month" size="1" value="${companyDetail.pl_month }"> 월</td>
					</tr>
					<tr>
					  <td>매출</td>
					  <td><input type="text" size="13" name="calA" value="${companyDetail.pl_sales }"> 원</td>
					</tr>
					<tr>
					  <td>원재료</td>
					  <td><input type="text" size="13" name="calB"  value="${companyDetail.pl_material }"> 원</td>
					</tr>
					<tr>
					  <td>인건비</td>
					  <td><input type="text" size="13" name="calC"  value="${companyDetail.pl_person_pay}"> 원</td>
					</tr>
					<tr>
					  <td>임대비</td>
					  <td><input type="text" size="13" name="calD"  value="${companyDetail.pl_rent_building}"> 원</td>
					</tr>
					<tr>
					  <td>운영비</td>
					  <td><input type="text" size="13" name="calE"  value="${companyDetail.pl_operating_pay}"> 원</td>
					</tr>
					<tr>
					  <td>순수익</td>
					  <td><input type="text" size="13" name="calT" value="${companyDetail.pl_net_revenue}"> 원</td>
					</tr>
			  	</table>
			  </div>
			  <div class="table2">
			    <h3>월 평균 수익금(1구좌당)</h3>
			    <table>
			      <tr>
			  	    <td>현금배당률</td>
			  	    <td>순수익의 <input type="text" size="1" name = "cal1" class="per" value="${companyDetail.ma_odds_percent }"> %</td>
			  	     <td><input type="text" size="13" name = "cal2" value="${companyDetail.ma_odds_money }"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>지분</td>
			  	    <td><input type="text" size="1" name = "cal3" class="per" value="${companyDetail.ma_share_percent }"> %</td>
			  	    <td><input type="text" size="13" name = "cal4" value="${companyDetail.ma_share_money }"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>플랫폼이용료</td>
			  	    <td>지분의 10.5%</td>
			  	    <td><input type="text" size="13" name = "cal5" value="${companyDetail.ma_platform_pay }"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td>예상수익금</td>
			  	    <td>지분 - 플랫폼이용료</td>
			  	    <td><input type="text" size="13" name = "cal6" value="${companyDetail.ma_estimated_revenue }"> 원</td>
			  	  </tr>
			  	  <tr>
			  	    <td colspan="2">월평균</td>
			  	    <td><input type="text" size="13" name = "cal7" value="${companyDetail.ma_monthly_average }"> 원</td>
			  	  </tr>
			    </table>
			  </div>
			  <div class="table3">
			    <h3>예상지급스케쥴</h3>
			    <table>
			    	<tbody id="company_pay_schedule">
			    		<tr id="abc">
			                <th>지급회차</th>
			                <th>예상 지급일</th>
			                <th>원금</th>
			                <th>지급이자</th>
			                <th>플랫폼 이용료</th>
			                <th>실 지급금액</th>
			                <th>실 수익률</th>
			           </tr>
			              <tr class="sum" id="sum">
			                <td>총 합계</td>
			                <td>-</td>
			                <td><input type="text" size="13"name="tot1"> 원</td>
			                <td><input type="text" size="13" name="tot2"> 원</td>
			                <td><input type="text" size="13" name="tot3"> 원</td>
			                <td><input type="text" size="13" name="tot4"> 원</td>
			                <td><input type="text" size="2" name="tot5" class="per"> %</td>
			              </tr>
			    	</tbody>              
            	</table>
            <input type="button" class="add add2" value="+">
            <input type="button" class="del del2" value="-">
			  </div>
			  <input type="hidden" name="cp_idx" value="${companyDetail.cp_idx }">
        </form>
        <button class="submit rec" id="modify">수정하기</button>
			  <button class="submit save" id="submit" onclick = "save();">저장하기</button>
			  <button class="submit cancel">취소</button>
			</div>
		</section>
	<script type="text/javascript">
	$(function(){
		$('input[type=file]').hide();
	});
	document.getElementById('modify').addEventListener('click',function(){
		//박신규
	    $('#cf_store_images').hide();
	    $('#plan').hide();
	    $('#multi_cf_store_images').append('<span>매장 사진</span><input type=file multiple name="cf_store_images"><span></span>');
	    $('#plan').hide();
	    $('#plan_images').append('<p><span>사업 계획서 사진</span><input type=file multiple name="cf_business_plan_images"><span></span>');
	    $('#cf_etc_files').hide();
	    $('#etc').append('<p><span>참고 자료</span><input type=file multiple name="cf_etc_files"><span></span>');
	});
	
	function save(){
		var form = document.corForm;
		
		if(confirm("해당 내용을 수정하시겠습니까?") == true){
    		form.submit();
    	}else{
    		alert("답변을 취소 하였습니다.");
    	}
	}
	
	$(function(){
		var cp_sector = '${companyDetail.cp_sector }';
		var select_cp_sector = document.getElementById('cp_sector')
		switch (cp_sector) {
		case '일반음식점':
			select_cp_sector.selectedIndex  = 1;
			break;
		case '카페':
			select_cp_sector.selectedIndex  = 2;
			break;
		default:
			select_cp_sector.selectedIndex  = 3;
			break;
		}
	})
	var cp_idx = '${companyDetail.cp_idx }';
	
	
	//매장사진
	var cf_store_images = '${companyDetail.cf_store_images}'.split(',');
	var cf_alias_store_images = '${companyDetail.cf_alias_store_images}'.split(',');
	
	var div_cf_store_images = $('#cf_store_images');
	
	var store_images_html = "";
	
	for (var i = 0; i < cf_alias_store_images.length; i++) {
		store_images_html += "<p><span>매장사진"+(i+1)+"</span><input type='file'><a href='/CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=2&fileName="+cf_alias_store_images[i]+"' download>"
		store_images_html += cf_store_images[i];
		if (i < 2) {
			store_images_html += "</a><span>930px * 310px</span></p>"
		}else if (i < 4) {
			store_images_html += "</a><span>445px * 310px</span></p>"
		}else{
			store_images_html += "</a><span>자유</span></p>"
		}
	}
	
	$('#cf_store_images').html(store_images_html);
	
	//사업계획서
	var div_plan = document.getElementById('plan');
	
	var cf_business_plan_images = '${companyDetail.cf_business_plan_images}'.split(',');
	var cf_alias_business_plan_images = '${companyDetail.cf_alias_business_plan_images}'.split(',');

	for (var i = 0; i < cf_alias_business_plan_images.length; i++) {
		var pTag = document.createElement('p');
		var inputTag = document.createElement('input');
		inputTag.type = 'file';
		var aTage = document.createElement('a');
		aTage.href = '/CompanyFileDownload?cp_idx='+cp_idx+'&kindOfFile=2&fileName='+cf_alias_business_plan_images[i]+'';
		//수정해줘야함
		aTage.text = cf_business_plan_images[0];
		
		pTag.append(inputTag);
		pTag.append(aTage);
		
		div_plan.append(pTag);
		
	} 
	
	//참고 자료
	var div_cf_etc_files = document.getElementById('cf_etc_files');
	
	var cf_etc_files = '${companyDetail.cf_etc_files}'.split(',');
	var cf_alias_etc_files = '${companyDetail.cf_alias_etc_files}'.split(',');
	
	for (var i = 0; i < cf_alias_etc_files.length; i++) {
		var pTag = document.createElement('p');
		var inputTag = document.createElement('input');
		inputTag.type = 'file';
		//inputTag.name = 'cf_etc_files';
		var aTage = document.createElement('a');
		aTage.href = '/CompanyFileDownload?cp_idx='+cp_idx+'&kindOfFile=1&fileName='+cf_etc_files[i]+'';
		aTage.text = cf_etc_files[i];
		
		pTag.append(inputTag);
		pTag.append(aTage);
		
		div_cf_etc_files.append(pTag);
		
	}
	
	//예상지급스케쥴
	var div_company_pay_schedule = document.getElementById('company_pay_schedule');
	
	var cp_pay_count = '${companyDetail.cp_pay_count}'.split('/**/');
	var cp_pay_expected_payment_date = '${companyDetail.cp_pay_expected_payment_date}'.split('/**/');
	var cp_pay_principal = '${companyDetail.cp_pay_principal}'.split('/**/');
	var cp_pay_interest_paid = '${companyDetail.cp_pay_interest_paid}'.split('/**/');
	var cp_pay_fees = '${companyDetail.cp_pay_fees}'.split('/**/');
	var cp_pay_actual_payment_amout = '${companyDetail.cp_pay_actual_payment_amout}'.split('/**/');
	var cp_pay_actual_rate_return = '${companyDetail.cp_pay_actual_rate_return}'.split('/**/');
	
	for (var i = 0; i < cp_pay_count.length; i++) {
		var trTag = document.createElement('tr');
		var tdTag = document.createElement('td');
		var inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size = "1";
		inputTag.defaultValue = cp_pay_count[i];
		inputTag.innerText = '회차';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.className='date';
		inputTag.defaultValue = cp_pay_expected_payment_date[i];
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum1';
		inputTag.defaultValue = cp_pay_principal[i];
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum2';
		inputTag.defaultValue = cp_pay_interest_paid[i];
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum3';
		inputTag.defaultValue = cp_pay_actual_payment_amout[i];
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum4';
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='2';
		inputTag.name='sum5';
		inputTag.className= 'per';
		inputTag.innerText = '%';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		div_company_pay_schedule.append(trTag);
	}
	$('#company_pay_schedule').append($('#sum'));
	/* var trTag = document.createElement('tr');
	var tdTag = document.createElement('td');
	var inputTag = document.createElement('input');
	
	trTag.className = 'sum';
	tdTag.innerText= '총 합계';
	
	trTag.append(tdTag);
	
	tdTag = document.createElement('td');
	inputTag = document.createElement('input');
	
	tdTag.innerText='-';
	trTag.append(tdTag);	
	
	for (var i = 1; i <= 4; i++) {
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		nputTag.type ="text";
		inputTag.size='13';
		inputTag.name='tot'+i;
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
	}
	
	tdTag = document.createElement('td');
	inputTag = document.createElement('input');
	
	nputTag.type ="text";
	inputTag.size='2';
	inputTag.name='tot5';
	inputTag.className = 'per';
	inputTag.innerText = '%';	
	
	tdTag.append(inputTag);
	trTag.append(tdTag);
	div_company_pay_schedule.append(trTag); */
	</script>	
	<script>
      $(function(){
        $('table input').on('keyup input', function(){
          corCalculate();
        });
        
        $('input').keyup();
        
        $('table input').each(function(){
          var num = $(this).val();
            var numPar = Number(num.replace(/\,/g, "") || 0);
                numPar = numPar.toFixed();
                numPar = numberWithCommas(numPar);
            var numFix = Number(num.replace(/\,/g, "") || 0);
                numFix = numFix.toFixed(2);
            var numDate = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3');

            if($(this).hasClass('per')){
              $(this).val(numFix)
            }else if($(this).hasClass('date')){
              $(this).val(numDate);
            }else{
              $(this).val(numPar);
            }
        });
        
        //수정하기
        $('input').prop('readonly',true);
        $('textarea').prop('readonly',true);
        $('.save').hide();
        $('.cancel').hide();
        
        $('.rec').on('click', function(rectify){
          $('input').css('border','1px solid #ddd');
          $('input').prop('readonly',false);
          $('textarea').prop('readonly',false);
          $('input[type=file]').show();
          
          
          
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
        });
        
        $('.cancel').on('click', function(){
            location.reload();
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
            $(".plan").append("<p><input type='file'><button>-</button></p>");
            $(this).parent().siblings('p').find('button').addClass('del del1');
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
      $(document).on('click', '.rmv1', function(){
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