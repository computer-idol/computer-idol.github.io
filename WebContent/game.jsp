<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>游戏设计开发博客</title>
</head>
<body>
<jsp:include page="BlogHeader.jsp"/>
   <div class="fly-panel fly-column">
   <div class="layui-container">
	 <ul class="layui-clear lay-filter="">
	    <li class="layui-nav-item layui-this"><a href="/web/blog">推荐</a></li>
	    <li><a href="/web/frontEnd">前端</a></li>
	    <li><a href="/web/language">编程语言</a></li>
	    <li><a href="/web/mobileSoftware">移动软件开发</a></li>
	    <li class="layui-nav-item layui-this"><a href="/web/game">游戏</a></li>
	    <li><a href="/web/else">其他</a></li>
	  </ul>
      <%if(session.getAttribute("isLogin")!=null&&session.getAttribute("isLogin")=="yes"){ %>
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="/web/write" class="layui-btn">发表博客</a> 
    </div> 
    <%} %> 
   </div> 
   <jsp:include page="footer.jsp"/>
</body>
</html>