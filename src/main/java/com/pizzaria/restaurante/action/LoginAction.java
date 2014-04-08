/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.action;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author kevim
 */
@ManagedBean(name = "login")
public class LoginAction implements Serializable{
    private String testeBean;
    private String valorBanco;
    
    @PostConstruct
    public void init(){
        setTesteBean("helll yeah bitches");
    
    }

    public String getTesteBean() {
        return testeBean;
    }

    public void setTesteBean(String testeBean) {
        this.testeBean = testeBean;
    }

    public String getValorBanco() {
        return valorBanco;
    }

    public void setValorBanco(String valorBanco) {
        this.valorBanco = valorBanco;
    }
    
    
}
