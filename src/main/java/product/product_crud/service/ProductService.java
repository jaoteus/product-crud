package product.product_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.entity.ProductEntity;
import product.product_crud.exception.CategoryIsAlreadyInTheProductException;
import product.product_crud.exception.CategoryNotFoundOnThisProductException;
import product.product_crud.exception.ProductNotFoundException;
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

    // TODO: Checar se esta funcionalidade está funcionando corretamente
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

    // TODO: Implementar a funcionalidade para remover uma categoria de um produto
    public void removeCategoryFromTheProduct(ProductEntity product, CategoryEntity category) {
        for (CategoryEntity i : product.getCategories()) {
            if (category != i) {
                throw new CategoryNotFoundOnThisProductException("category not found on the product");
            }
        }
        product.getCategories().remove(category);
        productRepository.save(product);
    }
}
