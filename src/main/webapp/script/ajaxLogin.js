function ajaxLogin() {
	var result = 'no';
	$.ajax({
			type: "POST",
			url: "login",
			data: {
				LoginName:$('#LoginName').val(),
				LoginPassword:$('#LoginPassword').val()
				},
			success: function(response) {
				$('#LoginResult').html(response);
				result = response;
				if(result == "Success Login") {
					document.getElementById('LoginName').disabled = true;
					document.getElementById('LoginPassword').disabled = true;
					document.getElementById('LoginRequest').disabled = true;
					document.getElementById('CreateButtonOverlay').disabled = false;
					ajaxSearch();
				};
			}
	});
};