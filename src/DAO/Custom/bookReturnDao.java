package DAO.Custom;

import java.util.ArrayList;

import DAO.SuperDAO;
import Entity.bookReturnEntity;

public interface bookReturnDao extends SuperDAO{

ArrayList<bookReturnEntity> getAll() throws  Exception;
bookReturnEntity getBookreturnEntity(String M_ID,String B_ID) throws Exception;



    
}
