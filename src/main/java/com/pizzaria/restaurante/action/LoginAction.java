/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pizzaria.restaurante.action;

import com.pizzaria.restaurante.dao.LoginDao;
import com.pizzaria.restaurante.model.Direito;
import com.pizzaria.restaurante.model.Pedido;
import com.pizzaria.restaurante.model.Pizza;
import com.pizzaria.restaurante.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

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
    private List<Pizza> listarPizza = new ArrayList<Pizza>();
    private boolean logado = false;
    private List<Pizza> pizzasSelecionadas =  new ArrayList<Pizza>();
    private List<Map<String,Object>> listPedidos;
    
    @PostConstruct
    public void init() {
        listarPizza = loginDAO.listarPizzas();
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
    
    public void adicionarPizza(ActionEvent actionEvent){
        Pizza p = (Pizza)actionEvent.getComponent().getAttributes().get("pizza");
        pizzasSelecionadas.add(p);
    }
    
    public String pedir(){
        loginDAO.gerarPedido(login, getTotalPizza(), pizzasSelecionadas);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Pronto","Só esperar"));
        return "pedidos.jsf";
    }
    
    public String logout(){
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
        session.invalidate();
        return "index.jsf";
    }
    
    public void marcarComoEntregue(ActionEvent actionEvent){
        Integer codPedido = (Integer)actionEvent.getComponent().getAttributes().get("codigo");
        loginDAO.mudarSituacao(codPedido);
    }
    
    public String logar(){
        
        logado = false;
        Usuario u = loginDAO.getUsuario(login, senha);
        if(u!=null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Olá",u.getLogin()));
            listarDireitos();
            logado = true;
            return "home.jsf";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Usuario ou senha incorretos"));
        }
        return "";
    }
    
    public List<Pedido> getPedidos(){
        //Alterar situacao
        if(getDireito(5)){
            return loginDAO.getTodosPedidos();
        }else{
            return loginDAO.getTodosPedidosUsuario(login);
        }
    }

    public List<Map<String,Object>> getDetalhesPedido(Pedido pedido){
        return loginDAO.getListPedidos(login, pedido.getId());
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

    public List<Pizza> getListarPizza() {
        return listarPizza;
    }

    public void setListarPizza(List<Pizza> listarPizza) {
        this.listarPizza = listarPizza;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    public List<Map<String,String>> getBanners(){
        List<Map<String,String>> listBanners = new ArrayList<Map<String,String>>();
        listBanners.add(createImagem("images/pizzabanner.jpg", "Especias ao sabados"));
        listBanners.add(createImagem("images/pizza_2.jpg", "Feito com amor e muita massa"));
        listBanners.add(createImagem("images/pizza_1.jpg", "Massa crocante e saborosa"));
        return listBanners;
    }
    public Float getTotalPizza(){
        Float preco = 0f;
        for(Pizza p:pizzasSelecionadas){
            preco = preco+p.getPrix();
        }
        return preco;
    }
    private Map<String,String> createImagem(String link,String descricao){
        Map<String,String> map = new HashMap<String,String>();
        map.put("link",link);
        map.put("descricao",descricao);
        return map;
    }

    public List<Pizza> getPizzasSelecionadas() {
        return pizzasSelecionadas;
    }

    public void setPizzasSelecionadas(List<Pizza> pizzasSelecionadas) {
        this.pizzasSelecionadas = pizzasSelecionadas;
    }

    public List<Map<String, Object>> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Map<String, Object>> listPedidos) {
        this.listPedidos = listPedidos;
    }
    
}
