//显示消息
function show(obj1,obj2,obj3,img,msg){
    obj1.show();
    obj2.attr("src",img);
    obj3.innerHTML=msg;
    setTimeout(function(){obj1.hide();},1500);
}
function checkChangePassword(){
	var pwd=$("#pwd").val();//原密码
	var oldpwd = $("#L_nowpass").val();//让用户填写来检验其是否是本人操作
	var newpwd = $("#L_newpass").val();
	var renewpwd = $("#L_renewpass").val();
	var reg =/^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,10}$/
	if(pwd!=oldpwd){
		show($("#message5"),$('#img5'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
		"密码不是原来的密码");
		return false;
	}
	else if(!newpwd.match(reg)){
		show($("#message6"),$('#img6'),document.getElementsByClassName('yanzheng')[1],"res/images/error.png",
		"新密码也必须要满足6-10位的数字和大小写字母中的两种");
		return false;
	}
	else if(renewpwd!=newpwd){
		show($("#message7"),$('#img7'),document.getElementsByClassName('yanzheng')[2],"res/images/error.png",
		"确认密码必须要和新密码相同");
		return false;
	}
	$("#changepwdForm").attr("action","/web/changepassword");
	$("#changepwdForm").submit();
	return true;
}function checkChangeMessage(){
	$("#changeMsgForm").attr("action","/web/changemessage");
	$("#changeMsgForm").submit();
}