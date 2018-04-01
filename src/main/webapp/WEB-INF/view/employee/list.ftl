<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>Cameo | Responsive Admin Dashboard</title>


    <link rel="stylesheet" href="/vendor/table-sortable/theme.css">
    <link rel="stylesheet" href="/vendor/offline/theme.css">
    <link rel="stylesheet" href="/vendor/pace/theme.css">


    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href=${base}"/css/animate.min.css">

    <link rel="stylesheet" href="${base}/css/panel.css">

    <link rel="stylesheet" href="${base}/css/skins/palette.1.css" id="skin">
    <link rel="stylesheet" href="${base}/css/fonts/style.1.css" id="font">
    <link rel="stylesheet" href="${base}/css/main.css">


    <!--[if lt IE 9]>
    <script src="${base}/js/html5shiv.js"></script>
    <script src="${base}/js/respond.min.js"></script>
    <![endif]-->

    <script src="${base}/vendor/modernizr.js"></script>

    <script language="javascript">
        //到指定的分页页面
        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }

    </script>
</head>

<body>
<div class="app">

    <header class="header header-fixed navbar">
        <div class="brand">
            <a href="javascript:;" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>
            <a href="${base}/home.do" class="navbar-brand text-white">
                <i class="fa fa-stop mg-r-sm"></i>
                <span class="heading-font">
                <b>好阿姨管理后台</b>
                </span>
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right off-right">
            <li class="hidden-xs">
                <a href="javascript:;">
                    +Gerald Theodore Morris
                </a>
            </li>
        </ul>
    </header>

    <section class="layout">

    <#include "../../share/nav.ftl" >


        <section class="main-content">


            <div class="content-wrap">

                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <div class="panel-body">
                                <form class="form-inline" role="form" action="${base}/admin/employee/list.do">
                                    <input type="hidden" name="page" id="page"/>
                                    <div class="form-group">
                                        <label class="sr-only">姓名</label>
                                        <input type="text" name="name" class="form-control" value="${name}"
                                               placeholder="姓名">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="exampleInputPassword2">手机</label>
                                        <input type="text" name="phone" class="form-control" value="${phone}"
                                               placeholder="手机号">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="types" value="0"
                                                   <#if (types?contains("0"))!>checked </#if>>学员
                                        </label>
                                        <label>
                                            <input type="checkbox" name="types" value="1"
                                                   <#if (types?contains("1"))!>checked </#if>>月嫂
                                        </label>
                                        <label>
                                            <input type="checkbox" name="types" value="2"
                                                   <#if (types?contains("2"))!>checked </#if>>讲师
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-default">查询</button>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <section class="panel">
                            <header class="panel-heading">员工列表</header>
                            <div class="panel-body no-padding">
                                <div class="table-responsive">
                                    <form action="${base}/admin/employee/list.do">
                                        <table class="table table-striped responsive" data-sortable>
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>图片</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>手机</th>
                                                <th>身份证</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <#list pageView.records as employee>
                                            <tr>
                                                <td>${employee.id}</td>
                                                <td>${employee.name}</td>
                                                <td>${employee.name}</td>
                                                <td>
                                                    <#if (employee.gender =="1")>男 </#if>
                                                    <#if (employee.gender =="0")>女 </#if>
                                                </td>
                                                <td>${employee.phone}</td>
                                                <td>${employee.idcard}</td>
                                                <td><a href="${base}/admin/${employee.id}/update.do"
                                                       class="btn btn-danger btn-sm">修改</a>
                                                    <a href="${base}/admin/${employee.id}/delete.do"
                                                       class="btn btn-danger btn-sm">删除</a>
                                                    <a href="/admin/order/list.do?eId=${employee.id}"
                                                       class="btn btn-danger btn-sm">订单</a>
                                                </td>
                                            </tr>
                                            </#list>
                                            </tbody>
                                        </table>
                                    <#include "../../share/paging.ftl" >

                                    </form>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

        </section>

    </section>
</div>

<script src="${base}/vendor/jquery-1.11.1.min.js"></script>
<script src="${base}/bootstrap/js/bootstrap.js"></script>
<script src="${base}/vendor/jquery.easing.min.js"></script>
<script src="${base}/vendor/jquery.placeholder.js"></script>
<script src="${base}/vendor/fastclick.js"></script>


<script src="${base}/vendor/table-sortable/sortable.min.js"></script>
<script src="${base}/vendor/offline/offline.min.js"></script>
<script src="${base}/vendor/pace/pace.min.js"></script>


<script src="${base}/js/off-canvas.js"></script>
<script src="${base}/js/main.js"></script>
<script src="${base}/js/panel.js"></script>
</body>

</html>