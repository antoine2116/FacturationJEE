package fr.epsi.facturation.servlets;

import fr.epsi.facturation.service.ClientService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listeClientsServlet", value = "/clients")
public class ListeClientsSerlvet extends HttpServlet {

    @EJB
    private ClientService clientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("clients", clientService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/index.jsp").forward(request, response);
    }
}
