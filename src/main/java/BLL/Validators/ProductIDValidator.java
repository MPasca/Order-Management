package BLL.Validators;

import DataAccess.ProductDAO;
import Model.Order;
import Model.Product;

import java.util.NoSuchElementException;

public class ProductIDValidator implements Validator<Order>{
    @Override
    public void validate(Order order) {
        Product product = ProductDAO.findProduct(order.getProductID());
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + order.getProductID());
        }
    }
}
