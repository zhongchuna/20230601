<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>注册页面</title>
        <script>
        function validateForm() {
            // 获取表单元素
            var passwordInput = document.getElementById("password");
            var hobbyInputs = document.querySelectorAll("input[name='hobby']:checked");
            var majorSelect = document.getElementById("major");

            // 验证密码长度
            if (passwordInput.value.length < 6 || passwordInput.value.length > 15) {
                alert("密码长度必须在6到15个字符之间。");
                return false;
            }

            // 验证密码是否包含大写字母
            if (!/[A-Z]/.test(passwordInput.value)) {
                alert("密码必须包含至少一个大写字母。");
                return false;
            }

            // 验证是否选择了至少一个爱好
            if (hobbyInputs.length === 0) {
                alert("请选择至少一个爱好。");
                return false;
            }

            // 验证是否选择了专业
            if (majorSelect.value === "") {
                alert("请选择一个专业。");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <h1>注册页面</h1>

    <form method="get" action="userRegister" onsubmit="return validateForm()">
        <label for="username">姓名:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="gender">性别:</label>
        <input type="radio" id="male" name="gender" value="0">男
        <input type="radio" id="female" name="gender" value="1">女<br><br>

        <label for="major">专业:</label>
        <select id="major" name="major">
        	<option value="">-</option>
            <option value="0">英语</option>
            <option value="1">数学</option>
            <option value="2">体育</option>
        </select><br><br>

        <label for="hobby">爱好:</label>
        <input type="checkbox" id="basketball" name="hobby" value="1">篮球
        <input type="checkbox" id="football" name="hobby" value="2">足球
        <input type="checkbox" id="tennis" name="hobby" value="3">网球<br><br>

        <label for="intro">简介:</label><br>
        <textarea id="intro" name="intro" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="注册">
    </form>
</body>
</html>