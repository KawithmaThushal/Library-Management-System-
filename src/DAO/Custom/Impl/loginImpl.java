package DAO.Custom.Impl;

import java.sql.ResultSet;

import DAO.CrudUtil;
import DAO.Custom.loginCustomdao;
import Entity.loginEntity;


public class loginImpl implements loginCustomdao {

    @Override
    public loginEntity getUser(String username, String password) throws Exception {
    ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users  WHERE username = ? AND password = ?",username,password);
     
        while (rst.next()) {
            loginEntity entity = new loginEntity(rst.getString("username"),rst.getString("password"));
            return entity;
        }
        return null;
    }

 
    
}
