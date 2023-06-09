<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>历史记录浏览</title>
</head>
<body>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>时间</th>
        <th>学号</th>
        <th>考点代码</th>
        <th>考场代码</th>
        <th>语言代码</th>
        <th>笔试成绩</th>
        <th>上机成绩</th>
        <th>总成绩</th>
        <th>状态</th>
    </tr>

    <c:forEach items="${histories}" var="histories">
        <tr align="center">
            <td>${histories.time}</td>
            <td>${histories.stuId}</td>
            <td>${histories.siteId}</td>
            <td>${histories.hallId}</td>
            <td>${histories.lanId}</td>
            <td>${histories.score01}</td>
            <td>${histories.score02}</td>
            <td>${histories.scoreTotal}</td>
            <c:if test="${histories.scoreTotal < 60}">
                <td>不合格</td>
            </c:if>
            <c:if test="${histories.scoreTotal >= 60}">
                <td>合格</td>
            </c:if>
        </tr>
    </c:forEach>
    <a href="/DB/model/userManagement.jsp">【返回】</a>
</table>
</body>
</html>
