package DAO.Custom;

import DAO.SuperDAO;

public interface homeCustomDao extends SuperDAO {

    int countBooks() throws Exception; 
    int OverdueBook() throws Exception; 
    int barrowedbook() throws Exception; 
    
}
