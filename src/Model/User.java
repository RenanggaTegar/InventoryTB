/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class User {

    /**
     * @return the ID_User
     */
    public Integer getID_User() {
        return ID_User;
    }

    /**
     * @param ID_User the ID_User to set
     */
    public void setID_User(Integer ID_User) {
        this.ID_User = ID_User;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    private Integer ID_User;
    private String Username;
    private String Password;
    
}
