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
public class Cliente {
    
    private int Codigo;
    private String Nome;
    private int compras;
    private double totalvalor;
    private double somaTotal;

    public double getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(double somaTotal) {
        this.somaTotal = somaTotal;
    }
    
    

    public double getTotalvalor() {
        return totalvalor;
    }

    public void setTotalvalor(double totalvalor) {
        this.totalvalor = totalvalor;
    }

    
    
    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return Nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
