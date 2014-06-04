/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.dao.impl;

import com.pizzaria.restaurante.dao.LoginDao;
import com.pizzaria.restaurante.model.Cliente;
import com.pizzaria.restaurante.model.Direito;
import com.pizzaria.restaurante.model.Grupo;
import com.pizzaria.restaurante.model.GrupoUsuario;
import com.pizzaria.restaurante.model.GrupoUsuarioPK;
import com.pizzaria.restaurante.model.Usuario;
import com.pizzaria.restaurante.model.UsuarioCliente;
import com.pizzaria.restaurante.model.UsuarioClientePK;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author kevim
 */
@Stateless
public class LoginDaoImpl extends GenericDao<Usuario> implements LoginDao {

    @Override
    public Usuario getUsuario(String login, String senha) {
        Query q = getSession().createQuery("from Usuario a where a.login=:login and a.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        q.setMaxResults(1);
        Usuario u = (Usuario) q.uniqueResult();
        return u;
    }

    @Override
    public void salvar(Usuario u, Cliente c) {
        UsuarioCliente uc = new UsuarioCliente();
        persist(c);

        persist(u);

        Integer codigo = c.getId();
        String login = u.getLogin();

        UsuarioClientePK pk = new UsuarioClientePK(codigo, login);
        uc.setId(pk);
        persist(uc);
    }

    public void salvarDireitoBasico(Usuario u, Cliente c) {
        UsuarioCliente uc = new UsuarioCliente();
        persist(c);
        persist(u);

        Integer codigo = c.getId();
        String login = u.getLogin();

        Grupo g = getEm().find(Grupo.class, 2);
        GrupoUsuario gu = new GrupoUsuario();
        GrupoUsuarioPK guPk = new GrupoUsuarioPK(g.getId(), login);
        gu.setId(guPk);
        persist(gu);

        UsuarioClientePK pk = new UsuarioClientePK(codigo, login);
        uc.setId(pk);
        persist(uc);
    }

    @Override
    public Usuario getUsuario(String login) {
        Usuario u = getEm().find(Usuario.class, login);
        return u;
    }

    public List<Direito> listarDireitos() {
        return getSession().createQuery("from Direito x").list();
    }

    public List<Map<String, Object>> listarDireitos(String login) {
        Query q = getSession().createSQLQuery(
                "select "
                + "	d.id as codigo, "
                + "	d.descricao as descricao "
                + "from "
                + "	Grupo_Usuario gu "
                + "inner join Grupo g "
                + "	on gu.id_grupo = g.id "
                + "left join Grupo_Direito gd "
                + "	on gd.id_grupo = gu.id_grupo "
                + "left join Direito d "
                + "	on gd.id_direito = d.id "
                + "where "
                + "	gu.login = :login ");
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        q.setString("login", login);
        return q.list();
    }
}
