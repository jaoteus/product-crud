package product.product_crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.product_crud.entity.ProductEntity;
import product.product_crud.service.CategoryService;
import product.product_crud.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> responseTest = new HashMap<String, String>();
        responseTest.put("message", "Hello world!");
        return ResponseEntity.status(HttpStatus.OK).body(responseTest);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getALlProducts() {
        List<ProductEntity> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{productUUID}")
    public ResponseEntity<ProductEntity> getOne(@PathVariable UUID productUUID) {
        ProductEntity product = productService.findOne(productUUID);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody
                                                ProductEntity productToInsert) {
        productService.insertOne(productToInsert);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{productUUID}")
    public ResponseEntity<Void> update(@PathVariable UUID productUUID,
                                                @Valid @RequestBody
                                                ProductEntity productToUpdate) {
        productService.updateOne(productUUID, productToUpdate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{productUUID}")
    public ResponseEntity<Void> delete(@PathVariable UUID productUUID) {
        productService.deleteOne(productUUID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // TODO: Implementar endpoint para adicionar uma categoria em um produto
    // TODO: Implementar endpoint para remover categoria de um produto
    // TODO: Checar se as novas funcionalidades estão funcionando corretamente
    @PostMapping("/{productUUID}/categories/{categoryUUID}")
    public ResponseEntity<Void> addCategotyToTheProduct(@PathVariable UUID productUUID,
                                                        @PathVariable UUID categoryUUID) {
        productService.addCategoryToTheProduct(productUUID, categoryUUID);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{productUUID}/categories/{categoryUUID}")
    public ResponseEntity<Void> removeCategoryFromTheProduct(@PathVariable UUID productUUID,
                                                             @PathVariable UUID categoryUUID) {
        productService.removeCategoryFromTheProduct(productService.findOne(productUUID), categoryService.findOne(categoryUUID));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
