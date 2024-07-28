package Service.Custom;

import java.util.ArrayList;

import Dto.bookDto;
import Service.SuperService;

public interface bookCustom extends SuperService{
    String save(bookDto dto) throws Exception;
    String Update(bookDto udtos) throws Exception;

    String Delete(String id) throws Exception;

    ArrayList<bookDto> getAll() throws  Exception;
    
}
