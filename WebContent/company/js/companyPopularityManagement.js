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

$("#saveBtn").on('click', function() {
	$.ajax({
        url : "./companyPopularityManagementUpdate.cp",
        type : "POST",
        dataType : "JSON",
        data : {
        	"tdArr" : tdArr
        },
        success : function(data) {
        	
        },
        error : function(e) {
        	alert('통신 실패');
        }
    });
});


