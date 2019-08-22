$(function(){
	Array.from(document.getElementsByClassName("allBtn")).forEach(function(item) {
		   item.addEventListener('click',function() { addManualToList(item.id); });
	});
});


var added_table = $('#added_table');
var added_table_js = document.getElementById('added_table');
var test;

// 수동으로 추가하기
function addManualToList(cp_idx){
	var company = document.getElementById(cp_idx);
	var cp_name = company.parentElement.nextElementSibling.innerText;
	var mb_id = company.parentElement.nextElementSibling.nextElementSibling.innerText;
	var cp_manager = company.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.innerText;
	var itemHtml = "";
	itemHtml += "<tr><td class='cp_idx'>"+ added_table.children().length + "</td>";
	itemHtml += "<td>" + cp_name + "</td>";
	itemHtml += "<td>" + mb_id + "</td>";
	itemHtml += "<td>" + cp_manager + "</td>";
	itemHtml += "<td><button class='topDelBtn' onclick='removeItem(this);'>삭제</button></td><td><button class='upBtn' onclick='up(this);''><i class='fas fa-chevron-up'></i></button><button class='downBtn' onclick='down(this);'><i class='fas fa-chevron-down'></i></button></td></tr>";
	
	added_table.append(itemHtml);
};

function removeItem(object){
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
