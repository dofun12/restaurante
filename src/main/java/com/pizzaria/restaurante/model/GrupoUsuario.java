/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.model;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kevim
 */
@Entity
@Table(name = "Grupo_Usuario")
public class GrupoUsuario implements Serializable{
    @Id
    @Embedded
    private GrupoUsuarioPK id;

    public GrupoUsuarioPK getId() {
        return id;
    }

    public void setId(GrupoUsuarioPK id) {
        this.id = id;
    }
}
