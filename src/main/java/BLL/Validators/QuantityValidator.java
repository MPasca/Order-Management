package BLL.Validators;

import BLL.ProductBLL;
import Model.Order;
import Model.Product;

/**
 * The type Quantity validator.
 */
public class QuantityValidator implements Validator<Object>{

    @Override
    public void validate(Object o) {
        if( o instanceof Product){
            Product product = (Product) o;
            if(product.getQuantity() < 0){
                throw new IllegalArgumentException("Quantity cannot be negative.");
            }
        } else if(o instanceof Order){
            Order order = (Order) o;
            if(order.getQuantity() < 0){
                throw new IllegalArgumentException("Quantity cannot be negative.");
            }

            ProductBLL productBLL = new ProductBLL();
            Product orderedProduct = productBLL.findProductByID(order.getProductID());

            if(orderedProduct.getQuantity() < order.getQuantity()){
                throw new ArithmeticException("The ordered quantity is bigger than the quantity in stock.");
            }

            orderedProduct.updateQuantity(order.getQuantity());
            productBLL.updateProduct(orderedProduct);
        }


    }
}
