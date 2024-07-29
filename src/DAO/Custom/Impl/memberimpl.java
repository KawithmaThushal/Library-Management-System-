package DAO.Custom.Impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.CrudUtil;
import DAO.Custom.membercustomDao;
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
        boolean isupdate = CrudUtil.executeUpdate("UPDATE member SET NAME=?,Adress=?,NIC=?,DOB=?,CONTAC_NUM=?,EMAIL=?,MembershipDate=? WHERE M_ID=? ",Mdtos.getName(),Mdtos.getAdress(),Mdtos.getNic(),Mdtos.getDOB(),Mdtos.getContac_No(),Mdtos.getEmail(),str,Mdtos.getM_ID());

        return isupdate ? "sucess" : "Fail";
    }

    @Override
    public String Delete(String id) throws Exception {
        boolean isupdated = CrudUtil.executeUpdate("DELETE FROM member WHERE M_ID=?",id);
        return isupdated ? "sucess":"Fail";
    }

    @Override
    public ArrayList<memberEntity> getAll() throws Exception {
         ResultSet rst = CrudUtil.executeQuery( "SELECT * FROM member");
        
      ArrayList<memberEntity> memberentitys= new ArrayList<>();
      
      while(rst.next()) {
        memberEntity entity = new memberEntity(rst.getString("M_ID"),rst.getString("NAME"),rst.getString("Adress"),rst.getString("NIC"),rst.getString("DOB"),rst.getInt("CONTAC_NUM"),rst.getString("EMAIL"),rst.getString("MembershipDate"));
        memberentitys.add(entity);
     }
      return memberentitys;
    }

    @Override
    public memberEntity getMemberEntity(String m_id) throws Exception {
          ResultSet rst = CrudUtil.executeQuery("SELECT * FROM member WHERE M_ID=?",m_id);
     
        while (rst.next()) {
            memberEntity entity = new memberEntity(rst.getString("M_ID"),rst.getString("NAME"),rst.getString("Adress"),rst.getString("NIC"),rst.getString("DOB"),rst.getInt("CONTAC_NUM"),rst.getString("EMAIL"),rst.getString("MembershipDate"));
            return entity;
        }
        return null;
    }

 

   
}
