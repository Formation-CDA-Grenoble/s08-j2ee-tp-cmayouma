package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/Articles")
@CrossOrigin
public class ArticleController<Article> {

    private static final Article Article = null;
    private static final Article Article = null;
    // Injection de dépendance
    @Autowired
    private ArticleRepository ArticleRepository;
    private Article Article;

    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<Article> getAllArticles() {
        return ArticleRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Article createArticle(@Valid @RequestBody Article Article) {
        return ArticleRepository.save(Article);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable(value = "id") Long ArticleId, @Valid @RequestBody Article newArticle) {
        Article Article = this.fetchArticle(ArticleId);
        Article.setName(newArticle.getName());
        Article.setCountry(newArticle.getCountry());
        return ArticleRepository.save(Article);
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable(value = "id") Long ArticleId) {
        return this.fetchArticle(ArticleId);
    }

    // Supprimer un produit existant
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable(value = "id") Long ArticleId) {
        Article Article = this.fetchArticle(ArticleId);
        ArticleRepository.delete(Article);
    }

    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en
    // fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Article fetchArticle(Long ArticleId) {
        Article article = ((Object) ArticleRepository.findById(ArticleId))
                .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found")
        );
        return Article;
    }
}