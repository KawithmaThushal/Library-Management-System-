package Service.Custom;
import Dto.bookReleaseDto;
import Service.SuperService;

public interface releasebook extends SuperService {
    String release(bookReleaseDto releseDto) throws Exception;

    
}
