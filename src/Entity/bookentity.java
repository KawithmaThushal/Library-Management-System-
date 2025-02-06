package Entity;

public class bookentity {
    private String ID;
    private String Author;
    private int CategoryID;
   
    private String Titale;
    private String publishDate;
    private String BookAddDate;
    private int QTY;
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public int getCategoryID() {
        return CategoryID;
    }
    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }
    public String getTitale() {
        return Titale;
    }
    public void setTitale(String titale) {
        Titale = titale;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getBookAddDate() {
        return BookAddDate;
    }
    public void setBookAddDate(String bookAddDate) {
        BookAddDate = bookAddDate;
    }
    public int getQTY() {
        return QTY;
    }
    public void setQTY(int qTY) {
        QTY = qTY;
    }

    
    public bookentity() {
    }
    

    public bookentity(String iD, String author, int categoryID, String titale, String publishDate, String bookAddDate,
            int qTY) {
        ID = iD;
        Author = author;
        CategoryID = categoryID;
        Titale = titale;
        this.publishDate = publishDate;
        BookAddDate = bookAddDate;
        QTY = qTY;
    }

    
    @Override
    public String toString() {
        return "bookentity [ID=" + ID + ", Author=" + Author + ", CategoryID=" + CategoryID + ", Titale=" + Titale
                + ", publishDate=" + publishDate + ", BookAddDate=" + BookAddDate + ", QTY=" + QTY + "]";
    }
    public bookentity(String iD, int categoryID, int qTY) {
        ID = iD;
        CategoryID = categoryID;
        QTY = qTY;
    }


    
    
}
