package Service.Custom.Impl;

import DAO.DAOFacutry;
import DAO.Custom.loginCustomdao;
import Dto.loginDto;
import Entity.loginEntity;
import Service.Custom.loginServiceCustom;

public class loginServiceimpl implements loginServiceCustom{

     private loginCustomdao loginUser = (loginCustomdao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.LOGIN);

    @Override
    public loginDto getUser(String username, String password) throws Exception {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        loginEntity loginEntity = loginUser.getUser(username, password);
        if (loginEntity != null) {
            loginDto dto = new loginDto(loginEntity.getUsername(),loginEntity.getPassword());
           
            return dto;
        }
        return null;

    }
    
}
