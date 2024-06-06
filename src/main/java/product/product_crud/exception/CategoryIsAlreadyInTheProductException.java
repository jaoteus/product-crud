package product.product_crud.exception;

public class CategoryIsAlreadyInTheProductException  extends  RuntimeException {

    public CategoryIsAlreadyInTheProductException(String message) {
        super(message);
    }
}
