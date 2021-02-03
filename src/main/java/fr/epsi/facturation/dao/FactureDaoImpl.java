package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Client;
import fr.epsi.facturation.entite.Facture;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.transaction.*;
import java.util.List;

public class FactureDaoImpl implements FactureDao {

    EntityManager em;
    UserTransaction utx;

    public FactureDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    /**
     * Récupère la liste des factures
     * @return
     */
    public List<Facture> getAll() {
        return em.createQuery("select f from Facture f", Facture.class).getResultList();
    }

    /**
     * Récupère une facture selon son id
     * @param id
     * @return
     */
    public Facture getById(int id) {
        return em.find(Facture.class, id);
    }
}
