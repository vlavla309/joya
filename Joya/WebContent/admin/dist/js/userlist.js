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
		url: '/admin/userinfo.joya',
		data: { 'email': email },
		type: 'get',
		dataType : "json",
		success: function (data) {
			$("#userInfoDiv").html("");
			$("#userInfoDiv").append("<p>이메일 : "+data.email+"</p>");
			$("#userInfoDiv").append("<p>이름 : "+data.name+"</p>");
			$("#userInfoDiv").append("<p>전화번호 : "+data.phone+"</p>");
			$("#userInfoDiv").append("<p>주소 : "+data.address+"</p>");
			$("#userInfoDiv").append("<p>포인트 : "+data.point+"</p>");
			$("#userInfoDiv").append("<p>생일 : "+data.birthdate+"</p>");
			$("#userInfoDiv").append("<p>가입일자 : "+data.regdate+"</p>");
			$("#userInfoDiv").append("<p>회원구분 : "+data.type+"</p>");
		}, error: function (err) {
			
		}
	});
}



