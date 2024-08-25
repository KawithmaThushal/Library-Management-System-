package DAO.Custom.Impl;

import java.sql.ResultSet;

import DAO.CrudUtil;
import DAO.Custom.homeCustomDao;


public class homeImpl implements homeCustomDao{

    @Override
    public int countBooks() throws Exception {
         ResultSet rst = CrudUtil.executeQuery("SELECT COUNT(*) FROM books");
         if (rst.next()) {
            return rst.getInt(1);  // Return the count of books
        }
        return 0;

    }

    @Override
    public int OverdueBook() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT COUNT(*) FROM borrowbook WhERE Expire_Date<CURRENT_DATE()");
        if (rst.next()) {
           return rst.getInt(1);  // Return the count of books
       }
       return 0;
    }

    @Override
    public int barrowedbook() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT COUNT(*) FROM borrowbook WhERE Expire_Date>CURRENT_DATE()");
        if (rst.next()) {
           return rst.getInt(1);  // Return the count of books
       }
       return 0;
    }
    
}
