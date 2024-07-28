package Service.Custom;

import Dto.memberDto;
import Service.SuperService;

public interface membercustom extends SuperService {

     String save(memberDto dto) throws Exception;
    String Update(memberDto Mdtos) throws Exception;

    String Delete(String id) throws Exception;

    
}
