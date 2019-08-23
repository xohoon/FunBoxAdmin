$(function(){
	
	added_table = $('#added_table');
	added_table_js = document.getElementById('added_table');
	all_list = document.getElementById('all_list');
	Array.from(document.getElementsByClassName("allBtn")).forEach(function(item) {		
		item.addEventListener('click',function() { addManualToList(item); all_list.removeChild(item.parentElement.parentElement); });
	});
	
	
});
var count = 1;
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
	itemHtml += "<tr><td>"+ added_table.children().length + "</td>";
	itemHtml += "<td>" + cp_name + "</td>";
	itemHtml += "<td>" + mb_id + "</td>";
	itemHtml += "<td>" + cp_manager + "</td>";
	itemHtml += "<td><button type='button' class='topDelBtn' onclick='removeItem(this);'>삭제</button></td><td><button type='button' class='upBtn' onclick='up(this);''><i class='fas fa-chevron-up'></i></button><button type='button' class='downBtn' onclick='down(this);'><i class='fas fa-chevron-down'></i></button></td><input name='"+count+"' class='cp_idx' type='hidden' value='"+object.id+"'></tr>";
	
	added_table.append(itemHtml);
	count++;
};

function removeItem(object){
	var trTag = object.parentElement.parentElement;
	
	var value = object.parentElement.parentElement.children[6].value;
	
	trTag.removeChild(trTag.children[6]);
	trTag.removeChild(object.parentElement.nextElementSibling);
	trTag.removeChild(object.parentElement);
	
	var Td = document.createElement('td');
	var Button = document.createElement('button');
	Button.id = value;
	Button.value = value;
	Button.className = 'allBtn';
	Button.style = "background-color: transparent";
	Button.innerText='선택';
	Button.addEventListener('click',function() { addManualToList(Button); all_list.removeChild(Button.parentElement.parentElement); });
	
	Td.append(Button);
	
	trTag.insertBefore(Td,trTag.children[0]);
	trTag.removeChild(trTag.children[1]);

	added_table_js.removeChild(trTag);
	
	reloadNumbering();
	
	all_list.appendChild(trTag);
	
	
	count--;
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
