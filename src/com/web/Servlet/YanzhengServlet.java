package com.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.util.DB;
import com.web.util.RandomCode;
import com.web.util.SendMail;

@WebServlet("/yanzheng")
public class YanzhengServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public YanzhengServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);
		String email = request.getParameter("email");
		System.out.println(email);
		DB db = new DB();
		int result = db.searchmail(email);
		switch(result) {
		  case -1:request.setAttribute("message", "您所填的邮箱尚未注册过,请先去<font color='blue'><a href='/web/register'>注册</a></font>");
		          request.getRequestDispatcher("forget.jsp").forward(request, response);
		          break;
		  case 1:
		       String code = RandomCode.getRandomCode();
		       SendMail sendmail = new SendMail(email,code);
		       sendmail.start();
		       request.setAttribute("message","已发送邮件到你所填的邮箱中");
		       request.setAttribute("email", email);
		       request.setAttribute("code", code);
		       request.getRequestDispatcher("forget.jsp").forward(request, response);
		       break;
		  default:break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
