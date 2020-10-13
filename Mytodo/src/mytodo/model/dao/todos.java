package mytodo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytodo.connection.conexao;
import mytodo.model.bean.conta;
import mytodo.model.bean.todo;
/**
 *
 * @author falaf
 */
public class todos {
    
    public ArrayList<todo> getDBValues(int UID){
        ArrayList<todo> todos = new ArrayList<>();
        Connection con = conexao.con();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select c.id, t.UID, t.tasks from todo as t join contas as c where t.UID = ? and c.id = ?");
            stmt.setInt(1, UID);
            stmt.setInt(2, UID);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                todo todo = new todo();
                todo.setName(rs.getString("tasks"));
                todo.setId(rs.getInt("id"));
                todo.setUID(rs.getInt("UID"));
                todos.add(todo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(todo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
        return todos;
    }
    
    //Save
    public void addOnDB(todo td){
        Connection con = conexao.con();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("insert into todo (UID, tasks) values (?, ?)");
            stmt.setInt(1, td.getUID());
            stmt.setString(2, td.getName());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(todos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
    }
    
    //Delete
    public void remoOnDB(String name, int UID){
        Connection con = conexao.con();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("delete from todo where tasks = ? and UID = ?");
            stmt.setString(1, name);
            stmt.setInt(2, UID);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(todos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
