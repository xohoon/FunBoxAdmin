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
          $('.save').show();
          $('.cancel').show();
        });
        
        $('.cancel').on('click', function(){
            location.reload();
        });
    });
    
    // 유정 - 공지사항 게시물 수정하기
    function noticeSave(){
    	var content = $("textarea#content").val();

    	if(content == ''){
    		alert('내용을 입력해주세요.');
    		content.focus();
    		return false;
    	}else{
    		var mod_confirm = confirm('해당 게시물을 수정하시겠습니까?');
    	}
    	
    	if(mod_confirm){
    		$('#noticeModifyForm').submit();
    	}
    }