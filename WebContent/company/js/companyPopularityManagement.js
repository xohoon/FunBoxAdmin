var auto_status_value = $("#auto_status_value").val();
	console.log("DDD:::"+auto_status_value);
$(document).ready(function() {
	if(auto_status_value == 1) {
		$("#auto").attr('disabled', false);
		$("#man").attr('disabled', true);
	} else {
		$("#auto").attr('disabled', true);
		$("#man").attr('disabled', false);
	}
});


//자동 - 1 , 수동 - 0
function saveCheck(frm){
	console.log(frm);
	var auto_status_value = $("#auto_status_value").val();
	
	if (auto_status_value == 0) {
		if(confirm("수동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("저장 취소.");
		}
	}else if(auto_status_value == 1){
		if(confirm("자동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("저장 취소.");
		}
	}else{
		alert("자동 수동 버튼을 확인해주세요.");
	}
	
}
/*
	var setting = "0";	
	alert("1212");
	$.ajax({
		url : './ComapnyPopularityInfoAjax.cp', 
		type : 'POST',
		data : {
			"setting":setting
			},
		dataType : 'json',
			success:function(data){
				var items = "";
				for(var i=0 ; i<data.length; i++){
					var number = i+1;
					items += "<tr>";
					items += "<td>"+ number + "</td>";
					items += "<td id='cp_name_"+number+"'>" + data[i].cp_name + "</td>";
					items += "<td id='mb_id_"+number+"'>" + data[i].member_id + "</td>";
					items += "<td id='cp_manager_name_"+number+"'>" + data[i].manager_name + "</td>";					
					items += "<td><button type = 'button' class='topDelBtn' onclick='removeItem(this);'>삭제</button></td>";
					items += "<td><button type = 'button' class='upBtn' onclick='up(this);'>";
					items += "<i class='fas fa-chevron-up'></i></button>";
					items += "<button type = 'button' class='downBtn' onclick='down(this);'>";
					items +=	"<i class='fas fa-chevron-down'></i></button></td><input name='cp_idx_"+ data[i].cp_idx +"' class='cp_idx' type='hidden' value='"+data[i].cp_idx+"'></tr>";
					
				}
				 $( '#added_table' ).append( items );
			},error:function(data){
				alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
			}
	});			

 */
