package BLL;

import BLL.Validators.PriceValidator;
import BLL.Validators.QuantityValidator;
import BLL.Validators.Validator;
import DataAccess.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Product bll.
 */
public class ProductBLL {
    /**
     * The Quantity validator.
     */
    QuantityValidator quantityValidator;
    /**
     * The Price validator.
     */
    PriceValidator priceValidator;
    /**
     * The Product dao.
     */
    ProductDAO productDAO = new ProductDAO();

    /**
     * Instantiates a new Product bll.
     */
    public ProductBLL() {
        quantityValidator = new QuantityValidator();
        priceValidator = new PriceValidator();
    }

    /**
     * Find product by id product.
     *
     * @param id the id
     * @return product product
     */
    public Product findProductByID(int id){
        Product product = productDAO.findById(id);
        if(product == null){
            throw new NoSuchElementException("There is no product with id = " + id);
        }
        return product;
    }

    /**
     * Insert product int.
     *
     * @param product the product
     * @return int int
     */
    public int insertProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return productDAO.insert(product);
    }

    /**
     * Update product int.
     *
     * @param product the product
     * @return int int
     */
    public int updateProduct(Product product){
        quantityValidator.validate(product);
        priceValidator.validate(product);

        return productDAO.update(product);
    }

    /**
     * Delete product int.
     *
     * @param productId the product id
     * @return int int
     */
    public int deleteProduct(int productId){
        return productDAO.delete(productId);
    }

    /**
     * Show all products list.
     *
     * @return list list
     */
    public List<Product> showAllProducts(){
        return productDAO.findAll();
    }

}
