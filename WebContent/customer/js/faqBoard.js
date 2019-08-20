		$(function() {
		  $('header').load('./template/header.jsp');
		  $('#gnb').load('./template/categoryTemplate.jsp');
		  $('footer').load('./template/footer.jsp');
		});

		$(document).ready(function(){	
			$("#selectBox").on("change", function(){
		        var category = $(this).val();
		        var pageNum = 1;
		        
		        location.href = './faqBoard.cu?category=' + category + '&pageNum=' + pageNum;
		    });

			$("#on_status").click(function(){
				var on_confirm = confirm('해당 게시물을 활성화 하시겠습니까?');
				
				if(on_confirm){
					$("input:checked[name='status']").each(function(){
						var faq_idx = $(this).val();
						$.ajax({
							url : "./faqShow.cu",
							data : {
								"status" : 1,
								"faq_idx" : faq_idx
							},
							type : "post",
							dataType : "json",
							
							success : function(data){
								if (String(data.result) == "faqShow_success") {
									alert(faq_idx+'번째 게시물이 활성화 되었습니다.');
									location.href='./faqBoard.cu';
								} else {
									alert(faq_idx+'번째 게시물이 활성화에 실패했습니다.');
									location.href='./faqBoard.cu';
								}
							},
							error : function(e) {
								alert(faq_idx+'번째 게시물이 활성화가 불가능합니다.');
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
						var faq_idx = $(this).val();
						$.ajax({
							url : "./faqShow.cu",
							data : {
								"status" : 0,
								"faq_idx" : faq_idx
							},
							type : "post",
							dataType : "json",
							
							success : function(data){
								if (String(data.result) == "faqShow_success") {
									alert(faq_idx+'번째 게시물이 비활성화 되었습니다.');
									location.href='./faqBoard.cu';
								} else {
									alert(faq_idx+'번째 게시물이 비활성화에 실패했습니다.');
									location.href='./faqBoard.cu';
								}
							},
							error : function(e) {
								alert(faq_idx+'번째 게시물이 비활성화가 불가능합니다.');
								console.log(e.responseText);
							}
						});
					});
				}
			});
		});