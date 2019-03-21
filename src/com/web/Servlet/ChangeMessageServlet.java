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

/**
 * Servlet implementation class ChangeMessageServlet
 */
@WebServlet("/changemessage")
public class ChangeMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeMessageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String hobby = request.getParameter("hobby");
		int age =Integer.parseInt(request.getParameter("age"));
		String text = request.getParameter("sign");
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("user");
		DB db = new DB();
		int flag=db.updateUser(name, account, hobby, age, sex, email,text,user);
		switch(flag) {
		case -1: request.setAttribute("message", "新的昵称已被使用,修改失败");
		         request.getRequestDispatcher("set.jsp").forward(request, response);
		         break;
		case 1:  request.setAttribute("message", "修改成功");
		         user = db.getUser(account);
		         session.setAttribute("user", user);
                 request.getRequestDispatcher("set.jsp").forward(request, response);  
                 break;
        default:break;
		}
	}
}
