<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH</title>
<style type="text/css">
	#ubody{
		width:80%;
		height:100%;
		margin:0px auto;
		text-align:center;
		border:red solid 1px;
	}
</style>
</head>
<body>
	<div id="ubody">
		<h1>Hello World!</h1>
		<form action="<%=path%>/user/addUser" method="post">
			<input type="text" name="user.uname" placeholder="请输入用户名" />
			<input type="password" name="user.upwd" placeholder="请输入密码" />
			<input type="text" name="user.umessage" placeholder="请输入用户信息" />
			<input type="submit" value="添加用户" />
		</form>
		<a href="<%=path%>/user/queryAll">用户列表</a>
		<s:iterator value="list">
			<p>
				<s:property value="uname"/>&nbsp;&nbsp;&nbsp;
				<s:property value="umessage"/>&nbsp;&nbsp;&nbsp;
				<s:property value="utime"/>&nbsp;&nbsp;&nbsp;
				<a href="<%=path%>/user/delUser?user.uid=<s:property value="uid"/>">删除用户</a>
			</p>
		</s:iterator>
		<p style="color:red;"><s:property value="mess"/></p>
	</div>
</body>
</html>