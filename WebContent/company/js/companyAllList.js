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
	itemHtml += "<td id='cp_name_"+count+"'>" + cp_name + "</td>";
	itemHtml += "<td id='mb_id_"+count+"'>" + mb_id + "</td>";
	itemHtml += "<td id='cp_manager_name_"+count+"'>" + cp_manager + "</td>";
	itemHtml += "<td><button type='button' class='topDelBtn' onclick='removeItem(this);'>삭제</button></td><td><button type='button' class='upBtn' onclick='up(this);''><i class='fas fa-chevron-up'></i></button><button type='button' class='downBtn' onclick='down(this);'><i class='fas fa-chevron-down'></i></button></td><input name='cp_idx_"+count+"' class='cp_idx' type='hidden' value='"+object.id+"'></tr>";
	
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

function swapUp(trTag){
	var temp = trTag.children[6].name;
	trTag.children[6].name = trTag.previousSibling.children[6].name;
	trTag.previousSibling.children[6].name = temp;
	
	temp = trTag.children[1].id;
	trTag.children[1].id = trTag.previousSibling.children[1].id;
	trTag.previousSibling.children[1].id = temp;
	
	temp = trTag.children[2].id;
	trTag.children[2].id = trTag.previousSibling.children[2].id;
	trTag.previousSibling.children[2].id = temp;
	
	temp = trTag.children[3].id;
	trTag.children[3].id = trTag.previousSibling.children[3].id;
	trTag.previousSibling.children[3].id = temp;
}
function swapDown(trTag){
	var temp = trTag.children[6].name;
	trTag.children[6].name = trTag.nextElementSibling.children[6].name;
	trTag.nextElementSibling.children[6].name = temp;
	
	temp = trTag.children[1].id;
	trTag.children[1].id = trTag.nextElementSibling.children[1].id;
	trTag.nextElementSibling.children[1].id = temp;
	
	temp = trTag.children[2].id;
	trTag.children[2].id = trTag.nextElementSibling.children[2].id;
	trTag.nextElementSibling.children[2].id = temp;
	
	temp = trTag.children[3].id;
	trTag.children[3].id = trTag.nextElementSibling.children[3].id;
	trTag.nextElementSibling.children[3].id = temp;
}
var a;
function up(object){
	var trTag = object.parentElement.parentElement;
	if (trTag.children[0].innerText <= 1) {
		return false;
	}
	
	/*var hidden_name = trTag.children[6].name;
	trTag.children[6].name = trTag.previousSibling.children[6].name;
	trTag.previousSibling.children[6].name = hidden_name;*/
	swapUp(trTag);
	
	added_table_js.insertBefore(trTag,trTag.previousSibling);
	reloadNumbering();
};

function down(object){
	var trTag = object.parentElement.parentElement;
	if (trTag.children[0].innerText >= added_table.children().length -1 ) {
		return false;
	}
	
	/*var hidden_name = trTag.children[6].name;
	trTag.children[6].name = trTag.nextElementSibling.children[6].name;
	trTag.nextElementSibling.children[6].name = hidden_name;*/
	swapDown(trTag);
	
	added_table_js.insertBefore(trTag.nextElementSibling,trTag);
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
