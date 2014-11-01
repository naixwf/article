<!doctype html>
<html>
<head>
    <title>SiteMesh example: <sitemesh:write property='title'/></title>
    <style type='text/css'>
        /* Some CSS */
        body { font-family: arial, sans-serif; background-color: #ffffcc; }
        h1, h2, h3, h4 { text-align: center; background-color: #ccffcc;
            border-top: 1px solid #66ff66; }
        .mainBody { padding: 10px; border: 1px solid #555555; }
        .disclaimer { text-align: center; border-top: 1px solid #cccccc;
            margin-top: 40px; color: #666666; font-size: smaller; }
    </style>
    <sitemesh:write property='head'/>
</head>
<body>
<div id="doc">
    <div id="content">
        <sitemesh:write property='body'/>
    </div>
</div>
</body>
</html>
