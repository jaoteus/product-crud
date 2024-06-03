package product.product_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.exception.CategoryNotFoundException;
import product.product_crud.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity findOne(UUID uuid) {
        // TODO: Remover o teste se ele não funcionar
        CategoryEntity category = categoryRepository.findById(uuid).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        return category;
    }

    public List<CategoryEntity> getAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories;
    }

    public CategoryEntity insert(CategoryEntity categoryToInsert) {
        categoryRepository.save(categoryToInsert);
        return categoryToInsert;
    }

    public CategoryEntity updateOne(UUID uuid, CategoryEntity categoryDetails) {
        CategoryEntity categoryToUpdate = findOne(uuid);
        categoryToUpdate.setName(categoryDetails.getName());
        categoryRepository.save(categoryToUpdate);
        return categoryToUpdate;
    }

    public void deleteOne(UUID uuid) {
        CategoryEntity category = findOne(uuid);
        categoryRepository.delete(category);
    }
}
