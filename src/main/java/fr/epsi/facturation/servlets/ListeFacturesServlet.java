package fr.epsi.facturation.servlets;

import fr.epsi.facturation.entite.Client;
import fr.epsi.facturation.service.ClientService;
import fr.epsi.facturation.service.FactureService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listeFactureServlet", value = "/factures")
public class ListeFacturesServlet extends HttpServlet {

    @EJB
    private FactureService factureService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("factures", factureService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/facture/index.jsp").forward(request, response);
    }
}
