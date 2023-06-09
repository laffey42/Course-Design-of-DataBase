<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩浏览</title>
</head>
<body>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>准考证号</th>
        <th>笔试成绩</th>
        <th>上机成绩</th>
        <th>总成绩</th>
        <th>状态</th>
        <th>选项</th>
    </tr>
    <c:forEach items="${scores}" var="scores">
        <tr align="center">
            <td>${scores.admission}</td>
            <td>${scores.score01}</td>
            <td>${scores.score02}</td>
            <td>${scores.scoreTotal}</td>
            <c:if test="${scores.scoreTotal < 60}">
                <td>不合格</td>
            </c:if>
            <c:if test="${scores.scoreTotal >= 60}">
                <td>合格</td>
            </c:if>
            <td>
                <a href="/DB/servlet/score/selectSingleServlet?admission=${scores.admission}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/DB/model/achievementManagement.jsp">【返回】</a>
</table>
</body>
</html>
