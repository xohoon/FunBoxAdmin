var checkBtn;
var tr;
var td;
var tdArr = new Array();

$(".allBtn").on('click', function() {
	var checkBtn = $(this);
	var tr = checkBtn.parent().parent();
	var td = tr.children();

	console.log("row values1 ::: " + tr.text());
	console.log("row values2 ::: " + td.text());
	var cp_name = td.eq(1).text();
	var cp_id = td.eq(2).text();
	var cp_manager = td.eq(3).text();

	console.log("row values3 ::: " + cp_name + "//" + cp_id + "//"
			+ cp_manager);

	td.each(function(i) {
		tdArr.push(td.eq(i).text());
	});

	console.log("td Array ::: " + tdArr);

	/*
	var table = document.getElementById(test01);
	var rowlen = table.rows.length;
	var row = table.insertRow(rowlen - 1);
	
	console.log("addROW" + cp_name);
	row.insertCell(1).innerHTML = cp_name;
	 */
	
});

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
	
});

$("#saveBtn").on('click', function() {
	location.href="./companyPopularityManagementUpdate.cp";
});


