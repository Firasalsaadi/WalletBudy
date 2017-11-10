<%@ include file="header.jsp" %>
 
<link rel="stylesheet" type="text/css" href="./resources/css/popupformmain.css">
<link rel="stylesheet" type="text/css" href="./resources/css/transactions.css">
<script src="./resources/css/transactions.js"></script>  
<link rel="stylesheet" type="text/css" href="./resources/css/bootstrap-select.min.css">
<script src="./resources/js/bootstrap-select.min.js"></script>   

<script src="./resources/datepick/pickmeup.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/datepick/pickmeup.css">
  
 
<div class="container" style="margin-top: 90px; width:1030px;"> 
<div style="width:200px; float:left;">
	<a class="btn" data-popup-open="popup-3" href="#"> <span
		class="glyphicon glyphicon-plus"></span> Create New Transaction
	</a>
</div>
  
<div style="margin-left:130px;width: 200px;float:left; ">
<input type="text" id="search-box3" name="search" size="45" class="form-control input-lg" 
       placeholder="Filter By Category.. "  >
<div id="sugestion-box3" class="sugestion_box"></div>
</div>
 
<div style="margin-left:40px;width: 180px;float:left; ">
<input type="text" id="search-box2" name="search" size="45" class="form-control input-lg" 
       placeholder="Filter By Price.." onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode==46'>
<div id="sugestion-box2" class="sugestion_box"></div>
</div> 

<div style="margin-left:780px; ">
<input type="text" id="search-box" name="search" size="45" class="form-control input-lg" placeholder="Filter By Note..">
<div id="sugestion-box" class="sugestion_box"></div>
</div>
 

<hr />
	<div id="catList" class="cont">
		<c:if test="${!empty transactionsView}">
			<!-- 	<div class="row tr" transId="${t.id}" trans-catid="${t.categoryId }" trans-date="${t.date }" trans-price="${t.price}" trans-color="${t.color}"></div>   -->
				    <table style="width:1060;margin-left: -13px;">
					  <c:forEach items="${transactionsView}" var="tv">
				 <tr class="row tr" transId="${tv.transactionId}" trans-date="${tv.date }" trans-price="${tv.price}" trans-note="${tv.note }" >
				    <td style="padding-left: 30px;">
					  <img src="./category/image/${tv.image }" style="width:40px;float:left;border-radius:10px;" />
					    <p style="font-size:16px;margin-top:10px;font-weight: bold;"> ${tv.categoryName }</p>
					</td>
					<td >
						<p class="par2" style='margin-left:12px; '>${tv.date }</p>
					</td>
					<td style="text-align: center;">
						<p class="par2" style='font-style: italic; font-size: 19px; '>${tv.note }</p>
					</td>
					<td style="text-align: right;">
						<p class="par2" style='color:${tv.color}'>${tv.price }</p>
					</td >
					<td >
						<a class="btn" style="margin-left: 45px; margin-top: 7px;" onclick="editRow(this)">
						    <span class="glyphicon glyphicon-edit"></span> Edit</a>
					</td>
					<td style="padding-right: 30px;" >
						<a class="btn" style="margin-top: 7px;" onclick="deleteRow(this)">
							<span class="glyphicon glyphicon-trash"></span> Delete
						</a>
					</td>
					 </tr>
			    </c:forEach>
			  </table>
		   
		</c:if>
	</div>
</div>
<div style="height: 70px;">  </div> 
 
 <!--  ==================================================== CREATE NEW CATEGORY POP-UP=================================    -->
