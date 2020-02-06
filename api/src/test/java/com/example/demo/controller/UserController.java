package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


// Ce contrôleur fonctionne sur le modèle d'une API REST
@RestController
// Ce contrôleur répond à toutes les requêtes sur les endpoints /api/products
@RequestMapping("/api/articles")
// Ce contrôleur accepte les requêtes venant d'un serveur différent
@CrossOrigin
public class ArticleController {

    // Injection de dépendance
    // Une instance de ProductRepository est automatiquement créée
    // et rangée dans cette propriété à la construction du contrôleur
    @Autowired
    private ArticleRepository articleRepository;
    
    // Renvoie tous les produits de la base de données
    @GetMapping("")
    public List<Product> getAllarticles() {
        return articleRepository.findAll();
    }

    // Crée un nouveau produit
    @PostMapping("")
    // En cas de succès, renvoie un code HTTP 201 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.CREATED)
    public article createProduct(@Valid @RequestBody Product product) {
        // Sauvegarde le produit en BDD et renvoie une copie 
        return articleRepository.save(article);
    }

    // Met à jour les propriétés d'un produit déjà existant
    @PutMapping("/{id}")
    public article updatearticle(@PathVariable(value = "id") Long articleId, @Valid @RequestBody article newarticle) {
        // Récupère le produit tel qu'il existe actuellement dans la BDD
        Article article = this.fetchArticle(articleId);
        // Remplace toutes ses propriétés par celles de l'objet entrant
        article.setName(newarticle.getName());
        article.setSerialNumber(newarticle.getSerialNumber());
        article.setDescription(newarticle.getDescription());
        article.setPrice(newarticle.getPrice());
        article.setStock(newarticle.getStock());
        article.setWeight(newarticle.getWeight());
        article.setPicture(newarticle.getPicture());
        article.setBrand(newarticle.getBrand());
        // Sauvegarde le produit en BDD et renvoie une copie
        return productRepository.save(product);
    }

    // Renvoie un produit particulier de la base de données (en fonction de son id)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId) {
        return this.fetchProduct(productId);
    }

    // Supprimer un produit existant
    @DeleteMapping("/{id}")
    // En cas de succès, renvoie un code HTTP 204 au lieu du code 200 par défaut
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value = "id") Long productId) {
        Product product = this.fetchProduct(productId);
        productRepository.delete(product);
    }

    // Méthode réutilisable permettant d'aller chercher un produit dans la BDD en fonction de son id
    // Renvoie automatiquement une erreur 404 si le produit n'existe pas
    public Product fetchProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
        );
        return product;