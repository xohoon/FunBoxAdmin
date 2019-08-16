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
		});	
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec16">
			<h2>수수료관리</h2>
			<div class="con">
			  <div>
			    <h4>플랫폼 이용료</h4>
          <p>
            <label>현재</label>
            <input type="text" value="10.5"><span>%</span>
          </p>
          <p>
            <label>변경</label>
            <input type="text"><span>%</span>
          </p>
          <input type="button" value="수정하기">
			  </div>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		setTimeout(function () {
		   jQuery('.nav5').trigger('click');
			jQuery('.nav52').addClass('on');
		}, 500);
		
	</script>
</body>
</html>