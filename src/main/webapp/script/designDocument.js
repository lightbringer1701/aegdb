$(document).ready(function() {
	ajaxLogin();
	ajaxSearch();
	
	$("#CreateButtonOverlay").click(function(e) {
		event.preventDefault();
    	$('#createOverlay').fadeIn(297,	function(){
     		 $('#createPopUp') 
     		 .css('display', 'block')
      		 .animate({opacity: 1}, 198);
   		});
	});
	$('#createPopUp__close').click( function(){
   		$('#createPopUp').animate({opacity: 0}, 198, function(){
    		$(this).css('display', 'none');
      		$('#createOverlay').fadeOut(297);
    	});
  	});
  	$('#editPopUp__close').click( function(){
   		$('#editPopUp').animate({opacity: 0}, 198, function(){
    		$(this).css('display', 'none');
      		$('#editOverlay').fadeOut(297);
    	});
  	});
  	
});