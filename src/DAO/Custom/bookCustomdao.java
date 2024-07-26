package DAO.Custom;

import DAO.SuperDAO;
import Entity.bookentity;

public interface bookCustomdao extends SuperDAO{

    String save(bookentity dto) throws Exception;
    
}
