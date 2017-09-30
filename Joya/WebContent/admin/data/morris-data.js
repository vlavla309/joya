var str=[{y: '2017-01-01', a: 100},
{y: '2017-01-02', a: 122}, 
{y: '2017-01-03', a: 33}, 
{y: '2017-01-04', a: 44},
{y: '2017-01-05', a: 44},
{y: '2017-01-06', a: 111},
{y: '2017-01-07', a: 111}];

var datas=new Array();

datas.push({y: '2017-01-01', a: 122});
datas.push({y: '2017-01-02', a: 100});

$(function() {
	console.log(str);
	console.log(datas);
	
	
	setData(datas);
});

function setData(datas){
	Morris.Line({
		element: 'morris-line-chart',
		data: datas,
		xkey: 'y',
		ykeys: ['a'],
		labels: ['방문자수'],
		gridTextSize:'8',
		hideHover: 'auto',
		resize: true
	});
}