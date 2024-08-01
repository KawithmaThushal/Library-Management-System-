package Service.Custom;
import Dto.loginDto;
import Service.SuperService;

public interface loginServiceCustom extends SuperService{

     loginDto getUser(String username, String password) throws Exception;
    
}
