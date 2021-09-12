package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import model.bean.Usuario;

public class UsuarioDA0 {
    static int a;
    
    
    public boolean checklogin(String login, String senha){
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
// executa e retorna resultados sendo guardado num result set
        boolean check = false; 
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM login WHERE login = ? and senha = ?");
            stmt.setString(1,login);
            stmt.setString(2,senha);
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
                check = true;
                
                
                a=rs.getInt("id");    
                }
            
            
        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
        
        
        return check;
        
       
        
        
        
        
    }
    
    public void logar(){
        
         Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("UPDATE login SET status=? WHERE id = ?") ;
            stmt.setBoolean(1, true );
            stmt.setInt(2, a);
            
            
            stmt.executeUpdate();
           
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
        
    }
    public void deslogar(){
        
         Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = cn.prepareStatement("UPDATE login SET status=? WHERE id = ?") ;
            stmt.setBoolean(1, false );
            stmt.setInt(2, a);
            
            
            stmt.executeUpdate();
           
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Failure" + ex);
        }
            finally {
            ConnectionFactory.closeConnection(cn, stmt);
            
        }
        
        
    }
    
    
    
    
    
    
    
    public String getNome(int id){
        
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; // executa e retorna resultados sendo guardado num result set
        String nm=null; 
        try {
            
            stmt = cn.prepareStatement("SELECT * FROM login WHERE id = ?");
            stmt.setInt(1, id);
            
            
            rs  = stmt.executeQuery();
            
            if(rs.next()){
                
                
                nm=rs.getString("login");    }
            
            
        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(cn, stmt,rs);
        }
         
        
        return nm;
        
        
        
        
    }
    
    
    
}
