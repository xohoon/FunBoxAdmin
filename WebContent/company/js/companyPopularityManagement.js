//자동 - 1 , 수동 - 0
function saveCheck(frm){
	if (!countLimit(10,10)) {
		alert('10개 기업을 선택해 주세요.');
		return false;
	}
	if(document.getElementById('auto').checked) {
		$("#auto_status").text('1');
	}else if(document.getElementById('man').checked) {
		$("#auto_status").text('0');
	}
	
	if ($("#auto_status").text() == "0") {
		console.log("DDD:::수동"+$("#auto_status").text());
		$('input[name=auto_status]').attr('value', "0");
		if(confirm("실시간 순위를 수동으로 전환하겠습니까?") == true){
			frm.submit();
		}else{
			alert("저장 취소.");
		}
	}else if($("#auto_status").text() == "1"){
		console.log("DDD:::자동"+$("#auto_status").text());
		$('input[name=auto_status]').attr('value', "1");
		if(confirm("실시간 순위를 자동으로 전환하겠습니까?") == true){
			frm.submit();
		}else{
			alert("저장 취소.");
		}
	}else{
		alert("자동 수동 버튼을 확인해주세요.");
	}
	
}
