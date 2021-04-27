package DataAccess;

import Model.Client;
import Model.Order;
import Connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO orders (clientId, productId, quantity)"
                                                            + " VALUES (?,?,?)";
    private static final String updateStatementString = "UPDATE orders SET clientId = ?, "
                                                            + "productId = ?, "
                                                            + "quantity = ? "
                                                            + "WHERE id = ?";
    private static final String deleteStatementString = "DELETE FROM clients"
                                                            + " WHERE id=?";
    private static final String showStatementString = "SELECT * FROM orders";

    private static final String findStatementStringID = "Select * FROM orders WHERE id=?";

    private static final String findStatementStringClient = "Select * FROM orders WHERE clientId=?";

    private static final String findStatementStringProduct = "Select * FROM orders WHERE productId=?";

    public static Order findbyId(int orderID){
        Order toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringID);
            findStatement.setInt(1, orderID);
            rs = findStatement.executeQuery();
            rs.next();

            int clientId = rs.getInt("clientId");
            int productId = rs.getInt("productId");
            int quantity = rs.getInt("quantity");

            toReturn = new Order(clientId, productId, quantity);
            toReturn.setId(orderID);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static Order findByClient(int clientID){
        Order toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringClient);
            findStatement.setInt(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            int orderId = rs.getInt("id");
            int productId = rs.getInt("productId");
            int quantity = rs.getInt("quantity");

            toReturn = new Order(clientID, productId, quantity);
            toReturn.setId(orderId);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static Order findByProduct(int productID){
        Order toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringProduct);
            findStatement.setInt(1, productID);
            rs = findStatement.executeQuery();
            rs.next();

            int orderID = rs.getInt("id");
            int clientID = rs.getInt("productId");
            int quantity = rs.getInt("quantity");

            toReturn = new Order(productID, clientID, quantity);
            toReturn.setId(orderID);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findByProductId " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static int insertOrder(Order order){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;

        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, order.getClientID());
            insertStatement.setInt(2, order.getProductID());
            insertStatement.setInt(3, order.getQuantity());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                order.setId(insertedId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static int updateOrder(Order order){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, order.getClientID());
            updateStatement.setInt(2, order.getProductID());
            updateStatement.setInt(3, order.getQuantity());
            updateStatement.setInt(4, order.getId());
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }

        return order.getId();
    }

    public static int deleteOrder(Order order){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, order.getId());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

        return order.getId();
    }

    public static List<Order> showAllOrders(){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement showStatement = null;
        ResultSet rs = null;

        List<Order> fetchedOrders = new ArrayList<>();

        try {
            showStatement = dbConnection.prepareStatement(showStatementString, Statement.RETURN_GENERATED_KEYS);
            rs = showStatement.executeQuery();

            while(rs.next()){       // while it finds rows
                fetchedOrders.add(new Order(rs.getInt("id"),
                                    rs.getInt("clientId"),
                                    rs.getInt("productId"),
                                    rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(showStatement);
            ConnectionFactory.close(dbConnection);
        }


        return fetchedOrders;
    }
}
