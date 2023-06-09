/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOUser;
import Helper.KoneksiDB;
import Model.User;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DAOUser implements IDAOUser{
    public DAOUser() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<User> getAll() {
        List<User> lstUser = null;
        try {
            lstUser = new ArrayList<User>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while (rs.next()) {
                User usr = new User();
                usr.setID_User(rs.getInt("ID_User"));
                usr.setUsername(rs.getString("Username"));
                usr.setPassword(rs.getString("Password"));
                lstUser.add(usr);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return lstUser;
    }

    @Override
    public boolean insert(User u) {
        boolean result = true;
        java.sql.PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, u.getID_User());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getPassword());
            statement.execute();
        } catch (SQLException x) 
        {
            System.out.println("gagal input");
            result = false;
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal inputt");
                result = false;
            }
        }
        return result;
    }

    @Override
    public void update(User u) {
        java.sql.PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.setInt(3, u.getID_User());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("gagal update");
        } finally {
            try {
                statement.close();
                
            } catch (SQLException x) {
                System.out.println("gagal updatee");
            }
        }
    }

    @Override
    public void delete(int ID_User) {
        java.sql.PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, ID_User);
            statement.executeUpdate();
        } catch (SQLException x) {
            System.out.println("gagal delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal deletee");
            }
        }
    }

    @Override
    public List<User> getAllByName(String Username) {
        List<User> lstUser = null;
        try {
            lstUser = new ArrayList<User>();
            java.sql.PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1, "%" + Username + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User usr = new User();
                usr.setID_User(rs.getInt("ID_User"));
                usr.setUsername(rs.getString("Username"));
                usr.setPassword(rs.getString("Password"));
                lstUser.add(usr);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return lstUser;
    }

    Connection con;
    // SQL Query
    String strRead = "SELECT * FROM login ORDER BY ID_User ASC";
    String strInsert = "INSERT INTO login (ID_User, Username, Password) VALUES (?, ?, ?)";
    String strUpdate = "UPDATE login SET Username=?, Password=? WHERE ID_User=?";
    String strDelete = "DELETE FROM login WHERE ID_User=?";
    String strSearch = "SELECT * FROM login WHERE Username LIKE ?";
}
