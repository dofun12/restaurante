/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.dao;

import com.pizzaria.restaurante.model.Usuario;
import org.hibernate.Query;


/**
 *
 * @author kevim
 */
public class LoginDAO extends GenericDAO<Usuario,Integer>{
    public Usuario getUsuario(String login,String senha){
        Query q = getSession().createQuery("from Usuario a where a.login=:login and a.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        q.setMaxResults(1);
        Usuario u = (Usuario)q.uniqueResult();
        return u;
    }
}
