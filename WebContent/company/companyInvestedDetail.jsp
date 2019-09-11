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
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
			<form name="corForm" action="./modifyCompany.cp" enctype="multipart/form-data" method="post">
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
            		<p><span>ID</span>
            			<input type="text" value="${companyDetail.mb_id }" name="mb_id" id="mb_id"></p>  
            		<p><span>오픈(예정) 날짜</span>
            			<input type="date" style="width:calc((100% - 264px)/6 + 27px)" name="cp_open_datetime" id="cp_open_datetime" value="${companyDetail.cp_open_datetime }">
					<p><span>자본금</span>
            			<input type="text" name="cp_capital" value="${companyDetail.cp_capital }"></p>
					<p><span>본사주소</span>
						<input type="text" name="cp_address" placeholder="시 /지점  (예시 :부산 동래점)" value="${companyDetail.cp_address }"></p>
					<p class="api">
					  <span>위치</span>
					  <input type="text" id="cp_add_num" name="cp_add_num" placeholder="우편번호" readonly="true" value="${companyDetail.cp_add_num }">
					  <input type="button" value="주소검색" onclick="address_search();">
					  <input type="text" id="cp_add_ch" name="cp_add_ch" placeholder="주소" readonly="true" value="${companyDetail.cp_add_ch }">
					  <input type="text" id="cp_add_more" name="cp_add_more" placeholder="상세주소" value="${companyDetail.cp_add_more }">
					  <input type="text" id="cp_add_extra" name="cp_add_extra" placeholder="참조" value="${companyDetail.cp_add_extra }">
					</p>
			  </div>
			<div>
				<h3>투자정보</h3>
	            <p><span>월수익률</span><input type="text" name="cp_monthly_profit" value="${companyDetail.cp_monthly_profit }"><span>%</span></p>
	            <p><span>투자계약기간</span><input type="text" name="iv_contraction_during" value="${companyDetail.iv_contraction_during }"><span>개월</span></p>
	            <p><span>최소투자금액</span><input type="text" name="iv_min_amount" value="${companyDetail.iv_min_amount }"><span>Point</span></p>
	            <p><span>모집구좌</span><input type="text" name="iv_appl_stock" value="${companyDetail.iv_appl_stock }"><span>구좌</span></p>
	            <p><span>총모집금액</span><input type="text" name="iv_goal_amount" value="${companyDetail.iv_goal_amount }"><span>Point</span></p>
	            <%-- <p><span>모집기간</span><input type="text" name="iv_appl_day" value="${companyDetail.iv_appl_day } 일"></p> --%>
	            <p><span>모집기간</span><input type="date" style="width:calc((100% - 264px)/6 + 27px)" value="${companyDetail.iv_appl_start_date_time }" name="iv_appl_start_date_time" id="iv_appl_start_date_time"> ~ <input type="date" style="width:calc((100% - 264px)/6 + 27px)" value="${companyDetail.iv_appl_stop_date_time }" name="iv_appl_stop_date_time" id="iv_appl_stop_date_time"></p>
			</div>
			<div>
				<h3>사진등록</h3>
        		<p><span>로고</span><input type="file" name="cf_corporation_icon"><a href="./CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=2&fileName=${companyDetail.cf_alias_corporation_icon }" download>${companyDetail.cf_corporation_icon }</a></p>
				<p><span>썸네일</span><input type="file" name="cf_thumbnail"><a href="./CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=2&fileName=${companyDetail.cf_alias_thumbnail }" download>${companyDetail.cf_thumbnail }</a></p>
        		<p id="store_images"><span>매장사진</span><input type="file" multiple name="cf_store_images"></p>
			</div>
			  
			<div>
		       <h3>리워드</h3><div class="checkBox"><input type="checkbox" id="reward"><label for="reward">선택</label></div>
		       <p><span>메인타이틀</span><input type="text" readonly="true" name="cp_reward_main_title" value="${companyDetail.cp_reward_main_title }"></p>
		       <p><span>서브타이틀</span><input type="text" readonly="true" name="cp_reward_sub_title" value="${companyDetail.cp_reward_sub_title }"></p>
		       <p><span>내용</span><textarea readonly="true" name="cp_reward_content" >${companyDetail.cp_reward_content }</textarea></p>
		    </div>
		     
		     <div>
		     	<h3>기업소개</h3>
				  <p><span>기업PR배경</span><input type="file" name="cf_pr_background" ><a href="./CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=2&fileName=${companyDetail.cf_alias_pr_background }" download>${companyDetail.cf_pr_background}</a><span>930px * 780px</span></p>
			      <p><span>매장PR타이틀</span><input type="text" name="cp_intro_headline" value="${companyDetail.cp_intro_headline }"></p>
			      <p><span style="width:auto; margin-right:0;">매장PR내용</span><span style="width:auto;color:#999; margin-right:0; margin-left:8px;">(200자 내외)</span>
			    <textarea name="cp_intro_content">${companyDetail.cp_intro_content }</textarea></p>
			</div>
			
			<div class="fundingNote">
				<h3>투자노트</h3>
				<span>투자 핵심</span>
				<button type="button" class="add"><i></i></button>
				<button type="button" class="del"><i></i></button>
