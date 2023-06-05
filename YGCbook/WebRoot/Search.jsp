<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>搜索页面</title>
</head>
<body>
    <h1>搜索页面</h1>
    <form method="get" action="search">
        <label for="name">姓名:</label>
        <input type="text" id="name" name="name">
        <br><br>
        
        <label for="gender">性别:</label>
        <select id="gender" name="gender">
        	<option value=""></option>
            <option value="1">男</option>
            <option value="2">女</option>
        </select>
        <br><br>
        
        <label for="major">专业:</label>
        <select
			id="major" name="major">
			<option value=""></option>
			<option value="1">软件工程</option>
			<option value="2">英语</option>
			<option value="3">数学</option>
		</select><br> 
        <br><br>
        
        <input type="submit" value="搜索">
    </form>
</body>
</html>