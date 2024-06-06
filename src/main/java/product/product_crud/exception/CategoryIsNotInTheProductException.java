package product.product_crud.exception;

public class CategoryIsNotInTheProductException extends RuntimeException {

    public CategoryIsNotInTheProductException(String message) {
        super(message);
    }
}
