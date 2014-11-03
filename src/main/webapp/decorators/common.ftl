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
                <li class="active"><a href="/article">文章检索</a></li>
                <li><a href="#about">分类管理</a></li>
                <li><a href="#contact">权限管理</a></li>
                <!-- <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                     <ul class="dropdown-menu" role="menu">
                         <li><a href="#">Action</a></li>
                         <li><a href="#">Another action</a></li>
                         <li><a href="#">Something else here</a></li>
                         <li class="divider"></li>
                         <li class="dropdown-header">Nav header</li>
                         <li><a href="#">Separated link</a></li>
                         <li><a href="#">One more separated link</a></li>
                     </ul>
                 </li>   -->
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<sitemesh:write property='body'/>

<footer role="contentinfo">
    <hr/>
    <div class="container">
        <p></p>
    </div>

</footer>
</body>
</html>
