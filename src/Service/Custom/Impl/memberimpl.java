package Service.Custom.Impl;

import java.util.ArrayList;

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
        dto.getEmail(),
        dto.getMembershipDate()
        
        
        
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
        Mdtos.getEmail(),
        Mdtos.getMembershipDate()
       );
       return member.Update(entity);

    }

    @Override
    public String Delete(String id) throws Exception {
        return member.Delete(id);
    }

    @Override
    public ArrayList<memberDto> getAll() throws Exception {

         ArrayList<memberEntity>  entitys = member.getAll();
            ArrayList<memberDto> dtos = new ArrayList<>();
            
            for(memberEntity dto:entitys){
                memberDto dtom = new memberDto(dto.getM_ID(),dto.getName(),dto.getAdress(),dto.getNic(),dto.getDOB(),dto.getContac_No(),dto.getEmail(),dto.getMembershipDate());
                
                
                dtos.add(dtom);
            }
            return dtos; 
       
    }

    @Override
    public memberDto getAllDto(String m_id) throws Exception {
        memberEntity dto = member.getMemberEntity(m_id);
       
        if(dto != null){
            memberDto dtos = new memberDto(dto.getM_ID(),dto.getName(),dto.getAdress(),dto.getNic(),dto.getDOB(),dto.getContac_No(),dto.getEmail(),dto.getMembershipDate());
            return dtos;
        }
        return null;  
    }

    
    
}
