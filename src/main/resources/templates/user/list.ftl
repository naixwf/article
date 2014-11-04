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
                    <@map.select blank=false textId="authority" class="form-control" source=authorityDefineMap selected="${item.authority}"/></td>
                <td>
                    <button type="submit" class="btn-primary">修改</button>
                </td>
            </form>
        </tr>
    </#list>
    </table>
    <hr/>
    <div class="row">
        <p>权限简介</p>
    </div>
</div>

</body>
</html>