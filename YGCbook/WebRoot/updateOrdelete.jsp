<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<%@page import="co.jp.ygcBook.dao.UserInfoDAO"%>
<%@page import="co.jp.ygcBook.entity.UserInfo"%>
<%@page import="co.jp.ygcBook.dao.HobbyDAO"%>
<%@page import="co.jp.ygcBook.entity.Hobby"%>
 <%
UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");
%>
 <%
Hobby hobby = (Hobby)request.getAttribute("hobby");
 %>
<html>
<head>
    <title>更新页面</title>
    <script>
    function Update(){ 
    	document.getElementById("handle").value = '1'
    }
    
    function Delete(){
    	document.getElementById("handle").value = '2'
    	
    }
    </script>
</head>
<body>
    <h1>更新页面</h1>

    <form method="get" action="updateOrdelete">
    <%if(userInfo != null && hobby != null) {%>
        <label for="username">姓名:</label>
        <input type="text" id="username" name="username" value ="<%=userInfo.getUsername()%>"><br><br>

        <label for="password">密码:</label>
        <input type="text" id="password" name="password"  value ="<%=userInfo.getPassword()%>"><br><br>
        
        <label for="gender">性别:</label>
        <input type="radio" id="male" name="gender" value="0" <%= userInfo.getGender().equals("0") ? "checked" : "" %>>男
        <input type="radio" id="female" name="gender" value="2" <%= userInfo.getGender().equals("1") ? "checked" : "" %>>女<br><br>

        <label for="major">专业:</label>
        <select id="major" name="major">
            <option value="0" <%= userInfo.getMajor().equals("0") ? "selected" : "" %>>英语</option>
            <option value="1" <%= userInfo.getMajor().equals("1") ? "selected" : "" %>>数学</option>
            <option value="2" <%= userInfo.getMajor().equals("2") ? "selected" : "" %>>体育</option>
        </select><br><br>

        <label for="hobby">爱好:</label>
        <input type="checkbox" id="basketball" name="hobby" value="1" <%= hobby.getHobby().contains("1") ? "checked" : "" %> >足球
        <input type="checkbox" id="football" name="hobby" value="2" <%= hobby.getHobby().contains("2") ? "checked" : "" %>>篮球
        <input type="checkbox" id="tennis" name="hobby" value="3" <%= hobby.getHobby().contains("3") ? "checked" : "" %>>网球<br><br>

        <label for="intro">简介:</label><br>
        <textarea id="intro" name="intro" rows="4" cols="50" ><%=userInfo.getIntro()%></textarea><br><br>
        
        <input type = "hidden" id ="handle" name ="handle">
 	    <input type="submit" value="修改" onClick="Update()">
        <input type="submit" value="删除" onClick="Delete()">
        <% }%>
    </form>
</body>
</html>