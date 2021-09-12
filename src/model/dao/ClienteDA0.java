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
import model.bean.Cliente;
import model.bean.Produtos;


public class ClienteDA0 {
    
    public void create(Cliente c){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("INSERT INTO cliente(nome) VALUES (?) ");
            stmt.setString(1, c.getNome() );
            
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Queima!");            
        }  finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
        
    }
    public void atualizarCliente(Cliente c){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("UPDATE cliente SET nome = ? WHERE codigo = ?") ;
            stmt.setString(1,  c.getNome() );
            stmt.setInt (2, c.getCodigo());
            
            
            stmt.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
    }
        public void excluir(Cliente c){
            
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            
            
        try {
            stmt = cn.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
            stmt.setInt(1,c.getCodigo());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDA0.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
            
            
            
        }
        public List<Cliente> buscar(String nom){
            VenderDA0 vd = new VenderDA0();
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Cliente> cliente = new ArrayList<>();
            
            try{
                stmt =cn.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ");
                stmt.setString(1,"%"+ nom +"%");
                rs= stmt.executeQuery();
                
                while (rs.next()){
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt("codigo"));
                    c.setCompras(vd.totalVendas(c.getCodigo()));
                    c.setNome(rs.getString("nome"));
                    c.setTotalvalor(vd.totalCompras(c.getCodigo()));
                    cliente.add(c);
                    
                    
                    
                }
                
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDA0.class.getName()).log(Level.SEVERE, null, ex);
                
            } finally{
                
                ConnectionFactory.closeConnection(cn, stmt, rs);
            }
            
            return cliente;
        }
    
    
    
    
    
    
    
        public List<Cliente> read(){
        VenderDA0 dao = new VenderDA0();
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement("SELECT * FROM cliente");
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                
                
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCompras(dao.totalVendas(cliente.getCodigo()));
                cliente.setTotalvalor(dao.totalCompras(cliente.getCodigo()));
               
                clientes.add(cliente);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"err0 ~e aqui");
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        
        
        return clientes;
        
       
        
        
        
        
    }
        
        
        
        
        
        
        
        
        
    public String getNombre(int id){ //pegar o nome
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        String name=null; 
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");
            stmt.setInt(1, id);
            
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
                
                name=rs.getString("nome");    }
            
            
        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
         
        
        return name;
       
    }
    
    
     public Cliente getClientes(String nome){
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM cliente WHERE nome = ?");
            stmt.setString(1, nome);
            Cliente c=new Cliente();
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
               
               c.setCodigo(rs.getInt("codigo"));
               
               
            }
           return c; 
            
        } catch (SQLException ex) {
           return null; 
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
         
        
  
        
    }
    
}

