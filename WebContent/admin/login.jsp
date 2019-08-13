<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>FUNBOX ADMIN</title>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/admin.css" rel="stylesheet">
	<script>
	  $(function() {
		  $('footer').load('../template/footer.jsp');
		});
	</script>
</head>

<body>
	<div id="wrap">
		<header>
		  <img src="img/logo.svg" style="margin:12px 0 0 24px">
		</header>
		<section id="login">
		  <div>
        <h2>FUNBOX</h2>
        <h3>ADMIN LOGIN</h3>
        <div>
          <label>ID</label>
          <input type="text">
        </div>
        <!--#id-->
        <div>
          <label>PASSWORD</label>
          <input type="password">
        </div>
        <!--pw-->
        <input type="button" class="login" value="LOGIN" onclick="location.href='./index.jsp'">
		  </div>
		</section>
		<footer></footer>
	</div>
</body>
</html>