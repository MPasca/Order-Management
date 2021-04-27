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
    public ProductBLL() {
        quantityValidator = new QuantityValidator();
        priceValidator = new PriceValidator();
    }

    public Product findProductByID(int id){
        Product product = ProductDAO.findProduct(id);
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + id);
        }
        return product;
    }

    public List<Product> findProductByName(String name){
        List<Product> fetchedProducts = ProductDAO.findProduct(name);
        if(fetchedProducts == null){
            throw new NoSuchElementException("There is no product named: " + name);
        }
        return fetchedProducts;
    }

    public int insertProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return ProductDAO.insertProduct(product);
    }

    public int updateProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return ProductDAO.updateProduct(product);
    }

    public int deleteProduct(Product product){
        return ProductDAO.deleteProduct(product);
    }

    public List<Product> showAllProduct(){
        return ProductDAO.showAllProducts();
    }
}
