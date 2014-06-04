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
import com.pizzaria.restaurante.model.UsuarioCliente;
import com.pizzaria.restaurante.model.UsuarioClientePK;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.hibernate.Query;


/**
 *
 * @author kevim
 */
@Stateless
public class LoginDaoImpl extends GenericDao<Usuario> implements LoginDao{
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
        UsuarioCliente uc = new UsuarioCliente();
        persist(c);
        
        persist(u);
        
        Integer codigo = c.getId();
        String login = u.getLogin();
        
        UsuarioClientePK pk = new UsuarioClientePK(codigo, login);
        uc.setId(pk);
        persist(uc);
    }
}
