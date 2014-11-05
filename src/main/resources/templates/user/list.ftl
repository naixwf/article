<#import "../map2select_macro.ftl" as map/>
<head>
    <title>用户权限列表</title>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>用户名</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
    <#list authorityList as item>
        <tr>
            <form action="/user/edit" method="POST">
                <td>${item.username}</td>
                <td>
                    <input type="hidden" name="username" value="${item.username}"/>
                    <@map.select blank=false textId="authority" class="form-control" source=authorityDefineMap selected="${item.authority}"/>
                </td>
                <td>
                    <button type="submit" class="btn-primary">修改</button>
                </td>
            </form>
        </tr>
    </#list>
    </table>
    <hr/>
    <div class="container">
        <h3>权限策略简介</h3>
        <ul>
            <li>注册用户有三种角色：初级账号、高级账号、管理员</li>
            <li>文章分三种安全级别：公开、内部资料、保密</li>
            <li><kbd>游客</kbd>只可以看<code>公开</code>的文档</li>
            <li><kbd>初级账号</kbd>可以看<code>公开、内部资料</code>文档</li>
            <li><kbd>高级账号</kbd>可以看所有文档</li>
            <li>只有<kbd>管理员</kbd>可以<code>增、删、改</code>文档</li>
        </ul>
    </div>
</div>

</body>
</html>