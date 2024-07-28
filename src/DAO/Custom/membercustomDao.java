package DAO.Custom;

import java.util.ArrayList;

import DAO.SuperDAO;
import Entity.bookentity;
import Entity.memberEntity;

public interface membercustomDao extends SuperDAO{

     String save(memberEntity dto) throws Exception;
    String Update(memberEntity Mdtos) throws Exception;
    String Delete(String id) throws Exception;
    ArrayList<bookentity> getAll() throws  Exception;
    
}
