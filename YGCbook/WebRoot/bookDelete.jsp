<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>删除图书</title>
</head>
<body>
    <h1>删除图书</h1>
    <form action="DeleteBookServlet" method="post">
        <input type="hidden" name="bookId" value="${param.bookId}">
        确认删除图书 ${param.bookId} 吗？<br>
        <input type="submit" value="删除">
    </form>
    <a href="books.jsp">返回列表</a>
</body>
</html>
