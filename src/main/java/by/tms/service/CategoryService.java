package by.tms.service;

import by.tms.entity.Category;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    @Autowired
    @Qualifier("hibernateCategoryDao")
    private Storage<Category, Long> categoryService;

    public Category save(Category category) {
        categoryService.save(category);
        return category;
    }

    public Optional<Category> findCategoryById(Long id) {
        return categoryService.findById(id);
    }

    public Optional<Category> findCategoryByName(Category category){
        return categoryService.findEntity(category.getNameCategory());
    }

    public List<Category> getCategoryList() {
        return categoryService.getListOfEntity();
    }

    public Category delete(Category category) {
        categoryService.delete(category);
        return category;
    }
}
