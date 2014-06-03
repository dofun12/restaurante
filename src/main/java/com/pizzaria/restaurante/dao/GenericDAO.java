/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author kevim
 * @param <T>
 */
public class GenericDAO<T, ID extends Serializable> {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    private Class<T> oClass;

    public Class<T> getObjectClass() {
        return this.oClass;
    }

    public GenericDAO() {
        this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("restaurante-pu");
    }

    public EntityManager getEm() {
        if (em != null&& em.isOpen()) {
            return em;
        } else {
            setUp();
            em = entityManagerFactory.createEntityManager();
            return em;
        }
    }

    public void persist(Object obj){
        getEm().getTransaction().begin();
        getEm().persist(obj);
        getEm().getTransaction().commit();
        getEm().flush();
    }
    
    public void close(){
        //getEm().close();
    }
    
    public Session getSession(){
        return getEm().unwrap(org.hibernate.Session.class);
    }
    
    public List<T> getAll(T classe) {
        return getEm().createQuery("from " + classe.getClass().getSimpleName() + " a").getResultList();
    }

    public T salvar(T object) {
        getEm().clear();
        getEm().persist(object);
        return object;
    }

    public T pesquisarPorId(ID id) {
        return (T) getEm().find(oClass, id);
    }

    public T atualizar(T object) {
        getEm().merge(object);
        return object;
    }

    public void excluir(T object) {
        object = getEm().merge(object);
        getEm().remove(object);
    }

    @SuppressWarnings("unchecked")
    public List<T> todos() {
        String queryS = "SELECT obj FROM " + oClass.getSimpleName() + " obj";
        Query query = getEm().createQuery(queryS);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> listPesqParam(String queryS, Map<String, Object> params) {
        Query query = getEm().createQuery(queryS);
        for (String chave : params.keySet()) {
            query.setParameter(chave, params.get(chave));
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> listPesqParam(String queryS, Map<String, Object> params,
            int maximo, int atual) {
        Query query = getEm().createQuery(queryS).setMaxResults(maximo).setFirstResult(atual);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> listPesq(String queryS) {
        Query query = getEm().createQuery(queryS);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public T pesqParam(String queryS, Map<String, Object> params) {
        Query query = getEm().createQuery(queryS);
        for (String chave : params.keySet()) {
            query.setParameter(chave, params.get(chave));
        }
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
