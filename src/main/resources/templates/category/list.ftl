<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>文档类别列表</title>
</head>
<body>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
<#list categoryList as item>
    <tr>
        <td>#{item.id}</td>
        <td>${item.categroyName}</td>
    </tr>
</#list>
</table>

</body>
</html>