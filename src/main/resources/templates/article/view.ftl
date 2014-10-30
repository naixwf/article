<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>查看文档</title>
</head>
<body>
查看文档
<form method="POST">
    title:${article.title}<br/>
    content:${article.content}<br/>
    categoryId:#{article.categoryId}<br/>
    secretLevel:#{article.secretLevel}<br/>
</form>
</body>
</html>