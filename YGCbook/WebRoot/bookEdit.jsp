<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑图书</title>
</head>
<body>
    <h1>编辑图书</h1>
    <form action="EditBookServlet" method="post">
        <input type="hidden" name="bookId" value="${param.bookId}">
        标题: <input type="text" name="title" value="${book.title}"><br>
        作者: <input type="text" name="author" value="${book.author}"><br>
        价格: <input type="text" name="price" value="${book.price}"><br>
        库存: <input type="text" name="inventory" value="${book.inventory}"><br>
        <input type="submit" value="保存">
    </form>
    <a href="books.jsp">返回列表</a>
</body>
</html>
