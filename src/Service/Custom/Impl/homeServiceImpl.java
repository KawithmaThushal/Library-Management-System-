package Service.Custom.Impl;

import DAO.DAOFacutry;
import DAO.Custom.homeCustomDao;
import Service.Custom.homeCustomService;

public class homeServiceImpl implements homeCustomService {
    private homeCustomDao homereturn =  (homeCustomDao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.HOME);


    @Override
    public int getTotalBooks() throws Exception {
        return homereturn.countBooks();
        
    }


    @Override
    public int getOverdueBook() throws Exception {
            return homereturn.OverdueBook();
    }


    @Override
    public int getbarrowedbook() throws Exception {
       return homereturn.barrowedbook();
    }
    
}
