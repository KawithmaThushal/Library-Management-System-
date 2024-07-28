package Service.Custom.Impl;

import DAO.DAOFacutry;
import DAO.Custom.membercustomDao;
import Dto.memberDto;
import Entity.memberEntity;
import Service.Custom.membercustom;


public class memberimpl implements membercustom{
    private membercustomDao member =  (membercustomDao) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.MEMBER);

    @Override
    public String save(memberDto dto) throws Exception {
        memberEntity entity = new memberEntity(dto.getM_ID(),
        dto.getName(),
        dto.getAdress(),
        dto.getNic(),
        dto.getDOB(),
        dto.getContac_No(),
        dto.getEmail()
       );

        return member.save(entity);
    }

    @Override
    public String Update(memberDto Mdtos) throws Exception {
        memberEntity entity = new memberEntity(Mdtos.getM_ID(),
        Mdtos.getName(),
        Mdtos.getAdress(),
        Mdtos.getNic(),
        Mdtos.getDOB(),
        Mdtos.getContac_No(),
        Mdtos.getEmail()
       );
       return member.Update(entity);

    }

    @Override
    public String Delete(String id) throws Exception {
        return null;
    }

    
    
}
