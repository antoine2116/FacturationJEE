package fr.epsi.facturation.service;

import fr.epsi.facturation.dto.ClientDTO;
import fr.epsi.facturation.entite.Client;

import java.util.List;

public interface ClientService {
    /**
     * Récupère la liste des client
     * @return
     */
    List<Client> getAll();

    /**
     * Convertit le DTO en Entité puis crée le client dans la base de données
     * @param clientDTO
     */
    void create(ClientDTO clientDTO);
}
