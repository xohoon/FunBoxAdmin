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
		});