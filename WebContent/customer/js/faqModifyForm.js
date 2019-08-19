    $(function(){
      $('.save').hide();
      $('.cancel').hide();
      $('input').prop('readonly',true);
      $('textarea').prop('readonly',true);
      $('input[type=file]').hide();  
        $('.rec').on('click', function(rectify){
          $('input').css('border','1px solid #ddd');
          $('input').prop('readonly',true);
          $('textarea').prop('readonly',false);
          $('input[type=file]').show();
          $(this).hide();
          $('.out').hide();
          $('.save').show();
          $('.cancel').show();
        });
        
        $('.cancel').on('click', function(){
            location.reload();
        });
    });
    
    // 유정 - faq 게시물 삭제하기
    function faqDel(){
    	var faq_idx = $('#faq_idx').val();
    	var del_confirm = confirm('해당 게시물을 삭제하시겠습니까?');
    	
    	if(del_confirm){
    		$.ajax({
    			url : "./faqDelete.cu",
    			data : {
    				"faq_idx" : faq_idx
    			},
    			type : "post",
    			dataType : "json",
    			
    			success : function(data){
    				if(String(data.result) == "faqDelete_success") {
    					alert('게시물이 삭제되었습니다.');
    					opener.location.href='./faqBoard.cu';
    					window.close();
    				}else{
    					alert('게시물 삭제에 실패했습니다.');
    					opener.location.href='./faqBoard.cu';
    					window.close();
    				}
    			},
    			error : function(e){
    				alert('게시물 삭제가 불가능합니다.');
    				console.log(e.responseText);
    			}
    		});
    	}
    }
    
    // 유정 - faq 게시물 수정하기
    function faqSave(){
    	var faq_idx = $('#faq_idx').val();
    	var category = $("#selectBox").val();
    	var title = $("textarea#title").val();
    	var content = $("textarea#content").val();

    	if(content == ''){
    		alert('내용을 입력해주세요.');
    		content.focus();
    		return false;
    	}else{
    		var mod_confirm = confirm('해당 게시물을 수정하시겠습니까?');
    	}
    	
    	if(mod_confirm){
    		$.ajax({
    			url : "./faqModify.cu",
    			data : {
    				"faq_idx" : faq_idx,
    				"category" : category,
    				"title" : title,
    				"content" : content
    			},
    			type : "post",
    			dataType : "json",
    			
    			success : function(data){
    				if(String(data.result) == "faqModify_success") {
    					alert('게시물이 수정되었습니다.');
    					opener.location.href='./faqBoard.cu';
    					window.close();
    				}else{
    					alert('게시물 수정에 실패했습니다.');
    					opener.location.href='./faqBoard.cu';
    					window.close();
    				}
    			},
    			error : function(e){
    				alert('게시물 수정이 불가능합니다.');
    				console.log(e.responseText);
    			}
    		});
    	}
    }