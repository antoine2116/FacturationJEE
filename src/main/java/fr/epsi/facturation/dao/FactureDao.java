package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Facture;

import java.util.List;

public interface FactureDao {
    List<Facture> getAll();
    Facture getById(int id);
}
