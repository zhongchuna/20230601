﻿<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page import="co.jp.netwisdom.dto.UserInfoHobbyDto"%>
<%@page import="co.jp.netwisdom.dto.HobbyDto"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>用户注册画面</title>
<script>
function changeActionName(actionName){
	document.getElementById("form").action = actionName;
	document.getElementById("username").action = false;
}

function checkHobby(){
	var hobbyFlg = document.getElementsByName("hobby");
	var flg = 0;
	for(var i=0; i < hobbyFlg.length; i++){
		if(hobbyFlg[i].checked == true){
			flg += 1;
		}
	}
	if(flg == 0){
		alert("请选择一个爱好！！！");
		return false;
	}
}
</script>

</head>
<%UserInfoHobbyDto dto = (UserInfoHobbyDto)request.getAttribute("dto");%>
<%List<String> hobbys = (List<String>)request.getAttribute("hobbys");%>
<%if(dto!=null){%>
<body>
	<form action="userUpdate.do" id="form">
		<bean:message bundle = "userResource" key = "username"/>:<input raidonly   id="username" name="username" value="<%=dto.getUsername()%>"><br>
		密码:<input type="password" id="password"name="password" value="<%=dto.getPassword()%>"><br>
		性别:<input type="radio" name="sex" checked  id="sex1" value="0"<%if("0".equals(dto.getSex())){%>checked<%} %>>男
			<input type="radio"  name="sex" id="sex2"  value="1"<%if("1".equals(dto.getSex())){%>checked<% }%>>女<br>
		爱好:<input type="checkbox" name="hobby" value="0"<%if(hobbys.contains("0")){%>checked<%}%>>足球
			<input type="checkbox" name="hobby" value="1"<%if(hobbys.contains("1")){%>checked<%}%>>篮球
			<input type="checkbox" name="hobby" value="2"<%if(hobbys.contains("2")){%>checked<%}%>     >网球<br>
		专业:<select id="major"name="major">
			<option value="0"<%if("0".equals(dto.getMajor())){%>selected<%}%>>软件工程</option>
			<option value="1" <%if("1".equals(dto.getMajor())){%>selected<%}%>>英语</option>
			<option value="2"<%if("2".equals(dto.getMajor())){%>selected<%}%>>数学</option>
		</select><br>
		简介:<br><textarea id="intro"name="intro"><%=dto.getIntro()%></textarea><br>
		
		<input type="submit" value="更新用户" onclick ="changeActionName('userUpdate.do')">
		<input type="submit" value="删除用户" onclick ="changeActionName('userDel.do')">
		<input type="button" value="重置">
	</form>
</body>
<%}else{%>
<body>     
	<form action="userReg.do">
		<bean:message bundle = "userResource" key = "username"/>:<input id="username" name="username" value=""><br>
		密码:<input type="password" id="password"name="password" value=""><br>
		性别:<input type="radio" name="sex" checked  id="sex1" value="0">男<input type="radio"  name="sex" id="sex2"  value="1">女<br>
		爱好:<input type="checkbox" name="hobby" value="0">足球
			<input type="checkbox" name="hobby" value="1">篮球
			<input type="checkbox" name="hobby" value="2">网球<br>
		专业:<select id="major"name="major">
			<option value="0">软件工程</option>
			<option value="1">英语</option>
			<option value="2">数学</option>
		</select><br>
		简介:<br><textarea id="intro"name="intro"></textarea><br>
		
		<input type="submit" value="注册用户" onClick="checkHobby()">
		<input type="button" value="重置">
	</form>
</body>
<%}%>
</html>