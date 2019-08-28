 $(function(){
      $('.save').hide();
      $('.cancel').hide();
      
      $('input').prop('readonly',true);
      $('textarea').prop('readonly',true);
      $('#test').css('background-color','#e2e2e2');
        
      $('.rec').on('click', function(rectify){
	          $('input').prop('readonly',true);
	          $('textarea').prop('readonly',true);
	          $('#test').css('background-color','#ffffff');
	          $('#test').prop('readonly',false);
          $(this).hide();
          $('.save').show();
          $('.cancel').show();
        });
      
        $('.save').on('click', function(){
        	var form = document.save;
        	
        	if(confirm("해당 답변을 적용하시겠습니까?") == true){
        		form.submit();
        	}else{
        		alert("답변을 취소 하였습니다.");
        	}
        }); 
        
        $('.cancel').on('click', function(){
            location.reload();
        });
    });