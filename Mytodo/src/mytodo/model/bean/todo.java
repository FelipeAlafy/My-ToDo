/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodo.model.bean;

/**
 *
 * @author falaf
 */
public class todo {
    private int id;
    private String name;
    private int UID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int idUser) {
        this.UID = idUser;
    }
    
}
