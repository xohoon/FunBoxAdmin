// 소수점 둘째자리까지만 입력가능
function delHangle(evt){ //한글을 지우는 부분, keyup부분에 넣어준다.
		var objTarget = evt.srcElement || evt.target;
	    var _value = event.srcElement.value;  
	    if(/[ㄱ-ㅎㅏ-ㅡ가-핳]/g.test(_value)) { 
	    	//  objTarget.value = objTarget.value.replace(/[ㄱ-ㅎㅏ-ㅡ가-핳]/g,''); // g가 핵심: 빠르게 타이핑할때 여러 한글문자가 입력되어 버린다.
	    	objTarget.value = null;
	    	//return false;
	    }
	}
	
	function isNumberKey(evt) { // 숫자를 제외한 값을 입력하지 못하게 한다. 
        var charCode = (evt.which) ? evt.which : event.keyCode;
        // Textbox value       
        var _value = event.srcElement.value;     

        if (event.keyCode < 48 || event.keyCode > 57) { 
            if (event.keyCode != 46) { //숫자와 . 만 입력가능하도록함
                return false; 
            } 
        } 

        // 소수점(.)이 두번 이상 나오지 못하게
        var _pattern0 = /^\d*[.]\d*$/; // 현재 value값에 소수점(.) 이 있으면 . 입력불가
        if (_pattern0.test(_value)) {
            if (charCode == 46) {
                return false;
            }
        }

        // 두자리 이하의 숫자만 입력가능
        var _pattern1 = /^\d{2}$/; // 현재 value값이 2자리 숫자이면 . 만 입력가능
        // {숫자}의 값을 변경하면 자리수를 조정할 수 있다.
        if (_pattern1.test(_value)) {
            if (charCode != 46) {
                alert("두자리 이하의 숫자만 입력가능합니다");
                return false;
            }
        }

        // 소수점 둘째자리까지만 입력가능
        var _pattern2 = /^\d*[.]\d{2}$/; // 현재 value값이 소수점 둘째짜리 숫자이면 더이상 입력 불가
        // {숫자}의 값을 변경하면 자리수를 조정할 수 있다.
        if (_pattern2.test(_value)) {
            alert("소수점 둘째자리까지만 입력가능합니다.");
            return false;
        }     
        return true;
    }

// 태훈 추가 - 기업등록 javascript
function company_register() {
	var f = document.corForm;
	var cp_sector = $('#cp_sector').val();

	if (cp_sector == '0') {
		alert("기업 구분을 체크 해주세요.");
	} else {
		if (confirm("기업등록 하시겠습니까?") == true) {
			f.submit();
		}
	}

}
function inNumber() {
	if (event.keyCode < 48 || event.keyCode > 57) {
		event.returnValue = false;
	}
}

// ///////// Daum Address API ///////////
function address_search() {

	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
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
				document.getElementById("cp_add_extra").value = extraAddr;

			} else {
				document.getElementById("cp_add_more").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('cp_add_num').value = data.zonecode;
			document.getElementById("cp_add_ch").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("cp_add_more").focus();
		}
	}).open();

}
