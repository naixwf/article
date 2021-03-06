<#assign security=JspTaglibs["/WEB-INF/tlds/security.tld"] />
<#import "../map2select_macro.ftl" as map/>
<title>文档列表</title>
<body>
<div class="container">
    <!-- TODO 只有管理员显示 -->
<@security.authorize ifAnyGranted="ROLE_ADMIN">
    <div>
        <a href="/article/add?info=" class="btn btn-primary">添加文档</a>
    </div>
    <hr/>
</@security.authorize>
    <div class="row">
        <div class="col-sm-8">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active" style="height: 300px;background: #BBBBBB;">
                        <img src="/appstatic/img/3.jpg" width="750" height="300" alt="">

                        <div class="carousel-caption">
                            <h3>Article</h3>

                            <p>一个基于<a href="http://wowubuntu.com/markdown/index.html">Markdown</a>的文档管理工具</p>
                        </div>
                    </div>
                    <div class="item" style="height: 300px;background: #BBBBBB;">
                        <img src="/appstatic/img/2.jpg" width="750" height="300" alt="">
                             alt="">

                        <div class="carousel-caption">
                            <h3>文档分类</h3>

                            <p>可对文档细分类别，方便管理</p>
                        </div>
                    </div>
                    <div class="item" style="height: 300px;background: #BBBBBB;">
                        <img src="/appstatic/img/4.jpg"
                             alt="">

                        <div class="carousel-caption">
                            <h3>查看权限</h3>

                            <p>文档分为公开、内部资料、保密等安全级别</p>

                            <p>高级用户可以查看保密级别高的文档</p>
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <!-- carousel -->

            <hr/>
            <!-- 按分类查看 -->
            <div class="btn-group" data-toggle="buttons" id="categoryBtn">
                <label class="btn btn-default <#if !(categoryId??)>active</#if>">
                    <input type="radio" name="options" autocomplete="off"
                           <#if !(categoryId??)>checked</#if> >&nbsp;&nbsp;&nbsp;全部&nbsp;&nbsp;&nbsp;
                </label>
            <#list categoryList as item>
                <label class="btn btn-primary <#if (categoryId??)&&(categoryId=item.id)>active</#if>"
                       id="categoryId=#{item.id}">
                    <input type="radio" name="categoryId" autocomplete="off"
                           <#if (categoryId??)&&(categoryId=item.id)>checked</#if>>${item.categroyName}
                </label>
            </#list>
            </div>


        <#list articleList as item>
            <div class="bs-callout bs-callout-info">
                <h4><a href="/article/view?articleId=${item.id}" target="_blank">${item.title}</a></h4>

                <p>
                    <code>最后修改人:</code>${item.modifierId}
                    <code>修改时间:</code>${item.modifyTime?string("yyyy-MM-dd HH:mm:ss")}
                    <code>安全级别:</code>
                    <#if (item.secretLevel > 0) ><kbd></#if>
                    <@map.text  source=secretLevelMap value="#{item.secretLevel}"/>
                    <#if (item.secretLevel > 0) ></kbd></#if>
                    <@security.authorize ifAnyGranted="ROLE_ADMIN">
                        <code><a href="/article/edit?articleId=${item.id}" target="_blank">edit</a></code>
                    </@security.authorize>
                </p>
            </div>
        </#list>
        </div>

        <div class="col-sm-1">
        </div>
    <@security.authorize ifAnyGranted="ROLE_ANONYMOUS">
        <div class="col-sm-2">
            <form class="form-signin" role="form" method="POST" action="/login">
                <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus>
                <input type="password" name="password" class="form-control" placeholder="密码" required>

                <button class="btn btn-default center-block" type="submit">登陆</button>
            </form>
        </div>
    </@security.authorize>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //幻灯片
        $('.carousel').carousel();

        //分类按钮
        $('#categoryBtn').on('click', function (e) {
            window.location.href = '/article?' + e.target.id;
        })
    })
</script>
</body>
