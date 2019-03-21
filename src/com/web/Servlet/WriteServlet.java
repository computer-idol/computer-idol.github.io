package com.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.entity.User;
import com.web.util.DB;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WriteServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("writeContent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	  response.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf8");
	  
	  String type=request.getParameter("type");
	  String title = request.getParameter("title");
	  String content = request.getParameter("content");
	  int money = Integer.parseInt(request.getParameter("money"));
	  System.out.println(type);
	  System.out.println(money);
	  HttpSession session = request.getSession();
	  User user =(User)session.getAttribute("user");
	  DB db =new DB();
	  db.addArticle(title, content, type, user.getUserID(), user.getName(), user.getTouxiang(), money);
	  request.setAttribute("message", "文章提交成功,正由管理员审核");
	  request.getRequestDispatcher("writeContent.jsp").forward(request, response);
	}

}
