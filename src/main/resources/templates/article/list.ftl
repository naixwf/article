<title>文档列表</title>
<body>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>content</th>
        <th>authorId</th>
        <th>lastUpdateTime</th>
        <th>operate</th>
    </tr>
<#list articleList as item>
    <tr>
        <td>#{item.id}</td>
        <td>${item.title}</td>
        <td>${item.content?if_exists}</td>
        <td>#{item.creatorId}</td>
        <td>${item.modifyTime?datetime}</td>
    <#-- TODO contextPath-->
        <td><a href="/article/edit?articleId=${item.id}">edit</a></td>
    </tr>
</#list>
</table>
</body>