$(function() {
	/* Submit form using Ajax */
	$('button[type=submit]').click(function(e) {

		// Prevent default submission of form
		e.preventDefault();

		// Remove all errors
		$('input').next().remove();

		saveEmployee($('form[name=employeeForm]').serialize());
	});
});

function saveEmployee(employee) {
	$.post({
		url : 'saveEmployee',
		data : employee,
		success : function(res) {
			display(res);
		}
	})
}

function display(res) {
	if (res.validated) {
		// Set response
		$('#resultContainer pre code').text(JSON.stringify(res.employee));
		$('#resultContainer').show();

	} else {
		// Set error messages
		$.each(res.errorMessages, function(key, value) {
			$('input[name=' + key + ']').after(
					'<span class="error">' + value + '</span>');
		});
	}
}
