<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统登录</title>
    <link rel="stylesheet" href="../css/index.css" />
    <link rel="stylesheet" href="../css/bootstrap.min.css" /><!---可无视-->
</head>
<body>
<div class="content">
    <div class="bidTitle">微信后台 · 商户运营后台</div>
    <div class="logCon">
        <div>${msg!""}</div>
        <form role="form" action="/sell/seller/login" method="post">
            <span>账号:</span>
            <input class="bt_input" type="text" name="username"/>
            <span>密码:</span>
            <input class="bt_input" type="text" name="password"/>
            <button type="submit" class="logingBut">登录</button>
        </form>
    </div>
</div>
</body>
</html>