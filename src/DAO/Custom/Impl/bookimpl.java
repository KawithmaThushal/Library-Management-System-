package DAO.Custom.Impl;

import DAO.CrudUtil;
import DAO.Custom.bookCustomdao;
import Entity.bookentity;

public class bookimpl implements bookCustomdao {

    @Override
    public String save(bookentity dto) throws Exception {
      boolean isssaved = CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?,?,?)", dto.getID(),dto.getAuthor(),dto.getCategories(),dto.getTitale(),dto.getPublishDate(),dto.getBookAddDate(),dto.getQTY());

        return isssaved ? "sucess" : "Fail";
    }

}
