package Service.Custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.DAOFacutry;
import DAO.Custom.bookCustomdao;
import Dto.bookDto;
import Entity.bookentity;
import Service.Custom.bookCustom;
import db.DBConnection;

public class bookImpl implements bookCustom{
private bookCustomdao custom = (bookCustomdao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.Book);

    @Override
    public String save(bookDto dto) throws Exception {

           Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false); // Start transaction
    
        try {

               // Validate Category ID
               if (dto.getCategoryID() <= 0) {
                connection.rollback();
                return "Invalid Category ID";
            }

            // Ensure date fields are not null
            if (dto.getPublishDate() == null || dto.getBookAddDate() == null) {
                connection.rollback();
                return "Invalid date values";
            }

            // Create a book entity from the DTO
            bookentity entity = new bookentity(
                    dto.getID(),
                    dto.getAuthor(),
                    dto.getCategoryID(),
                    dto.getTitale(),
                    dto.getPublishDate(),
                    dto.getBookAddDate(),
                    dto.getQTY()
            );
    
            // Save the book entity
            String resp = custom.save(entity);
    
            if (resp.equals("success")) {
                // Create another book entity for transaction save
                bookentity entitys = new bookentity(dto.getID(), dto.getCategoryID(), dto.getQTY());
    
                // Save transaction entity
                String respt = custom.TSave(entitys);
    
                if (respt.equals("success")) {
                    connection.commit(); // Commit transaction if everything is successful
                    return "success"; // Return success
                } else {
                    connection.rollback(); // Rollback transaction if TSave fails
                    return "error"; // Return error
                }
            } else {
                connection.rollback(); // Rollback transaction if save fails
                return "error"; // Return error
            }
        } catch (Exception e) {
            connection.rollback(); // Rollback transaction on exception
            throw e; // Rethrow exception for further handling
        } finally {
            connection.setAutoCommit(true); // Restore the connection's auto-commit state
        }

       


        
    }

    @Override
    public ArrayList<bookDto> getAll() throws Exception {

        ArrayList<bookentity>  entitys = custom.getAll();
            ArrayList<bookDto> dtos = new ArrayList<>();
            
            for(bookentity dto:entitys){
                bookDto dtom = new bookDto(dto.getID(),dto.getAuthor(),dto.getCategoryID(),dto.getTitale(),dto.getPublishDate(),dto.getBookAddDate(),dto.getQTY());
                
                
                dtos.add(dtom);
            }
            return dtos;    }

    @Override
    public String Delete(String id) throws Exception {
     return custom.Delete(id);
    }

    @Override
    public String Update(bookDto udtos) throws Exception {

        if (udtos.getCategoryID() <= 0) {
            return "Invalid Category ID";
        }

        if (udtos.getPublishDate() == null || udtos.getBookAddDate() == null) {
            return "Invalid date values";
        }
        bookentity entity = new bookentity(udtos.getID(),
        udtos.getAuthor(),
        udtos.getCategoryID(),
        udtos.getTitale(),
        udtos.getPublishDate(),
        udtos.getBookAddDate(),udtos.getQTY());

        return custom.Update(entity);

    }

    @Override
    public bookDto getAllDto(String ID) throws Exception {
        bookentity dto = custom.getBookEntity(ID);
       
        if(dto != null){
            bookDto dtos = new bookDto(dto.getID(),dto.getAuthor(),dto.getCategoryID(),dto.getTitale(),dto.getPublishDate(),dto.getBookAddDate(),dto.getQTY());
            return dtos;
        }
        return null;  
    }
      
    }

