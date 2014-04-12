/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.action;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author kevim
 */
@ManagedBean(name = "login")
public class LoginAction implements Serializable {

    private String testeBean;
    private String valorBanco;
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        setTesteBean("helll yeah bitches");
        setUp();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        session.createSQLQuery("select * from users");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    protected void setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("restaurante-pu");
    }

    public String getTesteBean() {
        return testeBean;
    }

    public void setTesteBean(String testeBean) {
        this.testeBean = testeBean;
    }

    public String getValorBanco() {
        return valorBanco;
    }

    public void setValorBanco(String valorBanco) {
        this.valorBanco = valorBanco;
    }

}
