/**
 * author 김형주
 */


$(document).ready(function () {
	//start of the document ready function
	
	$('.userInfoBtn').click(function () {
		var email = $(this).attr("value");
		console.log(email);
		getUserInfo(email);
		$('#myModal').modal('show');
	});
});


function getUserInfo(email){
	$.ajax({
		url: '/admin/UserInfoController',
		data: { 'email': email },
		type: 'get',
		dataType : "json",
		success: function (data) {
			console.log(data.user)
		}, error: function (err) {
			
		}
	});
}



