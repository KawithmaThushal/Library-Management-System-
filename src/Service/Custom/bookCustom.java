package Service.Custom;

import Dto.bookDto;
import Service.SuperService;

public interface bookCustom extends SuperService{
    String save(bookDto dto) throws Exception;
    
}
