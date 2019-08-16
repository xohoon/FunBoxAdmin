<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav>
			<a class="nav1" href="#"><i class="fas fa-user"></i>&nbsp;&nbsp;회원관리<span>+</span></a>
			<ul class="nav11">
				<li class="nav12" onclick="location.href='./memberList.mb'">회원 리스트</li>
				<li class="nav13" onclick="location.href='./memberRegister.mb'">회원 등록</li>
			</ul>
			<a href="#" class="nav2"><i class="fas fa-coins"></i>&nbsp;&nbsp;재정관리<span>+</span></a>
			<ul class="nav21">
				<li class="nav22" onclick="location.href='./tokenWithdrawalList.fn'">토큰 입출금 내역</li>
				<li class="nav23" onclick="location.href='./tokenExchangeList.fn'">포인트 환전 내역</li>
				<li class="nav24" onclick="location.href='./memberInvestedList.mb'">투자 내역</li>
			</ul>
			<a href="#" class="nav3"><i class="fas fa-building"></i>&nbsp;&nbsp;투자기업관리<span>+</span></a>
			<ul class="nav31">
			  <li class="nav32" onclick="location.href='./companyInvestApplyList.cp'">투자 기업 신청 리스트</li>
				<li class="nav33" onclick="location.href='./companyRegister.cp'">기업 등록</li>
				<li class="nav34" onclick="location.href='./companyInvestedList.cp'">투자 기업 리스트</li>
				<li class="nav35" onclick="location.href='./companyPopularityManagement.cp'">실시간 인기순위 관리</li>
				<li class="nav36" onclick="location.href='./companyRecomnandManagement.cp'">추천 기업 관리</li>
				<li class="nav37" onclick="location.href='./companyDeadLineManagement.cp'">마감 임박 기업 관리</li>
				<li class="nav38" onclick="location.href='./companyMainSlideManagement.cp'">메인배너1 관리</li>
				<li class="nav39" onclick="location.href='./companyBannerManagement.cp'">메인배너2 관리</li>
			</ul>
			<a href="#" class="nav4"><i class="fas fa-headset"></i>&nbsp;&nbsp;고객지원관리<span>+</span></a>
			<ul class="nav41">
				<li class="nav42" onclick="location.href='./faqBoard.cu'">FAQ 게시판</li>
				<li class="nav43" onclick="location.href='./inquiryBoard.cu'">1:1문의 게시판</li>
				<li class="nav44" onclick="location.href='./noticeBoard.cu'">공지 게시판</li>
			</ul>
			<a href="#" class="nav5"><i class="fas fa-cog"></i>&nbsp;&nbsp;설정 관리<span>+</span></a>
			<ul class="nav51">
				<li class="nav52" onclick="location.href='./feesManagement.st'">수수료관리</li>
			</ul>
		</nav><!--gnb-->
		<script>
			$('nav > a').click(function(){
				$('nav > a').removeClass('on');
				$(this).addClass('on');
				$('nav > ul').removeClass('on');
				$(this).next('ul').addClass('on');
			});
		</script>