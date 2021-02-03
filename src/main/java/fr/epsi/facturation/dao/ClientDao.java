package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Client;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import java.util.List;

public interface ClientDao {
    /**
     * Récupère la liste des clients
     * @return
     */
    List<Client> getAll();

    /**
     * Créer un client dans la base de données
     * @param client
     */
    void create(Client client);
}
