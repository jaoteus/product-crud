package product.product_crud.exception;

public class ProductWithNoCategoryException extends RuntimeException {

    public ProductWithNoCategoryException(String message) {
        super(message);
    }
}
