<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
    <h1>添加图书</h1>
    <form action="AddBookServlet" method="post">
        标题: <input type="text" name="title"><br>
        作者: <input type="text" name="author"><br>
        价格: <input type="text" name="price"><br>
        库存: <input type="text" name="inventory"><br>
        <input type="submit" value="添加">
    </form>
    <a href="books.jsp">返回列表</a>
</body>
</html>
