<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>查询</title>
</head>

<body>
<div id="loginDiv" style="height: 350px">
  <form action="/DB/servlet/info/selectSingleServlet" method="post" id="form">
    <a href="/DB/model/affairManagement.jsp">【返回】</a>
    <h1>-请输入学号或准考证号进行查询-</h1>
    <div id="errorMsg">${info_msg}</div>
    <p>学号：<input id="stuId" name="stuId" type="text"></p>
    <p>准考证号：<input id="admission" name="admission" type="text"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="查询">
    </div>
  </form>
</div>
</body>
</html>