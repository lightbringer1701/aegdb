function checkEmptyElement(element) {
	var fe = element;
	if ( fe.val() == '' ) {
			fe.css({'border-color':'#ff0000'})
			setTimeout(function(){
        		fe.removeAttr('style');
      		},500);
			return true;
	}
	return false;
};

function checkNaNElement(element) {
	var fe = element;
	if ( isNaN(fe.val()) ) {
			fe.css({'border-color':'#0000ff'})
			setTimeout(function(){
        		fe.removeAttr('style');
      		},500);
			return true;
	}
	return false;
};

function ajaxCreate() {
	var checkempty = true;

	if (checkEmptyElement($('#CreateInputACCENUMB'))) checkempty = false;
	if (checkNaNElement($('#CreateInputACCENUMB'))) checkempty = false;
	if (checkEmptyElement($('#CreateInputCOUNTRY'))) checkempty = false;	
	if (checkEmptyElement($('#CreateInputACCENAME'))) checkempty = false;
	if (checkEmptyElement($('#CreateInputYEAR'))) checkempty = false;
	if (checkNaNElement($('#CreateInputYEAR'))) checkempty = false;
	if (checkEmptyElement($('#CreateInputHEIGHT'))) checkempty = false;
	if (checkNaNElement($('#CreateInputHEIGHT'))) checkempty = false;
	if (checkEmptyElement($('#CreateInputDATEM'))) checkempty = false;
	if (checkNaNElement($('#CreateInputDATEM'))) checkempty = false;
	if (checkEmptyElement($('#CreateInputDATED'))) checkempty = false;
	if (checkNaNElement($('#CreateInputDATED'))) checkempty = false;	
	if (checkNaNElement($('#CreateInputSTAB1'))) checkempty = false;
	if (checkNaNElement($('#CreateInputSTAB2'))) checkempty = false;
	if (checkNaNElement($('#CreateInputSTAB3'))) checkempty = false;
		
	if(checkempty == false) return;
	
	$('#createPopUp').animate({opacity: 0}, 198, function(){
    	$(this).css('display', 'none');
      	$('#createOverlay').fadeOut(297);
    });
    
	$.ajax({
		type: "POST",
		url: "createsample",
		data: {
			CreateInputACCENUMB:$('#CreateInputACCENUMB').val(),
			CreateInputCOUNTRY:$('#CreateInputCOUNTRY').val(),
			CreateInputACCENAME:$('#CreateInputACCENAME').val(),
			CreateInputYEAR:$('#CreateInputYEAR').val(),
			CreateInputHEIGHT:$('#CreateInputHEIGHT').val(),
			CreateInputDATEM:$('#CreateInputDATEM').val(),
			CreateInputDATED:$('#CreateInputDATED').val(),
			CreateInputSTAB1:$('#CreateInputSTAB1').val(),
			CreateInputSTAB2:$('#CreateInputSTAB2').val(),
			CreateInputSTAB3:$('#CreateInputSTAB3').val()
		},
		success: function(response) {
			ajaxSearch();
			$('#createPopUp').animate({opacity: 0}, 198, function(){
    			$(this).css('display', 'none');
      			$('#createOverlay').fadeOut(297);
   			});
		}
	});

};