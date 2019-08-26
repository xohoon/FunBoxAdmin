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
		  //$('.allList').load('../company/compnayAllList.jsp');
		  $('.allList').load('./compnayAllList.cp?category=2');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec08">
			<h2>추천기업관리</h2>
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
                  <h3>추천기업</h3>
                  <ul class="push">
                    <li>
                      <input type="radio" name="push" id="auto" value="자동">
                      <label for="auto">자동</label>
                    </li>
                    <li>
                      <input type="radio" name="push" id="man" value="수동">
                      <label for="man">수동</label>
                    </li>
                  </ul>
                   <div class="topList">
                     <table>
                       <tbody id="added_table">
	                       <tr>
	                         <th>번호</th>
	                         <th>상호명</th>
	                         <th>아이디</th>
	                         <th>담당자</th>
	                         <th></th>
	                         <th></th>
	                       </tr>
	                       <c:forEach var="companyAdded" items="${companyAddedList }" varStatus="status">
	                       		<tr>
	                       			<td>${status.count }</td>
	                       			<td onclick="window.open('http://iofunbox.dothome.co.kr/corporation.jsp','바른생선회','width=1240,height=800,top=0,left=0,scrollbars=yes');">${companyAdded.cp_name }</td>
								    <td>${companyAdded.mb_id }</td>
								    <td>${companyAdded.cp_manager }</td>
								    <td><button type="button" class="topDelBtn" onclick="removeItem(this);">삭제</button></td>
								    <td><button type="button" class="upBtn" onclick="up(this);"><i class="fas fa-chevron-up"></i></button><button type="button" class="downBtn" onclick="down(this);"><i class="fas fa-chevron-down"></i></button></td>
								    <input name="cp_idx_${status.count }" class="cp_idx" type="hidden" value="${companyAdded.cp_idx }">
	                       		</tr>
		                   </c:forEach>
	                   	</tbody>
                     </table>
                   </div>
                </div>
			</div>
		</section>
		<footer></footer>
	</div>
	<input type="hidden" id="auto_status" name="auto_status" value="${auto_status}">
	<input type="hidden" id="aas_idx" name="aas_idx" value="${aas_idx}">	
</body>
	<script>  
	setTimeout(function () {
	  jQuery('.nav3').trigger('click');
	  jQuery('.nav36').addClass('on');
	}, 500);
	</script>
</html>