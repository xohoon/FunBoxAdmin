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
		<section id="index">
      <div>
		    <h3><i class="fas fa-user"></i>&nbsp;&nbsp;회원관리</h3>
		    <ul>
		      <li onclick="location.href='./sec01.html'">
		        <h4>회원리스트</h4>
		        <p><span>1</span> / 100</p>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		      <li onclick="location.href='./sec02.html'">
		      <h4>회원 등록하기</h4>
          <p>NEW</p>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		    </ul>
		  </div>
		  <div>
		    <h3><i class="fas fa-building"></i>&nbsp;&nbsp;기업관리</h3>
		    <ul>
		      <li onclick="location.href='./sec05.html'">
		        <h4>투자기업 신청 리스트</h4>
		        <p><span>1</span> / 100</p>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		      <li onclick="location.href='./sec06.html'">
		      <h4>기업 등록하기</h4>
          <p>NEW</p>
		        <i class="far fa-hand-pointer"> 등록하기</i>
		      </li>
		      <li onclick="location.href='./sec07.html'">
		      <h4>투자 기업 리스트</h4>
          <p>100</p>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li><br>
		      <li onclick="location.href='./sec08.html'">
		      <h4>실시간 인기순위</h4>
          <p>10</p>
		        <i class="far fa-hand-pointer"> 수정하기</i>
		      </li>
		      <li onclick="location.href='./sec09.html'">
		      <h4>추천 기업</h4>
          <p>4</p>
		        <i class="far fa-hand-pointer"> 수정하기</i>
		      </li>
		      <li onclick="location.href='./sec10.html'">
		      <h4>마감 임박 기업</h4>
          <p>3</p>
		        <i class="far fa-hand-pointer"> 수정하기</i>
		      </li>
		      <li onclick="location.href='./sec11.html'">
		      <h4>메인배너1</h4>
          <p>3</p>
		        <i class="far fa-hand-pointer"> 수정하기</i>
		      </li>
		      <li onclick="location.href='./sec12.html'">
		      <h4>메인배너2</h4>
          <p>2</p>
		        <i class="far fa-hand-pointer"> 수정하기</i>
		      </li>
		    </ul>
		  </div>
		  <div>
		    <h3><i class="fas fa-coins"></i>&nbsp;&nbsp;재정관리</h3>
		    <ul>
		      <li onclick="location.href='./sec03.html'">
		        <h4>토큰 입출금 내역</h4>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		      <li onclick="location.href='./sec04.html'">
		      <h4>포인트 환전 내역</h4>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		      <li onclick="location.href='./sec04.html'">
		      <h4>투자 내역</h4>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		    </ul>
		  </div>
		  <div>
		    <h3><i class="fas fa-headset"></i>&nbsp;&nbsp;고객지원</h3>
		    <ul>
		      <li onclick="location.href='./sec13.html'">
		        <h4>FAQ 게시판</h4>
		        <p>100</p>
		        <i class="far fa-hand-pointer"> 등록하기</i>
		      </li>
		      <li onclick="location.href='./sec14.html'">
		      <h4>1:1 문의 게시판</h4>
            <p><span>1</span> / 100</p>
		        <i class="far fa-hand-pointer"> 답변하기</i>
		      </li>
		      <li onclick="location.href='./sec15.html'">
		        <h4>공지 게시판</h4>
		        <p>100</p>
		        <i class="far fa-hand-pointer"> 등록하기</i>
		      </li>
		    </ul>
		  </div>
		  <div>
		    <h3><i class="fas fa-cog"></i>&nbsp;&nbsp;설정</h3>
		    <ul>
		      <li onclick="location.href='./sec16.html'">
		        <h4>수수료 관리</h4>
		        <i class="far fa-hand-pointer"> Click</i>
		      </li>
		    </ul>
		  </div>
		</section>
		<footer></footer>
	</div>
</body>
</html>