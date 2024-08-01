package DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.CrudUtil;
import DAO.Custom.bookReturnDao;
import Entity.bookReturnEntity;

public class bookReturnimpl implements bookReturnDao{

    @Override
    public ArrayList<bookReturnEntity> getAll() throws Exception {
    ResultSet rst = CrudUtil.executeQuery( "SELECT * FROM borrowbook  WHERE  Expire_Date='2024-08-12'");
        
      ArrayList<bookReturnEntity> bookReturnentity= new ArrayList<>();
      
      while(rst.next()) {
        bookReturnEntity entity = new bookReturnEntity(rst.getString("M_ID"),rst.getString("book_ID"),rst.getString("Release_Date"),rst.getString("Expire_Date"));
        bookReturnentity.add(entity);
     }
      return bookReturnentity;
    }

    @Override
    public bookReturnEntity getBookreturnEntity(String M_ID, String B_ID) throws Exception {

        ResultSet rst = CrudUtil.executeQuery(" SELECT * FROM borrowbook WHERE M_ID=? AND book_ID=?;",M_ID,B_ID);
     
        while (rst.next()) {
          bookReturnEntity entity = new bookReturnEntity(rst.getString("M_ID"),rst.getString("book_ID"),rst.getString("Release_Date"),rst.getString("Expire_Date"));
            return entity;
        }
        return null;


      
    }
    
}