<!-- 				<div id="fundingPoint"> -->
					<div class="fundingPoint">
					  <h4>1.</h4>
					  <div>
					  <input type="text" name="cp_point_title">
					  <textarea name="cp_point_content"></textarea>
					  </div>
					</div>
					<!-- 투자노트 만들어 -->
				<!-- </div> -->
				<p id="planImg"><span>사업계획서(이미지)</span><input type="file" multiple name="cf_business_plan_images"><br></p>
			</div>
				
			<div>
		      <h3>참고자료</h3>
		      <p><span>사업계획서</span><input type="file" name="cf_business_plan"><a href="./CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=1&fileName=${companyDetail.cf_alias_business_plan }" download>${companyDetail.cf_business_plan}</a></p>
		      <p><span>펀딩계약서</span><input type="file" name="cf_funding_contract"><a href="./CompanyFileDownload?cp_idx=${companyDetail.cp_idx }&kindOfFile=1&fileName=${companyDetail.cf_alias_funding_contract }" download>${companyDetail.cf_funding_contract}</a></p>
		      <p id="colFile"><span>기타자료</span><input type="file" multiple name="cf_etc_files"></p>
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
			
			<div class="warning">
	           <h3>투자 시 유의사항</h3>
	           <button type="button" class="add"><i></i></button>
			   <button type="button" class="del"><i></i></button>
			   <!-- <div id="warn"> -->
			   	   <div class="warn">
					 <h4>1.</h4>
					 <div>
					 <input type="text" name="cp_notice_title">
					 <textarea name="cp_notice_content"></textarea>
					 </div>
				   </div>
				   <!-- 여기에 넣어줘야해 -->
			   <!-- </div> -->
         	</div>	
         	  <input type="hidden" name="cp_idx" value="${companyDetail.cp_idx }">		
			  </form>
        	  <button class="submit rec" id="modify">수정하기</button>
			  <button class="submit save" id="submit" onclick = "save();">저장하기</button>
			  <button class="submit cancel">취소</button>
			</div>
		</section>
</body>
<script type="text/javascript">
	var company_image_path = '${companyDetail.company_image_path}';
	var test = '${companyDetail.cf_alias_business_plan_images }'.split(',');
</script>
<script type="text/javascript">
	// 매장 사진 만들기//
	var cf_store_images = '${companyDetail.cf_store_images }'.split(',');
	var cf_alias_store_images = '${companyDetail.cf_alias_store_images }'.split(',');
	
	var store_images = document.getElementById('store_images');
	
	for (var i = 0; i < cf_alias_store_images.length; i++) {
		var aTag = document.createElement('a');
		var brTag = document.createElement('br');
		aTag.href = './CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=2&fileName=' + cf_alias_store_images[i];
		aTag.download = '다운로드';
		aTag.innerHTML = '<i></i>' + cf_store_images[i];
		
		store_images.append(aTag);
		store_images.append(brTag);
	}
	
	// 매장 사진 만들기//
	
	// 투자 노트 만들기 //
	/*
	
	*/
	// 투자 노트 만들기 //
	
	// 투자 시 유의사항 만들기 //
	
	// 투자 시 유의사항 만들기 //
