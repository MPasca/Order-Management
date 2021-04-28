package DataAccess;

import Model.Product;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    private static final String insertStatementString = "INSERT INTO products (name, quantity, price)"
                                                            + " VALUES (?,?,?)";
    private static final String updateStatementString = "UPDATE products SET name = ?, "
                                                            + " quantity = ?, "
                                                            + " price = ? "
                                                            + " WHERE id = ?";
    private static final String deleteStatementString = "DELETE FROM products"
                                                            + " WHERE id=?";
    private static final String showStatementString = "SELECT * FROM products";
    private static final String findStatementStringID = "Select * FROM products WHERE id=?";
    private static final String findStatementStringNAME = "Select * FROM products WHERE name=?";

    public static Product findProduct(int productId){
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findStatementStringID);
            findStatement.setInt(1, productId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            float price = rs.getFloat("price");
            toReturn = new Product(name, quantity, price);
            toReturn.setId(productId);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static List<Product> findProduct(String productName){
        List<Product> fetchedProducts = new ArrayList<>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findStatementStringNAME);
            findStatement.setString(1, productName);
            rs = findStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                float price = rs.getFloat("price");
                fetchedProducts.add(new Product(id, productName, quantity, price));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return fetchedProducts;
    }

    public static int insertProduct(Product product){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;

        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, product.getName());
            insertStatement.setInt(2, product.getQuantity());
            insertStatement.setFloat(3, product.getPrice());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                product.setId(insertedId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static int updateProduct(Product product){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, product.getName());
            updateStatement.setInt(2, product.getQuantity());
            updateStatement.setFloat(3, product.getPrice());
            updateStatement.setInt(4, product.getId());
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }

        return product.getId();
    }

    public static int deleteProduct(int productId){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            System.out.println("product id: " + productId);
            deleteStatement.setInt(1, productId);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

        return productId;
    }

    public static List<Product> showAllProducts(){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement showStatement = null;
        ResultSet rs = null;

        List<Product> fetchedProducts = new ArrayList<>();

        try {
            showStatement = dbConnection.prepareStatement(showStatementString, Statement.RETURN_GENERATED_KEYS);
            rs = showStatement.executeQuery();

            while(rs.next()){       // while it finds rows
                fetchedProducts.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getFloat("price")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(showStatement);
            ConnectionFactory.close(dbConnection);
        }

        return fetchedProducts;
    }
}
