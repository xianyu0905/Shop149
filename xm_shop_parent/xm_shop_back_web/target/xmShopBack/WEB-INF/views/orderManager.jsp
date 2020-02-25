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

    <script>
        $(function () {
            $("tr.parent").click(function(){
                $(this)
                    .toggleClass("selected")
                    .siblings('.child_'+this.id).toggle();
            }).click();

            /*分页插件的初始化*/
            $('#pagination').bootstrapPaginator({
                bootstrapMajorVersion: 3,
                currentPage: ${pageInfo.pageNum},
                totalPages: ${pageInfo.pages},
                numberOfPages:${pageInfo.pageSize},
                itemTexts: function (type, page, current) {
                    switch (type) {
                        case 'first':
                            return '首页';
                        case 'prev':
                            return '上一页';
                        case 'next':
                            return '下一页';
                        case 'last':
                            return '末页';
                        case 'page':
                            return page;
                    }
                },
                <%--pageUrl: function (type, page, current) {--%>
                <%--return '${pageContext.request.contextPath}/admin/system_user/manager/getAllSystemUsers?pageNum='+ page;--%>
                <%--}--%>
                <%--TODO:此设置是在当前页面查找--%>
                onPageClicked: function (event, orignalEvent, type, page) {
                    $('#pageNum').val(page);
                    $('#frmSearch').submit();
                }
            });
        });

    </script>
</head>

<body>
<!-- 系统用户管理 -->
<div class="panel panel-default" id="adminSet">
    <div class="panel-heading">
        <h3 class="panel-title">订单管理</h3>
    </div>
    <div class="panel-body">

        <%--添加系统用户 start--%>
<%--        <input type="button" value="添加系统用户" class="btn btn-primary" id="doAddManger">--%>
        <div class="show-list text-center" style="position: relative; top: 10px;">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">序号</th>
                    <th class="text-center">订单号</th>
                    <th class="text-center">收件人</th>
                    <th class="text-center">订单状态</th>
                    <th class="text-center">订单总价</th>
                    <th class="text-center">收获地址</th>
                    <th class="text-center">下单时间</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <c:forEach items="${pageInfo.list}" var="order"  varStatus="idxStatus">
                    <tr  class="parent" id="row_${idxStatus.index+1}">
                        <td>${idxStatus.index+1}</td>
                        <td>${order.orderNumber}</td>
                        <td>${order.customer.name}</td>
                        <td>
                            <span>
                                    <c:if test="${order.status == 0}">待支付</c:if>
                                    <c:if test="${order.status == 1}">买家已支付待发货</c:if>
                                    <c:if test="${order.status == 2}">卖家已发货待收货</c:if>
                                    <c:if test="${order.status == 3}">交易已完成</c:if>
                                    <c:if test="${order.status == 4}">订单已取消</c:if>
                                </span>
                        </td>
                        <td>${order.price}</td>
                        <td>${order.address}</td>
                        <td>
                            <fmt:formatDate value="${order.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td class="text-center">

                            <button class="btn btn-info" data-toggle="modal"
                                    data-target="#addUserModal">展开订单详情</button>
                        </td>
                    </tr>
                    <tr class="child_row_${idxStatus.index+1} text-info">
                                <th class="text-center">图片</th>
                                <th class="text-center">商品名称</th>
                                <th class="text-center">数量</th>
                                <th class="text-center">单价</th>
                                <th class="text-center">总价</th>
                    </tr>
                    <c:forEach items="${order.orderItemList}" var="orderItem" >
                        <tr  class="child_row_${idxStatus.index+1}">
                            <td>
                               <img width="30px" height="30px" src="${pageContext.request.contextPath}/admin/product/images${orderItem.product.image}"/>
                            </td>
                            <td>${orderItem.product.name}</td>
                            <td>${orderItem.num}</td>
                            <td>${orderItem.product.price}</td>
                            <td>${orderItem.price}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
            <ul id="pagination"></ul>
        </div>
        <%--添加系统用户 end--%>
    </div>
</div>

</body>

</html>
