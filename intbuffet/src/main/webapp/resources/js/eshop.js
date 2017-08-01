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

function addAjax(articul,price,quantity) {
	$.ajax({
		type: "GET",
		url : 'add',
		data : ({idgood: articul}),
		success : function(data) {
			
			}

});  
	var total = price *quantity;
	$('#totalItem').html(total);
	return false;
}

function deleteAjax(articul,price,quantity) {
	$.ajax({
		type: "GET",
		url : 'delete',
		data : ({idgood: articul}),
		success : function(data) {
			
			}

});  
	var total = price *quantity;
	$('#totalItem').html(total);
	return false;
}

function find() {
	$.ajax({
		url : 'find',
		dataType: 'json',
		data : ({categoryId: $('#categoryId').val(),vegetarian: $('#vegetarian').prop("checked")}),
		success : function(data) {
				
			var out = '';
			for (var key in data){
				out+='<div> ';
				out+='<div class="thumbnail">';
				
				  out+='<h3>'+data[key]['name'];
				//  out+='<input type="checkbox" class="add-to-cart" data-art="'+key+'" data-art-name="'+data[key]['name']+'"/></h3>';
				//  out+='<p> price: '+data[key]['cost']+' € </p>';
				//  out+='<p>'+data[key]['description']+'</p> <br>';
				  out+='<p><a href="images/'+key+'.png"><img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive"></a></p> <br>';
				  out+='</div>';
				  out+='</div>';
				
				 
			}
			//console.log(data);
			$('#goods').html(out);
				
		}

	});
	}

