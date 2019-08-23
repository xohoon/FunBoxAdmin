$(function(){
	
	added_table = $('#added_table');
	added_table_js = document.getElementById('added_table');
	all_list = document.getElementById('all_list');
	
	Array.from(document.getElementsByClassName("allBtn")).forEach(function(item) {		
		item.addEventListener('click',function() { addManualToList(item); all_list.removeChild(item.parentElement.parentElement); });
	});
	
	
});
var test;
var added_table;
var added_table_js;
var all_list;

// 수동으로 추가하기
function addManualToList(object){
	var cp_name = object.parentElement.nextElementSibling.innerText;
	var mb_id = object.parentElement.nextElementSibling.nextElementSibling.innerText;
	var cp_manager = object.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.innerText;
	var itemHtml ="";
	itemHtml += "<tr><input name='cp_idx_"+object.id+"' class='cp_idx' type='hidden' value='"+object.id+"'><td>"+ added_table.children().length + "</td>";
	itemHtml += "<td>" + cp_name + "</td>";
	itemHtml += "<td>" + mb_id + "</td>";
	itemHtml += "<td>" + cp_manager + "</td>";
	itemHtml += "<td><button class='topDelBtn' onclick='removeItem(this);'>삭제</button></td><td><button class='upBtn' onclick='up(this);''><i class='fas fa-chevron-up'></i></button><button class='downBtn' onclick='down(this);'><i class='fas fa-chevron-down'></i></button></td></tr>";
	
	added_table.append(itemHtml);
};

function removeItem(object){
	
	//all_list.appendChild(object.parentElement.parentElement);
	added_table_js.removeChild(object.parentElement.parentElement);	
	reloadNumbering();
};

function up(object){
	if (object.parentElement.parentElement.children[0].innerText <= 1) {
		return false;
	}
	added_table_js.insertBefore(object.parentElement.parentElement,object.parentElement.parentElement.previousSibling);
	reloadNumbering();
};

function down(object){
	if (object.parentElement.parentElement.children[0].innerText >= added_table.children().length -1 ) {
		return false;
	}
	added_table_js.insertBefore(object.parentElement.parentElement.nextElementSibling,object.parentElement.parentElement);
	reloadNumbering();
};

function reloadNumbering(){
	var i = 0;
	Array.from(added_table_js.children).forEach(function(item) {
		if (i == 0) {
			i++;
			return;
		}
		item.children[0].innerText = i;
		i++;
	});
};

// 태훈 추가 - 기능 제어
$(document).ready(function() {
	$(".topList").children().css('backgroundColor', '#d3d3d3');
	$(".allList").children().css('backgroundColor', '#d3d3d3');
	
	$(".allBtn").prop("disabled", true);
	$(".allBtn").css('backgroundColor', '#d3d3d3');
	
	$(".topDelBtn").prop("disabled", true);
	$(".topDelBtn").css('backgroundColor', '#d3d3d3');
	
	$(".upBtn").prop("disabled", true);
	$(".upBtn").css('backgroundColor', '#d3d3d3');

	$(".downBtn").prop("disabled", true);
	$(".downBtn").css('backgroundColor', '#d3d3d3');
	
	$("input[name='push']").attr('disabled', true);
});

$("#modityBtn").on('click', function() {
	var BtnText = $("#modityBtn").val();
	if(BtnText == "수정") {
		$(".topList").children().css('backgroundColor', 'transparent');
		$(".allList").children().css('backgroundColor', 'transparent');
		
		$(".allBtn").prop("disabled", false);
		$(".allBtn").css('backgroundColor', 'transparent');
		
		$(".topDelBtn").prop("disabled", false);
		$(".topDelBtn").css('backgroundColor', 'transparent');
		
		$(".upBtn").prop("disabled", false);
		$(".upBtn").css('backgroundColor', 'transparent');
	
		$(".downBtn").prop("disabled", false);
		$(".downBtn").css('backgroundColor', 'transparent');
		
		$("input[name='push']").attr('disabled', false);
		$("#modityBtn").val("비활성화");
	}else if(BtnText == "비활성화") {
		$(".topList").children().css('backgroundColor', '#d3d3d3');
		$(".allList").children().css('backgroundColor', '#d3d3d3');
		
		$(".allBtn").prop("disabled", true);
		$(".allBtn").css('backgroundColor', '#d3d3d3');
		
		$(".topDelBtn").prop("disabled", true);
		$(".topDelBtn").css('backgroundColor', '#d3d3d3');
		
		$(".upBtn").prop("disabled", true);
		$(".upBtn").css('backgroundColor', '#d3d3d3');

		$(".downBtn").prop("disabled", true);
		$(".downBtn").css('backgroundColor', '#d3d3d3');
		
		$("input[name='push']").attr('disabled', true);
		$("#modityBtn").val("수정");
	}
});
