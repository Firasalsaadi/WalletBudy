
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
	$("#createTransaction").on('submit',(function(e) {
	e.preventDefault();
	$("#message").empty();
	$('#loading').show();
	$.ajax({
	url: "a/addtransaction",         
	type: "POST",              
	data: new FormData(this), 
	contentType: false,        
	cache: false,             
	processData:false,         
	success: function(data)   
	{
	  $('#loading').hide();
	  $("#transList").prepend(data); 
	  $('[data-popup-close]').click();
	  setTimeout(
			  function() 
			  {
			    //do something special
			  }, 1000);
	  window.location.href = "http://localhost:8080/walletbuddy/transactions";
	}
	});
	}));

	$("#editTransaction").on('submit',(function(e) {
		e.preventDefault(); 
		$.ajax({
		url: "a/edittransaction/"+document.transId,         
		type: "POST",              
		data: new FormData(this), 
		contentType: false,        
		cache: false,             
		processData:false,         
		success: function(data)   
		{ 
		   $('#popupeditform').fadeOut(650); 
			  setTimeout(
					  function() 
					  {
					    //do something special
					  }, 1000);
			  window.location.href = "http://localhost:8080/walletbuddy/transactions";
		}
		});
	}));
	
	$("#search-box").keyup(function(){
		$.ajax({
		type: "GET",
		url: "a/filter", 
		data: 'search='+$(this).val(), 
		success: function(data){ 
			
		  if(data.length!=794){   // alert(data.length);
			  $("#sugestion-box").show();
			  $("#sugestion-box").html(data); 
		  }
		  else{
		  	  $("#search-box").css("background","#FFF");
		  	  $("#sugestion-box").hide();
		  }
		},
		error: function(){
            //alert("Errr..");
       }
		});
	});

	$("#search-box2").keyup(function(){
		$.ajax({
		type: "GET",
		url: "a/filterprice", 
		data: 'search='+$(this).val(), 
		success: function(data){ 
			
		  if(data.length!=794){   // alert(data.length);
			  $("#sugestion-box").show();
			  $("#sugestion-box").html(data); 
		  }
		  else{
		  	  $("#search-box").css("background","#FFF");
		  	  $("#sugestion-box").hide();
		  }
		},
		error: function(){
           // alert("Errr..");
       }
		});
	});

	$("#search-box3").keyup(function(){
		$.ajax({
		type: "GET",
		url: "a/filtercategory", 
		data: 'search='+$(this).val(), 
		success: function(data){ 
			
		  if(data.length!=794){   
			  $("#sugestion-box").show();
			  $("#sugestion-box").html(data);  
		  }
		  else{
		  	  $("#search-box").css("background","#FFF");
		  	  $("#sugestion-box").hide();
		  }
		},
		error: function(){
           // alert("Errr..");
       }
		});
	});
	
	

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
 
 
 
addEventListener('DOMContentLoaded', function () { 
	pickmeup('#datepicker', {
		position       : 'bottom',
		hide_on_select : true
	});
});
addEventListener('DOMContentLoaded', function () { 
	pickmeup('#datepicker2', {
		position       : 'bottom',
		hide_on_select : true
	});
});
 
 

function deleteRow(elm){
	 
	$.ajax({
		url: "a/deltransaction/"+$(elm).parent().parent().attr('transId'),  
		type: "GET",              
		contentType: false,       
		cache: false,           
		processData:false,        
		success: function(data)   
		{  
			window.location.href = "http://localhost:8080/walletbuddy/transactions";
		}
		});
	
	 
}

document.catId = "";
document.activeElm = "";
document.activeSelect = "";

function editRow(elm){

	$('#popupeditform').fadeIn(600);
	
	document.transId =  $(elm).parent().parent().attr('transId');
	
	document.activeSelect =  $(elm).parent().parent().attr('cat-type');
	
	document.activeElm = $(elm).parent().parent();
	 
	$('#editforminputtext').val( $(elm).parent().parent().attr('cat-name') );
	
	$('#datepicker2').val( $(elm).parent().parent().attr('trans-date') );
	$('#note2').val( $(elm).parent().parent().attr('trans-note') );
	
	var price = $(elm).parent().parent().attr('trans-price');
	if (price.indexOf('-') > -1)
	{
	  price = price.substring(1,price.length)
	}
	
	$('#price2').val( price );
	 
	$('[value='+document.activeSelect+']').attr('selected','selected');
}


$( document ).ready(function() {
    hljs.initHighlightingOnLoad();
    $('table').addClass('table table-striped table-hover');
    $('pre').addClass('highlight');
});

$('body').scrollspy({
    target: '.bs-sidebar',
});

$('.bs-sidebar').affix({
  offset: {
    top: 210
  }
});

/* Prevent disabled links from causing a page reload */
$("li.disabled a").click(function() {
    event.preventDefault();
});
