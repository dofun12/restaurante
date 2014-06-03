/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

/**
 *
 * @author kevim
 * @param <T>
 */
public class GenericDao<T> implements Serializable{

    @PersistenceContext(unitName = "restaurante-pu")
    private EntityManager em;
    private Session session;

    public Session getSession() {
        if (getEm() != null) {
            session = getEm().unwrap(Session.class);
        }
        return session;
    }

    public List<?> listObject(Class classe){
        return getSession().createQuery("from "+classe.getSimpleName()+" x").list();
    }
    public List<?> listObject(Class classe,int maxResults){
        return getSession().createQuery("from "+classe.getSimpleName()+" x").setMaxResults(maxResults).list();
    }
    
    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
