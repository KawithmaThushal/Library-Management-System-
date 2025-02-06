package Service.Custom.Impl;

import java.util.ArrayList;
import java.util.List;

import DAO.DAOFacutry;
import DAO.Custom.CategoryDAO;
import Dto.CategoryDto;
import Entity.CategoryEntity;
import Service.Custom.CategoryService;

public class CategoryServiceImpl implements CategoryService{

        private CategoryDAO categoryDAO = (CategoryDAO) DAOFacutry.getInstance().getDao(DAOFacutry.DAOType.CATEGORY);

    @Override
    public List<CategoryDto> getAllCategories() {
       List<CategoryDto> categoryDtoList = new ArrayList<>();

        try {
            // Fetch all categories from DAO
            List<CategoryEntity> categories = categoryDAO.getAllCategories();

            // Convert Entity objects to DTOs
            for (CategoryEntity category : categories) {
                categoryDtoList.add(new CategoryDto(
                        category.getID(),
                        category.getCategoryName()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions (log them if using a logger)
        }

        return categoryDtoList;
    }
    
}
