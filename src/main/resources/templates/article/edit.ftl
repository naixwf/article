<#import "../map2select_macro.ftl" as map/>
<head>
    <title>修改文档</title>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" method="POST">
        <input type="hidden" name="id" value="#{article.id}"/>

        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">标题</label>

            <div class="col-sm-4">
                <input type="text" class="form-control" id="title" placeholder="标题" name="title"
                       value="${article.title}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="category" class="col-sm-2 control-label">类别</label>

            <div class="col-sm-2">
            <@map.select blank=false textId="categoryId" class="form-control" source=categoryMap selected="#{article.categoryId}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="level" class="col-sm-2 control-label">安全级别</label>

            <div class="col-sm-2">
            <@map.select blank=false textId="secretLevel" class="form-control" source=secretLevelMap selected="#{article.secretLevel}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">正文</label>

            <div class="col-sm-10">
                <textarea id="content" class="form-control" rows="16" name="content">${article.content}</textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="content" class="col-sm-2 control-label"></label>

            <div class="col-sm-10">
                <input type="submit" class="btn btn-primary" value="提交修改"/>
                <a type="submit" class="btn btn-danger" href="#">删除本文</a>
            </div>
        </div>
    </form>
    <form></form>
</div>

</body>

