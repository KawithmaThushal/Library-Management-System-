package DM;

public class bookreturnTM {

    private String  M_ID;
    private String book_ID;
   
    private String Expire_Date;

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public String getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(String book_ID) {
        this.book_ID = book_ID;
    }

    public String getExpire_Date() {
        return Expire_Date;
    }

    public void setExpire_Date(String expire_Date) {
        Expire_Date = expire_Date;
    }

    public bookreturnTM() {
    }

    public bookreturnTM(String m_ID, String book_ID, String expire_Date) {
        M_ID = m_ID;
        this.book_ID = book_ID;
        Expire_Date = expire_Date;
    }

    @Override
    public String toString() {
        return "bookreturnTM [M_ID=" + M_ID + ", book_ID=" + book_ID + ", Expire_Date=" + Expire_Date + "]";
    }

    
    
}
