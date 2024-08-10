package Dto;

public class bookQtyDto {
  
    private String B_ID;
    private String Category;
    private int QTY;
  
    public String getB_ID() {
        return B_ID;
    }
    public void setB_ID(String b_ID) {
        B_ID = b_ID;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public int getQTY() {
        return QTY;
    }
    public void setQTY(int qTY) {
        QTY = qTY;
    }
    public bookQtyDto() {
    }
    public bookQtyDto( String b_ID, String category, int qTY) {
  
        B_ID = b_ID;
        Category = category;
        QTY = qTY;
    }
    @Override
    public String toString() {
        return " B_ID=" + B_ID + ", Category=" + Category + ", QTY=" + QTY + "]";
    }

    
}
