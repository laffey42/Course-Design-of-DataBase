<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考生信息查询</title>
</head>
<body>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>准考证</th>
        <th>考生姓名</th>
        <th>考试时间</th>
        <th>语言</th>
        <th>考点</th>
        <th>考场</th>
        <th>座位号</th>
    </tr>

    <tr align="center">
        <td>${infoView.admission}</td>
        <td>${infoView.stuName}</td>
        <td>${infoView.time}</td>
        <td>${infoView.lanName}</td>
        <td>${infoView.siteName}</td>
        <td>${infoView.hallId}</td>
        <td>${infoView.seat}</td>
    </tr>
    <a href="/DB/model/affairManagement.jsp">【返回】</a>
</table>
</body>
</html>
