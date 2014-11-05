<#assign security=JspTaglibs["/WEB-INF/tlds/security.tld"] />
<#import "../map2select_macro.ftl" as map/>
<head lang="en">
    <title>查看文档</title>
</head>
<body>
<div class="container">
    <h1>${article.title}<@security.authorize ifAnyGranted="ROLE_ADMIN">
        <a href="/article/edit?articleId=#{article.id}" class="btn btn-primary">修改本文档</a>
    </@security.authorize></h1>
    <code>分类:</code><@map.text  source=categoryMap value="#{article.categoryId}"/><br/>
    <code>安全级别:</code><@map.text  source=secretLevelMap value="#{article.secretLevel}"/><br/>

    <hr/>
${article.contentHtml}
    <hr/>

</div>
</body>
</html>