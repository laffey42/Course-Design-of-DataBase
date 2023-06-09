<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩修改</title>
</head>
<body>
<div id="applyDiv" style="height: 350px">
    <form action="/DB/servlet/score/updateSingleServlet" method="post" id="form">
        <h1>-成绩修改-</h1>
        <div>${score_msg}</div>
        <p>笔试成绩：<input id="score01" name="score01" type="text" value="${score.score01}"></p>
        <p>上机成绩：<input id="score02" name="score02" type="text" value="${score.score02}"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="提交">
            <input type="reset" class="button" value="重置">
        </div>
    </form>
    <a href="/DB/servlet/score/selectAllServlet">【返回】</a>
</div>
</body>
</html>
