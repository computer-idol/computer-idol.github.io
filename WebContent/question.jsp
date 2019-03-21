<%@ page import="java.util.ArrayList,com.web.entity.Article" 
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提问</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear lay-filter="">
      <li><a href="/web/jing">精品文章</a></li> 
      <li class="layui-nav-item layui-this"><a href="/web/question">提问</a></li> 
      <li><a href="/web/discuss">讨论</a></li> 
      <li><a href="/web/suggest">建议</a></li> 
      <li><a href="/web/notice">公告</a></li> 
    </ul> 
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="/web/write" class="layui-btn">发表新帖</a> 
    </div> 
  </div>
</div>
<%
 ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
%>
<ul class="fly-list">
   <%for(Article article:articles){ %>
     <li>
            <a href="user/home.html" class="fly-avatar">
              <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
            </a>
            <h2>
              <a href="/web/showArticle?articleID=<%=article.getArticleID()%>"><%= article.getTitle() %></a>
            </h2>
            <div class="fly-list-info">
              <a href="user/home.html" >
                <cite><%= article.getAuthorName() %></cite>
              </a>
              <span><%= article.getWriteTime() %></span>
              <span class="fly-list-kiss layui-hide-xs" title="悬赏金币"><i class="iconfont icon-kiss"></i> <%= article.getMoney() %></span>
              <span class="fly-list-nums"> 
                <i class="iconfont icon-pinglun1" title="回答"></i> <%= article.getCommentTimes() %>
              </span>
            </div>
          </li>
   <%} %>
</ul>
<jsp:include page="footer.jsp"/>
</body>
</html>