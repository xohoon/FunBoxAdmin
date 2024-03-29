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
	<script type="text/javascript" src="member/js/memberRegisterForm.js"></script>
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
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec02">
			<h2>회원등록</h2>
			<div class="con">
				<div>
				<label>아이디</label>
				<input id="mb_id" type="text" maxlength="15" placeholder="영문 또는 영문/숫자 조합, 6~15자리 등록가능합니다." autocomplete="off">
				<input id="check_duplication_ID" type="button" value='중복확인'>
			  </div>
			  <!--#id-->
			  <div>
				<label>비밀번호</label>
				<input id="mb_pw" type="password" maxlength="15" placeholder="영문/숫자/특수문자 조합, 8~15자리 등록가능합니다." autocomplete="off">
			  </div>
			  <!--pw-->
			  <!-- <div>
				<label>비밀번호 확인</label>
				<input id="mb_pw_check" type="password" maxlength="15" placeholder="비밀번호를 한번 더 입력해주세요.">
			  </div> -->
			  <!--pwssword check-->
			  <div>
				<label>Pin code</label>
				<input id="mb_pincode" type="password" maxlength="6" placeholder="숫자 6자리 등록가능합니다.">
			  </div>
			  <!--pin-->
			  <!-- <div>
				<label>Pin code 확인</label>
				<input id="mb_pincode_check" type="password" maxlength="6" placeholder="핀코드를 한번 더 입력해주세요.">
			  </div> -->
			  <!--pwssword check-->
			  <div>
				<label>E-mail</label>
				<input id="mb_email" type="text" maxlength="35" placeholder="이메일을 입력해주세요.">
			  </div>
			  <!--email-->
				<div>
				<label>성명</label>
				<input id="mb_name" type="text" maxlength="10" placeholder="이름을 입력해주세요.">
				</div><!--#name-->
				<div>
				<label>휴대전화번호</label>
				<input id="mb_phone" type="text" maxlength="11" placeholder="'-'없이 11자리 입력해주세요.">
				</div><!--#ph-->
				<div>
					<label>주소</label>
					<input id="mb_add_num" type="text" placeholder="우편번호" readonly="readonly">
					<input id="search_post" type="button" value="우편번호 찾기"><br>
					<input id="mb_add_ch" type="text" class="adr2" placeholder="주소" readonly="readonly"><br>
					<input id="mb_add_more" type="text" class="adr3" placeholder="상세주소"><br>
					<input id="mb_add_extra" type="text" class="adr4" placeholder="참고항목">
					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
				</div><!--adderess-->
			  <div>
				<label>추천인 ID(선택)</label>
				<input id="mb_recommend" type="text" placeholder="추천인 ID를 입력해주세요.">
			  </div><!--추천인-->
			  <button id="registe" class="submit">등록하기</button>
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		setTimeout(function () {
		   jQuery('.nav1').trigger('click');
		   jQuery('.nav13').addClass('on');
		}, 500);
	</script>
</body>
</html>