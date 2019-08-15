<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。" />
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政" />
    <meta name="baidu-site-verification" content="71R86N1GBt" />

    <title>新新妈咪管理后台</title>
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
                <b>新新妈咪管理后台</b>
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
                                            <header class="panel-heading">订单修改</header>
                                            <div class="panel-body">
                                                <form class="form-horizontal bordered-group parsley-form" role="form"
                                                      action="${base}/admin/order/update.do" method="post"
                                                      accept-charset="utf-8"
                                                      enctype="multipart/form-data"
                                                      data-parsley-validate>
                                                    <input type="hidden" name="employeeId" id="employeeId"
                                                           value="${employeeDO.id}"/>
                                                    <input type="hidden" name="customerId" id="customerId"
                                                           value="${customerDO.id}"/>
                                                    <input type="hidden" name="orderId" id="orderId"
                                                           value="${orderDO.id}"/>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户姓名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="name" class="form-control"
                                                                   title="客户姓名" data-parsley-required="true"
                                                                   data-parsley-trigger="change"
                                                                   value="${customerDO.name}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户手机</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="phone" class="form-control"
                                                                   title="客户手机" data-parsley-required="true"
                                                                   data-parsley-type="number"
                                                                   value="${customerDO.phone}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">客户地址</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="address" class="form-control"
                                                                   title="客户地址" data-parsley-required="true"
                                                                   value="${customerDO.address}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">开始时间</label>
                                                        <div class="col-sm-3">
                                                            <div class="input-group mg-b-md input-append date datepicker"
                                                                 data-date="${orderDO.startDate?string('yyyy-MM-dd')}" data-date-format="yyyy-mm-dd">
                                                                <input type="text" name="startDate" class="form-control"
                                                                       title="开始时间"
                                                                       value="${orderDO.startDate?string('yyyy-MM-dd')}">
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
                                                                 data-date="${orderDO.endDate?string('yyyy-MM-dd')}" data-date-format="yyyy-mm-dd">
                                                                <input type="text" name="endDate" class="form-control"
                                                                       title="结束时间"
                                                                       value="${orderDO.endDate?string('yyyy-MM-dd')}">
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
                                                                   value="${orderDO.price}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">备注</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" rows="5" name="introduce"
                                                                      title="个人简介">${orderDO.memo}</textarea>
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