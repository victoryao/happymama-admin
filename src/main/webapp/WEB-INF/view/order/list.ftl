<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。" />
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政" />
    <meta name="baidu-site-verification" content="71R86N1GBt" />

    <title>快乐妈咪管理后台</title>

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
    <link rel="stylesheet" href="${base}/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${base}/vendor/dropzone/dropzone.css">
    <link rel="stylesheet" href="${base}/vendor/slider/slider.css">
    <link rel="stylesheet" href="${base}/vendor/bootstrap-datepicker/datepicker.css">
    <link rel="stylesheet" href="${base}/vendor/timepicker/jquery.timepicker.css">
    <link rel="stylesheet" href="${base}/vendor/offline/theme.css">
    <link rel="stylesheet" href="${base}/vendor/pace/theme.css">
    <link rel="stylesheet" href="${base}/css/animate.min.css">
    <link rel="stylesheet" href="${base}/css/panel.css">
    <link rel="stylesheet" href="${base}/css/skins/palette.1.css" id="skin">
    <link rel="stylesheet" href="${base}/css/fonts/style.1.css" id="font">
    <link rel="stylesheet" href="${base}/css/main.css">
    <!--[if lt IE 9]>
    <script src="${base}/js/html5shiv.js"></script>
    <script src="${base}/js/respond.min.js"></script>
    <![endif]-->
    <script src="${base}/vendor/modernizr.js"></script>
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
                <b>快乐妈咪管理后台</b>
                </span>
            </a>
        </div>

    </header>

    <section class="layout">

    <#include "../../share/nav.ftl" >

        <section class="main-content">

            <div class="content-wrap">

                <div class="row">
                    <div class="col-lg-12">
                    <#if (eId  !="0" )!>
                        <section class="panel">
                            <header class="panel-heading">个人信息</header>
                            <div class="panel-body">
                                月嫂姓名：<b>${employeeName}</b>
                                月嫂电话: <b>${employeePhone}</b><br/>
                            </div>
                        </section>

                        <section class="panel">
                            <header class="panel-heading">新订单</header>
                            <div class="panel-body">
                                <a href="${base}/admin/to/${eId}/order/add.do"
                                   class="btn btn-danger btn-sm">增加订单</a>
                            </div>
                        </section>

                    </#if>

                        <section class="panel">
                            <header class="panel-heading">查询</header>
                            <div class="panel-body">
                                <form class="form-inline" role="form" action="${base}/admin/order/list.do">
                                    <input type="hidden" name="page" id="page"/>
                                    <input type="hidden" name="eId" id="eId" value="${eId}"/>

                                    <#if (eId  =="0" )!>
                                        <div class="form-group">
                                            员工姓名:<label class="sr-only">员工姓名</label>
                                            <input type="text" name="name" class="form-control"
                                                   placeholder="员工姓名" value="${name}">
                                        </div>
                                    </#if>

                                    开始时间:
                                    <div class="input-group mg-b-md input-append date datepicker"
                                         data-date-format="yyyy-mm-dd">
                                        <input type="text" name="startDate" class="form-control"
                                               title="开始时间" value="${startDate}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-white add-on" type="button">
                                                <i class="fa fa-calendar"></i>
                                            </button>
                                        </span>
                                    </div>

                                    结束时间:
                                    <div class="input-group mg-b-md input-append date datepicker"
                                         data-date-format="yyyy-mm-dd">
                                        <input type="text" name="endDate" class="form-control"
                                               title="结束时间" value="${endDate}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-white add-on" type="button">
                                                <i class="fa fa-calendar"></i>
                                            </button>
                                        </span>
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
                            <header class="panel-heading">订单列表</header>
                            <div class="panel-body no-padding">
                                <div class="table-responsive">
                                    <form action="${base}/admin/order/list.do">
                                        <table class="table table-striped responsive" data-sortable>
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>员工姓名</th>
                                                <th>顾客姓名</th>
                                                <th>顾客电话</th>
                                                <th>开始时间</th>
                                                <th>结束时间</th>
                                                <th>价格</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <#list pageView.records as order>
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.employeeName}</td>
                                                <td>${order.customerName}</td>
                                                <td>${order.customerPhone}</td>
                                                <td>${order.startDate?string('yyyy-MM-dd')}</td>
                                                <td>${order.endDate?string('yyyy-MM-dd')}</td>
                                                <td>${order.price}</td>
                                                <td>
                                                <a href="${base}/admin/to/${order.id}/update.do"
                                                       class="btn btn-danger btn-sm">修改</a>
                                                    <a href="${base}/admin/${order.id}/order/delete.do"
                                                       class="btn btn-danger btn-sm">删除</a>
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
<script src="${base}/vendor/jquery-1.11.1.min.js"></script>
<script src="${base}/bootstrap/js/bootstrap.js"></script>
<script src="${base}/vendor/jquery.easing.min.js"></script>
<script src="${base}/vendor/jquery.placeholder.js"></script>
<script src="${base}/vendor/fastclick.js"></script>
<script src="${base}/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="${base}/vendor/dropzone/dropzone.js"></script>
<script src="${base}/vendor/parsley.min.js"></script>
<script src="${base}/vendor/jquery.maskedinput.min.js"></script>
<script src="${base}/vendor/fuelux/checkbox.js"></script>
<script src="${base}/vendor/fuelux/radio.js"></script>
<script src="${base}/vendor/fuelux/wizard.js"></script>
<script src="${base}/vendor/fuelux/pillbox.js"></script>
<script src="${base}/vendor/fuelux/spinner.js"></script>
<script src="${base}/vendor/slider/bootstrap-slider.js"></script>
<script src="${base}/vendor/bootstrap-datepicker/bootstrap-datepicker.js"></script>
<script src="${base}/vendor/wysiwyg/jquery.hotkeys.js"></script>
<script src="${base}/vendor/wysiwyg/bootstrap-wysiwyg.js"></script>
<script src="${base}/vendor/switchery/switchery.js"></script>
<script src="${base}/vendor/timepicker/jquery.timepicker.js"></script>
<script src="${base}/vendor/offline/offline.min.js"></script>
<script src="${base}/vendor/pace/pace.min.js"></script>
<script src="${base}/js/off-canvas.js"></script>
<script src="${base}/js/main.js"></script>
<script src="${base}/js/panel.js"></script>
<script src="${base}/js/forms.js"></script>
</body>

</html>