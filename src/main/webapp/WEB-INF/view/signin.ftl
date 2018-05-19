<#assign base=request.contextPath />
<!doctype html>
<html class="signin no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。" />
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政" />
    <meta name="baidu-site-verification" content="71R86N1GBt" />

    <title>快乐妈咪管理后台</title>


    <link rel="stylesheet" href="${base}/vendor/offline/theme.css">
    <link rel="stylesheet" href="${base}/vendor/pace/theme.css">


    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="${base}/css/animate.min.css">


    <link rel="stylesheet" href="${base}/css/skins/palette.1.css" id="skin">
    <link rel="stylesheet" href="${base}/css/fonts/style.1.css" id="font">
    <link rel="stylesheet" href="${base}/css/main.css">


    <!--[if lt IE 9]>
    <script src="${base}/js/html5shiv.js"></script>
    <script src="${base}/js/respond.min.js"></script>
    <![endif]-->

    <script src="${base}/vendor/modernizr.js"></script>
</head>

<body class="bg-color center-wrapper">
<div class="center-content">
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
            <section class="panel panel-default">
                <header class="panel-heading">请登陆</header>
                <div class="bg-white user pd-md">
                    <h6>
                        <strong>欢迎</strong>使用快乐妈咪管理后台</h6>
                    <form role="form" action="${base}/login.do" method="post">
                        <input type="text" name="name" class="form-control mg-b-sm" placeholder="用户名" autofocus>
                        <input type="password" name="password" class="form-control" placeholder="密码">
                        <button class="btn btn-info btn-block" type="submit">登陆</button>
                    </form>
                </div>
            </section>
        </div>
    </div>
</div>
</body>

</html>