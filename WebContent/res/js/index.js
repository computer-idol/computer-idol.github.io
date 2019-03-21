$("#message1").hide();
$("#message2").hide();
$("#message3").hide();
//显示消息
function show(obj1,obj2,obj3,img,msg){
    obj1.show();
    obj2.attr("src",img);
    obj3.innerHTML=msg;
    setTimeout(function(){obj1.hide();},1500);
}
function check(){
   var a = $("#c").val();
   var b = $("#d").val();
   var answer = $("#L_vercode").val();
   System.out.println(a);
   System.out.println(b);
   System.out.println(answer);
   if(answer!=a+b){
		show($("#message5"),$('#img5'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
		"你的回答错误，暂时无法认定为人类");
		setTimeout(function(){window.location.href="http://localhost:8080/web/login"},2000);
		return false;
	}
   $("#loginForm").attr("action","/web/login");
   $("#loginForm").submit();
   return true;
}
function check2(){
	var account = $("#L_account").val();
	var repwd = $("#L_repass").val();
	var pwd = $("#L_pass").val();
	var reg1 = /^\d{9,11}/;
	var reg2 =/^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,10}$/;
	var a = $("#a").val();
	var b = $("#b").val();
	var answer = $("#L_vercode").val();
	System.out.println(a);
	System.out.printlm(b);
	System.out.println(answer);
	if(!account.match(reg1)){
		show($("#message1"),$('#img1'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
		"账号必须是9-11位的数字");
        return false;
	}
	if(!pwd.match(reg2)){
		show($("#message2"),$('#img2'),document.getElementsByClassName('yanzheng')[1],"res/images/error.png",
				"密码必须是6-10位的数字、大小写字母中的两种");
		return false;
	}
	else if(pwd!=repwd){
		show($("#message3"),$('#img3'),document.getElementsByClassName('yanzheng')[2],"res/images/error.png",
		"确认密码必须要和密码相同");
		return false;
	}
	else if(answer!=a+b){
		show($("#message4"),$('#img4'),document.getElementsByClassName('yanzheng')[3],"res/images/error.png",
		"你的回答错误，暂时无法认定为人类");
		setTimeout(function(){window.location.href="http://localhost:8080/web/register"},2000);
		return false;
	}
	$("#loginForm").attr("action","/web/register");
	$("#loginForm").submit();
	return true;
}

function getCode(){
	var mail = $("#L_email").val().trim();
	window.location.href="http://localhost:8080/web/yanzheng?email="+mail;
	return false;
}
function checkCode(){
  var rightCode = $("#righCode").val();
  var code = $("#code").val();
  var email = $("#L_email").val();
  if(code==""){
	  show($("#message9"),$('#img9'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
		"验证码不能为空"); 
	  return false;
  }
  else if(code!=rightCode){
	  show($("#message9"),$('#img9'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
		"验证码输入错误"); 
	  return false;
  }
  show($("#message9"),$('#img9'),document.getElementsByClassName('yanzheng')[0],"res/images/right.png",
	"邮箱验证成功"); 
  $("#form1").hide();
  $("#form2").show();
  $("#email").val(email);
  return true;
}
function change(){
	var email = $("#email").val();
	var newpwd = $("#L_newpwd").val();
	var renewpwd = $("#L_renewpwd").val();
	var reg =/^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,10}$/; 
	if(!newpwd.match(reg)){
		show($("#message10"),$('#img10'),document.getElementsByClassName('yanzheng')[1],"res/images/error.png",
		"密码必须是6-10位的数字、大小写字母中的两种");
        return false;
	}
	else if(newpwd!=renewpwd){
		show($("#message11"),$('#img11'),document.getElementsByClassName('yanzheng')[2],"res/images/error.png",
		"确认密码必须要和新密码一样");
        return false;
	}
	$("#form2").attr("action","/web/forget");
	$("#form3").submit();
	return true;
}