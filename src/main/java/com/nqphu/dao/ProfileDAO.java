/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nqphu.dao;

import com.nqphu.model.ProfileModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phu
 */
public class ProfileDAO {  

    public ProfileDAO() {
    }
    
    public Connection getConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ManageProfile";
            String user = "nqphu";
            String pwd = "quangphu2805";
            try {
                return DriverManager.getConnection(url, user, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ProfileModel getProfile(int id) {
        Connection conn = this.getConnection();
        
        String sql = "SELECT * FROM Profile WHERE id=?";
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        ProfileModel pro = null;
        if (conn != null) {
            try {
                preStatement = conn.prepareStatement(sql);
                preStatement.setInt(1, id);
                resultSet = preStatement.executeQuery();
                
                if (resultSet.next()) {
                    pro = new ProfileModel();
                    pro.setId(resultSet.getInt("id"));
                    pro.setUsername(resultSet.getString("username"));
                    pro.setPwd(resultSet.getString("pwd"));
                    pro.setFullname(resultSet.getString("fullname"));
                    pro.setEmail(resultSet.getString("email"));
                    pro.setDob(resultSet.getString("dob"));
                    pro.setGender(resultSet.getString("gender"));
                    pro.setAddress(resultSet.getString("address"));
                    pro.setPhone(resultSet.getString("phone"));
                }
                
                conn.close();
                
                if (preStatement != null) {
                    preStatement.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return pro;

    }
    
    public ProfileModel findByUserNameAndPassword (String username, String password) {       
        Connection conn = this.getConnection();
        
        String sql = "SELECT * FROM Profile WHERE username=? AND pwd=?";
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        ProfileModel pro = null;
        if (conn != null) {
            try {
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, username);
                preStatement.setString(2, password);
                resultSet = preStatement.executeQuery();
                
                if (resultSet.next()) {
                    pro = new ProfileModel();
                    pro.setId(resultSet.getInt("id"));
                    pro.setUsername(resultSet.getString("username"));
                    pro.setPwd(resultSet.getString("pwd"));
                    pro.setFullname(resultSet.getString("fullname"));
                    pro.setEmail(resultSet.getString("email"));
                    pro.setDob(resultSet.getString("dob"));
                    pro.setGender(resultSet.getString("gender"));
                    pro.setAddress(resultSet.getString("address"));
                    pro.setPhone(resultSet.getString("phone"));
                } 
                
                conn.close();
                
                if (preStatement != null) {
                    preStatement.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return pro;
        
    }
}
