package DAO.Custom;

import DAO.SuperDAO;
import Entity.bookreleaseEntity;

public interface releasebookDAO extends SuperDAO{

        String Save(bookreleaseEntity releseEntitiy) throws Exception;



    
}
