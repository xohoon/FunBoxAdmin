function category(button){
		var selectOption = document.getElementById("selectID").value;
		var searchID = document.getElementById("hiddensearchID").value;
		console.log(searchID);
		var category = button;
		location.href='./tokenWithdrawalList.fn?category='+category+"&searchID="+searchID;
			
	}
	
	function btnIdsearch(){
		var selectOption = document.getElementById("selectID").value;
		var searchID =  document.getElementById("searchID").value;

		if(selectOption == '0'){				
			location.href='./tokenWithdrawalList.fn?category='+0;
		}else{
			location.href='./tokenWithdrawalList.fn?searchID='+searchID;
		}
	}
	
	$(function(){
		var searchID = document.getElementById("hiddensearchID").value;
		
		  if($('#cate_color').val() == '0'){
			  $('.tab li').removeClass('on');
			  	$('#button1').addClass('on');
		  }
		  else if($('#cate_color').val() == '1'){
			  $('.tab li').removeClass('on');
			  $('#button2').addClass('on');
	 	  }
		  else if($('#cate_color').val() == '2'){
			  $('.tab li').removeClass('on');
			  $('#button3').addClass('on');
		  }
		
		  /*if($('#searchID').val())=*/ 
		
	  });