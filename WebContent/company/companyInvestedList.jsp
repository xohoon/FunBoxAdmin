<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  $('.doneGroup').load('./companyInvestedDoneList.cp');
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
          <li class="on">펀딩진행</li>
          <li>펀딩완료</li>
        </ul>
			  <div class="ingGroup">
          <table>
            <tr>
              <th>상호명</th>
              <th>아이디</th>
              <th>담당자</th>
              <th>연락처</th>
              <th>수익률</th>
              <th>마감</th>
              <th>잔여구좌</th>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
            <tr>
              <td onclick="window.open('./sec07_1.jsp','dkdlel','width=1600,height=720,top=0,left=0,scrollbars=yes');">바른생선회</td>
              <td>dkdlel</td>
              <td>아이오</td>
              <td>010-1234-5678</td>
              <td>11%</td>
              <td>D-27</td>
              <td>5</td>
            </tr>
          </table>
          <a href="#" class="prev"><i class="fas fa-caret-left"></i></a>
          <ul class="pager">
            <li class="on"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
          </ul>
          <a href="#" class="next"><i class="fas fa-caret-right"></i></a>
        </div>
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
      $('.tab li').click(function(){
				$('.tab li').removeClass('on');
				$(this).addClass('on');
			});
      
      $('.tab li').eq(0).click(function(){
        $('.ingGroup').show();
        $('.doneGroup').hide();
      });
      $('.tab li').eq(1).click(function(){
        $('.doneGroup').show();
        $('.ingGroup').hide();
      });
      
      $('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
    });
    

    
	</script>
</body>
</html>ㄴ