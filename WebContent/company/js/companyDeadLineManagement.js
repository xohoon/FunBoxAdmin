$(document).ready(function() {
	
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
					itemHtml += "<tr><td class='cp_idx'>"+ number + "</td>";
					itemHtml += "<td>" + data[i].cp_name + "</td>";
					itemHtml += "<td>" + data[i].mb_id + "</td>";
					itemHtml += "<td>" + data[i].cp_manager + "</td>";
					itemHtml += "<td><button class='topDelBtn' onclick='removeItem(this);'>삭제</button></td>";
					itemHtml += "<td><button class='upBtn' onclick='up(this);'>";
					itemHtml += "<i class='fas fa-chevron-up'></i></button>";
					itemHtml += "<button class='downBtn' onclick='down(this);'>";
					itemHtml +=	"<i class='fas fa-chevron-down'></i></button></td></tr>";
				}
				 $( '#added_table' ).append( itemHtml );
			},error:function(data){
				alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
			}
	});			
});