<div class="popup" data-popup="popup-3" id="popupform">
	<div class="popup-inner">
		<a class="popup-close" data-popup-close="popup-3" href="#">x</a>
		<div class="row"> 
			<form id="createTransaction" action="" method="post" enctype="multipart/form-data">
					<table id="transList"><tr> 
					<td>
						 <select name="selectpicker" class="selectpicker" title="Choose Category.." data-width="260px">
							<optgroup label="Income">
							<c:if test="${!empty catIncome }">
							  <c:forEach items="${catIncome}" var="ci">
								 <option value="${ci.id }"
									data-content="<div style='width:45px; float :left;'>
								                    <img  style='width:40px;border-radius:10px;' src='./category/image/${ci.image }' /></div>
								                    <p class='par'>${ci.name }</p>">Club</option>
							  </c:forEach>
							</c:if>
							</optgroup>
							<optgroup label="Expence">
							<c:if test="${!empty catExpence }">
							  <c:forEach items="${catExpence}" var="ce">
								 <option value="${ce.id }"
									data-content="<div style='width:45px; float :left;'>
								                    <img  style='width:40px;border-radius:10px;' src='./category/image/${ce.image }' /></div>
								                    <p class='par'>${ce.name }</p>">Club</option>
							  </c:forEach>
							</c:if>
							</optgroup>
          				 </select>
					</td>

				<td> 
							<input name="datepicker" id="datepicker" type="text" value="2017-08-21" style="height: 52px;" class="form-control input-lg" /> 
				</td>

				<td>
					<input type="text" name="note" class="form-control input-lg" placeholder="Enter Some Note.." required 
						   style="height: 52px; width: 280px;" />
				</td>

				<td>
					<input  type="text" name="price" class="form-control input-lg" placeholder="  Price" required 
					       onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode==46' 
						   style="height: 52px; width: 150px;" />
				</td>

				<input type="file" name="file" id="file" class="btn" style="display: none;" />

				<td>
					<input type="submit" value="Add Transaction" class="submit btn" style="padding: 15px; font-size: 18px;" />
				</td> 
		 </tr></table>
			</form>
	   </div>
 
	 </div>
</div>
 
 <!--  ==================================================== EDIT CATEGORY POP-UP=================================   <c:if test= "${ci.name == document.activeImg  }" > selected="selected" </c:if>  -->
<div class="popup" id="popupeditform">
	<div class="popup-inner">
		<a class="popup-close" id="popupeditformclose" href="#">x</a>
		<div class="row"> 
			<form id="editTransaction" action="" method="post" enctype="multipart/form-data">
					<table id="transList"><tr> 
					<td>
						 <select name="selectpicker" class="selectpicker" title="Choose Category.." data-width="260px">
							<optgroup label="Income">
							<c:if test="${!empty catIncome }">
							  <c:forEach items="${catIncome}" var="ci">
								 <option value="${ci.id }"
									data-content="<div style='width:45px; float :left;'>
								                    <img  style='width:40px;border-radius:10px;' src='./category/image/${ci.image }' /></div>
								                    <p class='par'>${ci.name }</p>">Club</option>
							  </c:forEach>
							</c:if>
							</optgroup>
							<optgroup label="Expence">
							<c:if test="${!empty catExpence }">
							  <c:forEach items="${catExpence}" var="ce">
								 <option value="${ce.id }"
									data-content="<div style='width:45px; float :left;'>
								                    <img  style='width:40px;border-radius:10px;' src='./category/image/${ce.image }' /></div>
								                    <p class='par'>${ce.name }</p>">Club</option>
							  </c:forEach>
							</c:if>
							</optgroup>
          				 </select>
					</td>

				<td> 
							<input name="datepicker" id="datepicker2" type="text" value="2017-08-21" style="height: 52px;" class="form-control input-lg" /> 
				</td>

				<td>
					<input type="text" name="note" id="note2" class="form-control input-lg" placeholder="Enter Some Note.." required 
						   style="height: 52px; width: 280px;" />
				</td>

				<td>
					<input id="price2" type="text" name="price" class="form-control input-lg" placeholder="  Price" required 
					       onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode==46' 
						   style="height: 52px; width: 150px;" />
				</td>

				<input type="file" name="file" id="file" class="btn" style="display: none;" />

				<td>
					<input type="submit" value="Update Transaction" class="submit btn" style="padding: 15px; font-size: 18px;" />
				</td> 
		 </tr></table>
			</form>
		</div>
 
	</div>
</div>
<!-- ===================================================================================================================================== -->
 
</body>
</html>
