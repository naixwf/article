<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>查看文档</title>
</head>
<body>
<div class="container">
    <h1>${article.title}</h1>
    categoryId:#{article.categoryId}<br/>
    secretLevel:#{article.secretLevel}<br/>
    <hr/>
${article.contentHtml}
    <hr/>

</div>
</body>
</html>