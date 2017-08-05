function newMyWindow(e) {
  var h = 500;
  var w = 500;
  myWindow = window.open(e, '', 'scrollbars=1,height='+Math.min(h, screen.availHeight)+',width='+Math.min(w, screen.availWidth)+',left='+Math.max(0, (screen.availWidth - w)/2)+',top='+Math.max(0, (screen.availHeight - h)/2));
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
			$('#totalItems').html(data[2]);
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


function find() {
	$.ajax({
		url : 'find',
		dataType: 'json',
		data : ({categoryId: $('#categoryId').val(),vegetarian: $('#vegetarian').prop("checked")}),
		success : function(data) {
				
			var out = '';
			for (var key in data){
				var vegetarian = (data[key]['vegetarian'] > 0) ? 'No' : 'Yes';
				out+='<div>';
				out+='<div class="thumbnail">';
				out+='<img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive">';
				out+='<div class="caption">';
				out+='<h3>';
				out+='<a href="#">'+data[key]['name']+'</a>';
				out+='</h3>';
				out+='<p>Category: '+data[key]['category']+'</p>';//????
				out+='<p>'+data[key]['description']+'</p>';
				out+='<p> Price: '+data[key]['price']+'</p>';
				out+='<p> Vegetarian: '+vegetarian+'</p>';
				out+='<p> Weight: '+data[key]['weight']+'</p>';
				out+='<a target="_self" id="'+data[key]['id']+'" class="btn btn-danger" onclick="addAjax('+data[key]['id']+')"><i class="glyphicon glyphicon-shopping-cart"></i></a>'
				out+='</div>';
				out+='</div>';
				out+='</div>';
				// out+='<input type="checkbox" class="add-to-cart"
				// data-art="'+key+'"
				// data-art-name="'+data[key]['name']+'"/></h3>';
				// out+='<p> price: '+data[key]['cost']+' € </p>';
				// out+='<p>'+data[key]['description']+'</p> <br>';
				//  out+='<p><a href="images/'+key+'.png"><img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive"></a></p> <br>';
// out+='</div>';
				//  out+='</div>';
				
				 
			}
			console.log(data);
			$('#goods').html(out);
				
		}

	});
	}



//************************************************************
var vegetarian = (data[key]['vegetarian'] > 0) ? 'Yes' : 'No';
out+='<div>';
out+='<div class="thumbnail">';
out+='<img src="/intbuffetproject/getImage?id='+data[key]['id']+'" class="img-responsive">';
out+='<div class="caption">';
out+='<h3>';
out+='<a href="#">'+data[key]['name']+'</a>';
out+='</h3>';
out+='<p>Category: '+data[key]['category']+'</p>';//????
out+='<p>'+data[key]['description']+'</p>';
out+='<p> Price: '+data[key]['price']+'</p>';
out+='<p> Vegetarian: '+vegetarian+'</p>';
out+='<p> Weight: '+data[key]['weight']+'</p>';
out+='<a target="_self" id="'+data[key]['id']+'" class="btn btn-danger" onclick="addAjax('+data[key]['id']+')"></a>'
out+='</div>';
out+='</div>';
out+='</div>';


//************************************************************



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
	// var href="updateOrder/"+id+"/"+status;
	console.log(href);
	$('a[refattr="'+id+'"]').attr("href",href);
	
}

