package BLL.Validators;

import DataAccess.ProductDAO;
import Model.Order;
import Model.Product;

import java.util.NoSuchElementException;

public class ProductIDValidator implements Validator<Order>{
    ProductDAO productDAO = new ProductDAO();
    @Override
    public void validate(Order order) {
        Product product = productDAO.findById(order.getProductID());
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + order.getProductID());
        }
    }
}
