package DAO;

import DAO.Custom.Impl.bookimpl;

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
        
            default:
                return null;
        }
    }

    public enum DAOType{
        Book
    }
    
}
