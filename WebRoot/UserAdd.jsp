<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div align="center">
		<div align="left">
			<form action="http://www.baidu.com/" method="post">
				<font color="red">*</font>用户代码： <input type="text" name="userId"
					id="userId">
				<p>
					<font color="red">*</font>用户名称： <input type="text" name="userName"
						id="userName">
				<p>
					<font color="red">*</font>密码： <input type="password"
						name="password" id=""password"">
				<p>
					<font color="red">*</font>确认密码： <input type="password"
						name="password2" id="password2">
				<p>
					联系电话： <input type="text" name="tel" id="tel">
				<p>
					邮箱： <input type="text" name="email" id="email">
				<p>
					<input type="submit" value="提交" />
			</form>

		</div>
	</div>

	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input").click(function() {
				var index = parent.layer.getFrameIndex(window.name);
				parent.$('.btn-refresh').click();
				parent.layer.close(index);
				parent.layer.msg("添加成功")
			});
		});
	</script>
</body>
</html>
