$(document).ready(function() {
//	$("input[name = 'auto']").attr('disabled', true);
//	$("input[name = 'man']").attr('disabled', true);
	
	var category = "0";	
	
	$.ajax({
		url : './companyDeadLineAjax.cp', 
		type : 'POST',
		data : {"category":category},
		dataType : 'json',
			success:function(data){
				var itemHtml = "";
				for(var i=0 ; i<data.length; i++){
					var number = i+1;
					itemHtml += "<tr>";
					itemHtml += "<td>"+ number + "</td>";
					itemHtml += "<td id='cp_name_"+number+"'>" + data[i].cp_name + "</td>";
					itemHtml += "<td id='mb_id_"+number+"'>" + data[i].mb_id + "</td>";
					itemHtml += "<td id='cp_manager_name_"+number+"'>" + data[i].cp_manager + "</td>";					
					itemHtml += "<td><button type = 'button' class='topDelBtn' onclick='removeItem(this);'>삭제</button></td>";
					itemHtml += "<td><button type = 'button' class='upBtn' onclick='up(this);'>";
					itemHtml += "<i class='fas fa-chevron-up'></i></button>";
					itemHtml += "<button type = 'button' class='downBtn' onclick='down(this);'>";
					itemHtml +=	"<i class='fas fa-chevron-down'></i></button></td><input name='cp_idx_"+ data[i].cp_idx +"' class='cp_idx' type='hidden' value='"+data[i].cp_idx+"'></tr>";
					
				}
				 $( '#added_table' ).append( itemHtml );
			},error:function(data){
				alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
			}
	});			
});
function radiocheck(){
	var radioVal = $('input[name="button"]:checked').val();
	$('#radioVal').val(radioVal);
}


//자동 - 1 , 수동 - 0
function savebt(frm){
	console.log(frm);
	var radioVal = $('input[name="button"]:checked').val();
	
	if (radioVal == 0) {
		if(confirm("수동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("수동 저장을 취소되었습니다.");
		}
	}else if(radioVal == 1){
		if(confirm("자동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("자동 저장을 취소되었습니다.");
		}
	}else{
		alert("자동 수동 버튼을 클릭해주세요.");
	}
	
	
}