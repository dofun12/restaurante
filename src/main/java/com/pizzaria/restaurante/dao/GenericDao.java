/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author kevim
 */
public interface GenericDao {

    /**
     * @return the em
     */
    EntityManager getEm();

    Session getSession();

    List<?> listObject(Class classe);

    List<?> listObject(Class classe, int maxResults);

    /**
     * @param em the em to set
     */
    void setEm(EntityManager em);
    
}
