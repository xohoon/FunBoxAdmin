<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>editor</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/editor.css" rel="stylesheet">
</head>

<body>
	<div id="Editor">
       <h1>서영이의 에디터 :&#41;</h1>
       <form>
       <div class="editBtn"> 
        <select class="fontName" onchange="fontName(this.value)">
          <option value="FontL">기본서체</option>
          <option value="NotoSansKR">Noto Sans</option>
          <option>나눔고딕</option>
          <option>나눔스퀘어</option>
          <option>나눔명조</option>
        </select>
        <select class="fontSize" onchange="fontSize(this.value,'px')"/>
          <option value="10">10</option>
          <option value="12">12</option>
          <option value="14">14</option>
          <option value="16">16</option>
          <option value="20">20</option>
          <option value="24">24</option>
          <option value="32">32</option>
          <option value="40">40</option>
        </select>
        <input type="button" class="Bold" value="B" onclick="document.execCommand('bold')"/>
	    <input type="button" class="Italic" value="I" onclick="document.execCommand('Italic')"/>
	    <input type="button" class="Under" value="U" onclick="document.execCommand('Underline')"/>
	    <input type="button" class="alignL" value="" onclick="document.execCommand('justifyleft')">
	    <input type="button" class="alignC" value="" onclick="document.execCommand('justifycenter')">
	    <input type="button" class="alignR" value="" onclick="document.execCommand('justifyright')">
	    <input type="button" class="photoUp" value="" onclick="document.execCommand('insertImage', false, 'http://lorempixel.com/40/20/sports/')">
	  </div><!--.btn-->
	  <div class="editPlace">
	    <div class="Editor" contenteditable="true"></div><!--.Editor-->
	    <div class="HTML"></div><!--.HTML-->
	  </div>
	  <div class="editTab">
	    <input type="button" value="Editor" class="on">
	    <input type="button" value="HTML">
	  </div><!--.btn-->
      </form>
	</div>
  <script>
  $(function(){
    //텍스트창보기
    $('.HTML').hide();
    
    var $tab = $('.editTab').find('input')
    $tab.on('click', function(){
      $('.editTab').find('input').removeClass('on');
      $(this).addClass('on');
    });
    
    $tab.eq(0).on('click', function(){
      $('.HTML').hide();
      $('.Editor').show();
    });
    
    $tab.eq(1).on('click', function(){
      $('.HTML').show();
      $('.Editor').hide();
    });
    
  });
    
  //키이벤트
  $(document).on('keydown', function(e){
      if(e.keyCode == 13){
        e.preventDefault(); //Prevent default browser behavior
        if (window.getSelection) {
            var selection = window.getSelection(),
                range = selection.getRangeAt(0),
                br = document.createElement("br"),
                textNode = document.createTextNode("\u00a0");
                //Passing " " directly will not end up being shown correctly
                range.deleteContents();//required or not?
                range.insertNode(br);
                range.collapse(false);
                range.insertNode(textNode);
                range.selectNodeContents(textNode);

                selection.removeAllRanges();
                selection.addRange(range);
                return false;
        }
      }
  });
    
  //폰트
  function fontName(fontName) {
    document.execCommand("fontName", false, fontName);
  }
  var fontSize = function (size, unit) {
    var spanString = $('<span/>', {
        'text': document.getSelection()
    }).css('font-size', size + unit).prop('outerHTML');

    document.execCommand('insertHTML', false, spanString);
};
    
  </script>
</body>
</html>