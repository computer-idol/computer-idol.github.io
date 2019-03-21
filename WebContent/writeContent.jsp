<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>撰写文章</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">发表新帖</li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form  method="post" id="writeForm">
              <div class="layui-row layui-col-space15 layui-form-item">
                <div class="layui-col-md3">
                  <label class="layui-form-label">所在专栏</label>
                  <div class="layui-input-block" style="position:relative;z-index:10000">
                    <select lay-filter="column" id="typeSelect"> 
                      <option value="提问">提问</option> 
                      <option value="分享">分享</option> 
                      <option value="讨论">讨论</option> 
                      <option value="建议">建议</option>  
                    </select>
                    <input type="hidden" name="type" id="type">
                  </div>
                </div>
                <div class="layui-col-md9">
                  <label for="L_title" class="layui-form-label">标题</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_title" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                  </div>
                </div>
              </div>
             <div class="layui-form-item">
                <input type="hidden" name="content" id="content">
                <script type="text/plain" id="myEditor"><p>上传的图片可以通过点击后拖动边界缩放</p></script>
                <div class="layui-form-mid layui-word-aux" id="message">
                     <img src="" id="img" style="width:15px">
                     <span class="yanzheng" style="color:red;"></span>
                </div>
             </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">悬赏金币</label>
                  <div class="layui-input-inline" style="width: 190px;">
                    <select id="moneySelect">
                      <option value="0">0</option>
                      <option value="20">20</option>
                      <option value="30">30</option>
                      <option value="50">50</option>
                      <option value="60">60</option>
                      <option value="80">80</option>
                    </select>
                    <input type="hidden" name="money" id="money">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" onclick="return upArticle()">立即发布</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
//显示消息
function show(obj1,obj2,obj3,img,msg){
    obj1.show();
    obj2.attr("src",img);
    obj3.innerHTML=msg;
    setTimeout(function(){obj1.hide();},1500);
}
      var ue=UE.getEditor('myEditor',{
            toolbars:[['undo','redo','template','italic','Bold','fontsize','forecolor','link','spechars','insertvideo','justifyleft','justifyright','justifycenter','justifyjustify','SimpleUpload','emotion','highlightcode','insertcode']],
            autoClearinitialContent:true,
            wordCount:true,
            elementPathEnabled:false,
            initialFrameHeight:400,
            initialFrameWidth:1130
        });
      function upArticle(){
    	  var content=ue.getContent();
    	  if(content.length<50){
    		  show($("#message"),$('#img'),document.getElementsByClassName('yanzheng')[0],"res/images/error.png",
    			"文章字数不得小于50字");
    		  return false;
    	  }
    	  $("#type").val($("#typeSelect").val());
    	  $("#money").val($("#moneySelect").val());
    	  $("#content").val(content);
    	  $("#writeForm").attr("action","/web/write");
    	  $("#writeForm").submit();
    	  return true;
      }
</script>
</body>
</html>