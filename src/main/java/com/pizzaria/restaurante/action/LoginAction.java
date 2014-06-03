/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.action;

import com.pizzaria.restaurante.dao.impl.LoginDaoImpl;
import com.pizzaria.restaurante.model.Cliente;
import com.pizzaria.restaurante.model.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.dsig.Transform;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author kevim
 */
@SessionScoped
@ManagedBean(name = "login")
public class LoginAction implements Serializable {
    private Usuario usuario;
    private LoginDaoImpl loginDAO;
    private String login;
    private String senha;
    
    
    @PostConstruct
    public void init() {
        loginDAO = new LoginDaoImpl();
        
    }

    public String getNomeUsuario(){
//        Cliente cliente;
//        if(usuario!=null&&usuario.getClienteCollection()!=null){
//            if(usuario.getClienteCollection().iterator().hasNext()){
//                cliente = usuario.getClienteCollection().iterator().next();
//                if(cliente!=null){
//                    return cliente.getNome();
//                }
//            }
//        }
        return "";
    }
    
    public String logar(){
        Usuario u = loginDAO.getUsuario(login, senha);
        if(u!=null){
            return "home.jsf";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Usuario ou senha incorretos"));
        }
        return "";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginDaoImpl getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDaoImpl loginDAO) {
        this.loginDAO = loginDAO;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
