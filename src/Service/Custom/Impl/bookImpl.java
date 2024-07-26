package Service.Custom.Impl;

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
    
}
