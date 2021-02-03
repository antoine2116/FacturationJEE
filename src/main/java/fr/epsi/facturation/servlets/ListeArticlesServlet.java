package fr.epsi.facturation.servlets;

import fr.epsi.facturation.service.ArticleService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listeArticlesServlet", value = "/articles")
public class ListeArticlesServlet extends HttpServlet {

    @EJB
    private ArticleService articleService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("articles", articleService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/article/index.jsp").forward(request, response);
    }
}
