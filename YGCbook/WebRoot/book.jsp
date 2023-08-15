<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
    <h1>图书列表</h1>
    <table border="1">
        <tr>
            <th>图书ID</th>
            <th>名称</th>
            <th>作者</th>
            <th>价格</th>
            <th>库存</th>
            <th>操作</th>
        </tr>
        <!-- 遍历从后端获取的图书列表，并显示到表格中 -->
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.inventory}</td>
                <td>
                    <a href="edit.jsp?bookId=${book.bookId}">编辑</a>
                    <a href="delete.jsp?bookId=${book.bookId}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">添加图书</a>
</body>
</html>
