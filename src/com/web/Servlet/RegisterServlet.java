package com.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.util.DB;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = (int)(1+(Math.random()*1000-1));
		int b = (int)(1+(Math.random()*1000-1));
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String pwd = request.getParameter("pass");
		String account=request.getParameter("account");
		DB db = new DB();
		int result=db.addUser(name,account, pwd, mail);
		switch(result) {
		   case -1:request.setAttribute("nameWrong","昵称重复了");
			       request.getRequestDispatcher("register.jsp").forward(request, response);
		           break;
		   case -2:request.setAttribute("accountWrong","账号重复了");
	               request.getRequestDispatcher("register.jsp").forward(request, response);
		           break;
		   case -3:request.setAttribute("mailWrong","邮箱重复了");
                   request.getRequestDispatcher("register.jsp").forward(request, response);
                   break;
		   default:response.sendRedirect("/web/login");break;
		}
	}

}
