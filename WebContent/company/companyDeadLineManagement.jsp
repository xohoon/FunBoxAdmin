<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="net.company.dto.CompanyDeadLine"%>
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
	<link href="./css/common.css" rel="stylesheet">
	<link href="./css/admin.css" rel="stylesheet">
	<script>
	  $(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
      	  //$('.allList').load('../company/compnayAllList.jsp');
		  $('.allList').load('./compnayAllList.cp?category=3');
		});
	</script>
	<%
		ArrayList<CompanyDeadLine> companydeadline = (ArrayList<CompanyDeadLine>)request.getAttribute("companydeadline");
		//System.out.println("test :" + companydeadline.get(0).getCp_manager());
	%>
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
                  <div class="allList"></div>
				</div>
				<div class="top">
                  <h3>마감임박</h3>
                  <ul class="push">
                   <li>
                      <input type="radio" name="push" id="auto" value="1" onclick = "hiddenRadio(this.value)">
                      <label for="auto">자동</label>
                    </li>
                    <li>
                      <input type="radio" name="push" id="man" value="0" onclick = "hiddenRadio(this.value)">
                      <label for="man">수동</label>
                    </li>
                  </ul>
                   <form name="save" method="post" action="./CompanyDeadLineSaveAction.cp">
                   <div class="topList">                  
                     <table>                     
                     <input type="hidden" id="radioVal" name="radioVal" value="0">
                     	<tbody id="added_table">
                     	  <tr>
	                         <th>번호</th>
	                         <th>상호명</th>
	                         <th>아이디</th>
	                         <th>담당자</th>
	                         <th></th>
	                         <th></th>
	                       </tr>                     	
                       
                       <c:forEach var = "companydeadline" items="${companydeadline}" varStatus="status" >
	                       <tr>
	                         <td>${status.count}</td>
	                         <td>${companydeadline.cp_name}</td>
	                         <td>${companydeadline.mb_id}</td>
	                         <td>${companydeadline.cp_manager}</td>
	                         <td><button type = 'button' class='topDelBtn' onclick='removeItem(this);'>삭제</button></td>
	                         <td><button type = 'button' class='upBtn' onclick='up(this);'><i class='fas fa-chevron-up'></i></button>
	                         <button type = 'button' class='downBtn' onclick='down(this);'><i class='fas fa-chevron-down'></i></button></td>
	                         <input name='cp_idx_${status.count}' class='cp_idx' type='hidden' value= "${companydeadline.cp_idx}">	                         
	                       </tr>
	                   </c:forEach>
	                   </tbody>                       
                     </table>                     
                   </div>                                     
	                   <input type="button" id="modityBtn" value="수정" style="margin-top:10px;">
	                   <input type="button" id="save" onclick = "savebt(this.form)" value="저장" style="margin-left:10px; margin-top:10px;">
                   </form>                
                </div>
			</div>
		</section>
		<footer></footer>
	</div>
<input type="hidden" id="auto_status" name="auto_status" value="${auto_status}">	
</body>
<script>  
	setTimeout(function () {
	  jQuery('.nav3').trigger('click');
	  jQuery('.nav37').addClass('on');
	}, 500);  
</script>
</html>