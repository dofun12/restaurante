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
public class GrupoUsuarioPK implements Serializable {
    @Column(name = "id_grupo")
    private Integer codigoGrupo;
    
    @Column(name = "login")
    private String login;

    public GrupoUsuarioPK() {
    }
    
    public GrupoUsuarioPK(Integer codigoGrupo, String login) {
        this.codigoGrupo = codigoGrupo;
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoGrupo);
        hash = 97 * hash + Objects.hashCode(this.login);
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
        final GrupoUsuarioPK other = (GrupoUsuarioPK) obj;
        if (!Objects.equals(this.codigoGrupo, other.codigoGrupo)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "GrupoUsuarioPK{" + "codigoGrupo=" + codigoGrupo + ", login="+login+ '}';
    }

    
    
    public Integer getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(Integer codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    
    
    
}