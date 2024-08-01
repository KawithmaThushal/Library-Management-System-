package DAO.Custom;
import DAO.SuperDAO;
import Entity.loginEntity;


public interface loginCustomdao extends SuperDAO{

     loginEntity getUser(String username, String password) throws Exception;
    
     
     

    
}
