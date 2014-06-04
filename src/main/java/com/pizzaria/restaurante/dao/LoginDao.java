/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pizzaria.restaurante.dao;

import com.pizzaria.restaurante.model.Cliente;
import com.pizzaria.restaurante.model.Direito;
import com.pizzaria.restaurante.model.Usuario;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author kevim
 */
@Local
public interface LoginDao {

    public Usuario getUsuario(String login, String senha);
    
    public Usuario getUsuario(String login);

    public void salvar(Usuario u, Cliente c);

    public void salvarDireitoBasico(Usuario u, Cliente c);

    public List<Map<String, Object>> listarDireitos(String login);

    public List<Direito> listarDireitos();
    
}