</script>
<script type="text/javascript">
	$(function(){
		//$('input[type=file]').hide();
	});
	function save(){
		if ($('#cp_open_datetime').val().length <= 0) {
			alert('오픈(예정) 날짜를 입력해주세요.');
			return;
		}
		var form = document.corForm;
		
		if(confirm("해당 내용을 수정하시겠습니까?") == true){
			form.submit();
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
</script>
<script>
    //사업계획서
    $(function(){
      planRealImgArr = '${companyDetail.cf_business_plan_images }'.split(',');
      var planImg,
          //planImgArr = ['data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EA%B3%84%ED%9A%8D%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%ED%8E%80%EB%94%A9%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%9E%84%EB%8C%80%EC%B0%A8%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EA%B0%80%EB%A7%B9%ED%97%88%EA%B0%80%EC%9E%90%EB%A3%8C.txt'],
          planImgArr = '${companyDetail.cf_alias_business_plan_images }'.split(','),
          planL = planImgArr.length,
          $planImg = $('#planImg');
      for(planImg=0;planImg<planL;planImg++){
        var addImg = document.createElement('a'),
            br = document.createElement('br');
        addImg.setAttribute('href','./CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=2&fileName=' + planImgArr[planImg] );
        addImg.className = 'plani';
        $planImg.append(addImg).append(br);

      var fileUrl = planImgArr[planImg].split('/'),
          fileUrlLeng =fileUrl.length,
          fileNameFull = fileUrl[fileUrlLeng-1],
          //fileNameDec = decodeURI(fileNameFull);
          fileNameDec = planRealImgArr[planImg];
        addImg.setAttribute('download','다운로드');
        addImg.innerHTML = '<i></i>' + fileNameDec;
      }

    });
  </script>
	<script>
    //참고자료
    $(function(){
      var real_file_name_array= '${companyDetail.cf_etc_files}'.split(',');
      var corFile,
      	  corFileArr = '${companyDetail.cf_alias_etc_files}'.split(','),
          corL = corFileArr.length,
          $colFile = $('#colFile');
      for(corFile=0;corFile<corL;corFile++){
        var addFile = document.createElement('a'),
            br = document.createElement('br');
        addFile.setAttribute('href','./CompanyFileDownload?cp_idx=${companyDetail.cp_idx}&kindOfFile=2&fileName='+corFileArr[corFile]);
        addFile.className = 'corFile';
        $colFile.append(addFile).append(br);

      var fileUrl = corFileArr[corFile].split('/'),
          fileUrlLeng =fileUrl.length,
          fileNameFull = fileUrl[fileUrlLeng-1],
          fileNameDec = decodeURI(fileNameFull);
        addFile.setAttribute('download',fileNameDec);
        addFile.innerHTML = '<i></i>' + fileNameDec;

      }

    });
    
  </script>
  <script type="text/javascript">
/////////// Daum Address API ///////////
  function address_search() {
  	
  	new daum.Postcode({
          oncomplete: function(data) {
              // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

              // 각 주소의 노출 규칙에 따라 주소를 조합한다.
              // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
              var addr = ''; // 주소 변수
              var extraAddr = ''; // 참고항목 변수

              //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
              if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                  addr = data.roadAddress;
              } else { // 사용자가 지번 주소를 선택했을 경우(J)
                  addr = data.jibunAddress;
              }

              // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
              if(data.userSelectedType === 'R'){
                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                  if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                      extraAddr += data.bname;
                  }
                  // 건물명이 있고, 공동주택일 경우 추가한다.
                  if(data.buildingName !== '' && data.apartment === 'Y'){
                      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                  }
                  // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                  if(extraAddr !== ''){
                      extraAddr = ' (' + extraAddr + ')';
                  }
                  // 조합된 참고항목을 해당 필드에 넣는다.
                  document.getElementById("cp_add_extra").value = extraAddr;
              
              } else {
                  document.getElementById("cp_add_more").value = '';
              }

              // 우편번호와 주소 정보를 해당 필드에 넣는다.
              document.getElementById('cp_add_num').value = data.zonecode;
              document.getElementById("cp_add_ch").value = addr;
              // 커서를 상세주소 필드로 이동한다.
              document.getElementById("cp_add_more").focus();
          }
      }).open();

  }
  
  </script>
  <script type="text/javascript">
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
		inputTag.name='sum1';
		inputTag.defaultValue = cp_pay_count[i];
		inputTag.innerText = '회차';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum2';
		inputTag.className='date';
		inputTag.defaultValue = cp_pay_expected_payment_date[i];
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum3';
		inputTag.defaultValue = cp_pay_principal[i];
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum4';
		//inputTag.defaultValue = cp_pay_interest_paid[i];
		//inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum5';
		//inputTag.defaultValue = cp_pay_actual_payment_amout[i];
		//inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='sum6';
		//inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		tdTag = document.createElement('td');
		inputTag = document.createElement('input');
		
		inputTag.type ="text";
		inputTag.size='2';
		inputTag.name='sum7';
		inputTag.className= 'per';
		//inputTag.innerText = '%';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
		
		div_company_pay_schedule.append(trTag);
	}
	$('#company_pay_schedule').append($('#sum'));
	
	/*
	 var trTag = document.createElement('tr');
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
		
		inputTag.type ="text";
		inputTag.size='13';
		inputTag.name='tot'+i;
		inputTag.innerText = '원';
		
		tdTag.append(inputTag);
		trTag.append(tdTag);
	}
	
	tdTag = document.createElement('td');
	inputTag = document.createElement('input');
	
	inputTag.type ="text";
	inputTag.size='2';
	inputTag.name='tot5';
	inputTag.className = 'per';
	inputTag.innerText = '%';	
	
	tdTag.append(inputTag);
	trTag.append(tdTag);
	div_company_pay_schedule.append(trTag);
	*/
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
        $('input[type=file]').hide();
        $('.save').hide();
        $('.cancel').hide();
        $('.api').find('input[type=button]').hide();
        
        $('.rec').on('click', function(rectify){
          $('input').css('border','1px solid #ddd');
          $('input').prop('readonly',false);
          $('textarea').prop('readonly',false);
          $('input[type=file]').show();
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
          $('.api').find('input[type=button]').show();
          $('.sec07_1').addClass('on');
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
      //지급스케쥴 행추가
        $('.add2').click(function(){
          var cln = $('.sum').prev('tr').clone();
              cln.find('input').val('');
          cln.addClass('addTr');
          $('.sum').before(cln);
        });
      //지급스케쥴 행삭제
       $('.del2').click(function(){
          $('.sum').prev('.addTr').remove();
        });
      
      //투자포인트추가삭제
      var h4 = $('.addNote').last().index() + 3;
      $('.fundingNote').find('.add').on('click', function(){
        var noteCln = $('.fundingPoint').clone();
        noteCln.find('input').val('');
        noteCln.find('textarea').val('');
        noteCln.addClass('addNote');
        noteCln.removeClass('fundingPoint');
        noteCln.find('h4').text(h4++ + '.');
        $('.fundingNote > p').before(noteCln);
      });
      $('.fundingNote').find('.del').on('click',function(){
        $('.fundingNote > p').prev('.addNote').remove();
        h4--;
        if(h4 = 2){
          return false;
        }
      });
      
      // 박신규  투자포인트 초기화 //
      $(function(){		
  		var cp_point_title = '${companyDetail.cp_point_title}'.split('/**/');
  		var cp_point_content = '${companyDetail.cp_point_content}'.split('/**/');
  		console.log(cp_point_title);
  		for (var i = 0; i < cp_point_title.length; i++) {
  			if (i > 0) {
  				$('.fundingNote').find('.add').click();
  				var div = $('.addNote').last().children().last()[0];
  				div.children[0].value = cp_point_title[i];
  				div.children[1].value = cp_point_content[i];
			}else{
				var fundingPointDiv = document.getElementsByClassName('fundingPoint')[0].children[1];
				fundingPointDiv.children[0].value = cp_point_title[i];
				fundingPointDiv.children[1].innerText = cp_point_content[i];
			}
  		}
  	 })
  	 // 박신규  투자포인트 초기화 //
    
  	 //투자유의사항
      var H4 = $('.addWarn').last().index() + 3;
      $('.warning').find('.add').on('click', function(){
        var noteCln = $('.warn').clone();
        noteCln.find('input').val('');
        noteCln.find('textarea').val('');
        noteCln.addClass('addWarn');
        noteCln.removeClass('warn');
        noteCln.find('h4').text(H4++ + '.');
        $('.warning').append(noteCln);
      });
      $('.warning').find('.del').on('click',function(){
        $('.warning').find('.addWarn').last().remove();
        H4--;
        if(H4 = 2){
          return false;
        }
      });
      
      //투자유의사항 초기화 박신규//
      $(function(){
    	  var cp_notice_title = '${companyDetail.cp_notice_title}'.split('/**/');
    	  var cp_notice_content = '${companyDetail.cp_notice_content}'.split('/**/');
    	  for (var i = 0; i < cp_notice_title.length; i++) {
    		  if (i > 0) {
    			  	$('.warning').find('.add').click();
    				var addWarndiv = $('.addWarn').last().children().last()[0];
    				addWarndiv.children[0].value = cp_notice_title[i];
    				addWarndiv.children[1].value = cp_notice_content[i];
  			}else{
  				var warnDiv = document.getElementsByClassName('warn')[0].children[1];
  				warnDiv.children[0].value = cp_notice_title[i];
  				warnDiv.children[1].innerText = cp_notice_content[i];
  			}
		}
      })
      //투자유의사항 초기화//
        
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
</html>