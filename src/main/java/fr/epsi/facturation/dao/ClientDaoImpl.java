package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Client;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.transaction.*;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    EntityManager em;
    UserTransaction utx;

    public ClientDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    /**
     * Récupère la liste des clients
     * @return
     */
    public List<Client> getAll() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }

    /**
     * Créer un client dans la base de données
     * @param client
     */
    public void create(Client client) {
        try {
            utx.begin();
            em.persist(client);
            utx.commit();
        } catch (NotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (javax.transaction.RollbackException e) {
            e.printStackTrace();
        }
    }
}
