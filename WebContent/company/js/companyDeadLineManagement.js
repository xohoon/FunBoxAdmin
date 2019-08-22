var arrManCheck = new Array(0,0,0);
var changeCompany = new Array();
var changeManage = new Array();
var count = 0;

$(document).ready(function() {
	
	var category = "0";
	
	document.getElementById("autoTable").style.display = "table";
	document.getElementById("manTable").style.display = "none";
	
	$.ajax({
		url : './companyDeadLineAjax.cp', 
		type : 'POST',
		data : {"category":category},
		dataType : 'json',
			success:function(data){
				for (var i = 0; i < data.length; i++) {
					$("#companyName_"+i).text(data[i].cp_name);
					$("#companyID_"+i).text(""); // 해당 데이터 들어갈때 아이디 값 준다.
					$("#companyManage_"+i).text(data[i].cp_manager);		
					arrManCheck[i] = data[i].cp_idx;
					changeCompany[i] = data[i].cp_name;
					changeManage[i] = data[i].cp_manager;
				}
				
			},error:function(data){
				alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
			}
	});
	
	// 수동	
	$.ajax({
		url : './companyDeadLineManAjax.cp', 
		type : 'POST',
		data : {"category":category},
		dataType : 'json',
			success:function(data){
				for (var i = 0; i < data.length; i++) {
					$("#companyName_"+i).text(data[i].cp_name);
					$("#companyID_"+i).text(""); // 해당 데이터 들어갈때 아이디 값 준다.
					$("#companyManage_"+i).text(data[i].cp_manager);		
					arrManCheck[i] = data[i].cp_idx;
					changeCompany[i] = data[i].cp_name;
					changeManage[i] = data[i].cp_manager;
				}
				
			},error:function(data){
				alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
			}
	});
			
}); 

// 삭제 버튼
function cancelCheck(cancel){

	if(cancel == "0"){ // 번호 1 취소
		arrManCheck[0] = 0;
		document.getElementById("number_1").style.display = "none";
		document.getElementById("companyNameMan_0").style.display = "none";
		document.getElementById("companyIDMan_0").style.display = "none";
		document.getElementById("companyManageMan_0").style.display = "none";
		document.getElementById("companyManageMan_0_remove").style.display = "none";
		document.getElementById("companyManageMan_0_updowm").style.display = "none";						
		if(count > 0){
			$("#number_3").text("1");				
		}else{
			$("#number_2").text("1");
			$("#number_3").text("2");
			count++;
		}
	}else if(cancel == "1"){
		arrManCheck[1] = 0;
		document.getElementById("number_2").style.display = "none";
		document.getElementById("companyNameMan_1").style.display = "none";
		document.getElementById("companyIDMan_1").style.display = "none";
		document.getElementById("companyManageMan_1").style.display = "none";
		document.getElementById("companyManageMan_1_remove").style.display = "none";
		document.getElementById("companyManageMan_1_updowm").style.display = "none";
		
		if(count > 0){
			$("#number_3").text("1");				
		}else{
			$("#number_3").text("2");
			count++;
		}				
	}else if(cancel == "2"){
		arrManCheck[2] = 0;
		document.getElementById("number_3").style.display = "none";
		document.getElementById("companyNameMan_2").style.display = "none";
		document.getElementById("companyIDMan_2").style.display = "none";
		document.getElementById("companyManageMan_2").style.display = "none";
		document.getElementById("companyManageMan_2_remove").style.display = "none";
		document.getElementById("companyManageMan_2_updowm").style.display = "none";
		count++;
	}	
}

