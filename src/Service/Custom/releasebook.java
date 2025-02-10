package Service.Custom;
import Dto.bookReleaseDto;
import Service.SuperService;

public interface releasebook extends SuperService {
    String release(bookReleaseDto releseDto) throws Exception;
    String Delete(String M_id,String B_ID) throws Exception;


    
}
