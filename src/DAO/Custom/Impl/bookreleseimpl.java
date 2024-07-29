package DAO.Custom.Impl;

import java.time.DayOfWeek;
import java.time.LocalDate;

import DAO.CrudUtil;
import DAO.Custom.releasebookDAO;
import Entity.bookreleaseEntity;

public class bookreleseimpl implements releasebookDAO{

    LocalDate currentDate = LocalDate.now();
      LocalDate dateAfterTwoWeeks = currentDate.plusDays(14);
      DayOfWeek dayOfWeek = dateAfterTwoWeeks.getDayOfWeek();

    @Override
    public String Save(bookreleaseEntity releseEntitiy) throws Exception {
        boolean ischeked = CrudUtil.executeUpdate("INSERT INTO borrowbook VALUES(?,?,?,?)",releseEntitiy.getBook_ID(),releseEntitiy.getM_ID(), releseEntitiy.getRelease_Date(),releseEntitiy.getExpire_Date());
        return ischeked ? "sucess" : "Fail";
    }
    
}
