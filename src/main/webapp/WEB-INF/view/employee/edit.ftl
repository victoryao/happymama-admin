<!doctype html>
<html class="no-js" lang="">

<head>

    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>好阿姨</title>
    <link rel="stylesheet" href="/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="/vendor/dropzone/dropzone.css">
    <link rel="stylesheet" href="/vendor/slider/slider.css">
    <link rel="stylesheet" href="/vendor/bootstrap-datepicker/datepicker.css">
    <link rel="stylesheet" href="/vendor/timepicker/jquery.timepicker.css">
    <link rel="stylesheet" href="/vendor/offline/theme.css">
    <link rel="stylesheet" href="/vendor/pace/theme.css">


    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="/css/animate.min.css">

    <link rel="stylesheet" href="/css/panel.css">

    <link rel="stylesheet" href="/css/skins/palette.1.css" id="skin">
    <link rel="stylesheet" href="/css/fonts/style.1.css" id="font">
    <link rel="stylesheet" href="/css/main.css">


    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <script src="/vendor/modernizr.js"></script>
</head>

<body>

<div class="app">

    <header class="header header-fixed navbar">
        <div class="brand">
            <a href="javascript:;" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>
            <a href="/home.do" class="navbar-brand text-white">
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
                        <div class="tab-content ">
                            <section class="tab-pane active" id="elements">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <section class="panel">
                                            <header class="panel-heading">信息登记</header>
                                            <div class="panel-body">
                                                <form class="form-horizontal bordered-group parsley-form" role="form"
                                                      action="/admin/employee/update.do" method="post"
                                                      data-parsley-validate>
                                                    <input type="hidden" name="id" value="${employeeDO.id}">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">姓名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="name" class="form-control"
                                                                   title="姓名" data-parsley-required="true"
                                                                   value="${employeeDO.name}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">性别</label>
                                                        <div class="col-sm-10">
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="gender" value="0"
                                                                           <#if (employeeDO.gender == "0")!>checked="" </#if>
                                                                    >女</label>
                                                            </div>
                                                            <div class="radio">
                                                                <label>
                                                                    <input type="radio" name="gender" value="1"
                                                                           <#if (employeeDO.gender == "1")!>checked="" </#if>
                                                                    >男</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">手机</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="phone" class="form-control"
                                                                   title="手机" data-parsley-required="true"
                                                                   value="${employeeDO.phone}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">出生日期</label>
                                                        <div class="col-sm-3">
                                                            <div class="input-group mg-b-md input-append date datepicker"
                                                                 data-date="${employeeDO.birthday?string('yyyy-MM-dd')}"
                                                                 data-date-format="yyyy-mm-dd">
                                                                <input type="text" name="birthday" class="form-control"
                                                                       title="出生日期"
                                                                       value="${employeeDO.birthday?string('yyyy-MM-dd')}">
                                                                <span class="input-group-btn">
                                                                <button class="btn btn-white add-on" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                                </button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">身份证</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="IDCard"
                                                                   class="form-control" title="身份证"
                                                                   value="${employeeDO.idcard}"
                                                                   data-parsley-required="true"
                                                                   data-parsley-trigger="change"/>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">籍贯</label>
                                                        <div class="col-sm-10">
                                                            <input type="text"
                                                                   class="form-control" name="hometown"
                                                                   title="籍贯" data-parsley-required="true"
                                                                   value="${employeeDO.hometown}"
                                                                   data-parsley-trigger="change">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">个人图片</label>
                                                        <div class="col-sm-10">
                                                            <input type="file" name="photo">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">个人简介</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" rows="5" name="introduce"
                                                                      title="个人简介">${employeeDO.introduce}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">职位</label>
                                                        <div class="col-sm-10">
                                                            <div class="checkbox">
                                                                <label><input type="checkbox" name="types"
                                                                              <#if (employeeDO.types?contains("0"))!>checked=""  </#if>
                                                                              value="0">学员</label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label><input type="checkbox" name="types"
                                                                              <#if (employeeDO.types?contains("1"))!>checked=""  </#if>
                                                                              value="1">月嫂</label>
                                                            </div>
                                                            <div class="checkbox">
                                                                <label><input type="checkbox" name="types"
                                                                              <#if (employeeDO.types?contains("2"))!>checked=""  </#if>
                                                                              value="2">讲师</label>
                                                            </div>
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

<script src="/vendor/jquery-1.11.1.min.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>
<script src="/vendor/jquery.easing.min.js"></script>
<script src="/vendor/jquery.placeholder.js"></script>
<script src="/vendor/fastclick.js"></script>


<script src="/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="/vendor/dropzone/dropzone.js"></script>
<script src="/vendor/parsley.min.js"></script>
<script src="/vendor/jquery.maskedinput.min.js"></script>
<script src="/vendor/fuelux/checkbox.js"></script>
<script src="/vendor/fuelux/radio.js"></script>
<script src="/vendor/fuelux/wizard.js"></script>
<script src="/vendor/fuelux/pillbox.js"></script>
<script src="/vendor/fuelux/spinner.js"></script>
<script src="/vendor/slider/bootstrap-slider.js"></script>
<script src="/vendor/bootstrap-datepicker/bootstrap-datepicker.js"></script>
<script src="/vendor/wysiwyg/jquery.hotkeys.js"></script>
<script src="/vendor/wysiwyg/bootstrap-wysiwyg.js"></script>
<script src="/vendor/switchery/switchery.js"></script>
<script src="/vendor/timepicker/jquery.timepicker.js"></script>
<script src="/vendor/offline/offline.min.js"></script>
<script src="/vendor/pace/pace.min.js"></script>


<script src="/js/off-canvas.js"></script>
<script src="/js/main.js"></script>

<script src="/js/panel.js"></script>
<script src="/js/forms.js"></script>
</body>

</html>