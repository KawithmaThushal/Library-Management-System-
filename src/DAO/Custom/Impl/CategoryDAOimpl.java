package DAO.Custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.CrudUtil;
import DAO.Custom.CategoryDAO;
import Entity.CategoryEntity;

public class CategoryDAOimpl implements CategoryDAO{

    @Override
    public List<CategoryEntity> getAllCategories() throws Exception {

        List<CategoryEntity> categories = new ArrayList<>();
         // SQL query to fetch all categories
    String sql = "SELECT * FROM categories";

    // Execute the query
    ResultSet resultSet = CrudUtil.executeQuery(sql);

    // Loop through the result set and populate the list
    while (resultSet.next()) {
        categories.add(new CategoryEntity(
                resultSet.getInt("ID"),
                resultSet.getString("CategoryName")
        ));
    }

        return categories;
    }
    
}
