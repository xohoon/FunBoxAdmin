
function category(button){
	var selectOption = document.getElementById("selectID").value;
	var searchID = document.getElementById("hiddensearchID").value;
	console.log(searchID);
	var category = button;
	location.href='./memberInvestedList.fn?category='+category+"&searchID="+searchID;
		
}

function btnIdsearch(){
	var selectOption = document.getElementById("selectID").value;
	var searchID =  document.getElementById("searchID").value;
	var category = document.getElementById("cate_color").value;
	
	if(selectOption == '0'){				
		location.href='./memberInvestedList.fn?category='+0;
	}else{
		location.href='./memberInvestedList.fn?searchID='+searchID+"&category="+category;
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
	  else if($('#cate_color').val() == '3'){
		  $('.tab li').removeClass('on');
		  $('#button4').addClass('on');
	  }
	 
	  if(searchID.length > 0){
		 $("#selectID").val("1").prop("selected", true);
	  } else{
		 $("#selectID").val("0").prop("selected", true);
	  }
	
});	