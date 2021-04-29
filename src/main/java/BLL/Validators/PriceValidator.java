package BLL.Validators;

import Model.Product;

/**
 * The type Price validator.
 */
public class PriceValidator implements Validator<Product> {

    @Override
    public void validate(Product product) {
        if(product.getPrice() < 0){
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }
}
