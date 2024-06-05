package product.product_crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import product.product_crud.entity.CategoryEntity;
import product.product_crud.entity.ProductEntity;
import product.product_crud.repository.CategoryRepository;
import product.product_crud.repository.ProductRepository;
import product.product_crud.service.ProductService;

import java.util.Arrays;

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
        CategoryEntity category3 = new CategoryEntity(null, "TV");
        CategoryEntity category4 = new CategoryEntity(null, "Health");
        CategoryEntity category5 = new CategoryEntity(null, "Books");
        CategoryEntity category6 = new CategoryEntity(null, "Movies");
        CategoryEntity category7 = new CategoryEntity(null, "Science");

        categoryRepository.saveAll(
                Arrays.asList(
                        category1,
                        category2,
                        category3,
                        category4,
                        category5,
                        category6,
                        category7
                )
        );

        ProductEntity product1 = new ProductEntity(null, 4590.00, "Dell Inspiron 5000");
        ProductEntity product2 = new ProductEntity(null, 33.15, "Divertidamente 2");
        ProductEntity product3 = new ProductEntity(null, 4567.00, "SmartTV SmarTech");
        ProductEntity product4 = new ProductEntity(null, 230.00, "Clean Code");
        ProductEntity product5 = new ProductEntity(null, 15.00, "Vitamina C");
        ProductEntity product6 =  new ProductEntity(null, 0d, "Interestelar");

        productRepository.saveAll(
                Arrays.asList(
                        product1,
                        product2,
                        product3,
                        product4,
                        product5,
                        product6
                )
        );

        productService.addCategoryToTheProduct(product1, Arrays.asList(category1, category2)
                .toArray(new CategoryEntity[0]));

        productService.addCategoryToTheProduct(product2, Arrays.asList(category6)
                .toArray(new CategoryEntity[0]));

        productService.addCategoryToTheProduct(product3, Arrays.asList(category3, category2)
                .toArray(new CategoryEntity[0]));

        productService.addCategoryToTheProduct(product4, Arrays.asList(category5)
                .toArray(new CategoryEntity[0]));

        productService.addCategoryToTheProduct(product5, Arrays.asList(category4)
                .toArray(new CategoryEntity[0]));

        productService.addCategoryToTheProduct(product6, Arrays.asList(category6, category7)
                .toArray(new CategoryEntity[0]));

        productRepository.saveAll(
                Arrays.asList(
                        product1,
                        product2,
                        product3,
                        product4,
                        product5,
                        product6
                )
        );
    }
}
