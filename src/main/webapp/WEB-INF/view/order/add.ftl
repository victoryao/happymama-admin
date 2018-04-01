<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>好阿姨</title>
    <link rel="stylesheet" href="${base}/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${base}/vendor/dropzone/dropzone.css">
    <link rel="stylesheet" href="${base}/vendor/slider/slider.css">
    <link rel="stylesheet" href="${base}/vendor/bootstrap-datepicker/datepicker.css">
    <link rel="stylesheet" href="${base}/vendor/timepicker/jquery.timepicker.css">
    <link rel="stylesheet" href="${base}/vendor/offline/theme.css">
    <link rel="stylesheet" href="${base}/vendor/pace/theme.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
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
    </header>

    <section class="layout">

    <#include "../../share/nav.ftl" >

        <section class="main-content">

            <div class="content-wrap">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="tab-content ">
                            <section class="tab-pane active" id="elements">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <section class="panel">
                                            <header class="panel-heading">订单登记</header>
                                            <div class="panel-body">
                                                <form class="form-horizontal bordered-group parsley-form" role="form"
                                                      action="${base}/admin/order/add.do" method="post"
                                                      accept-charset="utf-8"
                                                      data-parsley-validate>
                                                    <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}"/>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户姓名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="name" class="form-control"
                                                                   title="客户姓名" data-parsley-required="true"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户手机</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="phone" class="form-control"
                                                                   title="客户手机" data-parsley-required="true"
                                                                   data-parsley-type="number"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户地址</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="address" class="form-control"
                                                                   title="客户地址" data-parsley-required="true"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">开始时间</label>
                                                        <div class="col-sm-3">
                                                            <div class="input-group mg-b-md input-append date datepicker"
                                                                 data-date="2018-01-01" data-date-format="yyyy-mm-dd">
                                                                <input type="text" name="startDate" class="form-control"
                                                                       title="开始时间"
                                                                       value="2018-01-01">
                                                                <span class="input-group-btn">
                                                                <button class="btn btn-white add-on" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                                </button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">结束时间</label>
                                                        <div class="col-sm-3">
                                                            <div class="input-group mg-b-md input-append date datepicker"
                                                                 data-date="2018-01-01" data-date-format="yyyy-mm-dd">
                                                                <input type="text" name="endDate" class="form-control"
                                                                       title="结束时间"
                                                                       value="2018-01-01">
                                                                <span class="input-group-btn">
                                                                <button class="btn btn-white add-on" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                                </button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">价格</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="price" class="form-control"
                                                                   title="价格" data-parsley-required="true"
                                                                   data-parsley-type="number"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">备注</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" rows="5" name="introduce"
                                                                      title="个人简介"></textarea>
                                                        </div>
                                                    </div>

                                                    <div align="center">
                                                        <button type="submit" class="btn btn btn-primary btn-parsley">
                                                            提交
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </section>
                                    </div>
                                </div>
                            </section>
                        </div>
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