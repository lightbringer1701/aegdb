function ajaxSearch() {
	$.ajax({
		type: "POST",
		url: "search",
		data: {
				SearchType:$('#SearchType').val(),
				SearchMove:$('#SearchMove').val(),
				SearchInputACCENUMB:$('#SearchInputACCENUMB').val(),
				SearchInputCOUNTRY:$('#SearchInputCOUNTRY').val(),
				SearchInputACCENAME:$('#SearchInputACCENAME').val(),
				SearchInputYEAR:$('#SearchInputYEAR').val(),
				SearchInputHEIGHT:$('#SearchInputHEIGHT').val(),
				SearchInputDATE:$('#SearchInputDATE').val(),
				SearchInputSTAB1:$('#SearchInputSTAB1').val(),
				SearchInputSTAB2:$('#SearchInputSTAB2').val(),
				SearchInputSTAB3:$('#SearchInputSTAB3').val()
				},
		success: function(response) {
				$('#ResultContent').html(response);
		}
	});
};