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

    <style type="text/css">
        .btn_b .selected{
            background: white;
        }

    </style>
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

        //显示确认发货的提示框
        function showConfirmModal(confirmOrderId,userId) {
            console.log(confirmOrderId);
            $('#confirmOrderId').val(confirmOrderId);
            $('#confirmUserId').val(userId);
            $('#confirmOrderModal').modal('show');
        }

        //确认发货
        function confirmReceiveOrder() {
            $.post(
                '${pageContext.request.contextPath}/admin/order/confirmSendOrder',
                {
                    'confirmOrderId': $('#confirmOrderId').val(),
                    'userId': $('#confirmUserId').val(),

                },
                function (result) {
                    if (result.status == 1) {
                        layer.msg(result.message, {
                            time: 1000,
                            skin: 'successMsg'
                        }, function () {
                            location.reload();
                        });
                    } else {
                        layer.msg(result.message, {
                            time: 1500,
                            skin: 'errorMsg'
                        });
                    }
                }
            );
        }
    </script>
</head>

<body>
<!-- 系统用户管理 -->
<div class="panel panel-default" id="adminSet">
    <div class="panel-heading">
        <h3 class="panel-title">订单管理</h3>
    </div>
    <div class="panel-body">
        <div class="showmargersearch">
            <form action="${pageContext.request.contextPath}/admin/order/getOrdersByParams"
                  class="form-inline" method="post" id="frmSearch">
                <div class="form-group">
                    <label for="loginName">订单号:</label>
                    <input type="text" class="form-control" id="loginName" name="orderId" placeholder="请输入帐号"
                           value="${params.orderId}">
                </div>
                <div class="form-group">
                    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" id="pageNum">
                    <label for="userName">姓名:</label>
                    <input type="text" class="form-control" id="userName" name="name" placeholder="请输入姓名"
                           value="${params.name}">
                </div>


                <div class="form-group">
                    <label for="status">订单状态</label>
                    <select class="form-control" name="status" id="status">
                        <option value="-1">全部</option>
                        <option value="0" >待支付</option>
                        <option value="1" >买家已支付待发货</option>
                        <option value="2" >卖家已发货待收货</option>
                        <option value="3" >交易已完成</option>
                        <option value="4" >订单已取消</option>
                    </select>
                </div>
                <input type="submit" value="查询" class="btn btn-primary" id="doSearch">
            </form>
        </div>
        <br>
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
                            <td  class="text-center btn_b" rowspan="${order.orderItemList.size()}" style="text-align: center;border: 0px;">

                                <span>
                                    <c:if test="${order.status == 0}">待支付</c:if>
                                    <c:if test="${order.status == 1}">
                                        <button  type="button" class="btn btn-success" onclick="showConfirmModal(${order.id},${order.customerId})" >确认发货</button>
                                    </c:if>
                                    <c:if test="${order.status == 2}">卖家已发货待收货</c:if>
                                    <c:if test="${order.status == 3}">交易已完成</c:if>
                                    <c:if test="${order.status == 4}">订单已取消</c:if>
                                </span>
                            </td>
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


<%--确认收货--%>
<div class="modal fade" tabindex="-1" id="confirmOrderModal" style="top: 10%;">
    <!-- 窗口声明 -->
    <div class="modal-dialog modal-sm">
        <!-- 内容声明 -->
        <div class="modal-content">
            <!-- 头部、主体、脚注 -->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">提示消息</h4>
            </div>
            <div class="modal-body text-center">
                <h5 class="text-warning" style="letter-spacing: 1px">确认完成发货吗？</h5>
            </div>
            <div class="modal-footer">
                <input type="hidden" name="confirmOrderId" id="confirmOrderId">
                <input type="hidden" name="userId" id="confirmUserId">
                <button class="btn btn-primary updateProType" data-dismiss="modal" onclick="confirmReceiveOrder()">确认
                </button>
                <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</body>

</html>
