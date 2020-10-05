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
public class createAccount {
    public boolean createAccount(String name, String pass) {
        boolean check = true;
        Connection con = conexao.con();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("Insert into contas (nome, pass) values (?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, pass);
            stmt.execute();
            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
        return check;
    }
}
