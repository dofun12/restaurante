/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.action;

import com.pizzaria.restaurante.dao.LoginDao;
import com.pizzaria.restaurante.dao.impl.LoginDaoImpl;
import com.pizzaria.restaurante.model.Direito;
import com.pizzaria.restaurante.model.Usuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kevim
 */
@SessionScoped
@ManagedBean(name = "login")
public class LoginAction implements Serializable {
    private Usuario usuario;
    @EJB
    private LoginDao loginDAO;
    private String login;
    private String senha;
    private Map<Integer,Boolean> direitos = new HashMap<Integer,Boolean>();
    
    
    
    @PostConstruct
    public void init() {
        
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
    
    
    public void listarDireitos(){
        for(Direito d:loginDAO.listarDireitos()){
            direitos.put(d.getId(),false);
        }
        for(Map<String,Object> map:loginDAO.listarDireitos(login)){
            if(map.get("codigo")!=null){
                Integer codigo = (Integer)map.get("codigo");
                direitos.put(codigo,true);
            }
        }
    }
    
    
    public String logar(){
        Usuario u = loginDAO.getUsuario(login, senha);
        if(u!=null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Olá",u.getLogin()));
            listarDireitos();
            return "home.jsf";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Usuario ou senha incorretos"));
        }
        return "";
    }

    public boolean getDireito(Integer codigo){
        return direitos.get(codigo);
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginDao getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDao loginDAO) {
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
    

    public Map<Integer, Boolean> getDireitos() {
        return direitos;
    }

    public void setDireitos(Map<Integer, Boolean> direitos) {
        this.direitos = direitos;
    }
    
}
