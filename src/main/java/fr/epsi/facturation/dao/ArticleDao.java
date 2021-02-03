package fr.epsi.facturation.dao;

import fr.epsi.facturation.entite.Article;
import java.util.List;

public interface ArticleDao {

    /**
     * Récupère la liste des articles
     * @return
     */
    List<Article> getAll();

    /**
     * Créer un article dans la base de données
     * @param article
     */
    void create(Article article);
}
