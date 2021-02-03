package fr.epsi.facturation.service;

import fr.epsi.facturation.dao.ArticleDao;
import fr.epsi.facturation.dao.ArticleDaoImpl;
import fr.epsi.facturation.dto.ArticleDTO;
import fr.epsi.facturation.entite.Article;

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
public class ArticleServiceImpl implements  ArticleService {

    @PersistenceContext(name = "facturation")
    EntityManager em;

    @Resource
    UserTransaction utx;

    /**
     * Récupère la liste des articles
     * @return
     */
    public List<Article> getAll() {
        ArticleDao articleDao = new ArticleDaoImpl(em, utx);
        return articleDao.getAll();
    }


    /**
     * Convertit le DTO en Entité puis crée l'article dans la base de données
     * @param articleDTO
     */
    public void create(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setNom(articleDTO.getNom());
        article.setPrix(articleDTO.getPrix());

        ArticleDao articleDao = new ArticleDaoImpl(em, utx);
        articleDao.create(article);
    }
}
