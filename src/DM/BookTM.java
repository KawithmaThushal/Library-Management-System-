package DM;

public class BookTM {

    private String ID;
    private String Author;
    private String Categories;
    private String Titale;
    private String BookAddDate;
    private String publishDate;
    private int Qty;
    public BookTM(String iD, String author, String categories, String titale, String bookAddDate, String publishDate,
            int qty, int qTY2) {
        ID = iD;
        Author = author;
        Categories = categories;
        Titale = titale;
        BookAddDate = bookAddDate;
        this.publishDate = publishDate;
        Qty = qty;
        QTY = qTY2;
    }
    public int getQty() {
        return Qty;
    }
    public void setQty(int qty) {
        Qty = qty;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getPublishDate() {
        return publishDate;
    }
   
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
    public BookTM() {
    }
   
    @Override
    public String toString() {
        return "BookTM [ID=" + ID + ", Author=" + Author + ", Categories=" + Categories + ", Titale=" + Titale
                + ", BookAddDate=" + BookAddDate + ", publishDate=" + publishDate + ", QTY=" + QTY + "]";
    }
    public BookTM(String iD, String author, String categories, String titale, String bookAddDate, String publishDate,
            int qTY) {
        ID = iD;
        Author = author;
        Categories = categories;
        Titale = titale;
        BookAddDate = bookAddDate;
        this.publishDate = publishDate;
        QTY = qTY;
    }

    
   
    

    
}
