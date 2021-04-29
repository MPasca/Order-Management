package BLL.Validators;

import DataAccess.ProductDAO;
import Model.Order;
import Model.Product;

import java.util.NoSuchElementException;

/**
 * The type Product id validator.
 */
public class ProductIDValidator implements Validator<Order>{
    /**
     * The Product dao.
     */
    ProductDAO productDAO = new ProductDAO();
    @Override
    public void validate(Order order) {
        Product product = productDAO.findById(order.getProductID());
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + order.getProductID());
        }
    }
}
