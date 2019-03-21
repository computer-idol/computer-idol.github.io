package com.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.Article;
import com.web.util.CalculatePasstime;
import com.web.util.DB;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		ArrayList<Article> articles = db.getAllarticles("Ã·Œ ");
		request.setAttribute("articles", articles);
		for(Article article:articles) {
			CalculatePasstime cpt = new CalculatePasstime();
			article.setWriteTime(cpt.passTime(article.getWriteTime()));
		}
		request.getRequestDispatcher("question.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
