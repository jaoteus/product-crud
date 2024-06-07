package product.product_crud.exception;

public class CategoryNotFoundOnThisProductException extends RuntimeException {

    public CategoryNotFoundOnThisProductException(String message) {
        super(message);
    }
}
