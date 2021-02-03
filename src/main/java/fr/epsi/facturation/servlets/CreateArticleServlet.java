package fr.epsi.facturation.servlets;

import fr.epsi.facturation.dto.ArticleDTO;
import fr.epsi.facturation.service.ArticleService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createArticleServlet", value = "/createArticle")
public class CreateArticleServlet extends HttpServlet {

    @EJB
    private ArticleService articleService;

    /**
     * Affiche le formulaire de création d'un article
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/article/create.jsp").forward(request, response);
    }

    /**
     * Reçoit le formulaire d'un article et crée un article dans la base de données
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setNom(request.getParameter("nomArticle"));
        articleDTO.setPrix(Double.parseDouble(request.getParameter("prixArticle")));

        articleService.create(articleDTO);
        response.sendRedirect(request.getContextPath() + "/articles");

    }
}
