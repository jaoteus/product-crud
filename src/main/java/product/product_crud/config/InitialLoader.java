package product.product_crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.entity.ProductEntity;
import product.product_crud.repository.CategoryRepository;
import product.product_crud.repository.ProductRepository;
import product.product_crud.service.CategoryService;
import product.product_crud.service.ProductService;

@Configuration
public class InitialLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
//    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    @Override
    public void run(String... args) throws Exception {
        CategoryEntity category1 = new CategoryEntity(null, "Computers");
        CategoryEntity category2 = new CategoryEntity(null, "Eletronics");
        categoryRepository.save(category1);
        categoryRepository.save(category2);

        ProductEntity product1 = new ProductEntity(null, 4590.00, "Dell Inspiron 5000");

        productRepository.save(product1);

//        product1.getCategories().add(category1);

        productService.addCategoryToTheProduct(product1, category1);
        productService.addCategoryToTheProduct(product1, category2);

        productRepository.save(product1);
    }
}
