<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改考点信息</title>
</head>
<body>
<div id="applyDiv" style="height: 350px">
  <form action="/DB/servlet/site/updateSingleServlet" method="post" id="form">
    <h1>-修改考点信息-</h1>
    <div>${site_msg}</div>
    <p>考点代码：
      <select id="siteId" name="siteId">
        <option value="001">001</option>
        <option value="012">012</option>
        <option value="037">037</option>
        <option value="085">085</option>
        <option value="172">172</option>
        <option value="199">199</option>
        <option value="234">234</option>
        <option value="288">288</option>
        <option value="306">306</option>
      </select>
    </p>
    <p>考点名：<input id="siteName" name="siteName" type="text" value="${site.siteName}"></p>
    </p>
    <div id="subDiv">
      <input type="submit" class="button" value="提交">
      <input type="reset" class="button" value="重置">
    </div>
  </form>
  <a href="/DB/site/selectAll.jsp">【返回】</a>
</div>
</body>
</html>
