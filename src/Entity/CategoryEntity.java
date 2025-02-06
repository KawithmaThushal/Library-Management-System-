package Entity;

public class CategoryEntity {
    private int ID;
    private String CategoryName;

    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getCategoryName() {
        return CategoryName;
    }
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
    public CategoryEntity(int iD, String categoryName) {
        ID = iD;
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryEntity [ID=" + ID + ", CategoryName=" + CategoryName + "]";
    }
    public CategoryEntity() {
    }

    

    
    
}
