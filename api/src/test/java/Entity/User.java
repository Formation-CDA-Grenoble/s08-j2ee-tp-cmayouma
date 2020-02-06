package com.example.demo.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String country;

    @OneToMany(mappedBy = "Article")
    @JsonIgnoreProperties("article")
    private Set<user> users;


    public Set<name> getnames() {
    	return this.names;
    }
    public void setnames(Set<name> names) {
    	this.names = names;
    }


    public String getemail {
    	return this.email;
    }
    public void setemailString email) {
    	this.email = email;
    }


    public long getId() {
    	return this.id;
    }
    public void setId(long id) {
    	this.id = id;
    }

}