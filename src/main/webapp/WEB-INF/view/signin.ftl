<#assign base=request.contextPath />
<!doctype html>
<html class="signin no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description" content="Flat, Clean, Responsive, admin template built with bootstrap 3">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

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
                    <form role="form" action="${base}/login.do">
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