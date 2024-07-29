package Service.Custom;

import java.util.ArrayList;

import Dto.memberDto;
import Service.SuperService;

public interface membercustom extends SuperService {

     String save(memberDto dto) throws Exception;
    String Update(memberDto Mdtos) throws Exception;

    String Delete(String id) throws Exception;
    memberDto getAllDto(String m_id) throws Exception;
        ArrayList<memberDto> getAll() throws  Exception;


    
}
