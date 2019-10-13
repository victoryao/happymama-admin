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


    <script src="${base}/vendor/jquery-1.11.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${base}/css/webuploader.css">

    <script type="text/javascript" src="${base}/js/webuploader.html5only.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${base}/css/diyUpload.css">
    <script type="text/javascript" src="${base}/js/diyUpload.js"></script>




    <style>

        *{ margin:0; padding:0;}


        #lifePhoto {
            margin: 50px auto;
            width: 540px;
            min-height: 200px;
            background: #FF9
        }

        #foodPhoto {
            margin: 50px auto;
            width: 540px;
            min-height: 200px;
            background: #CF9
        }

    </style>
</head>

<body>
<div class="app">


    <section class="layout">


        <section class="main-content">


            <div id="lifePhoto">
                <b>生活照</b>
                <div id="life"></div>

            </div>

            <div id="foodPhoto">
                <b>月子餐</b>
                <div id="food"></div>

            </div>

        </section>

    </section>
</div>

</body>
<script type="text/javascript">

    /*
    * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
    * 其他参数同WebUploader
    */
    $('#life').diyUpload({
        url: '${base}/upload.do?&method=upload&employeeId=${eId}&fileType=0',
        success: function (data) {
            console.info(data);
        },
        error: function (err) {
            console.info(err);
        },
        buttonText: '选择文件',
        chunked: true,
        // 分片大小
        chunkSize: 512 * 1024,
        //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        fileNumLimit: 50,
        fileSizeLimit: 500000 * 1024,
        fileSingleSizeLimit: 50000 * 1024,
        accept: {}
    });

    $('#food').diyUpload({
        url: '${base}/upload.do?&method=upload&employeeId=${eId}&fileType=1',
        success: function (data) {
            console.info(data);
        },
        error: function (err) {
            console.info(err);
        },
        buttonText: '选择文件',
        chunked: true,
        // 分片大小
        chunkSize: 512 * 1024,
        //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        fileNumLimit: 50,
        fileSizeLimit: 500000 * 1024,
        fileSingleSizeLimit: 50000 * 1024,
        accept: {}
    });
</script>
</html>