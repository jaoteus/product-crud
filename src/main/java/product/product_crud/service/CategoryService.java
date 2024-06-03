package product.product_crud.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.exception.CategoryNotFoundException;
import product.product_crud.exception.ProductNotFoundException;
import product.product_crud.repository.CategoryRepository;

import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity findOne(UUID uuid) {
        // TODO: Adicionar uma classe de exceção para category not found
        CategoryEntity category = categoryRepository.findById(uuid).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        return category;
    }
}
