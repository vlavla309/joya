$(function() {
	var datas=[
		{y: "2017-01-01", a: 100}, 
		{y: "2017-01-02", a: 122}, 
		{y: "2017-01-03", a: 33}, 
		{y: "2017-01-04", a: 44}, 
		{y: "2017-01-05", a: 44}, 
		{y: "2017-01-06", a: 111},
		{y: "2017-01-07", a: 111}

			];
	
	var dates=[
	    { y: '2006', a: 100, b: 90 },
	    { y: '2007', a: 75,  b: 65 },
	    { y: '2008', a: 50,  b: 40 },
	    { y: '2009', a: 75,  b: 65 },
	    { y: '2010', a: 50,  b: 40 },
	    { y: '2011', a: 75,  b: 65 },
	    { y: '2012', a: 100, b: 90 }
	  ];

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

});
