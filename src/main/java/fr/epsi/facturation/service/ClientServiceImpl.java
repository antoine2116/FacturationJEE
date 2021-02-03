package fr.epsi.facturation.service;

import fr.epsi.facturation.dao.ClientDao;
import fr.epsi.facturation.dao.ClientDaoImpl;
import fr.epsi.facturation.dto.ClientDTO;
import fr.epsi.facturation.entite.Client;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientServiceImpl implements  ClientService {

    @PersistenceContext(name = "facturation")
    EntityManager em;

    @Resource
    UserTransaction utx;

    /**
     * Récupère la liste des client
     * @return
     */
    public List<Client> getAll() {
        ClientDao clientDao = new ClientDaoImpl(em, utx);
        return clientDao.getAll();
    }


    /**
     * Convertit le DTO en Entité puis crée le client dans la base de données
     * @param clientDTO
     */
    public void create(ClientDTO clientDTO) {
        Client client = new Client();
        client.setNom(clientDTO.getNom());
        client.setAdresse(clientDTO.getAdresse());

        ClientDao clientDao = new ClientDaoImpl(em, utx);
        clientDao.create(client);
    }
}
