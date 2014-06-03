/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.dao.impl;

import com.pizzaria.restaurante.dao.LoginDao;
import com.pizzaria.restaurante.model.Cliente;
import com.pizzaria.restaurante.model.GrupoUsuario;
import com.pizzaria.restaurante.model.GrupoUsuarioPK;
import com.pizzaria.restaurante.model.Usuario;
import org.hibernate.Query;


/**
 *
 * @author kevim
 */
public class LoginDaoImpl extends GenericDaoImpl<Usuario> implements LoginDao{
    @Override
    public Usuario getUsuario(String login,String senha){
        Query q = getSession().createQuery("from Usuario a where a.login=:login and a.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        q.setMaxResults(1);
        Usuario u = (Usuario)q.uniqueResult();
        return u;
    }
    @Override
    public void salvar(Usuario u,Cliente c){
        GrupoUsuario gu = new GrupoUsuario();
        getEm().persist(c);
        getEm().persist(u);
        
        Integer codigo = c.getId();
        String login = u.getLogin();
        
        GrupoUsuarioPK pk = new GrupoUsuarioPK(codigo, login);
        gu.setId(pk);
        getEm().persist(gu);
        getEm().flush();
    }
}