function ajaxSave(id) {
	var SAVEID = id;
	
	$.ajax({
		type: "POST",
		url: "savesample",
		data: {
			EditInputACCENUMB:$('#EditInputACCENUMB').val(),
			EditInputCOUNTRY:$('#EditInputCOUNTRY').val(),
			EditInputACCENAME:$('#EditInputACCENAME').val(),
			EditInputYEAR:$('#EditInputYEAR').val(),
			EditInputHEIGHT:$('#EditInputHEIGHT').val(),
			EditInputDATEM:$('#EditInputDATEM').val(),
			EditInputDATED:$('#EditInputDATED').val(),
			EditInputSTAB1:$('#EditInputSTAB1').val(),
			EditInputSTAB2:$('#EditInputSTAB2').val(),
			EditInputSTAB3:$('#EditInputSTAB3').val(),
			SENDID:SAVEID
		},
		success: function(response) {
			ajaxSearch();
			$('#editPopUp').animate({opacity: 0}, 198, function(){
    			$(this).css('display', 'none');
      			$('#editOverlay').fadeOut(297);
    		});
		}
	});
	
	
};