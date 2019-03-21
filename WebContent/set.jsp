<%@ page import="com.web.entity.User" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<% User user = (User)session.getAttribute("user");
%>
<div class="layui-container fly-marginTop fly-user-main">
 <jsp:include page="aside.jsp"/> 
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li class="layui-this" lay-id="info">我的资料</li>
        <li lay-id="avatar">头像</li>
        <li lay-id="pass">密码</li>
        <li lay-id="bind">帐号绑定</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-form layui-form-pane layui-tab-item layui-show">
          <form action="" method="post" id="changeMsgForm">
          <input type="hidden" value="<%=user.getAccount()%>" name="account"/>
            <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="email" id="L_email" name="email" required lay-verify="email" autocomplete="off" value="<%=user.getEmail() %>" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">昵称</label>
              <div class="layui-input-inline">
                <input type="text" id="L_username" name="name" required lay-verify="required" autocomplete="off" value="<%=user.getName()%>" class="layui-input">
              </div>
              <div class="layui-inline">
                <div class="layui-input-inline">
                  <input type="radio" name="sex" value="男" checked title="男">
                  <input type="radio" name="sex" value="女" title="女">
                </div>
              </div>
              
            </div>
            <div class="layui-form-item">
              <label for="L_hobby" class="layui-form-label">爱好</label>
              <div class="layui-input-inline">
                <%if(user.getHobby()==null) {%>
                  <input type="text" id="L_hobby" name="hobby" autocomplete="off" value="" class="layui-input">
                 <%}else{ %>
                   <input type="text" id="L_hobby" name="hobby" autocomplete="off" value="<%=user.getHobby() %>" class="layui-input">
                 <%} %>
              </div>
            </div>
             <div class="layui-form-item">
              <label for="L_age" class="layui-form-label">年龄</label>
              <div class="layui-input-inline">
                <%if(user.getHobby()==null) {%>
                  <input type="text" id="L_age" name="age" autocomplete="off" value="" class="layui-input">
                 <%}else{ %>
                   <input type="text" id="L_age" name="age"autocomplete="off" value="<%=user.getAge() %>" class="layui-input">
                 <%} %>
              </div>
            </div>
            <div class="layui-form-item layui-form-text">
              <label for="L_sign" class="layui-form-label">签名</label>
              <div class="layui-input-block">
                <%if(user.getQianming()==null){ %>
                <textarea placeholder="随便写些什么刷下存在感" id="L_sign"  name="sign" autocomplete="off" class="layui-textarea" style="height: 80px;"></textarea>
                <%}else{ %>
                <textarea placeholder="随便写些什么刷下存在感" id="L_sign"  name="sign" autocomplete="off" class="layui-textarea" style="height: 80px;"><%=user.getQianming() %></textarea>
                <%} %> 
              </div>
            </div>
            <div class="layui-form-item">
              <button class="layui-btn" onClick="return checkChangeMessage()">确认修改</button>
              <%if(request.getAttribute("message")!=null){ 
                String message = (String)request.getAttribute("message");  
              %>
              <font color="red"><%=message %></font>
              <% }%>
            </div>
            </form>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <div class="layui-form-item">
              <div class="avatar-add">
                <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过50KB</p>
                <button type="button" class="layui-btn upload-img">
                  <i class="layui-icon">&#xe67c;</i>上传头像
                </button>
                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
                <span class="loading"></span>
              </div>
            </div>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <form action="" method="post" id="changepwdForm">
             <input type="hidden" value="<%=user.getAccount() %>" name="account">
             <input type="hidden" value="<%=user.getPwd() %>" id="pwd">
              <div class="layui-form-item">
                <label for="L_nowpass" class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_nowpass" name="nowpass" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message5">
                     <img src="" id="img5" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_newpass" class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_newpass" name="pass" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="6-10位数字与大小写字母的两种">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message6">
                     <img src="" id="img6" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_renewpass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_renewpass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux" id="message7">
                     <img src="" id="img7" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" onClick="return checkChangePassword()">确认修改</button>
              </div>
            </form>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <ul class="app-bind">
              <li class="fly-msg app-havebind">
                <i class="iconfont icon-qq"></i>
                <span>已成功绑定，您可以使用QQ帐号直接登录Fly社区，当然，您也可以</span>
                <a href="javascript:;" class="acc-unbind" type="qq_id">解除绑定</a>
                
                <!-- <a href="" onclick="layer.msg('正在绑定微博QQ', {icon:16, shade: 0.1, time:0})" class="acc-bind" type="qq_id">立即绑定</a>
                <span>，即可使用QQ帐号登录Fly社区</span> -->
              </li>
              <li class="fly-msg">
                <i class="iconfont icon-weibo"></i>
                <!-- <span>已成功绑定，您可以使用微博直接登录Fly社区，当然，您也可以</span>
                <a href="javascript:;" class="acc-unbind" type="weibo_id">解除绑定</a> -->
                
                <a href="" class="acc-weibo" type="weibo_id"  onclick="layer.msg('正在绑定微博', {icon:16, shade: 0.1, time:0})" >立即绑定</a>
                <span>，即可使用微博帐号登录Fly社区</span>
              </li>
            </ul>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>
</body>
</html>