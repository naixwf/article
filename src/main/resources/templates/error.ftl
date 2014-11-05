<head>
    <title>哦呦，出错了</title>
</head>
<body>
<div>
<#if status=403>
    您没有访问此页面的权限<a href="javascript:history.go(-1);">返回上一页</a>
<#else>
    哦呦，出错了~ [${error} : ${status}]
    <a href="javascript:history.go(-1);">返回上一页</a>
</#if>

</div>
</body>
</html>
