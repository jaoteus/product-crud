package product.product_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    // TODO: checar se todas as funcionalidades estão funcionando corretamente

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAll() {
        List<CategoryEntity> categories = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{categoryUUID}")
    public ResponseEntity<CategoryEntity> getOne(@PathVariable UUID categoryUUID) {
        CategoryEntity category = categoryService.findOne(categoryUUID);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }
}
