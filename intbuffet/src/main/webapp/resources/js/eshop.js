function newMyWindow(e) {
  var h = 500;
  var w = 500;
  myWindow = window.open(e, '', 'scrollbars=1,height='+Math.min(h, screen.availHeight)+',width='+Math.min(w, screen.availWidth)+',left='+Math.max(0, (screen.availWidth - w)/2)+',top='+Math.max(0, (screen.availHeight - h)/2));
  }

function doAjax() {
$.ajax({
	url : 'checkStrength',
	data : ({password: $('#password').val()}),
	success : function(data) {
			$('#strengthValue').html(data);
			
	}

});
}

function addAjax(articul) {
	$.ajax({
		type: "GET",
		url : 'add',
		data : ({idgood: articul}),
		success : function(data) {
			console.log(data);
	}

});
}

