<%@ page import="com.web.entity.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="res/layui/css/layui.css" type="text/css" rel="stylesheet">
<link href="res/css/global.css" type="text/css" rel="stylesheet">
<script src="res/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>
<script src="res/js/setup.js"> </script>
<script src="res/js/jquery.min.js"></script>
<script src="res/js/index.js"></script>
<script src="res/js/checkChangePassword.js"></script>
<script type="text/javascript" charset="utf-8" src="res/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="res/js/ueditor/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="res/js/ueditor/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="res/js/ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="res/js/ueditor/utf8-jsp/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="res/js/ueditor/utf8-jsp/third-party/SyntaxHighlighter/shCoreDefault.css">
<script>
SyntaxHighlighter.all();
</script>
</head>
<body>
<div class="fly-header layui-bg-black">
 <div class="layui-container">
   <a class="fly-logo" href="/">
      <img src="res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
      <li class="layui-nav-item">
        <a href="/web/"><i class="layui-icon">&#xe68e</i>首页</a>
      </li>
      <li class="layui-nav-item layui-this">
        <a href="/web/blog"><i class="iconfont icon-iconmingxinganli"></i>技术博客</a>
      </li>
      <li class="layui-nav-item">
        <a href="http://www.layui.com/" target="_blank"><i class="layui-icon">&#xe601;</i>资源</a>
      </li>
    </ul>
    
    <ul class="layui-nav fly-nav-user">
      
    <% if(session.getAttribute("isLogin")==null||!session.getAttribute("isLogin").equals("yes")){%>
      <li class="layui-nav-item">
        <a class="iconfont icon-touxiang layui-hide-xs" href="/web/login"></a>
      </li>
      <li class="layui-nav-item">
        <a href="/web/login">登入</a>
      </li>
      <li class="layui-nav-item">
        <a href="/web/register">注册</a>
      </li>
      <%}else{ 
    	  User user = (User)session.getAttribute("user");
      %>
       <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs"><%= user.getName() %></cite>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="/web/set"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="/web/message"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="/web/home"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="/web/logout" style="text-align: center;">退出</a></dd>
        </dl>
      </li> 
      <%} %>
      </ul>
     </div>
     </div>
    
</body>
</html>