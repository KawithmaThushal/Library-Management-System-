package Service.Custom;

import java.util.List;

import Dto.CategoryDto;
import Service.SuperService;

public interface CategoryService extends SuperService {
    List<CategoryDto> getAllCategories();
}
