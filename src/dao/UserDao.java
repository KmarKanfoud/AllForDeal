/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entite.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author maroo
 */
public class UserDao implements Idao.IDao<User>{
    private Connection connection;
    private PreparedStatement pst;
    
     public UserDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();
     }
    @Override
    public void add(User t) {
        String req = "insert into fos_user_user(username, username_canonical, email, email_canonical, enabled, password, last_Login, gender, phone, firstname, lastname, roles, created_at, updated_at)"
               +"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsernameCanonical());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmailCanonical());
             pst.setInt(5, t.getEnabled());
            pst.setString(6, t.getPassword());
            pst.setDate(7, (Date) t.getLastLogin());
            pst.setString(8, t.getGender());
            pst.setInt(9, t.getPhone());
            pst.setString(10, t.getFirstname());
            pst.setString(11, t.getLastname());
            pst.setString(12, t.getRoles());
            pst.setDate(13, (Date) t.getCreated_at());
            pst.setDate(14, (Date) t.getUpdated_at());
           
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