// 전체목록 수동 버튼
function mancheck(value){
	var cp_idx = value;
	var overlap ="중복없음";  
	var cp;
	
	if(flagcheck == "자동"){
		alert("수동 버튼을 클릭 후 사용해주세요.");
	}else{
		$.ajax({
			url : './companyDeadLineManAjax.cp', 
			type : 'POST',
			data : {"cp_idx":cp_idx},
			dataType : 'json',
				success:function(data){
				/*	console.log(arrManCheck[0]);
					console.log(arrManCheck[1]);
					console.log(arrManCheck[2]);
*/
					if(arrManCheck[0] !== 0 && arrManCheck[1] !== 0 && arrManCheck[2] !== 0){
						alert("3개 기업이 최대 입니다."); // 수정						
					}else{
						// 여기서 배열 안에 있는 cp 값을 검사하여 중복여부 판별									
						if(arrManCheck[0] == data[0].cp_idx || arrManCheck[1] == data[0].cp_idx || arrManCheck[2] == data[0].cp_idx){
							alert("중복된 기업 명이 있습니다."); // 수정							
						}else{
							console.log(count);
							console.log(count-3);
							cp = Math.abs(count-3);
							console.log(cp);
							document.getElementById("number_").style.display = "block";
							/*for(var j=0; j<3; j++){																
								if(arrManCheck[j] == 0){ // 0이 있을때
									arrManCheck[j] = data[0].cp_idx;
									$("#companyNameMan_"+j).text(data[0].cp_name);
									$("#companyIDMan_"+j).text(""); // 해당 데이터 들어갈때 아이디 값 준다.
									$("#companyManageMan_"+j).text(data[0].cp_manager);
									break;
								}																			
							}*/
						}					
					}
																									
				},error:function(data){
					alert("데이터 통신을 실패 하였습니다. 개발실에 문의 하세요.");	    					
				}
		});
	}
	
} 

function updouwnCheck(btn){
	var flag_Company;
	var flag_Manage;
	console.log(changeCompany[0]);
	console.log(changeCompany[1]);
	console.log(changeCompany[2]);
	console.log(changeManage[0]);
	console.log(changeManage[1]);
	console.log(changeManage[2]);
	
	switch (btn) {
	  case "Up_0" :
		  alert("더이상 위로 올라 갈수가 없습니다.");		  
	    break;
	  case "Down_0" :
		  $("#companyNameMan_0").text(changeCompany[1]);
		  changeCompany[0] = changeCompany[1];
		  flag_Company = changeCompany[1];
		  $("#companyManageMan_0").text(changeManage[1]);
		  changeManage[0] = changeCompany[1];
		  flag_Manage = changeCompany[1];
		  $("#companyNameMan_1").text(changeCompany[0]);
		  changeCompany[1] = flag_Company;
		  $("#companyManageMan_1").text(changeManage[0]);
		  changeManage[1] = flag_Manage;
	    break;
	  case "Up_1" :
		  $("#companyNameMan_0").text(changeCompany[1]);
		  changeCompany[0] = changeCompany[1];
		  flag_Company = changeCompany[1];
		  $("#companyManageMan_0").text(changeManage[1]);
		  changeManage[0] = changeCompany[1];
		  flag_Manage = changeCompany[1];
		  $("#companyNameMan_1").text(changeCompany[0]);
		  changeCompany[1] = flag_Company;
		  $("#companyManageMan_1").text(changeManage[0]);
		  changeManage[1] = flag_Manage;		  
	    break;
	  case "Down_1" :
		  $("#companyNameMan_1").text(changeCompany[2]);
		  changeCompany[1] = changeCompany[2];
		  flag_Company = changeCompany[2];
		  $("#companyManageMan_1").text(changeManage[2]);
		  changeManage[1] = changeCompany[2];
		  flag_Manage = changeCompany[2];
		  $("#companyNameMan_2").text(changeCompany[1]);
		  changeCompany[2] = flag_Company;
		  $("#companyManageMan_2").text(changeManage[1]);
		  changeManage[2] = flag_Manage;
	    break;
	  case "Up_2" :		  
		  $("#companyNameMan_1").text(changeCompany[2]);
		  changeCompany[1] = changeCompany[2];
		  flag_Company = changeCompany[2];
		  $("#companyManageMan_1").text(changeManage[2]);
		  changeManage[1] = changeCompany[2];
		  flag_Manage = changeCompany[2];
		  $("#companyNameMan_2").text(changeCompany[1]);
		  changeCompany[2] = flag_Company;
		  $("#companyManageMan_2").text(changeManage[1]);
		  changeManage[2] = flag_Manage;
	    break;
	  case "Down_2" :
		  alert("더이상 아래로 내려 갈수가 없습니다.");
	    break;
	    
	  default :
	    alert('체크 박스 오류 개발실에 문의 하세요.');
	    break;
	}
}

// 자동 ,수동 테이블 보이기
function autocheck(check){
	var radiocheck = check;
	flagcheck = radiocheck;
	
	if(radiocheck == "자동"){		
		document.getElementById("autoTable").style.display = "table";
		document.getElementById("manTable").style.display = "none";
	
	}else if(radiocheck == "수동"){
		document.getElementById("manTable").style.display = "table";
		document.getElementById("autoTable").style.display = "none";
		
	}
}
