// 태훈 추가 - 관리자 로그인 세션 없을때 OUT
var sessionValue;
$(document).ready(function() {
	getOut();
});
function getOut() {
	sessionValue = $("#sessionValue").val();
	if(sessionValue == "null") {
		alert("관리자 권한으로 로그인해주세요.");
		location.href="/loginForm.ad";
	}
}