<%@ page language="java" %>
<html>
<head>
 
 <script src="./resources/js/Chart.bundle.js"></script>
    <script src="./resources/js/utils.js"></script>
 
 
<body style="background-color: #f2f2f2">




 <div id="canvas-holder" style="width:100%">

        <canvas id="chart-area" />
    </div> 
    <script>
    var randomScalingFactor = function() {
        return Math.round(Math.random() * 100);
    };
//var colll = rgb(0,0,0); alert(colll);
    var config = {
        type: 'pie',
        data: {
            datasets: [{    
                data: [<% out.println( request.getAttribute("expenceVals") ); %>],
                backgroundColor: [
                	window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.blue,
                    window.chartColors.green,
                    window.chartColors.yellow,
                    '#ff00ff',
                    '#53c100',
                    'rgb(0,0,0)'
                ],
                label: 'Dataset 1'
            }],
            labels: [ <% out.println( request.getAttribute("expenceCats") ); %> ]
        },
        options: {
            responsive: true
        }
    };

    window.onload = function() {
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myPie = new Chart(ctx, config);
    }; 
    </script>



















</body>
</html>