package DAO.Custom.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.CrudUtil;
import DAO.Custom.membercustomDao;
import Entity.bookentity;
import Entity.memberEntity;

public class memberimpl implements membercustomDao {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     String str = formatter.format(date);

    @Override
    public String save(memberEntity dto) throws Exception {
         boolean isssaved = CrudUtil.executeUpdate("INSERT INTO member VALUES(?,?,?,?,?,?,?,?)", dto.getM_ID(),dto.getName(),dto.getAdress(),dto.getNic(),dto.getDOB(),dto.getContac_No(),dto.getEmail(),str);

        return isssaved ? "sucess" : "Fail";
    }

    @Override
    public String Update(memberEntity Mdtos) throws Exception {
        boolean isupdate = CrudUtil.executeUpdate("UPDATE books SET NAME=?,Adress=?,NIC=?,DOB=?,CONTAC_NUM=?,EMAIL=?,MembershipDate=? WHERE M_ID=? ",Mdtos.getName(),Mdtos.getAdress(),Mdtos.getNic(),Mdtos.getDOB(),Mdtos.getContac_No(),Mdtos.getEmail(),str,Mdtos.getM_ID());

        return isupdate ? "sucess" : "Fail";
    }

    @Override
    public String Delete(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<bookentity> getAll() throws Exception {
        return null;
    }
    
}
