var testText;
$(document).ready(function() {
	asd();
});

function asd() {
	var testText = $("#pre_pay_schedule").children();
    var jbString = testText.eq(0).text();
    var jbString1 = testText.eq(1).text();
    var jbString2 = testText.eq(2).text();
    var jbString3 = testText.eq(3).text();
    var jbString4 = testText.eq(4).text();
    var jbString5 = testText.eq(5).text();
    var jbString6 = testText.eq(6).text();
    
    var jbSplit = jbString.split('/**/');
    var jbSplit1 = jbString1.split('/**/');
    var jbSplit2 = jbString2.split('/**/');
    var jbSplit3 = jbString3.split('/**/');
    var jbSplit4 = jbString4.split('/**/');
    var jbSplit5 = jbString5.split('/**/');
    var jbSplit6 = jbString6.split('/**/');
    var a = jbSplit;
    for(var i = 0; i<jbSplit.length; i++) {

    	var row = "<tr id='pre_pay_schedule'>";
      	row += "<td>"+jbSplit[i]+"</td>";
      	row += "<td>"+jbSplit1[i]+"</td>";
      	row += "<td>"+jbSplit2[i]+"</td>";
      	row += "<td>"+jbSplit3[i]+"</td>";
      	row += "<td>"+jbSplit4[i]+"</td>";
      	row += "<td>"+jbSplit5[i]+"</td>";
      	row += "<td>"+jbSplit6[i]+"</td>";
      	row += "</tr>";
      $("#body_id").append(row);
    }
    testText.parent().remove();
}