package product.product_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.entity.ProductEntity;
import product.product_crud.exception.CategoryIsAlreadyInTheProductException;
import product.product_crud.exception.CategoryNotFoundOnThisProductException;
import product.product_crud.exception.ProductNotFoundException;
import product.product_crud.exception.ProductWithNoCategoryException;
import product.product_crud.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ProductEntity> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        return products;
    }

    public ProductEntity findOne(UUID uuid) {
        ProductEntity product = productRepository.findById(uuid).orElseThrow(() -> new ProductNotFoundException("Product not found with uuid " + uuid));
        return product;
    }

    public ProductEntity insertOne(ProductEntity product) {
        productRepository.save(product);
        return product;
    }

    public ProductEntity updateOne(UUID uuid, ProductEntity product) {
        ProductEntity productToUpdate = findOne(uuid);
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productRepository.save(productToUpdate);
        return productToUpdate;
    }

    public void deleteOne(UUID uuid) {
        ProductEntity productToDelete = findOne(uuid);
        productRepository.delete(productToDelete);
    }

    public void addCategoryToTheProduct(UUID productUUID, UUID categoryUUID) {
        ProductEntity product = findOne(productUUID);
        CategoryEntity category = categoryService.findOne(categoryUUID);

        for (CategoryEntity i : product.getCategories()) {
            if (i == category) {
                throw new CategoryIsAlreadyInTheProductException("this category is already in the product");
            }
        }
        product.getCategories().add(category);
        productRepository.save(product);
    }

    // TODO: Fazer testes para saber se este endpoint está funcionando
    // TODO: Testar as exceções
    public void removeCategoryFromTheProduct(UUID productUUID, UUID categoryUUID) {
        ProductEntity product = findOne(productUUID);
        CategoryEntity category = categoryService.findOne(categoryUUID);

        if (product.getCategories().isEmpty()) {
            throw new ProductWithNoCategoryException("This product has no category yet");
        }

        for (int i = 0; i < product.getCategories().size(); i++) {
            if (product.getCategories().contains(category)) {
                product.getCategories().remove(category);
                productRepository.save(product);
                System.out.println("possui categoria: linha 78");
            } else {
                throw new CategoryNotFoundOnThisProductException("category not found on the product");
            }
        }
    }
}
