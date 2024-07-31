package Entity;



public class bookReturnEntity {

    private String  M_ID;
    private String book_ID;
    private String Release_Date;
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
    public String getRelease_Date() {
        return Release_Date;
    }
    public void setRelease_Date(String release_Date) {
        Release_Date = release_Date;
    }
    public String getExpire_Date() {
        return Expire_Date;
    }
    public void setExpire_Date(String expire_Date) {
        Expire_Date = expire_Date;
    }
    public bookReturnEntity() {
    }
    public bookReturnEntity(String m_ID, String book_ID, String release_Date, String expire_Date) {
        M_ID = m_ID;
        this.book_ID = book_ID;
        Release_Date = release_Date;
        Expire_Date = expire_Date;
    }
    @Override
    public String toString() {
        return "bookReturnEntity [M_ID=" + M_ID + ", book_ID=" + book_ID + ", Release_Date=" + Release_Date
                + ", Expire_Date=" + Expire_Date + "]";
    }


    
}
