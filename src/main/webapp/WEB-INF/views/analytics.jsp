<%@ include file="header.jsp" %>

<script src="./resources/js/Chart.bundle.js"></script>
<script src="http://www.chartjs.org/samples/latest/utils.js"></script>

 

<div style="margin-top:150px;" > 
</div> 



 
 <div class="container" style="width:1170px;background-color: #f2f2f2; border-radius: 30px;box-shadow:0px 20px 25px rgba(0,0,0,1);">
 <div class="row"  style="padding-top: 10px;">
    <div class="col-sm-12"  >
		<iframe src="/walletbuddy/lineareacharts" style="width:1130px;height:600px; " frameborder="0" scrolling="no"></iframe>
    </div>
 </div>
 <div class="row">
  <div class="col-sm-6" style=" ">
  		<iframe width="560px" height="350px"  src="/walletbuddy/accountbalance" frameborder="0" scrolling="no"></iframe>
  </div>
  <div class="col-sm col-sm-offset-6" style=" ">
		<iframe width="560px" height="350px"  src="/walletbuddy/twolines" frameborder="0" scrolling="no"></iframe>
  </div>
</div>
<div class="row" style="padding-bottom: 20px;">
  <div class="col-sm-6" style=" ">
        <label style="font-size: 14px;margin-left: 200px;">Income By Categories</label>
		<iframe  width="560px" height="350px" src="/walletbuddy/piechart" frameborder="0" scrolling="no"></iframe>
  </div>
  <div class="col-sm col-sm-offset-6" style=" ">
        <label style="font-size: 14px;margin-left: 200px;">Expenses By Categories</label>
		<iframe  width="560px" height="350px" src="/walletbuddy/piechart2" frameborder="0" scrolling="no"></iframe>
  </div> 
</div> 
</div>
 
 
 
 



<div style="margin-top:50px;height:70px;" > 
</div>

</body>
</html>