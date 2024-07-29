package Service.Custom.Impl;

import java.sql.Connection;

import DAO.DAOFacutry;
import DAO.Custom.bookCustomdao;
import DAO.Custom.releasebookDAO;
import Dto.bookDto;
import Dto.bookReleaseDto;
import Entity.bookentity;
import Entity.bookreleaseEntity;
import Service.Custom.releasebook;
import db.DBConnection;

public class releasebookimpl implements releasebook{
    private releasebookDAO releBook =  (releasebookDAO) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.RELEASE);
    private bookCustomdao custom = (bookCustomdao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.Book);

    @Override
    public String release(bookReleaseDto releseDto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            bookreleaseEntity releseEntitiy = new bookreleaseEntity(releseDto.getBook_ID(),releseDto.getM_ID(),releseDto.getRelease_Date(),releseDto.getExpire_Date());
            String resp = releBook.Save(releseEntitiy);

            if(resp.equals("sucess")){
                boolean isbookrelease =true;
                for(bookDto bdto:releseDto.getDtos()){
                    bookentity bokkEntity = custom.getBookEntity(bdto.getID());
                    System.out.println("Error Console Log");
                    System.out.println(bokkEntity);
                    System.out.println(bdto.getQTY());
                    bokkEntity.setQTY(bdto.getQTY()-1);
                    String respt = custom.Update(bokkEntity);

                    if(!(respt.equals("sucess"))){
                        isbookrelease=false;
                    }
                    if(isbookrelease){
                        connection.commit();
                        return "Sucess";
                    }else{
                        connection.rollback();
                        return "Error1";
                    }

                }
            }else{
                connection.rollback();
              return " Error2";
            }


        } catch (Exception e) {
            connection.rollback();
             e.printStackTrace();
        }
        finally{
            connection.setAutoCommit(true);

         
        }
        return null;


       
    }


    
}
