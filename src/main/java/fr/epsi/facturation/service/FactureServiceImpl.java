package fr.epsi.facturation.service;

import fr.epsi.facturation.dao.ClientDao;
import fr.epsi.facturation.dao.ClientDaoImpl;
import fr.epsi.facturation.dao.FactureDao;
import fr.epsi.facturation.dao.FactureDaoImpl;
import fr.epsi.facturation.entite.Facture;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureServiceImpl implements FactureService {

    @PersistenceContext(name = "facturation")
    EntityManager em;

    @Resource
    UserTransaction utx;

    /**
     * Récupère la liste des factures
     * @return
     */
    public List<Facture> getAll() {
        FactureDao factureDao = new FactureDaoImpl(em, utx);
        return factureDao.getAll();
    }

    /**
     * Récupère une facture selon son id
     * @param id
     * @return
     */
    public Facture getById(int id) {
        FactureDao factureDao = new FactureDaoImpl(em, utx);
        return factureDao.getById(id);
    }
}
