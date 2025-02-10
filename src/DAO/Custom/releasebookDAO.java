package DAO.Custom;

import DAO.SuperDAO;
import Entity.bookreleaseEntity;

public interface releasebookDAO extends SuperDAO{

        String Save(bookreleaseEntity releseEntitiy) throws Exception;
        String Delete(String M_id,String B_ID) throws Exception;




    
}
