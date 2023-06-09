<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户设置</title>
</head>
<body>
<div id="updateSingleDiv" style="height: 350px">
    <form action="/DB/servlet/user/updateSingleServlet" method="post" id="form">
        <h1>-用户设置-</h1>
        <div id="errorMsg">${user_msg}</div>
        <p>用户名：<input id="username" name="username" type="text" value="${user.username}"></p>
        <p>密码：<input id="password" name="password" type="text" value="${user.password}"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="提交">
            <input type="reset" class="button" value="重置">
        </div>
    </form>
    <a href="/DB/model/userManagement.jsp">【返回】</a>
</div>
</body>
</html>
