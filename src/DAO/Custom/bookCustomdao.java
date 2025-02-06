package DAO.Custom;

import java.util.ArrayList;

import DAO.SuperDAO;
import Entity.bookentity;

public interface bookCustomdao extends SuperDAO{

    String  save(bookentity dto) throws Exception;
    String Update(bookentity udtos) throws Exception;
    String Delete(String id) throws Exception;
    bookentity getBookEntity(String itemcode) throws Exception;
    ArrayList<bookentity> getAll() throws  Exception;


    String TSave(bookentity tdto)throws Exception;

    
    
}
