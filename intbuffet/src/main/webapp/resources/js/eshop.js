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
		url : 'add_to_cart',
		data : ({idgood: articul}),
		success : function(data) {
			console.log(data);
			$('#total_price').html('&#8364; '+ data[0]);
			$('input[cartAttr="'+articul+'"]').val(data[1]);
			}

});  
	
	return false;
}

function deleteAjax(articul,price,quantity) {
	$.ajax({
		type: "GET",
		url : 'delete_from_cart',
		data : ({idgood: articul}),
		success : function(data) {
			$('#total_price').html('&#8364; '+ data[0]);
			$('input[cartAttr="'+articul+'"]').val(data[1]);
			}

});  
	
	return false;
}




function getSumma(goods) {
	console.log("**********");
   // return _.reduce(cartData, function(sum, item) {return sum + item.count *
	// item.price}, 0);
}  

function find() {
	$.ajax({
		url : 'find',
		dataType: 'json',
		data : ({categoryId: $('#categoryId').val(),vegetarian: $('#vegetarian').prop("checked")}),
		success : function(data) {
				
			var out = '';
			for (var key in data){
// out+='<div> ';
				out+='<div class="thumbnail">';
				
				  out+='<h3>'+data[key]['name'];
				// out+='<input type="checkbox" class="add-to-cart"
				// data-art="'+key+'"
				// data-art-name="'+data[key]['name']+'"/></h3>';
				// out+='<p> price: '+data[key]['cost']+' € </p>';
				// out+='<p>'+data[key]['description']+'</p> <br>';
				  out+='<p><a href="images/'+key+'.png"><img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive"></a></p> <br>';
// out+='</div>';
				  out+='</div>';
				
				 
			}
			// console.log(data);
			$('#goods').html(out);
				
		}

	});
	}


function changeHref(id) {
	console.log(id);
	var category =  $('input[attr="'+id+'"]').val();
	var href="updateCategory/"+id+"/"+category;
	console.log(href);
	$('a[refattr="'+id+'"]').attr("href",href);
	
}

function changeHrefOrder(id) {
	console.log(id);
	var status =  $('select[optionAttr="'+id+'"] option:selected').text();
	var obj = {id: id,status:status}
	var href="updateOrder?"+$.param(obj);
	//var href="updateOrder/"+id+"/"+status;
	console.log(href);
	$('a[refattr="'+id+'"]').attr("href",href);
	
}

