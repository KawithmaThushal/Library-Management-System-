package Service.Custom;

import java.util.ArrayList;

import Dto.bookReturnDto;
import Service.SuperService;

public interface bookreturnCustom extends SuperService{
     ArrayList<bookReturnDto> getAll() throws  Exception;
}
