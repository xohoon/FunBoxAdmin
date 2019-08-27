
function category(button){
	var selectOption = document.getElementById("selectID").value;
	var searchID = document.getElementById("hiddensearchID").value;
	var category = button;
	location.href='./inquiryBoard.cu?category='+category+"&searchID="+searchID;
		
}

function btnIdsearch(){
	var selectOption = document.getElementById("selectID").value;
	var searchID =  document.getElementById("searchID").value;
	
	if(selectOption == '0'){				
		location.href='./inquiryBoard.cu?category='+0;
	}else if(selectOption == '1'){
		location.href='./inquiryBoard.cu?searchID='+searchID;
	}
}

$(function(){
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
});	