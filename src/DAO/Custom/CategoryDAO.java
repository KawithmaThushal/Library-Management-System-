package DAO.Custom;

import java.util.List;

import DAO.SuperDAO;
import Entity.CategoryEntity;

public interface CategoryDAO extends SuperDAO{

         List<CategoryEntity> getAllCategories()  throws Exception;
    
} 