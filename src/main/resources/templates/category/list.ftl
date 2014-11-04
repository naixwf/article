<head>
    <title>文档类别列表</title>
</head>
<body>

<div class="container">
    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal">新增</button>
    <hr/>
<h3>现有类别</h3>
<#list categoryList as item>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#editModal"
            id="#{item.id}">${item.categroyName}</button>
</#list>
    <!-- edit Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="editModalLabel">编辑文档类别</h4>
                </div>
                <form action="/category/edit" method="POST">
                    <div class="modal-body">
                        <div class="input-group">
                            <input type="hidden" name="id" value="" id="categoryId"/>
                            <input type="text" class="form-control" name="categroyName" value="" id="categroyName"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </form>
                <div class="modal-footer">
                    <form action="/category/delete" method="POST">
                        <input type="hidden" name="categoryId" value="" id="categoryIdDelete"/>
                        <button type="submit" class="btn btn-danger">删除</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- add Modal -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="addModalLabel">编辑文档类别</h4>
                </div>
                <form action="/category/add" method="POST">
                    <div class="modal-body">
                        <div class="input-group">
                            <input type="text" class="form-control" name="categroyName" value="" id="categroyName"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/bower_components/bootstrap/js/modal.js"></script>
<script type="text/javascript">
    $(function () {
        $('#editModal').on('show.bs.modal', function (e) {//每当有按钮被按下，把当前id和name赋值到模态对话框里
            //edit 模态框
            $("#categoryId").val(e.relatedTarget.id);
            $("#categroyName").val(e.relatedTarget.innerHTML);
            //delete 模态框
            $("#categoryIdDelete").val(e.relatedTarget.id);
        })
    });
</script>
</body>
</html>