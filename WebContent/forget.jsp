<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>忘记密码</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li><a href="/web/login">登入</a></li>
        <li class="layui-this">找回密码</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <div id="form1">
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                  <%if(request.getAttribute("email")!=null){
            	  String email =(String)request.getAttribute("email");
                   %> 
                  <input type="text" id="L_email" name="email" value="<%=email %>" required lay-verify="required" autocomplete="off" class="layui-input">
                 <%}else{ %>
                  <input type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                 <%} %>
                </div>
                <div class="layui-input-inline">
                  <button class="layui-btn" onclick="return getCode()">获取验证码</button>
                </div>
                <%if(request.getAttribute("message")!=null){
                	String message = (String)request.getAttribute("message");
                %>
                  <font color="red">
                   <%=message%>
                 </font>
                 <%}%>
              </div>
              <%if(request.getAttribute("code")!=null){
            	  String code =(String)request.getAttribute("code");
              %>
                  <input type="hidden" value="<%=code%>" name="rightCode" id="rightCode"/>
              <%}%>
              <div class="layui-form-item">
                <label for="L_code" class="layui-form-label">验证码</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_code" name="code"  autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-mid layui-word-aux" id="message9">
                     <img src="" id="img9" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              <div class="layui-form-item">
                <button class="layui-btn" onclick="return checkCode()">提交</button>
              </div>
            </div>
            
            <!-- 邮箱验证成功后显示 -->
            <form action="" method="post" id="form2">
            <div class="layui-form-item">
            <%if(request.getAttribute("email")!=null){
                String email =(String) request.getAttribute("email"); %>
               <input type="hidden" name="email" value="<%=email %>" id="email">
             <%} %>
                <label for="L_newpwd" class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_newpwd" name="newpwd"  autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message10">
                     <img src="" id="img10" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_renewpwd" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_renewpwd" name="renewpwd"  autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message11">
                     <img src="" id="img11" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" onclick="return change()">提交</button>
              </div>
              </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  $(function(){
	  $("#form2").hide();
  })
</script>

</body>
</html>