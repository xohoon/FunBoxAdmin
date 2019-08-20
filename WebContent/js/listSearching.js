
var search_url;
var search_type;
var search_word;

$(function() {
	search_url = window.location.pathname;
	search_type = document.getElementById('search_type');
	search_word = document.getElementById('search_word');
	document.getElementById('search').addEventListener('click', function() {
		if (search_type.value == 0) {
			alert('검색 항목을 설정해주세요.');
		}else{
			window.location.href=search_url+'?search_type='+search_type.value+'&search_word='+search_word.value;
			//window.location.href='./memberList.mb?search_type='+search_type.value+'&search_word='+search_word.value;
		}

	});
});
