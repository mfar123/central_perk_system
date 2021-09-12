/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produtos;

/**
 *
 * @author PC TESTE
 */
public class ProdutoDA0 { //manipular dados do banco 

    public void create(Produtos p){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("INSERT INTO produto (descricao,qtd,preco) VALUES (?,?,?)");
            stmt.setString(1, p.getDescricao() );
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreço());
            
            stmt.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
    }

    
    public void update(Produtos p){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("UPDATE produto SET descricao=?,qtd=?,preco=? WHERE id = ?") ;
            stmt.setString(1, p.getDescricao() );
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreço());
            stmt.setInt(4,p.getId());
            
            stmt.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
    }
    public void updateProduto(Produtos p){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = cn.prepareStatement("UPDATE produto SET qtd=? where id=?") ;
            
            stmt.setInt(1, p.getQtd());
            stmt.setInt(2, p.getId());
            
            
            
            stmt.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
    }
    public void delete(Produtos p){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("DELETE FROM produto WHERE id = ?") ;
            stmt.setInt(1,p.getId());
            
            stmt.executeUpdate();
   
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
    }
    
    // metodo para ler os dados e colocar na Jtable
    public List<Produtos> read(){
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        List<Produtos> produtos = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement("SELECT * FROM produto");
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                
                Produtos produto = new Produtos();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreço(rs.getDouble("preco"));
                produtos.add(produto);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"N Funciona");
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        
        
        return produtos;
        
       
        
        
        
        
    }
    
    public List<Produtos> search(String desc){
        
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produtos> p = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            
                while(rs.next()){
                    
                    Produtos produto = new Produtos();
                    produto.setId(rs.getInt("id"));
                    produto.setQtd(rs.getInt("qtd"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreço(rs.getDouble("preco"));
                    p.add(produto);
                   
                }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDA0.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return p;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getName(int id){  //pega o id e retorna o nome do produto
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        String name=null; 
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM produto WHERE id = ?");
            stmt.setInt(1, id);
            
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
                
                name=rs.getString("descricao");    }
            
            
        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
         
        
        return name;
       
    }
    
    
     public Produtos getProduto(String nome){
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM produto WHERE descricao = ?");
            stmt.setString(1, nome);
            Produtos p=new Produtos();
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
               
               p.setId(rs.getInt("id"));
               p.setPreço(rs.getDouble("preco"));
               p.setQtd(rs.getInt("qtd"));
               
            }
           return p; 
            
        } catch (SQLException ex) {
           return null; 
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
         
        
  
        
    }
}
