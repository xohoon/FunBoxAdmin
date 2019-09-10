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
//    	testText.eq(0).text(jbSplit[0]);
//      testText.hide();
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

// 디자인/////////////////////
$(function(){
//수정하기
$('.save').hide();
$('.cancel').hide();
  $('form').hide();

$('.rec').on('click', function(rectify){
  $(this).hide();
  $('.save').show();
  $('.cancel').show();
  $('form').show();
});

$('.cancel').on('click', function(){
    location.reload();
});

$('table').focusout(function(){
  $('table input').trigger('change');
})
  $('table').on('keyup input', function(){
  corCalculate();
  });
//행추가
  $('.add').click(function(){
    var cln = $('Form').find('tr').last().clone();
        cln.find('input').val('');
    cln.addClass('addTr');
    $('Form').find('table').append(cln);
  });
//행삭제
 $('.del').click(function(){
    if($('form tr').length > 2){
      $('form').find('tr').last().remove();
    }
  });



});


function corCalculate(){

sum1 = $('input[name=sum1]');
sum2 = $('input[name=sum2]');
sum3 = $('input[name=sum3]');
sum4 = $('input[name=sum4]');
sum5 = $('input[name=sum5]');
res1 = 0;

var i;

for(i=0; i<sum4.length; i++) {
  var val2 = sum2.eq(i).val();
      val2 = Number(val2.replace(/\,/g, "") || 0);
  var val3 = sum3.eq(i).val();
      val3 = Number(val3.replace(/\,/g, "") || 0);
  var val4 = sum4.eq(i).val();
      val4 = Number(val4.replace(/\,/g, "") || 0);
  sum4.eq(i).val(val2-val3);
}
for(i=0; i<sum5.length; i++) {
  var val4 = sum4.eq(i).val();
      val4 = Number(val4.replace(/\,/g, "") || 0);
  var val5 = sum5.eq(i).val();
      val5 = Number(val5.replace(/\,/g, "") || 0);
  var val1 = sum1.eq(i).val();
      val1 = Number(val1.replace(/\,/g, "") || 0);
  res1 += val1;
  var total = $('.total').text();
  total = Number(total.replace(/\,/g, "") || 0);
  total = total + res1;
  sum5.eq(i).val(val4/total*100);
}      

  console.log(total);
}

//참고자료
$(function(){
var corFile,
  corFileArr = ['data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EA%B3%84%ED%9A%8D%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%ED%8E%80%EB%94%A9%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%9E%84%EB%8C%80%EC%B0%A8%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EA%B0%80%EB%A7%B9%ED%97%88%EA%B0%80%EC%9E%90%EB%A3%8C.txt'],
  corL = corFileArr.length,
  $fileWrap = $('.file');
for(corFile=0;corFile<corL;corFile++){
var addFile = document.createElement('a');
addFile.setAttribute('href',corFileArr[corFile]);
addFile.className = 'corFile';
$fileWrap.append(addFile);

var fileUrl = corFileArr[corFile].split('/'),
  fileUrlLeng =fileUrl.length,
  fileNameFull = fileUrl[fileUrlLeng-1],
  fileNameDec = decodeURI(fileNameFull);
addFile.setAttribute('download',fileNameDec);
addFile.innerHTML = '<i></i>' + fileNameDec + '<i></i>';

}

});
