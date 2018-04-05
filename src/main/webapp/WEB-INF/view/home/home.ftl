<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="zh-CN">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>快乐妈咪管理后台</title>

    <link rel="stylesheet" href="${base}/vendor/offline/theme.css">
    <link rel="stylesheet" href="${base}/vendor/pace/theme.css">
    <link rel="stylesheet" href="${base}/vendor/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${base}/vendor/bxslider/jquery.bxslider.css">


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
<div class="app" data-sidebar="locked">

    <header class="header header-fixed navbar">
        <div class="brand">
            <a href="javascript:;" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>
            <a href="${base}/home.do" class="navbar-brand">
                <i class="fa fa-stop mg-r-sm"></i>
                <span class="heading-font"><b>快乐妈咪管理后台</b></span>
            </a>
        </div>
    </header>

    <section class="layout">


    <#include "../../share/nav.ftl" >

        <section class="main-content">

            <div class="content-wrap">
                <div class="row mg-b">
                    <div class="col-xs-6">
                        <h3 class="no-margin">快乐妈咪管理后台/h3>
                        <small>欢迎回来</small>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <section class="panel">
                            <div class="panel-body">
                                <div class="circle-icon bg-success">
                                    <i class="fa fa-microphone"></i>
                                </div>
                                <div>
                                    <h3 class="no-margin">${studentCount}</h3> 培训学员
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <section class="panel">
                            <div class="panel-body">
                                <div class="circle-icon bg-danger">
                                    <i class="fa fa-anchor"></i>
                                </div>
                                <div>
                                    <h3 class="no-margin">${babySitterCount}</h3> 讲师数
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <section class="panel">
                            <div class="panel-body">
                                <div class="circle-icon bg-default">
                                    <i class="fa fa-magnet"></i>
                                </div>
                                <div>
                                    <h3 class="no-margin">${teacherCount}</h3> 月嫂数
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


<script src="${base}/vendor/moment.js"></script>
<script src="${base}/vendor/skycons.js"></script>
<script src="${base}/vendor/jquery.blockUI.js"></script>
<script src="${base}/vendor/raphael.min.js"></script>
<script src="${base}/vendor/morris/morris.js"></script>
<script src="${base}/vendor/switchery/switchery.js"></script>
<script src="${base}/vendor/jquery.slimscroll.js"></script>
<script src="${base}/vendor/bxslider/jquery.bxslider.min.js"></script>
<script src="${base}/vendor/offline/offline.min.js"></script>
<script src="${base}/vendor/pace/pace.min.js"></script>


<script src="${base}/js/off-canvas.js"></script>
<script src="${base}/js/main.js"></script>

<script src="${base}/js/panel.js"></script>
<script src="${base}/js/dashboard.js"></script>
</body>

</html>