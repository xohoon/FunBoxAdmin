function register(){
	var title = $('#title').val();
	var content = $('#content').val();
	var fileCheck = document.getElementById('uploadfile').value;
	
	if(!title){
		alert('제목을 입력해주세요.');
		title.focus();
		return false;
	}else if(!content){
		alert('내용을 입력해주세요.');
		content.focus();
		return false;
	}else if(!fileCheck){
		alert('파일을 첨부해주세요.');
		return false;
	}else{
		$('#noticeRegisterForm').submit();
	}
}