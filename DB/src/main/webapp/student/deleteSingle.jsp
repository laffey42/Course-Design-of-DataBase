<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除报名信息</title>
</head>
<body>
<div id="applyDiv" style="height: 350px">
    <form action="/DB/servlet/student/deleteSingleServlet" method="post" id="form">
        <h1>-删除报名信息-</h1>
        <h2>提示：您确定要从报名库中删除本条信息吗？</h2>
        <div id="subDiv">
            <input type="submit" class="button" value="确定">
        </div>
    </form>
    <a href="/DB/student/selectAll.jsp">【返回】</a>
</div>
</body>
</html>
