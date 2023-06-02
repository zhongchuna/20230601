<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>

<html>
<head>
<title>课后练习题</title>
<%@page import="co.jp.netwisdom.dto.UserInfoHobbyDto"%>
<%@page import="co.jp.netwisdom.dto.HobbyDto"%>
<%@page import="java.util.*"%>
<%
List<UserInfoHobbyDto> dtos = (List<UserInfoHobbyDto>) request.getAttribute("dtos");
%>
  <script>
	function changeToUpdatePage(username){
		window.location = "userUpdateInit.do?username="+username;
	}
	function delUser(username){
		window.location = "userDel.do?username="+username;
	}
  </script>
</head>
<body>
	<form action="userSearch.do">
		姓名:<input id="username" name="username"><br> 性别:<input
			type="radio" name="sex" checked id="sex1" value="0">男<input
			type="radio" name="sex" id="sex2" value="1">女<br> 专业:<select
			id="major" name="major">
			<option value=""></option>
			<option value="0">软件工程</option>
			<option value="1">英语</option>
			<option value="2">数学</option>
		</select><br> 
		<input type="submit" value="检索"><br> <br>
		<br> 检索一览
		<hr>
		<table border="16px" align="center" width="88%">
			<tr bgcolor="grey">
			<td style ="width:5"></td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>爱好</td>
				<td>专业</td>
				<td>简介</td>
				<td>更新</td>
				<td>删除</td>
			
			</tr>
			<%if(dtos != null){%>
			<% int line = 0;%>
			<% 
			for(UserInfoHobbyDto dto : dtos){
				 line++;
			%> 
			<% if(line%2==0){%><tr bgcolor="#A6D66">
			<%}else{%> <tr bgcolor="#A4D3EE"><%}%>
			<td style = "width:5"><input type ="theckbox"></td>
				<td><a href = "userUpdateInit.do?username=<%=dto.getUsername()%>"><%=dto.getUsername()%></a></td>
				<td><%=dto.getPassword()%></td>
				<td>
				<%if("0".equals(dto.getSex())){%>
				   男
				<%}else{%>
				   女
				<%}%>
				</td>  
				<td>
				<%
				StringBuffer sb = new StringBuffer("");
				for (HobbyDto hobbyDto : dto.getHobbyList()) {
					sb.append(hobbyDto.getHobby() + ",");
				}
				if (",".equals(sb.toString().substring(sb.toString().length() - 1))) {%>
				<%=sb.toString().substring(0, sb.toString().length() - 1).replace("0","足球").replace("1","蓝球").replace("2","网球")%>
					<%
				}else{
				%>
				<%=sb.toString().replace("0","足球").replace("1","篮球").replace("2","网球")%>
				
				<%}%>   
				</td>  
				<td>
				<%if("0".equals(dto.getMajor())){%>
				   软件工程
				<%}%>
				<%if("1".equals(dto.getMajor())){%>
				   英语
				<%}%>
				<%if("2".equals(dto.getMajor())){%>
				  数学
				<%}%>
				</td>
				<td><%=dto.getIntro()%></td>
				<td style=width:"20"><input type="button" value="更新" onclick="changeToUpdatePage('<%=dto.getUsername()%>')"></td>
				<td style=width:"20"><input type="button" value="删除" onclick="delUser('<%=dto.getUsername()%>')"></td>
				
			</tr>
			<tr><td><input type ="checkbox"></td></tr>
			<%
			}
			%>
				
			<%} %>
			

		</table>
	</form>
</body>
</html>