function register(){
	var title = $('#title').val();
	var content = $('#content').val();
	var category = $("#selectBox").val();
	
	if(title == ''){
		alert('제목을 입력해주세요.');
		title.focus();
		return false;
	}else if(content == ''){
		alert('내용을 입력해주세요.');
		content.focus();
		return false;
	}else{
		submit(category, title, content);
	}
}

function submit(category, title, content){
	$.ajax({
		url : "./faqRegisterForm.cu",
		data : {
			"category" : category,
			"title" : title,
			"content" : content
		},
		type : "post",
		dataType : "json",
		
		success : function(data){
			if(String(data.result) == "register_success") {
				alert('게시물이 등록되었습니다.');
				opener.location.href='./faqBoard.cu';
				window.close();
			}else{
				alert('게시물 등록에 실패했습니다.');
				opener.location.href='./faqBoard.cu';
				window.close();
			}
		},
		error : function(e){
			alert('게시물 등록이 불가능합니다.');
			console.log(e.responseText);
		}
	});
}