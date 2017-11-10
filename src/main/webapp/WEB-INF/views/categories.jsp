<%@ include file="header.jsp" %> 
<link rel="stylesheet" type="text/css" href="./resources/css/popupformmain.css">
<link rel="stylesheet" type="text/css" href="./resources/css/categories.css">
<script src="./resources/css/categories.js"></script>  
<link rel="stylesheet" type="text/css" href="./resources/css/bootstrap-select.min.css">
<script src="./resources/js/bootstrap-select.min.js"></script>  
 

<!--  ==================================================== CREATE NEW CATEGORY POP-UP=================================    -->
<div class="popup" data-popup="popup-3" id="popupform">
	<div class="popup-inner">
		<a class="popup-close" data-popup-close="popup-3" href="#">x</a>
		<div class="row">


			<form id="createCategory" action="" method="post"
				enctype="multipart/form-data">

				<div class="col-md-4">


					<div style="width: 60px;">
						<select class="selectpicker" name="select"  data-size="15">

							<c:if test="${!empty catImages }">
								<c:forEach items="${catImages }" var="ci">
									<option value="${ci.name }"
										data-content='<img style="width:50px;" src="./category/image/${ci.name}">'>Club</option>
								</c:forEach>
							</c:if> 
						</select>
					</div>
				</div>
				<div style="width: 200px; margin-left: 140px; position: absolute;">
					<input type="text" name="text" class="form-control input-lg" placeholder="New Category Name.." required 
						   style="height: 63px; width: 280px;" />
				</div>

				<div style="width: 200px; margin-left: 425px; position: absolute;">
					<select name="type" class=" " style="font-size: 26px; padding: 14px; border-radius: 8px;">
						<option value="Expence">Expence</option>
						<option value="Income">Income</option>
					</select>
				</div>

				<input type="file" name="file" id="file" class="btn" style="display: none;" />

				<div style="width: 200px; margin-left: 585px; position: absolute;">
					<input type="submit" value="Create Category" class="submit btn" style="padding: 19px; font-size: 18px;" />
				</div>
			</form>
		</div>
 
	</div>
</div>
 
<div class="popup" id="popupeditform">
	<div class="popup-inner">
		<a class="popup-close" id="popupeditformclose" href="#">x</a>
		<div class="row">


			<form id="editCategory" action="" method="post" enctype="multipart/form-data">

				<div class="col-md-4">


					<div style="width: 60px;">
						<select class="selectpicker" name="select" data-size="15">

							<c:if test="${!empty catImages }">
								<c:forEach items="${catImages }" var="ci">
									<option value="${ci.name }" 
										data-content='<img style="width:50px;" src="./category/image/${ci.name}">'>Club</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
				</div>
				<div style="width: 200px; margin-left: 140px; position: absolute;">
					<input id="editforminputtext" type="text" name="text" class="form-control input-lg" placeholder="Category New Name.." required 
						   style="height: 63px; width: 280px;" />
				</div>

				<div style="width: 200px; margin-left: 425px; position: absolute;">
					<select name="type"  id="editselect" style="font-size: 26px; padding: 14px; border-radius: 8px;">
						<option value="Expence">Expence</option>
						<option value="Income">Income</option>
					</select>
				</div>

				<input type="file" name="file" id="file" class="btn" style="display: none;" />

				<div style="width: 200px; margin-left: 585px; position: absolute;">
					<input type="submit" value="Update Category" class="submit btn" style="padding: 19px; font-size: 18px;" />
				</div>
			</form>
		</div>
 
	</div>
</div> 
 
<div class="container" style="margin-top: 180px; width:730px;">
<p>
	<a class="btn" data-popup-open="popup-3" href="#"> <span
		class="glyphicon glyphicon-plus"></span> Create New Category
	</a>
</p>
<hr />
	<div id="catList" class="cont">
<c:if test="${!empty categories}">
			<c:forEach items="${categories}" var="c">
				<div class="row tr"  catId="${c.id}" cat-image="${c.image }" cat-name="${c.name }" cat-type="${c.type}" alt="asdsa">
					<div class="col-sm-6">
						<span class="svgImg"><img src="./category/image/${c.image }" class="img-circle" style="width:50px;margin-left:7px;">
						   <p class="par">${c.name }</p></span>
					</div>
					<div class="col-sm-2"><p class="par2" style='color:${c.color}'>${c.type }</p></div>
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