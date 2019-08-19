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
	<script src="customer/js/faqBoard.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<%
		int category = (Integer)request.getAttribute("caetgory");
	%>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec13">
			<h2>FAQ게시판</h2>
			<div class="con">
			<select id="selectBox">
			  <option value="0">- 전체 -</option>
			  <option value="1">입출금 관련</option>
			  <option value="2">투자 관련</option>
			  <option value="3">기타</option>
			</select>
			<button class="write" onclick="window.open('./faqRegister.cu','게시물등록','width=840,height=640,top=0,left=0,scrollbars=yes');">게시물등록</button>
			<button>비활성화</button>
			<button>활성화</button>
				<table>
					<tr>
					  <th></th>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록날짜</th>
						<th>활성여부</th>
					</tr>
								
					<c:set var="cate" value="${category}"/>
					<c:if test="${cate == 0}">
					<c:forEach var="faq_list" items="${faq}">
					<tr>
            		  <td><input type="checkbox"></td>
					  <td>${faq_list.idx}</td>
					  <c:choose>
					  <c:when test="${faq_list.category == 1}">
					  <td>입출금</td>
					  </c:when>
					  <c:when test="${faq_list.category == 2}">
					  <td>투자</td>
					  </c:when>
					  <c:otherwise>
					  <td>기타</td>
					  </c:otherwise>
					  </c:choose>
					  <td onclick="window.open('./faqModifyForm.cu?idx=${faq_list.idx}','자주묻는질문','width=800,height=720,top=0,left=0,scrollbars=yes');">${faq_list.title}</td>
					  <td>${faq_list.mb_name }</td>
					  <td>${faq_list.reg_date_time}</td>
					  <td>Yes</td>
					</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${cate == 1}">
					<c:forEach var="faq_list" items="${faq}">
					<tr>
            		  <td><input type="checkbox"></td>
					  <td>${faq_list.idx}</td>
					  <c:choose>
					  <c:when test="${faq_list.category == 1}">
					  <td>입출금</td>
					  </c:when>
					  <c:when test="${faq_list.category == 2}">
					  <td>투자</td>
					  </c:when>
					  <c:otherwise>
					  <td>기타</td>
					  </c:otherwise>
					  </c:choose>
					  <td onclick="window.open('./faqModifyForm.cu?idx=${faq_list.idx}','자주묻는질문','width=800,height=720,top=0,left=0,scrollbars=yes');">${faq_list.title}</td>
					  <td>${faq_list.mb_name }</td>
					  <td>${faq_list.reg_date_time}</td>
					  <td>Yes</td>
					</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${cate == 2}">
					<c:forEach var="faq_list" items="${faq}">
					<tr>
            		  <td><input type="checkbox"></td>
					  <td>${faq_list.idx}</td>
					  <c:choose>
					  <c:when test="${faq_list.category == 1}">
					  <td>입출금</td>
					  </c:when>
					  <c:when test="${faq_list.category == 2}">
					  <td>투자</td>
					  </c:when>
					  <c:otherwise>
					  <td>기타</td>
					  </c:otherwise>
					  </c:choose>
					  <td onclick="window.open('./faqModifyForm.cu?idx=${faq_list.idx}','자주묻는질문','width=800,height=720,top=0,left=0,scrollbars=yes');">${faq_list.title}</td>
					  <td>${faq_list.mb_name }</td>
					  <td>${faq_list.reg_date_time}</td>
					  <td>Yes</td>
					</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${cate == 3}">
					<c:forEach var="faq_list" items="${faq}">
					<tr>
            		  <td><input type="checkbox"></td>
					  <td>${faq_list.idx}</td>
					  <c:choose>
					  <c:when test="${faq_list.category == 1}">
					  <td>입출금</td>
					  </c:when>
					  <c:when test="${faq_list.category == 2}">
					  <td>투자</td>
					  </c:when>
					  <c:otherwise>
					  <td>기타</td>
					  </c:otherwise>
					  </c:choose>
					  <td onclick="window.open('./faqModifyForm.cu?idx=${faq_list.idx}','자주묻는질문','width=800,height=720,top=0,left=0,scrollbars=yes');">${faq_list.title}</td>
					  <td>${faq_list.mb_name }</td>
					  <td>${faq_list.reg_date_time}</td>
					  <td>Yes</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
			<ul class="pager">
				<c:if test="${count > 0}">
					<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" /> 
					<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
					<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
					<c:if test="${numPageGroup > 1}">
						<li><a href="./faqBoard.cu?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${category}" class="prev">◀</a></li>
					</c:if>
					
					<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<li><b><a class="on" href="./faqBoard.cu?pageNum=${i}&category=${category}"><font size=3>${i}</font></a></b></li>
								</c:when>
								<c:otherwise>
									<li><a class="on" href="./faqBoard.cu?pageNum=${i}&category=${category}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
					
					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./faqBoard.cu?pageNum=${numPageGroup*pageGroupSize+1}&category=${category}" class="next">▶</a>
					</c:if>
				</c:if>
			</ul><!--.pager-->
			</div>
		</section>
		<footer></footer>
	</div>
	<script>
		setTimeout(function () {
		   jQuery('.nav4').trigger('click');
			jQuery('.nav42').addClass('on');
		}, 500);
		
		$(function(){
			$('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
		});
	</script>
</body>
</html>