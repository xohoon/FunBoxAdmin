<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="net.company.dto.CompanyBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script type="text/javascript" src="company/js/companyInvestDetailFunded.js"></script>
	<script src="js/jquery-3.1.1.min.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/cor_info.css" rel="stylesheet">
</head>

<body>
		<section>
			<div class="con">
			<div>
          <ul>
            <li>
              <img src="img/ico_fin1.jpg" alt="투자현황">
              <p>기업명</p>
              <span>${companyBean.cp_name}<span>${companyBean.cp_branch}</span></span>
            </li>
            <li>
              <img src="img/ico_fin2.jpg" alt="투자현황">
              <p>보유구좌</p>
              <span>5구좌</span>
            </li>
            <li>
              <img src="img/ico_fin3.jpg" alt="투자현황">
              <p>구좌가치</p>
              <span>50,000P</span>
            </li>
            <li>
              <img src="img/ico_fin4.jpg" alt="투자현황">
              <p>당월수익</p>
              <span>30,000P</span>
            </li>
            <li>
              <img src="img/ico_fin5.png" alt="투자현황">
              <p>누적수익</p>
              <span>30,000P</span>
            </li>
          </ul>
          <div class="cor_info">
            <h5>기업정보</h5>
            <div>
              <h6>기본정보</h6>
              <table>
                <tr>
                  <td>대표자</td>
                  <td>${companyBean.cp_manager}</td>
                </tr>
                <tr>
                  <td>사업자 등록번호</td>
                  <td>${companyBean.cp_number}</td>
                </tr>
                <tr>
                  <td>자본금</td>
                  <td><fmt:formatNumber value="${companyBean.cp_capital}" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <td>본사주소</td>
                  <td>${companyBean.cp_add_ch} ${companyBean.cp_add_more}</td>
                </tr>
              </table>
            </div>
            <div>
              <h6>위치보기</h6>
              <div id="daumRoughmapContainer1567051096650" class="root_daum_roughmap root_daum_roughmap_landing"></div>
            </div>
            <div class="rep">
              <h6>예상 지급 스케쥴</h6>
              <div>
                <table id="tableId">
                  <tr>
                    <th>지급회차</th>
                    <th>예상 지급일</th>
                    <th>원금</th>
                    <th>지급이자</th>
                    <th>플랫폼 이용료</th>
                    <th>실 지급금액</th>
                    <th>실 수익률</th>
                  </tr>
                <tbody id="body_id">
	                <tr id="pre_pay_schedule">
	                  <td>${companyBean.cp_pay_count}</td>
	                  <td>${companyBean.cp_pay_expected_payment_date}</td>
	                  <td>${companyBean.cp_pay_principal}</td>	                  
	                  <td>${companyBean.cp_pay_interest_paid }</td>
	                  <td>${companyBean.cp_pay_fees }</td>
	                  <td>${companyBean.cp_pay_actual_payment_amout }</td>
	                  <td>${companyBean.cp_pay_actual_rate_return }</td>
	                </tr>
	            </tbody>
                <tfoot class="foot_id">
		            <tr>
	                  <th>총 합계</th>
	                  <th>-</th>
	                  <th>${companyBean.cp_total_sum_pay_principal}</th>	                  
	                  <th>${companyBean.cp_total_sum_pay_interest_paid }</th>
	                  <th>${companyBean.cp_total_sum_pay_fees }</th>
	                  <th>${companyBean.cp_total_sum_pay_actual_payment_amout }</th>
	                  <th>${companyBean.cp_total_sum_actual_rate_return }</th>
	                </tr>
                </tfoot>
                </table>
              </div>
            </div>
          </div>
          <div class="pay">
        <h5>지급내역</h5>
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
                    <td>1 회차</td>
                    <td>2019.09.01</td>
                    <td>0원</td>
                    <td>25,111원</td>
                    <td>2,636원</td>
                    <td>22,475원</td>
                    <td>0.75%</td>
                  </tr>
                  <tr>
                    <td>2 회차</td>
                    <td>2019.10.01</td>
                    <td>0원</td>
                    <td>25,948원</td>
                    <td>2,724원</td>
                    <td>23,224원</td>
                    <td>0.77%</td>
                  </tr>
                  <tr>
                    <td>3 회차</td>
                    <td>2019.11.01</td>
                    <td>0원</td>
                    <td>25,111원</td>
                    <td>2,636원</td>
                    <td>22,475원</td>
                    <td>0.75%</td>
                  </tr>
                  <tr>
                    <td>4 회차</td>
                    <td>2019.12.01</td>
                    <td>0원</td>
                    <td>25,948원</td>
                    <td>2,724원</td>
                    <td>23,224원</td>
                    <td>0.77%</td>
                  </tr>
                  <tr>
                    <td>총 합계</td>
                    <td>-</td>
                    <td><span class="total">3,000,000</span>원</td>
                    <td>305,520원</td>
                    <td>32,080원</td>
                    <td>273,470원</td>
                    <td>9.13%</td>
                  </tr>
                </table>
      </div>
          <div class="file">
        <h5>참고자료</h5>
      </div>
       <form name="addForm">
         <div>
          <h5>실사 자료 입력</h5>
           <h6>월별 제무제표 추가</h6>
           <input type="file">
           <h6>지급내역추가</h6>
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
           </table>
           <input type="button" class="add" value="+">
            <input type="button" class="del" value="-">
         </div>
       </form>
        </div>
        <button class="submit rec">수정하기</button>
			  <button class="submit save">저장하기</button>
			  <button class="submit cancel">취소</button>
      </div>
	</section>
	<script>      
        $(function(){
        //수정하기
        $('.save').hide();
        $('.cancel').hide();
          $('form').hide();
        
        $('.rec').on('click', function(rectify){
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
          $('form').show();
        });
        
        $('.cancel').on('click', function(){
            location.reload();
        });
        
        $('table').focusout(function(){
          $('table input').trigger('change');
        })
          $('table').on('keyup input', function(){
          corCalculate();
          });
        //행추가
          $('.add').click(function(){
            var cln = $('Form').find('tr').last().clone();
                cln.find('input').val('');
            cln.addClass('addTr');
            $('Form').find('table').append(cln);
          });
        //행삭제
         $('.del').click(function(){
            if($('form tr').length > 2){
              $('form').find('tr').last().remove();
            }
          });
        
        
        
      });
      
      
      function corCalculate(){
        
        sum1 = $('input[name=sum1]');
        sum2 = $('input[name=sum2]');
        sum3 = $('input[name=sum3]');
        sum4 = $('input[name=sum4]');
        sum5 = $('input[name=sum5]');
        res1 = 0;
        
        var i;
        
        for(i=0; i<sum4.length; i++) {
          var val2 = sum2.eq(i).val();
              val2 = Number(val2.replace(/\,/g, "") || 0);
          var val3 = sum3.eq(i).val();
              val3 = Number(val3.replace(/\,/g, "") || 0);
          var val4 = sum4.eq(i).val();
              val4 = Number(val4.replace(/\,/g, "") || 0);
          sum4.eq(i).val(val2-val3);
        }
        for(i=0; i<sum5.length; i++) {
          var val4 = sum4.eq(i).val();
              val4 = Number(val4.replace(/\,/g, "") || 0);
          var val5 = sum5.eq(i).val();
              val5 = Number(val5.replace(/\,/g, "") || 0);
          var val1 = sum1.eq(i).val();
              val1 = Number(val1.replace(/\,/g, "") || 0);
          res1 += val1;
          var total = $('.total').text();
          total = Number(total.replace(/\,/g, "") || 0);
          total = total + res1;
          sum5.eq(i).val(val4/total*100);
        }      
        
          console.log(total);
   }

	</script>
	<script>
    //참고자료
    $(function(){
      var corFile,
          corFileArr = ['data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EA%B3%84%ED%9A%8D%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%ED%8E%80%EB%94%A9%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%9E%84%EB%8C%80%EC%B0%A8%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EA%B0%80%EB%A7%B9%ED%97%88%EA%B0%80%EC%9E%90%EB%A3%8C.txt'],
          corL = corFileArr.length,
          $fileWrap = $('.file');
      for(corFile=0;corFile<corL;corFile++){
        var addFile = document.createElement('a');
        addFile.setAttribute('href',corFileArr[corFile]);
        addFile.className = 'corFile';
        $fileWrap.append(addFile);
        
      var fileUrl = corFileArr[corFile].split('/'),
          fileUrlLeng =fileUrl.length,
          fileNameFull = fileUrl[fileUrlLeng-1],
          fileNameDec = decodeURI(fileNameFull);
        addFile.setAttribute('download',fileNameDec);
        addFile.innerHTML = '<i></i>' + fileNameDec + '<i></i>';
        
      }
      
    });
  </script>
</body>
</html>