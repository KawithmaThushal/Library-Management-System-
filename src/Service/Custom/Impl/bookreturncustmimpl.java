package Service.Custom.Impl;

import java.util.ArrayList;

import DAO.DAOFacutry;
import DAO.Custom.bookReturnDao;
import Dto.bookReturnDto;
import Entity.bookReturnEntity;
import Service.Custom.bookreturnCustom;

public class bookreturncustmimpl implements bookreturnCustom{

    private bookReturnDao breturn = (bookReturnDao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.RETURN);

    @Override
    public ArrayList<bookReturnDto> getAll() throws Exception {
      ArrayList<bookReturnEntity>  entitys = breturn.getAll();
            ArrayList<bookReturnDto> dtos = new ArrayList<>();
            
            for(bookReturnEntity dto:entitys){
                bookReturnDto dtom = new bookReturnDto(dto.getBook_ID(),dto.getM_ID(),dto.getRelease_Date(),dto.getExpire_Date());
                
                
                dtos.add(dtom);
            }
            return dtos;   
    }

    @Override
    public bookReturnDto getBookreturnEntity(String M_ID, String B_ID) throws Exception {

        bookReturnEntity dto = breturn.getBookreturnEntity(M_ID, B_ID);
       
        if(dto != null){
            bookReturnDto dtom = new bookReturnDto(dto.getBook_ID(),dto.getM_ID(),dto.getRelease_Date(),dto.getExpire_Date());
            return dtom;
        }

        return null;  
      
    }
    
}
