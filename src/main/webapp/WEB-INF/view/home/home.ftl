<!doctype html>
<html class="no-js" lang="zh-CN">

<head>

    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <title>好阿姨管理系统</title>

    <script type="text/javascript">
        //<![CDATA[
        try {
            if (!window.CloudFlare) {
                var CloudFlare = [{
                    verbose: 0,
                    p: 0,
                    byc: 0,
                    owlid: "cf",
                    bag2: 1,
                    mirage2: 0,
                    oracle: 0,
                    paths: {
                        cloudflare: "/cdn-cgi/nexp/dok2v=1613a3a185/"
                    },
                    atok: "1668c19642567e08c574f5d9458345a2",
                    petok: "3285f1db20753df31d6fcdae6015a30e5a60a785-1419101748-1800",
                    zone: "nyasha.me",
                    rocket: "0",
                    apps: {
                        "ga_key": {
                            "ua": "UA-50530436-1",
                            "ga_bs": "2"
                        }
                    }
                }];
                CloudFlare.push({
                    "apps": {
                        "ape": "86d42e0b8c0027bb178361fce707fc15"
                    }
                });
                !function (a, b) {
                    a = document.createElement("script"), b = document.getElementsByTagName("script")[0], a.async = !0, a.src = "js/cloudflare.min.js", b.parentNode.insertBefore(a, b)
                }()
            }
        } catch (e) {
        }
        ;
        //]]>
    </script>
    <link rel="stylesheet" href="/vendor/offline/theme.css">
    <link rel="stylesheet" href="/vendor/pace/theme.css">
    <link rel="stylesheet" href="/vendor/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="/vendor/bxslider/jquery.bxslider.css">


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
    <script type="text/javascript">

        (function (b) {
            (function (a) {
                "__CF" in b && "DJS" in b.__CF ? b.__CF.DJS.push(a) : "addEventListener" in b ? b.addEventListener("load", a, !1) : b.attachEvent("onload", a)
            })(function () {
                "FB" in b && "Event" in FB && "subscribe" in FB.Event && (FB.Event.subscribe("edge.create", function (a) {
                    _gaq.push(["_trackSocial", "facebook", "like", a])
                }), FB.Event.subscribe("edge.remove", function (a) {
                    _gaq.push(["_trackSocial", "facebook", "unlike", a])
                }), FB.Event.subscribe("message.send", function (a) {
                    _gaq.push(["_trackSocial", "facebook", "send", a])
                }));
                "twttr" in b && "events" in twttr && "bind" in twttr.events && twttr.events.bind("tweet", function (a) {
                    if (a) {
                        var b;
                        if (a.target && a.target.nodeName == "IFRAME") a: {
                            if (a = a.target.src) {
                                a = a.split("#")[0].match(/[^?=&]+=([^&]*)?/g);
                                b = 0;
                                for (var c; c = a[b]; ++b)
                                    if (c.indexOf("url") === 0) {
                                        b = unescape(c.split("=")[1]);
                                        break a
                                    }
                            }
                            b = void 0
                        }
                        _gaq.push(["_trackSocial", "twitter", "tweet", b])
                    }
                })
            })
        })(window);
        /* ]]> */
    </script>
</head>

<body>
<div class="ob_options hidden-xs">
    <div class="options">
        <h6>COLOR SKINS</h6>
        <div class="options-container color_skins">
            <a href="/css/skins/palette.1.css" class="css_orange cs_color cs_1"></a>
            <a href="/css/skins/palette.2.css" class="css_orange cs_color cs_2"></a>
            <a href="/css/skins/palette.3.css" class="css_orange cs_color cs_3"></a>
            <a href="/css/skins/palette.4.css" class="css_orange cs_color cs_4"></a>
            <a href="/css/skins/palette.5.css" class="css_orange cs_color cs_5"></a>
            <a href="/css/skins/palette.6.css" class="css_orange cs_color cs_6"></a>
            <a href="/css/skins/palette.7.css" class="css_orange cs_color cs_7"></a>
            <a href="/css/skins/palette.8.css" class="css_orange cs_color cs_8"></a>
            <a href="/css/skins/palette.9.css" class="css_orange cs_color cs_9"></a>
            <a href="/css/skins/palette.10.css" class="css_orange cs_color cs_10"></a>
        </div>
        <h6>FONT OPTIONS</h6>
        <div class="options-container font_options">
            <select class="input-sm">
                <option value="/css/fonts/style.1.css">Open Sans</option>
                <option value="/css/fonts/style.2.css">Helvetica Neue</option>
                <option value="/css/fonts/style.3.css">Montserrat &amp; Open Sans</option>
            </select>
        </div>
        <h6>LAYOUT VARIATIONS</h6>
        <div class="options-container layout_options">
            <select class="input-sm">
                <option value="boxed.html">Boxed</option>
                <option value="horizontal.html">Horizontal menu</option>
                <option value="horizontal_boxed.html">Horizontal Boxed</option>
                <option value="small-sidebar.html">Small sidebar</option>
                <option value="right-sidebar.html">Right sidebar</option>
                <option value="right-sidebar-collapsible.html">Right Collapsed</option>
                <option value="both.html">Mixed Menus</option>
                <option value="collapsible.html">Collapsible</option>
                <option value="app.html">App</option>
                <option value="footer.html">With footer</option>
            </select>
        </div>
        <small class="ucase">This Panel is for demo purposes only</small>
    </div>
    <div class="ob_toggle bg-color"><span class="fa fa-cog"></span>
    </div>
</div>
<div class="app" data-sidebar="locked">

    <header class="header header-fixed navbar">
        <div class="brand">
            <a href="javascript:;" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>
            <a href="index.html" class="navbar-brand">
                <i class="fa fa-stop mg-r-sm"></i>
                <span class="heading-font">好阿姨<b>管理后台</b></span>
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
                <div class="row mg-b">
                    <div class="col-xs-6">
                        <h3 class="no-margin">好阿姨</h3>
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
                                    <h3 class="no-margin">5468</h3> 培训学员
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
                                    <h3 class="no-margin">2,300</h3> 讲师数
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
                                    <h3 class="no-margin">3,823</h3> 月嫂数
                                </div>
                            </div>
                        </section>
                    </div>

                </div>
            </div>

        </section>

    </section>
</div>
<script src="vendor/jquery-1.11.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="vendor/jquery.easing.min.js"></script>
<script src="vendor/jquery.placeholder.js"></script>
<script src="vendor/fastclick.js"></script>


<script src="/vendor/moment.js"></script>
<script src="/vendor/skycons.js"></script>
<script src="/vendor/jquery.blockUI.js"></script>
<script src="/vendor/raphael.min.js"></script>
<script src="/vendor/morris/morris.js"></script>
<script src="/vendor/switchery/switchery.js"></script>
<script src="/vendor/jquery.slimscroll.js"></script>
<script src="/vendor/bxslider/jquery.bxslider.min.js"></script>
<script src="/vendor/offline/offline.min.js"></script>
<script src="/vendor/pace/pace.min.js"></script>


<script src="/js/off-canvas.js"></script>
<script src="/js/main.js"></script>

<script src="/js/panel.js"></script>
<script src="/js/dashboard.js"></script>
</body>

</html>