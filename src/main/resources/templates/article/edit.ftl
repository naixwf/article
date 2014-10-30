<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改文档</title>
</head>
<body>
修改文档
<form method="POST">
    <input type="hidden" name="id" value="#{article.id}"/>
    title:<input name="title" value="${article.title}"/><br/>
    content:<input name="content" value="${article.content}"/><br/>
    categoryId:<input name="categoryId" value="#{article.categoryId}"/><br/>
    secretLevel:<input name="secretLevel" value="#{article.secretLevel}"/><br/>
    <input type="submit" value="submit"/>
</form>

<a href="#">删除</a>
</body>
</html>