/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevim
 */
@Embeddable
public class PedidoPizzasPK implements Serializable {
    @Column(name = "id_pedido")
    private int idPedido;
    @Column(name = "id_pizza")
    private int idPizza;

    public PedidoPizzasPK() {
    }

    public PedidoPizzasPK(int idPedido, int idPizza) {
        this.idPedido = idPedido;
        this.idPizza = idPizza;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idPizza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoPizzasPK)) {
            return false;
        }
        PedidoPizzasPK other = (PedidoPizzasPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idPizza != other.idPizza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pizzaria.restaurante.model.PedidoPizzasPK[ idPedido=" + idPedido + ", idPizza=" + idPizza + " ]";
    }
    
}
