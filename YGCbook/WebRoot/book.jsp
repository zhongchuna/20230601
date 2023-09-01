<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="co.jp.ygcBook.dao.BooksDAO"%>
<%@page import="co.jp.ygcBook.entity.Books"%>
 <%
  List<Books> bookList = (List<Books>)request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
    <a href="bookAdd.jsp">添加图书</a>
    <h1>图书列表</h1>
    <form action="Book" method="get">
        <label for="">圖書ID    ：</label>
        <input type="text" id="bookId" name="bookId"><br><br>  
        <label for="">圖書名称：</label>
        <input type="text" id="title" name="title"><br><br>  
        <label for="">圖書作者：</label>
        <input type="text" id="author" name="author"><br><br>    
        <input type="submit" value="搜索"><br><br>
    </form>
    <table border="1">
        <tr>
        <% if (bookList != null) { %>
            <th>图书ID</th>
            <th>名称</th>
            <th>作者</th>
            <th>价格</th>
            <th>库存</th>
            <th>操作</th>
        </tr>
        <!-- 遍历从后端获取的图书列表，并显示到表格中 -->
       
    
        <% for (Books book : bookList) { %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
            <td><%= book.getInventory() %></td>
            <td><a href ="http://www.baidu.com">编辑</a> <a href ="http://www.baidu.com">删除</a></td>
                
        <% } %>
    <% } %>
</tr>

          
    </table>
   
    
</body>
</html>