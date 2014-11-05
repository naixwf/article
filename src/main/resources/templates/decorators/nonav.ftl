<!DOCTYPE html>
<!--[if lt IE 7]> <html lang="en" ng-app="Sys" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html lang="en" ng-app="Sys" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html lang="en" ng-app="Sys" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" ng-app="Sys" class="no-js"> <!--<![endif]-->
<head lang="en">
    <meta charset="UTF-8">
    <title>
        <sitemesh:write property='title'/>
    </title>

    <!-- Bootstrap-->
    <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css">

    <!--<link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap-theme.min.css"> -->
    <sitemesh:write property='head'/>

    <!--js-->
    <script type="text/javascript" src="/bower_components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

</head>
<body>
<!--  action完成之后的提示，读取model里的内容 -->
<!-- TODO copy common.ftl,后续这块需要提取出来 -->
<#if info??>
<div class="container">
    <div class="alert alert-info alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span
                class="sr-only">Close</span></button>
    ${info}
    </div>
</div>
</#if>
<sitemesh:write property='body'/>

<footer role="contentinfo">
    <hr/>
    <div class="container">
        <p></p>
    </div>

</footer>
</body>
</html>
