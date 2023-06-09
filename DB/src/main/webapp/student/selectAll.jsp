<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考点设置</title>
</head>
<body>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>语言代码</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${students}" var="students">
        <tr align="center">
            <td>${students.stuId}</td>
            <td>${students.stuName}</td>
            <td>${students.lanId}</td>
            <td>
                <a href="/DB/servlet/student/selectSingleServlet?stuId=${students.stuId}&amp;action=update">修改</a>
                <a href="/DB/servlet/student/selectSingleServlet?stuId=${students.stuId}&amp;action=delete">删除</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/DB/model/applyManagement.jsp">【返回】</a>
</table>
</body>
</html>
