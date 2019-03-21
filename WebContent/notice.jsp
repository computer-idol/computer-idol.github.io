<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear lay-filter="">
      <li><a href="/web/jing">精品文章</a></li> 
      <li><a href="/web/question">提问</a></li> 
      <li><a href="/web/discuss">讨论</a></li> 
      <li><a href="/web/suggest">建议</a></li> 
      <li class="layui-nav-item layui-this"><a href="/web/notice">公告</a></li> 
    </ul> 
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="/web/write" class="layui-btn">发表新帖</a> 
    </div> 
  </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>