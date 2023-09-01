<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
    <h1>添加图书</h1>
    <form action="AddBook" method="get">
        书名: <input type="text" name="title"><br>
        作者: <input type="text" name="author"><br>
        价格: <input type="text" name="price"><br>
        库存: <input type="text" name="inventory"><br>
        <input type="submit" value="添加">
    </form>
    <a href="book.jsp">返回搜索页面</a>
</body>
</html>
