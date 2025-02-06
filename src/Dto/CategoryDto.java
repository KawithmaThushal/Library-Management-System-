package Dto;

public class CategoryDto {
    private int categoryId;
    private String CategoryName;
   
    public String getCategoryName() {
        return CategoryName;
    }
    public void setCategoryName(final String categoryName) {
        CategoryName = categoryName;
    }
    public CategoryDto() {
    }
    public CategoryDto(final int iD, final String categoryName) {
        categoryId = iD;
        CategoryName = categoryName;
    }
    @Override
    public String toString() {
        return "CategoryDto [ID=" + categoryId + ", CategoryName=" + CategoryName + "]";
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    
}
