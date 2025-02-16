package DAO;

import DAO.Custom.Impl.CategoryDAOimpl;
import DAO.Custom.Impl.bookReturnimpl;
import DAO.Custom.Impl.bookimpl;
import DAO.Custom.Impl.bookreleseimpl;
import DAO.Custom.Impl.homeImpl;
import DAO.Custom.Impl.loginImpl;
import DAO.Custom.Impl.memberimpl;

public class DAOFacutry {
    private   static DAOFacutry daoFacutry;

    public static DAOFacutry getInstance(){
        if(daoFacutry == null){
            daoFacutry= new DAOFacutry();
        }
        return daoFacutry;
    }

    public SuperDAO getDao(DAOType type){
        switch (type) {
            case Book:
                
            return new bookimpl();
                
            case MEMBER:
            return new memberimpl();

            case RELEASE:
            return new bookreleseimpl();
            
            case  RETURN :
            return new bookReturnimpl();

            case LOGIN:
            return new loginImpl();

            case HOME:
            return new homeImpl();

            case CATEGORY:
            return new CategoryDAOimpl();


        
            default:
                return null;
        }
    }

    public enum DAOType{
        Book,
        MEMBER,
        RELEASE,
        RETURN,
        LOGIN,
        HOME,
        CATEGORY
    }
    
}
