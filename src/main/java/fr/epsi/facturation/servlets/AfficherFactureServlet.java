package fr.epsi.facturation.servlets;

import fr.epsi.facturation.entite.Facture;
import fr.epsi.facturation.entite.LigneFacture;
import fr.epsi.facturation.service.FactureService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "afficherFactureServel", value = "/afficherFacture")
public class AfficherFactureServlet extends HttpServlet {

    @EJB
    private FactureService factureService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Facture facture = factureService.getById(Integer.parseInt(request.getParameter("id")));
        System.out.println(facture.getNumero());
        request.setAttribute("facture", facture);
        for (LigneFacture ligne : facture.getLignesFacture()) {
            System.out.println(ligne.getQte());
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/facture/afficher.jsp").forward(request, response);
    }
}
