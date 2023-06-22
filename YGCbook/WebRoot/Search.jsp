<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<%@page import="co.jp.ygcBook.dao.UserInfoDAO"%>
<%@page import="co.jp.ygcBook.entity.UserInfo"%>
<%@page import="co.jp.ygcBook.dao.HobbyDAO"%>
<%@page import="co.jp.ygcBook.entity.Hobby"%>
 <%
 List<UserInfo> list = (List<UserInfo>) request.getAttribute("data");
%>
 <%
List<Hobby> hobbylist = (List<Hobby>)request.getAttribute("data1");
 %>
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索页面</title>

</head>
<body>
    <h1>搜索页面</h1>
    
    <form action="newSearch" method="Get">
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name"><br><br>    
        <label for="gender">性别：</label>
        <select id="gender" name="gender">
            <option value="">--请选择--</option>
            <option value="0">男</option>
            <option value="1">女</option>
        </select><br><br>
        
        <label for="major">专业:</label>
        <select id="major" name="major">
        	<option value="">--请选择--</option>
            <option value="0">英语</option>
            <option value="1">数学</option>
            <option value="2">体育</option>
        </select><br><br>
        
        <input type="submit" value="搜索">
    </form>
    
    <h2>搜索结果</h2>
    <table border="1">
        <tr>
        <%if(list != null && hobbylist != null){%>
            <th>姓名</th>
            <th>性别</th>
            <th>专业</th>
            <th>爱好</th>
            <th>简介</th>
        </tr>
        <% for (UserInfo userInfo : list) { %>
            <tr>
                <td><a href ="updateOrdelete?handle=0&usernameForUAD=<%= userInfo.getUsername()%>"><%= userInfo.getUsername()%></a></td>
                <td><%= userInfo.getGender().toString().replace("0", "男").replace("1", "女") %></td>
                <td><%= userInfo.getMajor().toString().replace("0", "英语").replace("1", "数学").replace("2", "体育")  %></td>
                <%if(hobbylist != null){%>
                <% for (Hobby hobby : hobbylist) { %>
                	<%if(userInfo.getUsername().equals(hobby.getUsername())){ %>
                		<td><%= hobby.getHobby().replace("1", "足球").replace("2", "篮球").replace("3", "网球")%></td>
                	<%} %>
                
                <% } %> 
                <% } %> 
                <td><%= userInfo.getIntro()%></td>
            </tr>
        <% } %> 
        <% } %> 
    </table>
</body>
</html>