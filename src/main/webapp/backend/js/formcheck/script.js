function formCheck(obj){
	var error = 0;
	//get all input field with type=text
	var input_field = $(obj).find('input[formcheck="1"][type="text"]');
	$(input_field).each(function(){
		var content = $(this).val();
		if(content == ''){
			alert($(this).attr("errMsg"));
			$(this).focus();
			error = 1;
			return false;
		}
	});
	
	//get textarea
	if(error == 0){		
		var textarea = $(obj).find('textarea[formcheck="1"]');
		$(textarea).each(function(){
			var content = $(this).val();
			if(content == ''){
				alert($(this).attr("errMsg"));
				$(this).focus();
				error = 1;
				return false;
			}
		});
	}
	
	//get input field with type=file
	if(error == 0){		
		var file_field = $(obj).find('input[formcheck="1"][type="file"]');
		$(file_field).each(function(){
			var content = $(this).val();
			if(content == ''){
				alert($(this).attr("errMsg"));
				$(this).focus();
				error = 1;
				return false;
			}
		});
	}
	
	if(error == 0){
		return true;
	}
}

function mceChecker(obj){
	var error = 0;
	var textarea = $(obj).find('textarea[mceEditor="1"]');
	$(textarea).each(function(){
		var content = tinyMCE.get($(this).attr('id')).getContent();
		if(content == ''){
			alert($(this).attr("errMsg"));
			$(this).focus();
			error = 1;
			return false;
		}
	});
	
	if(error == 0){
		return true;
	}
}