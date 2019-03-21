package com.web.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.entity.User;
import com.web.util.DB;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		int a = (int)(1+(Math.random()*1000-1));
		int b = (int)(1+(Math.random()*1000-1));
		request.setAttribute("c", a);
		request.setAttribute("d", b);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String account = request.getParameter("account");
	   String pwd = request.getParameter("pass");
	   String remember = request.getParameter("rememebr");
	   
	   //Í¨¹ýcookie´æ´¢
	   if(remember!="") {
		   Cookie c1 = new Cookie("account",account);
		   Cookie c2 = new Cookie("password",pwd);
		   Date date = new Date();
		   Cookie c3 = new Cookie("lastVisited",new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(date));
		   c1.setMaxAge(60*60*24);
		   c2.setMaxAge(60*60*24);
		   c3.setMaxAge(60*60*24);
		   
		   response.addCookie(c1);
		   response.addCookie(c2);
		   response.addCookie(c3);
	   }
	   
	   DB db = new DB();
	   User user=db.login(account, pwd);
	   if(user==null) {
		   response.sendRedirect("/login");
	   }
	   HttpSession session = request.getSession();
	   session.setAttribute("user", user);
	   session.setAttribute("isLogin","yes");
	   request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
