<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考点设置</title>
</head>
<body>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>考点代码</th>
        <th>考点名</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${sites}" var="sites">
        <tr align="center">
            <td>${sites.siteId}</td>
            <td>${sites.siteName}</td>
            <td>
                <a href="/DB/servlet/site/selectSingleServlet?siteId=${sites.siteId}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/DB/model/userManagement.jsp">【返回】</a>
</table>
</body>
</html>
