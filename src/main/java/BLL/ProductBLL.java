package BLL;

import BLL.Validators.PriceValidator;
import BLL.Validators.QuantityValidator;
import BLL.Validators.Validator;
import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    QuantityValidator quantityValidator;
    PriceValidator priceValidator;
    ProductDAO productDAO = new ProductDAO();

    public ProductBLL() {
        quantityValidator = new QuantityValidator();
        priceValidator = new PriceValidator();
    }

    public Product findProductByID(int id){
        Product product = productDAO.findById(id);
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + id);
        }
        return product;
    }

    public int insertProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return productDAO.insert(product);
    }

    public int updateProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return productDAO.update(product);
    }

    public int deleteProduct(int productId){
        return productDAO.delete(productId);
    }

    public List<Product> showAllProducts(){
        return productDAO.findAll();
    }

}
