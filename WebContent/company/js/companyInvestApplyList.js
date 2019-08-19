function confirmDeleteApply(app_cp_idx, app_cp_name) {
	if (confirm(app_cp_name + '의 신청서를 삭제하시겠습니까?')) {
		deleteCompanyInvestApply(app_cp_idx);
	}
}

function deleteCompanyInvestApply(app_cp_idx) {
	$.ajax({
		url : './deleteCompanyInvestApply.cp',
		method : "POST",
		data : {app_cp_idx : app_cp_idx},
		type : "json"
	}).done(function(resultData) {
		switch (resultData.result) {
		case 0:
			alert(resultData.message);
			window.location.reload();
			break;
		case 1:
			alert(resultData.message);
			break;
		case 2:
			alert(resultData.message);
			break;
		default:
			break;
		}
	}).fail(function() {
		alert('서버통신 오류');
	}).always(function() {
	});
};