package fr.epsi.facturation.servlets;

import fr.epsi.facturation.dto.ClientDTO;
import fr.epsi.facturation.service.ClientService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createClientSerlvet", value = "/createClient")
public class CreateClientSerlvet extends HttpServlet {

    @EJB
    private ClientService clientService;

    /**
     * Affiche le formulaire de création d'un client
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/create.jsp").forward(request, response);
    }

    /**
     * Reçoit le formulaire d'un client et crée un client dans la base de données
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNom(request.getParameter("nomClient"));
        clientDTO.setAdresse(request.getParameter("adresseClient"));

        clientService.create(clientDTO);
        response.sendRedirect(request.getContextPath() + "/clients");

    }
}
