package fr.epsi.facturation.service;

import fr.epsi.facturation.entite.Facture;

import java.util.List;

public interface FactureService {
    /**
     * Récupère la liste des factures
     * @return
     */
    List<Facture> getAll();

    /**
     * Récupère une facture selon son id
     * @param id
     * @return
     */
    Facture getById(int id);
}
