package product.product_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.product_crud.entity.ProductEntity;
import product.product_crud.exception.ProductNotFoundException;
import product.product_crud.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

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
}
