    setTimeout(function () {
      jQuery('.nav3').trigger('click');
      jQuery('.nav34').addClass('on');
    }, 500);
    
    $(function(){
    	console.log("test");
      $('.tab li').click(function(){
	 		$('.tab li').removeClass('on');
				$(this).addClass('on');
	  });
      
      $('.tab li').eq(0).click(function(){
    	 window.location.href="./companyInvestedList.cp?page=1&funding_status=0";
        //$('.ingGroup').show();
        //$('.doneGroup').hide();
      });
      
      $('.tab li').eq(1).click(function(){
    	  window.location.href="./companyInvestedList.cp?page=1&funding_status=12";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.tab li').eq(2).click(function(){
    	  window.location.href="./companyInvestedList.cp?page=1&funding_status=11";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.tab li').eq(3).click(function(){
    	  window.location.href="./companyInvestedList.cp?page=1&funding_status=10";
        //$('.doneGroup').show();
        //$('.ingGroup').hide();
      });
      
      $('.pager li').click(function(){
				$('.pager li').removeClass('on');
				$(this).addClass('on');
			});
    });
    
    
    function replybtn(count){
    	var fund_state = document.getElementById("fund_state_"+count).value;
    	var give_state = document.getElementById("give_state_"+count).value;
    	var arrears_state = document.getElementById("arrears_state_"+count).value;
    	var cp_idx = document.getElementById("cp_"+count).value;
    	
    	console.log("fund_state :" + fund_state);
    	console.log("give_state :" + give_state);
    	console.log("arrears_state :" + arrears_state);
    	console.log("cp_idx :" + cp_idx);
    	
    	// 1row씩 수정 가능
    	if (confirm("수정 하시겠습니까??") == true){
    		// 일단 0    		
        	location.href="./companyInvestDetailstates.cp?page=1&funding_status=0&cp_idx="+cp_idx+"&fund_state="+fund_state+"&give_state="+give_state+"&arrears_state="+arrears_state;
    	
    	}else{
    		alert("수정을 취소 하였습니다.")
    	}    	

    }
