<%@ page language="java" %>
<html>
<head>
 
 <script src="./resources/js/Chart.bundle.js"></script>
    <script src="./resources/js/utils.js"></script>
 
 
<body style="background-color: #f2f2f2">

 
	<style>
		canvas {
				-moz-user-select: none;
				-webkit-user-select: none;
				-ms-user-select: none;
		}
	</style>
 

 
	<div style="width:100%;">
		<canvas id="canvas"></canvas>
	</div>
	<br>
	<br> 
	<script>
		var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		var config = {
			type: 'line',
			data: {
				labels: [ <% out.println( request.getAttribute("dates") ); %> ],
				datasets: [
				 {
					label: "My Wallet Ballance",
					borderColor: window.chartColors.blue,
					backgroundColor: window.chartColors.blue,
					data: [ <% out.println( request.getAttribute("money") ); %> ],
				} ]
			},
			options: {
				responsive: true,
				title:{
					display:true,
					text:"My Wallet Ballance"
				},
				tooltips: {
					mode: 'index',
				},
				hover: {
					mode: 'index'
				},
				scales: {
					xAxes: [{
						scaleLabel: {
							display: true,
							labelString: 'Time Interval'
						}
					}],
					yAxes: [{
						stacked: true,
						scaleLabel: {
							display: true,
							labelString: 'Ballance Value Change'
						}
					}]
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById("canvas").getContext("2d");
			window.myLine = new Chart(ctx, config);
		}; 
	</script> 













</body>
</html>