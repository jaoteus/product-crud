package product.product_crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.product_crud.entity.ProductEntity;
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

    // TODO: Checar se todos estão funcionando

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

    @GetMapping("/{productUuid}")
    public ResponseEntity<ProductEntity> getOne(@PathVariable UUID productUuid) {
        ProductEntity product = productService.findOne(productUuid);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> insert(@Valid @RequestBody
                                                ProductEntity productToInsert) {
        productService.insertOne(productToInsert);
        return ResponseEntity.status(HttpStatus.CREATED).body(productToInsert);
    }

    @PutMapping("/{productUuid}")
    public ResponseEntity<ProductEntity> update(@PathVariable UUID uuid,
                                                @Valid @RequestBody
                                                ProductEntity productToUpdate) {
        productService.updateOne(uuid, productToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(productToUpdate);
    }

    @DeleteMapping("/{productUuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        productService.deleteOne(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    // TODO: Implementar endpoints para adicionar e remover categoria de um produto
//    @PostMapping("/{productUUID}/categories/{categoryUUID}")

}
