package Entity;

public class memberEntity {

    private String M_ID;
    private String Name;
    private String Adress;
    private String  Nic;
    private String  DOB;
    private int Contac_No;
    private String  Email;
    private String  MembershipDate;
    public String getM_ID() {
        return M_ID;
    }
    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAdress() {
        return Adress;
    }
    public void setAdress(String adress) {
        Adress = adress;
    }
    public String getNic() {
        return Nic;
    }
    public void setNic(String nic) {
        Nic = nic;
    }
    public String getDOB() {
        return DOB;
    }
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public int getContac_No() {
        return Contac_No;
    }
    public void setContac_No(int contac_No) {
        Contac_No = contac_No;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public memberEntity(String m_ID, String name, String adress, String nic, String dOB, int contac_No, String email,
            String membershipDate) {
        M_ID = m_ID;
        Name = name;
        Adress = adress;
        Nic = nic;
        DOB = dOB;
        Contac_No = contac_No;
        Email = email;
        MembershipDate = membershipDate;
    }
    @Override
    public String toString() {
        return "memberEntity [M_ID=" + M_ID + ", Name=" + Name + ", Adress=" + Adress + ", Nic=" + Nic + ", DOB=" + DOB
                + ", Contac_No=" + Contac_No + ", Email=" + Email + ", MembershipDate=" + MembershipDate + "]";
    }
    public memberEntity() {
    }
    public String getMembershipDate() {
        return MembershipDate;
    }
    public void setMembershipDate(String membershipDate) {
        MembershipDate = membershipDate;
    }
    

 

    
    
}
