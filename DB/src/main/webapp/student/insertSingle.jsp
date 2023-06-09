<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入报名信息</title>
</head>
<body>
<div id="applyDiv" style="height: 350px">
    <form action="/DB/servlet/student/insertSingleServlet" method="post" id="form">
        <h1>-录入报名信息-</h1>
        <div>${stu_msg}</div>
        <p>学号：<input id="stuId" name="stuId" type="text"></p>
        <p>姓名：<input id="stuName" name="stuName" type="text"></p>
        <p>语言：
            <select id="lanId" name="lanId">
                <option value="01">C语言</option>
                <option value="02">C++</option>
                <option value="03">Java</option>
                <option value="04">Visual Basic</option>
                <option value="05">WEB</option>
                <option value="06">Python</option>
            </select>
        </p>
        <div id="subDiv">
            <input type="submit" class="button" value="提交">
            <input type="reset" class="button" value="重置">
        </div>
    </form>
    <a href="/DB/model/applyManagement.jsp">【返回】</a>
</div>
</body>
</html>
