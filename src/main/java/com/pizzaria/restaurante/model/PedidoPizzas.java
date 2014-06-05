/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevim
 */
@Entity
@Table(name = "pedido_pizzas")
public class PedidoPizzas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoPizzasPK pedidoPizzasPK;

    public PedidoPizzas() {
    }

    public PedidoPizzas(PedidoPizzasPK pedidoPizzasPK) {
        this.pedidoPizzasPK = pedidoPizzasPK;
    }

    public PedidoPizzas(int idPedido, int idPizza) {
        this.pedidoPizzasPK = new PedidoPizzasPK(idPedido, idPizza);
    }

    public PedidoPizzasPK getPedidoPizzasPK() {
        return pedidoPizzasPK;
    }

    public void setPedidoPizzasPK(PedidoPizzasPK pedidoPizzasPK) {
        this.pedidoPizzasPK = pedidoPizzasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoPizzasPK != null ? pedidoPizzasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoPizzas)) {
            return false;
        }
        PedidoPizzas other = (PedidoPizzas) object;
        if ((this.pedidoPizzasPK == null && other.pedidoPizzasPK != null) || (this.pedidoPizzasPK != null && !this.pedidoPizzasPK.equals(other.pedidoPizzasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pizzaria.restaurante.model.PedidoPizzas[ pedidoPizzasPK=" + pedidoPizzasPK + " ]";
    }
    
}
