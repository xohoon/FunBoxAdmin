var mb_id;

$(function() {
	mb_id = $('#mb_id');
	document.getElementById('save').addEventListener('click', function() {
		$.ajax({
			url : './modifyMember.mb',
			method : "POST",
			data : {
				mb_idx : $("#mb_idx").val(),
				mb_name : $("#mb_name").val(),
				mb_id : $("#mb_id").val(),
				mb_email : $("#mb_email").val(),				
				mb_phone : $("#mb_phone").val(),
				mb_add_num : $("#mb_add_num").val(),
				mb_add_ch : $("#mb_add_ch").val(),
				mb_add_more : $("#mb_add_more").val(),
				mb_add_extra : $("#mb_add_extra").val(),				
				mb_recommend : $("#mb_recommend").val(),
				mb_point : $("#mb_point").val(),
				mb_token : $("#mb_token").val()
				},
			type : "json"
		}).done(function(resultData) {
			switch (resultData.result) {
			case 0:
				alert(resultData.message);
				window.location.reload();
				window.opener.document.location.reload();
				break;
			case 1:
				alert(resultData.message);
				break;	
			default:
				break;
			}

		}).fail(function() {
			alert('서버통신 오류');
		}).always(function() {
		});
	});
});