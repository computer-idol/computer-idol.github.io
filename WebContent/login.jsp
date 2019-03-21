<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style>
.layui-form-checkbox i {
  width:15px;
  height:15px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
  String account = null;
  String pwd = null;
  Cookie[] cookies = request.getCookies();
  for(Cookie cookie : cookies){
	   if(cookie.getName().equals("account")){
		   account = cookie.getValue();
	   }
	   else if(cookie.getName().equals("password")){
		   pwd = cookie.getValue();
	   }
   }
%>
<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">.
      <ul class="layui-tab-title">
        <li class="layui-this">登入</li>
        <li><a href="/web/register">注册</a></li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" id="loginForm" action="">
              <div class="layui-form-item">
                <label for="L_account" class="layui-form-label" >账号</label>
                <div class="layui-input-inline">
                 <% if(account!=null){ %>
                  <input type="text" id="L_account" name="account" value="<%=account %>"
                   required lay-verify="required" autocomplete="off" class="layui-input">
                  <%}else{ %>
                   <input type="text" id="L_account" name="account"
                   required lay-verify="required" autocomplete="off" class="layui-input">
                  <%} %>
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                   <% if(pwd!=null){ %>
                  <input type="password" id="L_pass" name="pass" value="<%=pwd %>"
                   required lay-verify="required" autocomplete="off" class="layui-input">
                   <%}else{ %>
                      <input type="password" id="L_pass" name="pass"
                   required lay-verify="required" autocomplete="off" class="layui-input">
                   <%} %>
                </div>
              </div>
               <% 
                  if(request.getAttribute("c")!=null||request.getAttribute("d")!=null){
                     int c=(int)request.getAttribute("c"); 
                     int d=(int)request.getAttribute("d");
              %>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid">
                  <span style="color: #c00;">回答：<span id="c"><%=c %></span>+<span id="d"><%=d %></span>=?</span>
                </div>
                 <div class="layui-form-mid layui-word-aux" id="message5">
                     <img src="" id="img5" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
                <%} %>
              </div>
              <div class="layui-form-item">
                <div class="layui-input-inline">
                  <input type="checkbox" id="remember" value="remember" name="remember" title="记住我" style="position:relative;left:-10px;">
                  <button class="layui-btn" onclick="return check()">立即登录</button>
                  <a href="/web/forget">忘记密码？</a>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>