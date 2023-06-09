<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>成绩录入</title>
</head>
<body>
<div id="applyDiv" style="height: 350px">
  <form action="/DB/servlet/score/insertSingleServlet" method="post" id="form">
    <h1>-成绩录入-</h1>
    <div>${score_msg}</div>
    <p>准考证号：<input id="admission" name="admission" type="text"></p>
    <p>笔试成绩：<input id="score01" name="score01" type="text"></p>
    <p>上机成绩：<input id="score02" name="score02" type="text"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="提交">
      <input type="reset" class="button" value="重置">
    </div>
  </form>
  <a href="/DB/model/achievementManagement.jsp">【返回】</a>
</div>
</body>
</html>
