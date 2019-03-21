package com.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.Article;
import com.web.util.CalculatePasstime;
import com.web.util.DB;

@WebServlet("/showArticle")
public class ShowArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowArticleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int articleID  =Integer.parseInt(request.getParameter("articleID"));
		DB db = new DB();
		Article article = db.getArticle(articleID);
		CalculatePasstime cpt = new CalculatePasstime();
		article.setWriteTime(cpt.passTime(article.getWriteTime()));
		request.setAttribute("article", article);
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
