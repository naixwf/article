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
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Article</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/article">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理员权限<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/category">分类管理</a></li>
                        <li><a href="/user">权限管理</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">登出</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<!--  action完成之后的提示，读取model里的内容 -->

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
