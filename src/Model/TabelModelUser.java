/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class TabelModelUser extends AbstractTableModel{
    public TabelModelUser(List<User> lstUser)
    {
        this.lstUser = lstUser;
    }
    @Override
    public int getRowCount() {
        return this.lstUser.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID_User";
            case 1:
                return "Username";
            case 2:
                return "Password";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lstUser.get(rowIndex).getID_User();
            case 1:
                return lstUser.get(rowIndex).getUsername();
            case 2:
                return lstUser.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    
    List<User> lstUser;
    
}
