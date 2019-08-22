<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<script type="text/javascript" src="company/js/companyDeadLineManagement.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<script>
	  $(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
      	  //$('.allList').load('../company/compnayAllList.jsp');
		  //$('.allList').load('./compnayAllList.cp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header></header>
		<div id="gnb"></div>
		<section id="sec08">
			<h2>마감임박기업관리</h2>
			<div class="con">
				<div class="all">
                  <h3>전체목록</h3>
                  <div class="sch">
				    <input type="text">
				    <button><i class="fas fa-search"></i></button>
			       </div>
                  <div class="allList">
                  <table class="allGroup">
				    <tr>
				      <th>선택</th>
				      <th>상호명</th>
				      <th>아이디</th>
				      <th>담당자</th>
				    </tr>
				    <c:forEach var="company" items="${companyList }">
				    	<tr>
					     <td><button id="${company.cp_idx }" value ="${company.cp_idx }" class="allBtn" onclick="mancheck(this.value)">선택</button></td>
					      <td onclick="window.open('http://iofunbox.dothome.co.kr/corporation.jsp','바른생선회','width=1240,height=800,top=0,left=0,scrollbars=yes');">${company.cp_name }</td>
					      <td>${company.mb_id }</td>
					      <td>${company.cp_manager }</td>
					    </tr>
				    </c:forEach>
                  </table>
                  </div>
				</div>
				<div class="top">
                  <h3>마감임박</h3>
                  <ul class="push">
                    <li>
                      <input type="radio" name="push" id="auto" value="자동" onclick="autocheck(this.value)" checked >
                      <label for="auto">자동</label>
                    </li>
                    <li>
                      <input type="radio" name="push" id="man" value="수동" onclick="autocheck(this.value)">
                      <label for="man">수동</label>
                    </li>
                  </ul>
                   <div class="topList">
                     <table id = "manTable">
                       <tr>
                         <th>번호</th>
                         <th>상호명</th>
                         <th>아이디</th>
                         <th>담당자</th>
                         <th></th>
                         <th></th>
                       </tr>
                     </table>                      
                   </div>
                   </div>
                </div>
			</div>
		</section>
		<footer></footer>
	</div>
<script>  
setTimeout(function () {
  jQuery('.nav3').trigger('click');
  jQuery('.nav37').addClass('on');
}, 500);
  
</script>
</body>
</html>