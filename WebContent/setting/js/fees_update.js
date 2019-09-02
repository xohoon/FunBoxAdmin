// 태훈 추가 - 수수료 수정
var update_fees;
function feemodify() {
	update_fees = $("#update_fees").val();
	$.ajax({
		dataType : "JSON",
		type : "POST",
		url : "./FeesUpdateActipn.st",
		data : {
			"update_fees" : update_fees
		},
		success : function(data) {
			if(parseInt(data.result) == 0) {
				alert("update 실패");
				return false;
			}else if(parseInt(data.result) == 1) {
				alert("수수료를 변경하였습니다.");
				window.location.href="./feesManagement.st";
			}
		}
	});	
}
