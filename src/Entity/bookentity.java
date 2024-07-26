package Entity;

public class bookentity {
    private String ID;
    private String Author;
    private String Categories;
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
    public String getCategories() {
        return Categories;
    }
    public void setCategories(String categories) {
        Categories = categories;
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
    
    public bookentity(String iD, String author, String categories, String titale, String publishDate,
            String bookAddDate, int qTY) {
        ID = iD;
        Author = author;
        Categories = categories;
        Titale = titale;
        this.publishDate = publishDate;
        BookAddDate = bookAddDate;
        QTY = qTY;
    }
    @Override
    public String toString() {
        return "bookentity [ID=" + ID + ", Author=" + Author + ", Categories=" + Categories + ", Titale=" + Titale
                + ", publishDate=" + publishDate + ", BookAddDate=" + BookAddDate + ", QTY=" + QTY + "]";
    }

    
    
}
