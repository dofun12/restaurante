package com.pizzaria.restaurante.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kevim
 */
@Embeddable
public class UsuarioClientePK implements Serializable {
    @Column(name = "id_cliente")
    private Integer codigoCliente;
    
    @Column(name = "login")
    private String login;

    public UsuarioClientePK() {
    }
    
    public UsuarioClientePK(Integer codigoCliente, String login) {
        this.codigoCliente = codigoCliente;
        this.login = login;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codigoCliente);
        hash = 71 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioClientePK other = (UsuarioClientePK) obj;
        if (!Objects.equals(this.codigoCliente, other.codigoCliente)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    
}