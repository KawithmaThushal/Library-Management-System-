package Service.Custom;

import java.util.ArrayList;

import Dto.bookReturnDto;
import Service.SuperService;

public interface bookreturnCustom extends SuperService{
     ArrayList<bookReturnDto> getAll() throws  Exception;
     bookReturnDto getBookreturnEntity(String M_ID,String B_ID) throws Exception;


}
