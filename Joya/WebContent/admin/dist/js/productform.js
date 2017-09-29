/**
 * author 김형주
 */
var rowIndex=1;

$(document).ready(function () {
	//start of the document ready function

	$('.userInfoBtn').click(function () {
		var email = $(this).attr("value");
		console.log(email);
		getUserInfo(email);
		$('#myModal').modal('show');
	});
});


function addFile(form){
	if(rowIndex > 6) return false;
	rowIndex++;

	var content="";

	content+="<div>";
	content+="<div class='form-group' id='fileForm"+rowIndex+"'>";
	content+="<label>사진 등록 ("+rowIndex+")</label>";
	content+="<INPUT TYPE='FILE' NAME='filename" + rowIndex + "' size=25>";
	content+="</div>";
	console.log(content);
	$("#imageForm").append(content);
}

//첨부파일 삭제
function deleteFile(form){
	if(rowIndex<2){
		return false;
	}else{
		var target="div[id=fileForm"+rowIndex+"]";
		$(target).remove();
		rowIndex--;
	}
}





