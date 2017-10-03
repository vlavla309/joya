

function setData(datas){
	Morris.Line({
		element: 'morris-line-chart',
		postUnits:"명",
		data: datas,
		xkey: 'y',
		ykeys: ['a'],
		xLabels:'day',
		labels: ['방문자수'],
		gridTextSize:'9',
		hideHover: 'auto',
		yLabelFormat: function(y){return y != Math.round(y)?'':y+"명";},
		resize: true,
		parseTime:false
	});
}