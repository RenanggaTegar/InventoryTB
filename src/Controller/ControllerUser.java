/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOUser;
import DAOInterface.IDAOUser;
import Model.TabelModelUser;
import Model.User;
import View.FormUser;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class ControllerUser {
    public ControllerUser(FormUser frmUser)
    {
        this.frmUser = frmUser;
        iUser = new DAOUser();
    }
    
    public void isiTable()
    {
        lstUser = iUser.getAll();
        TabelModelUser tabelUser = new TabelModelUser(lstUser);
        frmUser.getTabelData().setModel(tabelUser);
    }
    
    public void Insert()
    {
         User u = new User();
         u.setID_User(Integer.parseInt(frmUser.gettxtID_User().getText()));
         u.setUsername((frmUser.gettxtUsername().getText()));
         u.setPassword(frmUser.gettxtPassword().getText());
         boolean res = iUser.insert(u);
         if(res)
             JOptionPane.showMessageDialog(null, "Input berhasil");
         else
             JOptionPane.showMessageDialog(null, "Gagal/Data Duplikat");

    }
    
    public void reset()
    {
        if(!frmUser.gettxtID_User().isEnabled())
            frmUser.gettxtID_User().setEnabled(true);
        frmUser.gettxtID_User().setText("");
        frmUser.gettxtUsername().setText("");
        frmUser.gettxtPassword().setText("");
    }
    
    public void isiField(int row)
    {
        frmUser.gettxtID_User().setEnabled(false);
        frmUser.gettxtID_User().setText(lstUser.get(row).getID_User().toString());
        frmUser.gettxtUsername().setText(lstUser.get(row).getUsername());
        frmUser.gettxtPassword().setText(lstUser.get(row).getPassword());
    }
    
    public void update() {
        User u = new User();
        u.setID_User(Integer.parseInt(frmUser.gettxtID_User().getText()));
        u.setUsername(frmUser.gettxtUsername().getText());
        u.setPassword(frmUser.gettxtPassword().getText());
        iUser.update(u);
        JOptionPane.showMessageDialog(null, "Update berhasil");
    }
    
    public void delete()
    {
         iUser.delete(Integer.parseInt(frmUser.gettxtID_User().getText()));
         JOptionPane.showMessageDialog(null, "Delete berhasil");
    }
    
    public void search()
    {
        lstUser = iUser.getAllByName(frmUser.gettxtCariNama().getText());
        TabelModelUser tabelUser = new TabelModelUser(lstUser);
        frmUser.getTabelData().setModel(tabelUser);
    }
    
    FormUser frmUser;
    IDAOUser iUser;
    List<User> lstUser;
    
}

