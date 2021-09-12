/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author PC TESTE
 */
public class Vender {
    
    private int id;
    private int produto;
    private int cliente;
    private String data;
    private String hora;
    private int funcionario;
    private double valor;
    private int qtd;
    private double total;
    private String us;
    private String pro;
    private String cli;
    private double somavendas;

    public double getSomavendas() {
        return somavendas;
    }

    public void setSomavendas(double somavendas) {
        this.somavendas = somavendas;
    }
    
    

        
    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }
    
    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }
    
    

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }
    
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        //int nova;
        
        //nova = (int) ((this.produtoo.getPreço())*(qtd));
        this.total=total;
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
}
