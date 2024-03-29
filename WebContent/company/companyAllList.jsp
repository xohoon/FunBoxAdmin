<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>all_Group</title>
    <link href="css/common.css" rel="stylesheet">
<link href="css/admin.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
<script type="text/javascript" src="company/js/companyPopularityManagement.js"></script> 
<script src="company/js/companyAllList.js"></script>
</head>
<body>


<table class="allGroup">
	<thead>
	    <tr>
	      <th>선택</th>
	      <th>상호명</th>
	      <th>아이디</th>
	      <th>담당자</th>
	    </tr>
	</thead>
	<tbody id="all_list">
	    <c:forEach var="company" items="${companyList }">
	    	<tr>
		     <td><button id="${company.cp_idx }" value="${company.cp_idx }" class="allBtn">선택</button></td>
		      <td onclick="window.open('http://iofunbox.dothome.co.kr/corporation.jsp','바른생선회','width=1240,height=800,top=0,left=0,scrollbars=yes');">${company.cp_name }</td>
		      <td>${company.mb_id }</td>
		      <td>${company.cp_manager }</td>
		    </tr>
	    </c:forEach>
    </tbody>
  </table>
<script>

</script>
</body>
</html>

