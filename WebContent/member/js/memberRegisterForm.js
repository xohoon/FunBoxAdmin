$(function() {
	mb_id = document.getElementById('mb_id');
	mb_pw = document.getElementById('mb_pw');
	mb_pincode = document.getElementById('mb_pincode');
	mb_email = document.getElementById('mb_email');
	mb_name = document.getElementById('mb_name');
	mb_phone = document.getElementById('mb_phone');
	mb_add_num = document.getElementById('mb_add_num');
	mb_add_ch = document.getElementById('mb_add_ch');
	mb_add_more = document.getElementById('mb_add_more');
	mb_add_extra = document.getElementById('mb_add_extra');
	mb_recommend = document.getElementById('mb_recommend');
	
	document.getElementById('search_post').addEventListener('click',function() { searchPost(); });
	document.getElementById('check_duplication_ID').addEventListener('click',function() { checkDuplicateID(); });
	document.getElementById('registe').addEventListener('click',function() { registeMember(); });
	document.getElementById('mb_id').addEventListener('change',function() { 
		duplication_check_flag = false;
		document.getElementById('check_duplication_ID').disabled = false; 
	});
});

//아이디 정규식//영문/숫자 허용, 6~15 이내의 아이디 정규식
var id_regex = /^[a-zA-Z0-9]*$/;
// 특수문자/문자/숫자 포함 형태의 8~15 이내의 비밀번호 정규식
var pw_regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
// 한글과 영문만 가능
var name_regex = /^[ㄱ-ㅎ가-힣a-zA-Z]+$/;
var num_regex = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
var phone_regex = /\d{11}$/g; // 휴대전화번호 정규식
var pincode_regex = /\d{6}$/g; // pin code 정규식
// 이메일 정규식
var email_regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
// 공백 체크
var blank_regex = /[\s]/g;

var duplication_check_flag = false;

var mb_id;
var mb_pw;
var mb_pincode;
var mb_email;
var mb_name;
var mb_phone;
var mb_add_num;
var mb_add_ch;
var mb_add_more;
var mb_add_extra;
var mb_recommend;

//id 유효성 검사
function checkRegExID(){
	var mb_id = document.getElementById('mb_id');
	
	if (mb_id.value.length <= 0) {
		alert('사용할 아이디를 입력해주세요.');
		mb_id.focus();
		return false;
	}
	
	if (!checkRegEx(id_regex,mb_id,'아이디는 6~15자리의 영문,숫자 사용만 가능합니다.')) {
		return false;
	}
	/*var mb_id = $("#mb_id").val();
	if (mb_id.length <= 0 ) {		
		alert('사용할 아이디를 입력해주세요.');
		$("#mb_id").focus();
		return false;
	}
	if (blank_regex.test(mb_id)) {
		alert('아이디는 공백을 포함할 수 없습니다.');
		alert(mb_id);
		$("#mb_id").focus();
		return false;
	}
	if (!id_regex.test(mb_id)) {
		alert('아이디는 6~15자리의 영문,숫자 사용만 가능합니다.');
		alert(mb_id);
		$("#mb_id").focus();
		return false;
	}
	return true;*/
	
	return true;
}

function checkRegEx(reg, object, message) {
	if (reg.test(object.value)) {
		return true;
	}
	alert(message);
	object.value = "";
	object.focus();
	return false;
}

//중복 체크
function checkDuplicateID() {	
	$.ajax({
		url : './CheckDuplicationID.mb',
		method : "POST",
		data : {mb_id : $("#mb_id").val()},
		type : "json"
	}).done(function(resultData) {
		switch (resultData.result) {
		case 0:
			alert(resultData.message);
			duplication_check_flag = true;
			//document.getElementById('check_duplication_ID').disabled = true;
			break;
		case 1:
			alert(resultData.message);
			duplication_check_flag = false;
			//document.getElementById('check_duplication_ID').disabled = false;
			break;	
		default:
			break;
		}

	}).fail(function() {
		alert('서버통신 오류');
	}).always(function() {
	});
}

function checkEffectiveness(reg, ref) {
	return reg.test(ref.value);
}

