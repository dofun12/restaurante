/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.action;

import com.pizzaria.restaurante.dao.LoginDao;
import com.pizzaria.restaurante.model.Cliente;
import com.pizzaria.restaurante.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author kevim
 */
@ConversationScoped
@Named(value = "cadastro")
public class CadastroAction implements Serializable {
    private String nome;
    private String login;
    private String endereco;
    private String telefone;
    private String senha;
    @EJB
    private LoginDao loginDAO;
    
    @PostConstruct
    public void init() {
    }

    public void cadastrar(){
        try{
            if(login!=null){
                Cliente c = new Cliente();
                c.setTelefone(telefone);
                c.setEndereco(endereco);
                c.setNome(nome);
                Usuario u = new Usuario();
                u.setLogin(login);
                u.setSenha(senha);
                u.setAtivo(true);
                loginDAO.salvar(u, c);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso","Cadastro efetuado sem problemas"));
            }    
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","Erro ao cadastrar"));
            e.printStackTrace();
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
