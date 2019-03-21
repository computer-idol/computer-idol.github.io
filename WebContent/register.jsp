<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<style>
.layui-input-inline input{
width:210px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li><a href="/web/login">登入</a></li>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="" id="regForm">
              <div class="layui-form-item">
                <label for="L_name" class="layui-form-label">昵称</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_name" name="name" required  autocomplete="off" class="layui-input" placeholder="给自己起个帅气的名字吧">
                </div>
                <%if(request.getAttribute("nameWrong")!=null&&request.getAttribute("nameWrong")!=""){
                	String message1=(String)request.getAttribute("nameWrong");
                %>
                <div class="layui-form-mid layui-word-aux">
                  <img src="res/images/error.png"style="width:15px">
                  <span style="color:red;"><%=message1 %></span>
                </div>
                <%} %>
              </div>
              <div class="layui-form-item">
                <label for="L_name" class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_account" name="account" required  autocomplete="off" class="layui-input" placeholder="9-11位数字">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message1">
                     <img src="" id="img1" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
                <%if(request.getAttribute("accountWrong")!=null&&request.getAttribute("accountWrong")!=""){
                	String message2=(String)request.getAttribute("accountWrong");
                %>
                <div class="layui-form-mid layui-word-aux">
                  <img src="res/images/error.png"style="width:15px">
                  <span style="color:red;"><%=message2 %></span>
                </div>
                <%} %>
              </div>
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                  <input type="email" id="L_username" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <%if(request.getAttribute("mailWrong")!=null&&request.getAttribute("mailWrong")!=""){
                	String message3=(String)request.getAttribute("mailWrong");
                %>
                <div class="layui-form-mid layui-word-aux">
                  <img src="res/images/error.png"style="width:15px">
                  <span style="color:red;"><%=message3 %></span>
                </div>
                <%} %>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pass" required placeholder="6-10位数字与大小写字母的两种"
                   lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message2">
                     <img src="" id="img2" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message3">
                     <img src="" id="img3" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <% int a=(int)request.getAttribute("a"); 
                 int b=(int)request.getAttribute("b");
              %>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                </div>
                 <div class="layui-form-mid">
                  <span style="color: #c00;">回答：<span id="a"><%=a %></span>+<span id="b"><%=b %></span>=?</span>
                 </div>
                 <div class="layui-form-mid" id="message4">
                  <img src="" id="img4" style="width:15px">
                  <span class="yanzheng" style="color:red;"></span>
                </div>
            
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" onclick="return check2()">立即注册</button>
              </div>
              <div class="layui-form-item fly-form-app">
                <span>或者直接使用社交账号快捷注册</span>
                <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
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