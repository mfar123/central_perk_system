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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Produtos;
import model.bean.Usuario;
import model.bean.Vender;
import static sun.security.jgss.GSSUtil.login;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 *
 * @author PC TESTE
 */
public class VenderDA0 {
    
    public void vender(Vender v){
        Connection cn = ConnectionFactory.getConnection();
        int f = UsuarioDA0.a;
        PreparedStatement stmt = null;
        try {
            stmt = cn.prepareStatement("INSERT INTO vender(id_cliente,total,idf,idp,qtd,data,hora) VALUES (?,?,?,?,?,?,?)");
            
            stmt.setInt(1 , v.getCliente());
            stmt.setDouble(2, v.getTotal());
            stmt.setInt(3 , f );
            stmt.setInt(4 , v.getProduto());   
            stmt.setInt(5, v.getQtd());
            stmt.setString(6,v.getData());
            stmt.setString(7,v.getHora());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(VenderDA0.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
        
    }
    
    public List<Vender> ler(){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        List<Vender> vendera = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement("SELECT * FROM vender");
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                
                Vender vender = new Vender();
                vender.setId(rs.getInt("id"));
                vender.setFuncionario(rs.getInt("idf"));                
                vender.setCliente(rs.getInt("id_cliente"));
                vender.setProduto(rs.getInt("idp"));
                vender.setTotal(rs.getDouble("total"));
                vender.setQtd(rs.getInt("qtd")); 
                vendera.add(vender);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"N Funciona");
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        
        
        return vendera;
        
       
        
        
        
        
        
        
    }
    
    
 
    
    
    public double totalCompras(int id){
        double totCompras = 0;
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set

        
        try {
            stmt = cn.prepareStatement("SELECT * FROM vender WHERE id_cliente = ?");
            stmt.setInt(1, id);
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                Vender vender = new Vender();
                totCompras = totCompras + (rs.getDouble("total"));
               
                
                
            }
            
            
        } catch (SQLException ex) {
                        Logger.getLogger(VenderDA0.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        

      return totCompras;
    }
    
        public int totalVendas(int id){
        int totVendas = 0;
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set

        
        try {
            stmt = cn.prepareStatement("SELECT * FROM vender WHERE id_cliente = ?");
            stmt.setInt(1, id);
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                Vender vender = new Vender();
                totVendas++;
               
                
                
            }
            
            
        } catch (SQLException ex) {
                        Logger.getLogger(VenderDA0.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        

      return totVendas;
    }
    
    
    public void delete(Vender v){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("DELETE FROM vender WHERE id = ?") ;
            stmt.setInt(1,v.getId());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Queima");
        }finally{
            
            ConnectionFactory.closeConnection(cn, stmt);
                   
        }
        
        
    }
     public List<Vender> get(Vender v){
            
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Vender> vendersse = new ArrayList<>();
            
            try{
                stmt =cn.prepareStatement("SELECT * FROM vender WHERE id ? ");
                //mt.setString(1, v.getId());
                rs= stmt.executeQuery();
                
                while(rs.next()){
                    
                    Vender vender = new Vender();
                    vender.setId(rs.getInt("id"));
                    vender.setTotal(rs.getDouble("total"));
                    vender.setFuncionario(rs.getInt("idf"));                
                    vender.setProduto(rs.getInt("idp"));
                    vender.setQtd(rs.getInt("qtd"));
                    vender.setCliente(rs.getInt("id_cliente"));
                    vendersse.add(vender);
                    
                    
                    
                }
                
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema no Get");
                
            } finally{
                
                ConnectionFactory.closeConnection(cn, stmt, rs);
            }
            
            return vendersse;
        }
 
    
     public Cliente getClientes(String nome){ // 0s d0is met0dos são pra compras
        
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
        
    
   public List<Vender> lera(int idc){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        List<Vender> vendera = new ArrayList<>();
        
        try {
            stmt = cn.prepareStatement("SELECT * FROM vender WHERE id_cliente = ?");
            stmt.setInt(1,idc);
            
            rs  = stmt.executeQuery();
            
            
            
            
            
            while(rs.next()){
                
                Vender vender = new Vender();
                vender.setProduto(rs.getInt("idp"));
                vender.setTotal(rs.getDouble("total"));
                vender.setData(rs.getString("data"));
                vender.setHora(rs.getString("hora"));
                vendera.add(vender);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"N Funciona");
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        
        
        return vendera;
        
       
        
        
        
        
        
        
    }
     
    
    
    
}
