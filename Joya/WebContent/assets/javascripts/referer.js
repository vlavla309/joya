	$(function() {
    	var url = $(location).attr('href');
		$('.referer').each(function(index, item) {
			$(this).attr('value', url);
		});
	})