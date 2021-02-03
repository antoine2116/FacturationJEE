package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Article;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.transaction.*;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    EntityManager em;
    UserTransaction utx;

    public ArticleDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    /**
     * Récupère la liste des articles
     * @return
     */
    public List<Article> getAll() {
        return em.createQuery("select a from Article a", Article.class).getResultList();
    }

    /**
     * Créer un article dans la base de données
     * @param article
     */
    public void create(Article article) {
        try {
            utx.begin();
            em.persist(article);
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
