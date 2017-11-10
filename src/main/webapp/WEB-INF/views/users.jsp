<%@ include file="header.jsp" %> 
<link rel="stylesheet" type="text/css" href="./resources/css/popupformmain.css">
<link rel="stylesheet" type="text/css" href="./resources/css/users.css">
<script src="./resources/css/users.js"></script>  
<link rel="stylesheet" type="text/css" href="./resources/css/bootstrap-select.min.css"> 
 
<div class="popup" id="popupeditform">
	<div class="popup-inner">
		<a class="popup-close" id="popupeditformclose" href="#">x</a>
		<div class="row"> 
			<form id="editUser" action="" method="post" enctype="multipart/form-data"> 
				<div style="width: 140px; margin-left:  5px; float:left; ">
					<select name="role"  id="editselect" style="font-size: 26px; padding: 14px; border-radius: 8px;">
						<option value="user">User</option>
						<option value="admin">Admin</option>
					</select>
				</div> 
				<input type="file" name="file" id="file" class="btn" style="display: none;" /> 
				<div style="width: 200px; margin-left: 125px;  ">
					<input type="submit" value="Update User" class="submit btn" style="padding: 19px; font-size: 18px;" />
				</div>
			</form>
		</div> 
	</div>
</div>  

<div class="container" style="margin-top: 160px; width:730px;">
<h2> Edit Users </h2>
<hr />
	<div id="catList" class="cont">
<c:if test="${!empty userList}">
			<c:forEach items="${userList}" var="u">
				<div class="row tr"  catId="${u.id}" cat-image="${ u.photo}" cat-name="${u.firstName } ${u.lastName }" cat-type="${u.role }" alt="asdsa">
					<div class="col-sm-7">
						<span class="svgImg"><img src="./user/image/${u.photo }" class="img-circle" style="width:50px;margin-left:7px;">
						   <p class="par">${u.firstName } ${u.lastName }</p></span>
					</div>
					<div class="col-sm-1"><p class="par2" style='color:blue'>${u.role } </p></div>
					<div class="col-sm-2">
					    <a class="btn" style="margin-left:45px;margin-top:7px;" onclick="editRow(this)"><span class="glyphicon glyphicon-edit"></span> Edit</a>
					</div>
					<div class="col-sm-2">
						<a class="btn" style="margin-top: 7px;" onclick="deleteRow(this)"> <span class="glyphicon glyphicon-trash"></span> Delete </a>
					</div>
				</div>
			</c:forEach></c:if>
</div>
</div>
<div style="height: 70px;">  </div> 
</body>
</html>