package com.example.demo.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Cette classe est une entité de la BDD
@Entity
// Elle correspond à la table `product`
@Table(name = "artcle")
@EntityListeners(AuditingEntityListener.class)
public class article {

    // Cette propriété est la clé primaire de l'entité
    @Id
    // Cette propriété s'auto-incrémente
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Cette propriété correspond à la colonne `id` en BDD
    // Elle est unique et ne peut pas être nulle
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    // Getter (permet d'accéder à cette propriété)
    public long getId() {
        return this.id;
    }

    // Setter (permet de modifier cette propriété)
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    private String title;

    public String getName() {
        return this.title;
    }

    public void setName(String title) {
        this.title = title;
    }

    @Column(name = "date", nullable = false)
    private String date;

    public String date() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "author", nullable = false)
    private String author;

    public String getauthor() {
        return this.author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    @Column(name = "content", nullable = false)
    private float price;
    private string content;

    public string getcontent() {
        return this.content;
    }

    public void setcontent(string content) {
        this.content = content;
    }

    @Column(name = "clap", nullable = false)
    private int stock;
    private int clap;

    public int getclap() {
        return this.clap;
    }

    public void setclap(int clap {
    	this.clap = clap;
    }

    @Column(name = "user_id", nullable = false)
    private int user_id;

    public int getuser_id() {
        return this.user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("users")
    private Article article;

    public Article getArticle() {
        return this.article
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    
    
