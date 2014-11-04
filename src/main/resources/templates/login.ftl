<head>
    <title>登陆</title>
    <link rel="stylesheet" href="/appstatic/signin.css"/>
</head>
<body>
<#if (param.error)??>
<div>
    Invalid username and password.
</div>
</#if>

<#if (param.logout)??>
<div>
    You have been logged out.
</div>
</#if>

<div class="container">


    <form class="form-signin" role="form" method="POST">
        <h2 class="form-signin-heading">Article</h2>
        <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="密码" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>

</div>
<!-- /container -->
</body>
