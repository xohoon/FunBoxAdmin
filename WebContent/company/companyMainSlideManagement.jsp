<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/admin.css" rel="stylesheet">
	<script>
	  $(function() {
		  $('header').load('./header.html')
		  $('#gnb').load('./gnb.html')
		  $('footer').load('./footer.html')
          $('.allList').load('./all_group.html');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec08">
			<h2>메인슬라이드관리</h2>
			<div class="con">
				<div class="all">
                  <h3>전체목록</h3>
                  <div class="sch">
				    <input type="text">
				    <button><i class="fas fa-search"></i></button>
			       </div>
                  <div class="allList"></div>
				</div>
				<div class="top">
                  <h3>메인배너1</h3>
                  <ul class="push">
                    <li>
                      <input type="radio" name="push" id="auto" value="자동" checked>
                      <label for="auto">자동</label>
                    </li>
                    <li>
                      <input type="radio" name="push" id="man" value="수동">
                      <label for="man">수동</label>
                    </li>
                  </ul>
                   <div class="topList">
                     <table>
                       <tr>
                         <th>번호</th>
                         <th>상호명</th>
                         <th>아이디</th>
                         <th>담당자</th>
                         <th></th>
                         <th></th>
                       </tr>
                       <tr>
                         <td>1</td>
                         <td></td>
                         <td></td>
                         <td></td>
                         <td><button class="topDelBtn">삭제</button></td>
                         <td>
                           <button class="upBtn"><i class="fas fa-chevron-up"></i></button>
                           <button class="downBtn"><i class="fas fa-chevron-down"></i></button>
                          </td>
                       </tr>
                       <tr>
                         <td>2</td>
                         <td></td>
                         <td></td>
                         <td></td>
                         <td><button class="topDelBtn">삭제</button></td>
                         <td>
                           <button class="upBtn"><i class="fas fa-chevron-up"></i></button>
                           <button class="downBtn"><i class="fas fa-chevron-down"></i></button>
                          </td>
                       </tr>
                       <tr>
                         <td>3</td>
                         <td></td>
                         <td></td>
                         <td></td>
                         <td><button class="topDelBtn">삭제</button></td>
                         <td>
                           <button class="upBtn"><i class="fas fa-chevron-up"></i></button>
                           <button class="downBtn"><i class="fas fa-chevron-down"></i></button>
                          </td>
                       </tr>
                     </table>
                   </div>
                </div>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>  
setTimeout(function () {
  jQuery('.nav3').trigger('click');
  jQuery('.nav38').addClass('on');
}, 500);
    
        
        
    

    
	</script>
</body>
</html>