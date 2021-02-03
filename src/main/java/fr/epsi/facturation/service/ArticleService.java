package fr.epsi.facturation.service;

import fr.epsi.facturation.dto.ArticleDTO;
import fr.epsi.facturation.entite.Article;

import java.util.List;

public interface ArticleService {
    /**
     * Récupère la liste des articles
     * @return
     */
    List<Article> getAll();

    /**
     * Convertit le DTO en Entité puis crée l'article dans la base de données
     * @param articleDTO
     */
    void create(ArticleDTO articleDTO);
}
