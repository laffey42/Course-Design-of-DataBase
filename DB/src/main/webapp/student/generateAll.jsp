<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/DB/servlet/student/generateAllServlet" method="post" id="form">
        <a href="/DB/model/applyManagement.jsp">【返回】</a>
        <h1>-请输入要随机生成的学生数量-</h1>
        <h1>注意：本操作将清空以往所有学生信息！</h1>
        <div id="errorMsg">${info_msg}</div>
        <p>数量：<input id="num" name="num" type="text"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="提交">
        </div>
    </form>
</div>
</body>
</html>