/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevim
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "ativo")
    private Boolean ativo;
    @JoinTable(name = "Grupo_Usuario", joinColumns = {
        @JoinColumn(name = "login", referencedColumnName = "login")}, inverseJoinColumns = {
        @JoinColumn(name = "id_grupo", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Grupo> grupoCollection;
    @JoinTable(name = "Usuario_Cliente", joinColumns = {
        @JoinColumn(name = "login", referencedColumnName = "login")}, inverseJoinColumns = {
        @JoinColumn(name = "id_cliente", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Cliente> clienteCollection;

    public Usuario() {
    }

    public Usuario(String login) {
        this.login = login;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pizzaria.restaurante.model.Usuario[ login=" + login + " ]";
    }
    
}
