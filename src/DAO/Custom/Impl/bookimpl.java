package DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.CrudUtil;
import DAO.Custom.bookCustomdao;
import Entity.bookentity;

public class bookimpl implements bookCustomdao {

    @Override
    public String  save(bookentity dto) throws Exception {
      boolean isssaved= CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?,?,?)", dto.getID(),dto.getAuthor(),dto.getCategoryID(),dto.getTitale(),dto.getPublishDate(),dto.getBookAddDate(),dto.getQTY());

        return isssaved ? "sucess" : "Fail";
    }

    @Override
    public ArrayList<bookentity> getAll() throws Exception {
      ResultSet rst = CrudUtil.executeQuery( "SELECT * FROM books");
        
      ArrayList<bookentity> bookEntitys= new ArrayList<>();
      
      while(rst.next()) {
        bookentity entity = new bookentity(rst.getString("ID"),rst.getString("Author"),rst.getInt("CategoryID"),rst.getString("Title"),rst.getString("PublishDate"),rst.getString("BookAddDate"),rst.getInt("QTY"));
        bookEntitys.add(entity);
     }
      return bookEntitys;
 }

    @Override
    public String Delete(String id) throws Exception {
     boolean issaved = CrudUtil.executeUpdate("DELETE FROM books WHERE ID=?",id);

     return issaved ? "sucess":"Fail";
    }

    @Override
    public String Update(bookentity udtos) throws Exception {
        boolean isupdate = CrudUtil.executeUpdate("UPDATE books SET Author=?,CategoryID=?,Title=?,PublishDate=?,BookAddDate=?,QTY=? WHERE ID=? ",udtos.getAuthor(),udtos.getCategoryID(),udtos.getTitale(),udtos.getPublishDate(),udtos.getBookAddDate(),udtos.getQTY(),udtos.getID());
        return isupdate ? "sucess" : "Fail";
    }

    @Override
    public bookentity getBookEntity(String ID) throws Exception {
      ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE ID=?",ID);
     
        while (rst.next()) {
          bookentity entity = new bookentity(rst.getString("ID"),rst.getString("Author"),rst.getInt("CategoryID"),rst.getString("Title"),rst.getString("PublishDate"),rst.getString("BookAddDate"),rst.getInt("QTY"));
            return entity;
        }
        return null;
    }

    @Override
    public String TSave(bookentity tdto) throws Exception {
      boolean isTempeoryssaved = CrudUtil.executeUpdate("INSERT INTO bookquty VALUES(?,?,?)", tdto.getID(),tdto.getCategoryID(),tdto.getQTY());

      return isTempeoryssaved ? "sucess" : "Fail";
    }

  
    }
  

