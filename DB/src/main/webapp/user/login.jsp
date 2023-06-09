<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/DB/servlet/user/loginServlet" method="post" id="form">
        <h1>-请登陆-</h1>
        <div id="errorMsg">${login_msg}</div>
        <p>用户名：<input id="username" name="username" type="text"></p>
        <p>密码：<input id="password" name="password" type="password"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登陆">
        </div>
    </form>
</div>
</body>
</html>