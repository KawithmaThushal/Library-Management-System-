package Service.Custom.Impl;

import java.util.ArrayList;

import DAO.DAOFacutry;
import DAO.Custom.bookCustomdao;
import Dto.bookDto;
import Entity.bookentity;
import Service.Custom.bookCustom;

public class bookImpl implements bookCustom{
private bookCustomdao custom = (bookCustomdao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.Book);

    @Override
    public String save(bookDto dto) throws Exception {
        bookentity entity = new bookentity(dto.getID(),
        dto.getAuthor(),
        dto.getCategories(),
        dto.getTitale(),
        dto.getPublishDate(),
        dto.getBookAddDate(),dto.getQTY());


        return custom.save(entity);
    }

    @Override
    public ArrayList<bookDto> getAll() throws Exception {

        ArrayList<bookentity>  entitys = custom.getAll();
            ArrayList<bookDto> dtos = new ArrayList<>();
            
            for(bookentity dto:entitys){
                bookDto dtom = new bookDto(dto.getID(),dto.getAuthor(),dto.getCategories(),dto.getTitale(),dto.getPublishDate(),dto.getBookAddDate(),dto.getQTY());
                
                
                dtos.add(dtom);
            }
            return dtos;    }

    @Override
    public String Delete(String id) throws Exception {
     return custom.Delete(id);
    }

    @Override
    public String Update(bookDto udtos) throws Exception {
        bookentity entity = new bookentity(udtos.getID(),
        udtos.getAuthor(),
        udtos.getCategories(),
        udtos.getTitale(),
        udtos.getPublishDate(),
        udtos.getBookAddDate(),udtos.getQTY());

        return custom.Update(entity);

    }
      
    }

