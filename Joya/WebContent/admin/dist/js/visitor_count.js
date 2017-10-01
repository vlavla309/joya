/**
 * visitor_count.jsp
 * 방문자수 날짜 변경 이벤트 처리
 * 
 */

$(function() {
	
	$("#visitDate").change(function(){
		location.href="/admin/visitors.joya?date="+$(this).val();
	})
});
