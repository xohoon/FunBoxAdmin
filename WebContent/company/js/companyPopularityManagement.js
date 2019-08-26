//자동 - 1 , 수동 - 0
function saveCheck(frm){
	if (!countLimit(10,10)) {
		alert('10개 기업을 선택해 주세요.');
		return false;
	}
	console.log("autostatusvalue:::::1"+$("#auto_status").text());
	if(document.getElementById('auto').checked) {
		$("#auto_status").text('1');
		console.log("autostatusvalue:::::2"+$("#auto_status").text());
	}else if(document.getElementById('man').checked) {
		$("#auto_status").text('0');
		console.log("autostatusvalue:::::3"+$("#auto_status").text());
	}
	
	if ($("#auto_status").text() == "0") {
		console.log("DDD:::수동"+$("#auto_status").text());
		$('input[name=auto_status]').attr('value', "0");
		if(confirm("수동으로 저장하시겠습니까?") == true){
			frm.submit();
		}else{
			alert("저장 취소.");
		}
	}else if($("#auto_status").text() == "1"){
		console.log("DDD:::자동"+$("#auto_status").text());
		$('input[name=auto_status]').attr('value', "1");
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
