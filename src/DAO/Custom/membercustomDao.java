package DAO.Custom;

import java.util.ArrayList;

import DAO.SuperDAO;
import Entity.memberEntity;

public interface membercustomDao extends SuperDAO{

     String save(memberEntity dto) throws Exception;
    String Update(memberEntity Mdtos) throws Exception;
    String Delete(String id) throws Exception;
    memberEntity getMemberEntity(String m_id) throws Exception;
    ArrayList<memberEntity> getAll() throws  Exception;
    
}
