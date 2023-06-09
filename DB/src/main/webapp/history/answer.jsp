<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>确认</title>
    <style>
        a {
            display: block;
        }
    </style>
</head>
<body>

<h1>注意，此操作将清空报名信息、考务信息和成绩信息，是否继续？</h1>
<div id="errorMsg">${history_msg}</div>
<a href="/DB/servlet/history/generateAllServlet">【继续】</a>
<a href="/DB/model/userManagement.jsp">【返回】</a>

</body>
</html>
