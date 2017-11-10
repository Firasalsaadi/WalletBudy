$(function() {  
	//----- OPEN
	$('[data-popup-open]').on('click', function(e)  {
		var targeted_popup_class = jQuery(this).attr('data-popup-open');
		$('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);

		e.preventDefault();
	});

	//----- CLOSE
	$('[data-popup-close]').on('click', function(e)  {
		var targeted_popup_class = jQuery(this).attr('data-popup-close');
		$('[data-popup="' + targeted_popup_class + '"]').fadeOut(650);

		e.preventDefault();
	});
	
	//----- CLOSE EDIT CATEGORY FORM
	$('#popupeditformclose').on('click', function(e)  { 
		$('#popupeditform').fadeOut(650);

		e.preventDefault();
	});
	 
});



$().ready(function() {
	
	$('.selectpicker').hide();
	
	
	$("#signupForm").validate({
		rules: {  
			firstName: {
				required: true,
				minlength: 2
			},
			lastName: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			} 
		},
		messages: { 
			firstName: {
				required: "Please enter your First Name",
				minlength: "Your First Name must consist of at least 2 characters"
			},
			lastName: {
				required: "Please enter your Last Name",
				minlength: "Your Last Name must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password confirmation",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address" 
		}
	});
	});






$(document).on('click', '#close-preview', function(){ 
    $('.image-preview').popover('hide');
    // Hover befor close the preview
    $('.image-preview').hover(
        function () {
           $('.image-preview').popover('show');
        }, 
         function () {
           $('.image-preview').popover('hide');
        }
    );    
});

$(function() {
    // Create the close button
    var closebtn = $('<button/>', {
        type:"button",
        text: 'x',
        id: 'close-preview',
        style: 'font-size: initial;',
    });
    closebtn.attr("class","close pull-right");
    // Set the popover default content
    $('.image-preview').popover({
        trigger:'manual',
        html:true,
        title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
        content: "There's no image",
        placement:'bottom'
    });
    // Clear event
    $('.image-preview-clear').click(function(){
        $('.image-preview').attr("data-content","").popover('hide');
        $('.image-preview-filename').val("");
        $('.image-preview-clear').hide();
        $('.image-preview-input input:file').val("");
        $(".image-preview-input-title").text("Browse"); 
    }); 
    // Create the preview image
    $(".image-preview-input input:file").change(function (){     
        var img = $('<img/>', {
            id: 'dynamic',
            width:250,
            height:200
        });      
        var file = this.files[0];
        var reader = new FileReader();
        // Set preview image into the popover data-content
        reader.onload = function (e) {
            $(".image-preview-input-title").text("Change");
            $(".image-preview-clear").show();
            $(".image-preview-filename").val(file.name);            
            img.attr('src', e.target.result);
            $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
        }        
        reader.readAsDataURL(file);
    });  
});



 
$(document).ready(function (e) { 
	
	$("#editUser").on('submit',(function(e) {
		e.preventDefault(); 
		$.ajax({
		url: "user/edituser/"+document.catId,         
		type: "POST",              
		data: new FormData(this), 
		contentType: false,        
		cache: false,             
		processData:false,         
		success: function(data)   
		{ 
		   $(document.activeElm).replaceWith(data); // alert(data); 
		   $('#popupeditform').fadeOut(650);
		   $('[ww]').attr('onClick','editRow(this)');
	   	   $('[www]').attr('onClick','deleteRow(this)');
		}
		});
		}));
	
	

	// Function to preview image after validation
	$(function() {
	$("#file").change(function() {
	$("#message").empty(); // To remove the previous error message
	var file = this.files[0];
	var imagefile = file.type;
	var match= ["image/jpeg","image/png","image/jpg"];
	if(!((imagefile==match[0]) || (imagefile==match[1]) || (imagefile==match[2])))
	{
	$('#previewing').attr('src','noimage.png');
	$("#message").html("<p id='error'>Please Select A valid Image File</p>"+"<h4>Note</h4>"+"<span id='error_message'>Only jpeg, jpg and png Images type allowed</span>");
	return false;
	}
	else
	{
	var reader = new FileReader();
	reader.onload = imageIsLoaded;
	reader.readAsDataURL(this.files[0]);
	}
	});
	});
	 
});   




function deleteRow(elm){
	 
	$.ajax({
		url: "user/deluser/"+$(elm).parent().parent().attr('catId'),  
		type: "GET",              
		contentType: false,       
		cache: false,           
		processData:false,        
		success: function(data)   
		{  
		  $(elm).parent().parent().hide(500);
		}
		});
	
	 
}

document.catId = "";
document.activeElm = "";
document.activeSelect = "";

function editRow(elm){

	$('#popupeditform').fadeIn(600);
	
	document.catId =  $(elm).parent().parent().attr('catId');
	
	document.activeSelect =  $(elm).parent().parent().attr('cat-type');
	
	document.activeElm = $(elm).parent().parent();
	 
	$('#editforminputtext').val( $(elm).parent().parent().attr('cat-name') );
	 
	$('[value='+document.activeSelect+']').attr('selected','selected');
}



 
