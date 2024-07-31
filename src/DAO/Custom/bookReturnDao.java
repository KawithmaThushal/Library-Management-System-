package DAO.Custom;

import java.util.ArrayList;

import DAO.SuperDAO;
import Entity.bookReturnEntity;

public interface bookReturnDao extends SuperDAO{

ArrayList<bookReturnEntity> getAll() throws  Exception;

    
}
