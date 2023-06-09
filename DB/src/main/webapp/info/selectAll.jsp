<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>准考证浏览</title>
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

    <c:forEach items="${infoViews}" var="infoViews">
        <tr align="center">
            <td>${infoViews.admission}</td>
            <td>${infoViews.stuName}</td>
            <td>${infoViews.time}</td>
            <td>${infoViews.lanName}</td>
            <td>${infoViews.siteName}</td>
            <td>${infoViews.hallId}</td>
            <td>${infoViews.seat}</td>
        </tr>
    </c:forEach>
    <a href="/DB/model/affairManagement.jsp">【返回】</a>
</table>
</body>
</html>
