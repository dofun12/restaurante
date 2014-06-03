/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.dao.impl;

import com.pizzaria.restaurante.dao.GenericDao;
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
public class GenericDaoImpl<T> implements Serializable, GenericDao{

    @PersistenceContext(unitName = "restaurante-pu")
    private EntityManager em;
    private Session session;

    @Override
    public Session getSession() {
        if (getEm() != null) {
            session = getEm().unwrap(Session.class);
        }
        return session;
    }

    @Override
    public List<?> listObject(Class classe){
        return getSession().createQuery("from "+classe.getSimpleName()+" x").list();
    }
    @Override
    public List<?> listObject(Class classe,int maxResults){
        return getSession().createQuery("from "+classe.getSimpleName()+" x").setMaxResults(maxResults).list();
    }
    
    /**
     * @return the em
     */
    @Override
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
