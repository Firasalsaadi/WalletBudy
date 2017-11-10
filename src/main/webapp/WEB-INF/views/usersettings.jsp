<%@ include file="header.jsp" %>


<script src="/walletbuddy/resources/js/jquery.validate.js"></script>

 
<script>


$().ready(function() {
	 
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
</script>
<style>

.image-preview-input {
    position: relative;
    overflow: hidden;
    margin: 0px;    
    color: #333;
    background-color: #fff;
    border-color: #ccc;    
}
.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity=0);
}
.image-preview-input-title {
    margin-left:5px;
}

.signup-btn {
  background: #79bc64;
  background-image: -webkit-linear-gradient(top, #79bc64, #578843);
  background-image: -moz-linear-gradient(top, #79bc64, #578843);
  background-image: -ms-linear-gradient(top, #79bc64, #578843);
  background-image: -o-linear-gradient(top, #79bc64, #578843);
  background-image: linear-gradient(to bottom, #79bc64, #578843);
  -webkit-border-radius: 4;
  -moz-border-radius: 4;
  border-radius: 4px;
  text-shadow: 0px 1px 0px #898a88;
  -webkit-box-shadow: 0px 0px 0px #a4e388;
  -moz-box-shadow: 0px 0px 0px #a4e388;
  box-shadow: 0px 0px 0px #a4e388;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  border: solid #3b6e22  1px;
  text-decoration: none;
}

.signup-btn:hover {
  background: #79bc64;
  background-image: -webkit-linear-gradient(top, #79bc64, #5e7056);
  background-image: -moz-linear-gradient(top, #79bc64, #5e7056);
  background-image: -ms-linear-gradient(top, #79bc64, #5e7056);
  background-image: -o-linear-gradient(top, #79bc64, #5e7056);
  background-image: linear-gradient(to bottom, #79bc64, #5e7056);
  text-decoration: none;
}
.navbar-default .navbar-brand{
		color:#fff;
		font-size:30px;
		font-weight:bold;
	}
.form .form-control { margin-bottom: 10px; }
@media (min-width:768px) {
	#home{
		margin-top:50px;
	}
	#home .slogan{
		color: #0e385f;
		line-height: 29px;
		font-weight:bold;
	}
}
 
</style>


 
 
<div class="container" id="wrap" style="margin-top:90px;">

	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
        
        
        
        <c:if test="${!empty userImage }">
        	<p><img src="/walletbuddy/user/image/${userImage }"  class="img-circle" style="width:250px;margin-left:25%;"/></p>
        </c:if>
        
        
        
        
        
        
	  <c:if test="${!empty userUpdateStatus }">
	  	<b><p>${userUpdateStatus }</p></b>
	  </c:if>
            <form:form id="signupForm" action="/walletbuddy/user/settings/save" method="post" class="form" role="form" modelAttribute="user" enctype="multipart/form-data">   
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
                            <form:input type="text" path="firstName" name="firstName" value="" class="form-control input-lg" placeholder="First Name"  />                        
                        </div>  
                        <div class="col-xs-6 col-md-6">
                            <form:input type="text" path="lastName" name="lastName" value="" class="form-control input-lg" placeholder="Last Name"  />                        
                       </div>
                    </div>
                    <form:input type="text" path="email" name="email" value="" class="form-control input-lg" placeholder="Your Email"  />
                    <form:input type="password" path="password" name="password" value="" class="form-control input-lg" placeholder="Enter Your New Password"  />
                    <form:input type="password" path="" name="confirm_password" value="" class="form-control input-lg" placeholder="Confirm Password"  />                    

 
              <span class="help-block">Update Your Photo</span>
          
            <div class="input-group image-preview">
                <input type="text" class="form-control image-preview-filename" disabled="disabled"> 
                <span class="input-group-btn">
                    
                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;margin-top:-10px;">
                        <span class="glyphicon glyphicon-remove"></span> Clear
                    </button>
                  
                    <div class="btn btn-default image-preview-input" style="margin-top:-10px;">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <span class="image-preview-input-title">Browse</span>
                        <input type="file" accept="image/png, image/jpeg, image/gif" name="input-file-preview"/>  
                    </div>
                </span>
            </div>   
            
                    <hr />
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Update my account</button>
            </form:form>          
</div>  </div> </div> </div> 































</body>
</html>