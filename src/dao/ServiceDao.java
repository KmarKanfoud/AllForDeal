/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
import entite.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Super
 */
public class ServiceDao implements IDao<Service> {
    
       private Connection connection;
    private PreparedStatement pst;
    
     public ServiceDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(Service s) {
            String req = "insert into personne (id,nom, prenom) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getNomService());
            pst.setString(3, s.getDescription());
            pst.setString(4, s.getType());
            pst.setString(5, s.getEtat());
            //pst.setString(5, s.DateAjout());
            pst.setString(5, s.getZone());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void update(Service s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Service> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Service findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
