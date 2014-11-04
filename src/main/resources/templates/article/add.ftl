<#import "../map2select_macro.ftl" as map/>
<head>
    <title>新增文档</title>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" method="POST">
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">标题</label>

            <div class="col-sm-4">
                <input type="text" class="form-control" id="title" placeholder="标题" name="title"/>
            </div>
        </div>
        <div class="form-group">
            <label for="category" class="col-sm-2 control-label">类别</label>

            <div class="col-sm-2">
            <@map.select blank=false textId="categoryId" class="form-control" source=categoryMap selected="1"/>
            </div>
        </div>

        <div class="form-group">
            <label for="level" class="col-sm-2 control-label">安全级别</label>

            <div class="col-sm-2">
            <@map.select blank=false textId="secretLevel" class="form-control" source=secretLevelMap selected="0"/>
            </div>
        </div>

        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">正文</label>

            <div class="col-sm-10">
                <textarea id="content" class="form-control" rows="16" name="content"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="content" class="col-sm-2 control-label"></label>

            <div class="col-sm-10">
                <input type="submit" class="btn btn-primary" value="新增文档"/>
            </div>
        </div>
    </form>
</div>
</body>