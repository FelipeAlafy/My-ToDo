/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytodo.connection.conexao;

/**
 *
 * @author falaf
 */
public class login {
    public boolean login(String name, String pass) throws InterruptedException{
        boolean check = false;
        
        Connection con = conexao.con();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM contas WHERE nome=? and pass=?");
            stmt.setString(1, name);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
        return check;
    }
}