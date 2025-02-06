package DM;

public class BookTM {

    private String ID;
    private String Author;
    private String CategoryName; 
    private String Titale;
    private String BookAddDate;
    private String publishDate;
    private int Qty;

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
    public String getCategoryName() {
        return CategoryName;
    }
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
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
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public int getQty() {
        return Qty;
    }
    public void setQty(int qty) {
        Qty = qty;
    }
    @Override
    public String toString() {
        return "BookTM [ID=" + ID + ", Author=" + Author + ", CategoryName=" + CategoryName + ", Titale=" + Titale
                + ", BookAddDate=" + BookAddDate + ", publishDate=" + publishDate + ", Qty=" + Qty + "]";
    }
    public BookTM() {
    }
    public BookTM(String iD, String author, String categoryName, String titale, String bookAddDate, String publishDate,
            int qty) {
        ID = iD;
        Author = author;
        CategoryName = categoryName;
        Titale = titale;
        BookAddDate = bookAddDate;
        this.publishDate = publishDate;
        Qty = qty;
    }

    
    
    
    
}
