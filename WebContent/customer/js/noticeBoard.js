		$(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		});
		
		$(document).ready(function(){
			$("#on_status").click(function(){
				var on_confirm = confirm('해당 게시물을 활성화 하시겠습니까?');
				
				if(on_confirm){
					$("input:checked[name='status']").each(function(){
						var notice_idx = $(this).val();
						$.ajax({
							url : "./noticeShow.cu",
							data : {
								"status" : 1,
								"notice_idx" : notice_idx
							},
							type : "post",
							dataType : "json",
							
							success : function(data){
								if (String(data.result) == "noticeShow_success") {
									alert(notice_idx+'번째 게시물이 활성화 되었습니다.');
									location.href='./noticeBoard.cu';
								} else {
									alert(notice_idx+'번째 게시물이 활성화에 실패했습니다.');
									location.href='./noticeBoard.cu';
								}
							},
							error : function(e) {
								alert(notice_idx+'번째 게시물이 활성화가 불가능합니다.');
								console.log(e.responseText);
							}
						});
					});
				}
			});
			
			$("#off_status").click(function(){
				var off_confirm = confirm('해당 게시물을 비활성화 하시겠습니까?');
				
				if(off_confirm){
					$("input:checked[name='status']").each(function(){
						var notice_idx = $(this).val();
						$.ajax({
							url : "./noticeShow.cu",
							data : {
								"status" : 0,
								"notice_idx" : notice_idx
							},
							type : "post",
							dataType : "json",
							
							success : function(data){
								if (String(data.result) == "noticeShow_success") {
									alert(notice_idx+'번째 게시물이 비활성화 되었습니다.');
									location.href='./noticeBoard.cu';
								} else {
									alert(notice_idx+'번째 게시물이 비활성화에 실패했습니다.');
									location.href='./noticeBoard.cu';
								}
							},
							error : function(e) {
								alert(notice_idx+'번째 게시물이 비활성화가 불가능합니다.');
								console.log(e.responseText);
							}
						});
					});
				}
			});
		});