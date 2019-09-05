function hiddenRadio(radioval){
	$('#radioVal').val(radioval);	
}


//자동 - 1 , 수동 - 0
function savebtn(frm){	
	var radioVal = $('input[name="push"]:checked').val();
	
	if (!countLimit(3,3)) {
		alert('마감 임박 3개를 지정해주세요.');
		return false;
	}
	
	if (radioVal == 0) {
		if(confirm("수동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("수동 저장을 취소되었습니다.");
		}
	}else if(radioVal == 1){
		if(confirm("자동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("자동 저장을 취소되었습니다.");
		}
	}else{
		alert("자동 수동 버튼을 클릭해주세요.");
	}
	
	
}