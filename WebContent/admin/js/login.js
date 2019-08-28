// 태훈 추가 - 관리자 로그인 체크 ajax
var adminId;
var adminPw;
$(document).ready(function() {
	loginAjax();
});
/*
function enterkey(){
     if(event.keyCode == 13){
    	 loginAjax();
     }
}
*/
$("#adminPw").keyup(function(e){
	if(e.keyCode == 13){
		loginAjax(); 
	}
});
function loginAjax() {
	$("#loginBtn").on('click', function() {
		adminId = $("#adminId").val();
		adminPw = $("#adminPw").val();
		console.log("adminID ::: "+adminId);
		console.log("adminPW ::: "+adminPw);
		$.ajax({
			dataType : "JSON",
			type : "POST",
			url : "./LoginCheckAction.ad",
			data : {
				"adminId" : adminId,
				"adminPw" : adminPw
			},
			success : function(data) {
				if(parseInt(data.result) == 0) {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}else if(parseInt(data.result) == -1) {
					alert("아이디가 존재하지 않습니다.");
					return false;
				}else if(parseInt(data.result) == 1) {
					alert("관리자 권한이 확인되었습니다.");
					window.location.href="./index.jsp";
				}
			}
		});
	});	
}