//회원 등록
function registeMember() {
	if (blank_regex.test(mb_id.value)) {
		alert('아이디는 공백을 포함할 수 없습니다.');
		return false;
	}
	if (mb_id.value.length < 6 || mb_id.value.length > 15) {
		alert('아이디는 6~15자리의 영문,숫자 사용만 가능합니다.');
		return false;
	}
	if (!id_regex.test(mb_id.value)) {
		alert('아이디는 6~15자리의 영문,숫자 사용만 가능합니다.');
		return false;
	}
	if (!duplication_check_flag) {
		alert('ID 중복 체크 해주세요.');
		return false;
	}
	
	if (blank_regex.test(mb_pw.value)) {
		alert('비밀번호는 공백을 포함할 수 없습니다.');
		return false;
	}
	if (mb_pw.value.length < 6 || mb_pw.value.length > 15) {
		alert('비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.');
		return false;
	}
	if (!pw_regex.test(mb_pw.value)) {
		alert('비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.');
		return false;
	}
	
	if (blank_regex.test(mb_pincode.value)) {
		alert('Pin code는 공백을 포함할 수 없습니다.');
		return false;
	}
	if (!num_regex.test(mb_pincode.value)) {
		alert('Pin code는 숫자만 사용 가능합니다.');
		return false;
	}
	/*if (!pincode_regex.test(mb_pincode.value)) {
		alert('Pin code는 숫자 6자리 여야합니다.');
		return false;
	}*/
	
	if (mb_pincode.value.length != 6) {
		alert('Pin code는 숫자 6자리 여야합니다.');
		return false;
	}
	
	if (blank_regex.test(mb_email.value)) {
		alert('E-mail은 공백을 포함할 수 없습니다.');
		return false;
	}
	if (!email_regex.test(mb_email.value)) {
		alert('옳바른 E-mail을 사용해주세요.');
		return false;
	}
	
	if (mb_name.value.length <= 0) {
		alert('이름을 입력해주세요.');
		return false;
	}
	if (!name_regex.test(mb_name.value)) {
		alert('이름은 한글/영어만 사용 가능합니다.');
		return false;
	}
	
	if (blank_regex.test(mb_phone.value)) {
		alert('휴대전화번호는 공백을 포함할 수 없습니다.');
		return false;
	}
	if (!num_regex.test(mb_phone.value)) {
		alert('휴대전화번호 숫자만 사용 가능합니다.');
		return false;
	}
	/*if (!phone_regex.test(mb_phone.value)) {
		alert('휴대전화번호 11자리를 입력해주세요.');
		return false;
	}*/
	if (mb_phone.value.length != 11) {
		alert('휴대전화번호 11자리를 입력해주세요.');
		return false;
	}
	
	if (blank_regex.test(mb_recommend.value)) {
		alert('추천인 아이디는 공백을 포함할 수 없습니다.');
		return false;
	}
	if (!id_regex.test(mb_recommend.value)) {
		alert('추천인 아이디는 6~15자리의 영문,숫자 사용만 가능합니다.');
		return false;
	}
	if (mb_recommend.value.length < 6 || mb_recommend.value.length > 15) {
		alert('추천인 아이디는 6~15자리의 영문,숫자 사용만 가능합니다.');
		return false;
	}

	$.ajax({
		url : './registeMember.mb',
		method : "POST",
		data : {
			mb_id : $("#mb_id").val(),
			mb_pw : $("#mb_pw").val(),
			mb_pincode : $("#mb_pincode").val(),
			mb_email : $("#mb_email").val(),
			mb_name : $("#mb_name").val(),
			mb_phone : $("#mb_phone").val(),
			mb_add_num : $("#mb_add_num").val(),
			mb_add_ch : $("#mb_add_ch").val(),
			mb_add_more : $("#mb_add_more").val(),
			mb_recommend : $("#mb_recommend").val()
			},
		type : "json"
	}).done(function(resultData) {
		switch (resultData.result) {
		case 0:
			alert(resultData.message);
			window.location.reload();
			break;
		case 1:
			alert(resultData.message);
			break;	
		default:
			break;
		}

	}).fail(function() {
		alert('서버통신 오류');
	}).always(function() {
	});
}

function searchPost() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을
				// 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("mb_add_extra").value = extraAddr;

			} else {
				document.getElementById("mb_add_extra").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('mb_add_num').value = data.zonecode;
			document.getElementById("mb_add_ch").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("mb_add_more").focus();
		}
	}).open();
}

