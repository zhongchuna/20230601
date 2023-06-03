<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <h1>注册页面</h1>

    <form method="get" action="userRegister">
        <label for="username">姓名:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="gender">性别:</label>
        <input type="radio" id="male" name="gender" value="0">男
        <input type="radio" id="female" name="gender" value="1">女<br><br>

        <label for="major">专业:</label>
        <select id="major" name="major">
            <option value="0">英语</option>
            <option value="1">数学</option>
            <option value="2">体育</option>
        </select><br><br>

        <label for="hobbies">爱好:</label>
        <input type="checkbox" id="basketball" name="hobbies" value="篮球">篮球
        <input type="checkbox" id="football" name="hobbies" value="足球">足球
        <input type="checkbox" id="tennis" name="hobbies" value="网球">网球<br><br>

        <label for="intro">简介:</label><br>
        <textarea id="intro" name="intro" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="注册">
    </form>
</body>
</html>