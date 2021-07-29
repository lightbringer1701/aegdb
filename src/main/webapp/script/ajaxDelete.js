function ajaxDelete(id) {
	var SENDID = id;
	$.ajax({
		type: "POST",
		url: "delete",
		data: {
			DELETEID:SENDID
		},
		success: function(response) {
			ajaxSearch();
		}
	});
};