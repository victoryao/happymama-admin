<#assign base=request.contextPath />
<!doctype html>
<html class="no-js" lang="">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="description"
          content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <title>新新妈咪管理后台</title>
    <link rel="stylesheet" href="${base}/vendor/table-sortable/theme.css">
    <link rel="stylesheet" href="${base}/vendor/offline/theme.css">
    <link rel="stylesheet" href="${base}/vendor/pace/theme.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="${base}/css/animate.min.css">
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
                            <header class="panel-heading">个人信息</header>
                            <div class="panel-body">
                                员工姓名：<b>${employeeDO.name}</b>
                                员工电话: <b>${employeeDO.phone}</b><br/>
                            </div>
                        </section>

                        <section class="panel">
                            <div class="panel-body">
                                <div class="form-group">
                                    <form class="form-horizontal bordered-group parsley-form"
                                          role="form" action="${base}/admin/course/add.do" data-parsley-validate>
                                        <input type="hidden" name="employeeId" id="employeeId" value="${employeeId}"/>

                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">科目</label>
                                            <div class="col-sm-10">
                                                <select class="form-control selectpicker" data-style="btn-primary"
                                                        name="courseId">
                                                <#list courses as course>
                                                    <option value="${course.id}">${course.name}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">证书颁发时间</label>
                                            <div class="col-sm-3">
                                                <div class="input-group mg-b-md input-append date datepicker"
                                                     data-date="${achieveDate}" data-date-format="yyyy-mm-dd">
                                                    <input type="text" name="achieveDate" class="form-control"
                                                           title="证书颁发时间"
                                                           value="${achieveDate}">
                                                    <span class="input-group-btn">
                                                                <button class="btn btn-white add-on" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                                </button>
                                                                </span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">培训方式</label>
                                            <div class="col-sm-2">
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="achieveType" value="0"
                                                               checked="">我司培训</label>
                                                </div>
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="achieveType"
                                                               value="1">他司培训</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div id="recommendDiv">
                                            <label class="col-sm-2 control-label">学费</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="price" class="form-control"
                                                       title="学费" data-parsley-required="true"
                                                       data-parsley-type="number"
                                                       value="0"
                                                       data-parsley-trigger="change">
                                            </div>

                                            <label class="col-sm-2 control-label">介绍人姓名</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="name" class="form-control"
                                                       title="介绍人姓名"
                                                       data-parsley-trigger="change">
                                            </div>

                                            <label class="col-sm-2 control-label">介绍人手机</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="phone" class="form-control"
                                                       title="介绍人手机"
                                                       data-parsley-type="number"
                                                       data-parsley-trigger="change">
                                            </div>

                                            <label class="col-sm-2 control-label">介绍费用</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="recommendPrice" class="form-control"
                                                       value="0" title="介绍费用"
                                                       data-parsley-type="number"
                                                       data-parsley-trigger="change">
                                            </div>
                                        </div>

                                        <div align="center">
                                            <button type="submit"
                                                    class="btn btn btn-primary btn-parsley">
                                                提交
                                            </button>
                                        </div>
                                    </form>
                                </div>
                        </section>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <section class="panel">
                            <header class="panel-heading">技能列表</header>
                            <div class="panel-body no-padding">
                                <div class="table-responsive">
                                    <table class="table table-striped responsive" data-sortable>
                                        <thead>
                                        <tr>
                                            <th>技能科目</th>
                                            <th>培训方式</th>
                                            <th>学费</th>
                                            <th>介绍人</th>
                                            <th>介绍人电话</th>
                                            <th>介绍人费用</th>
                                            <th>公司实际收入</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list courseOrders as courseOrder>
                                        <tr>
                                            <td>${courseOrder.courseName}</td>
                                            <td>
                                                <#if (courseOrder.achieveType =="0")>我司培训 </#if>
                                                <#if (courseOrder.achieveType =="1")>他司培训 </#if>
                                            </td>
                                            <td>${courseOrder.price}</td>
                                            <td>${courseOrder.recommendName}</td>
                                            <td>${courseOrder.recommendPhone}</td>
                                            <td>${courseOrder.recommendPrice}</td>
                                            <td>${courseOrder.realPrice}</td>
                                            <td>
                                                <a href="${base}/admin/course/${courseOrder.id}/delete.do?employeeId=${employeeId}"
                                                   class="btn btn-danger btn-sm">删除</a>
                                            </td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>

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
<script>
    $(document).ready(function () {
        $('input:radio[name="achieveType"]').change(function () {
            var a = $("input[name='achieveType']:checked").val();
            if (a == 1) {
                $("#recommendDiv").hide();
            } else {
                $("#recommendDiv").show();
            }
        });

    });
</script>
</body>

</html>