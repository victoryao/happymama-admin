<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="zh-CN">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>新新妈咪管理后台</title>

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
                <span class="heading-font"><b>新新妈咪管理后台</b></span>
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

            <div class="center-content text-center">
                <div class="result-message">
                    <b>${message}</b>
                </div>
                <div>
                <#if (nextStep != "")>
                    <a href="${base}${nextUrl}"
                       class="btn btn-danger btn-sm">${nextStep}</a>
                </#if>
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