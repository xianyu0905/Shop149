<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>backend</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/file.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/userSetting.js"></script>
    <script src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/zshop.css"/>

    <%--图表ChartCSS--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"/>

    <%--图表Chart.JS--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>

    <script>
        $(function () {
            $("tr.parent").click(function(){
                $(this)
                    .toggleClass("selected")
                    .siblings('.child_'+this.id).toggle();
            }).click();

        });


    </script>
</head>

<body>
<!-- 系统用户管理 -->
<div class="panel panel-default" id="adminSet">
    <div class="panel-heading">
        <h3 class="panel-title">数据分析</h3>
    </div>
    <div class="panel-body">
       <div style="width: 700px;height: 400px;text-align: center">
           <%--图表 start--%>
           <canvas id="popChart" width="500px" height="300px"></canvas>
           <%--图表 end--%>
       </div>
    </div>
</div>


<script>
    var popCanvas = $("#popChart");
    var popCanvas = document.getElementById("popChart");
    var popCanvas = document.getElementById("popChart").getContext("2d");

    var lable=[];
    var value=[];

    var array = new Array();
    <c:forEach items="${analysisInfo}" var="element">
     //js中可以使用此标签，将EL表达式中的值push到数组中
    lable.push('${element.name }');
    value.push('${element.num }');
    </c:forEach>



    // ["China", "India", "United States", "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh", "Russia", "Japan"]
    // [1379302771, 1281935911, 326625791, 260580739, 207353391, 204924861, 190632261, 157826578, 142257519, 126451398]
    var barChart = new Chart(popCanvas, {
        type: 'bar',
        data: {
            labels: lable,
            datasets: [{
                label: '销售统计',
                data: value,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)',
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)'
                ]
            }]
        }
    });

</script>

</body>

</html>
