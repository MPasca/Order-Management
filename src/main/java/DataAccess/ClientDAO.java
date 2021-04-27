package DataAccess;

import Model.Client;
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

public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO clients (name, email, address, telephone)"
                                                            + " VALUES (?,?,?,?)";
    private static final String updateStatementString = "UPDATE clients SET name = ?, "
                                                            + "email = ?, "
                                                            + "address = ?, "
                                                            + "telephone = ? "
                                                            + "WHERE id = ?";
    private static final String deleteStatementString = "DELETE FROM clients"
                                                            + " WHERE id=?";
    private static final String showStatementString = "SELECT * FROM clients";

    private static final String findStatementStringID = "Select * FROM clients WHERE id=?";

    private static final String findStatementStringNAME = "Select * FROM clients WHERE name=?";

    public static Client find(int clientID){
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringID);
            findStatement.setInt(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            toReturn = new Client(name, address, email, telephone);
            toReturn.setId(clientID);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static List<Client> find(String clientName){
        List<Client> toReturn = new ArrayList<>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringNAME);
            findStatement.setString(1, clientName);
            rs = findStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                toReturn.add(new Client(id, clientName, address, email, telephone));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static int insertClient(Client client){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;

        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, client.getName());
            insertStatement.setString(2, client.getEmail());
            insertStatement.setString(3, client.getAddress());
            insertStatement.setString(4, client.getTelephone());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                client.setId(insertedId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static int updateClient(Client client){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, client.getName());
            updateStatement.setString(2, client.getEmail());
            updateStatement.setString(3, client.getAddress());
            updateStatement.setString(4, client.getTelephone());
            updateStatement.setInt(5, client.getID());
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }

        return client.getID();
    }

    public static int deleteClient(Client client){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, client.getID());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

        return client.getID();
    }

    public static List<Client> showAllClients(){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement showStatement = null;
        ResultSet rs = null;

        List<Client> fetchedClients = new ArrayList<>();

        try {
            showStatement = dbConnection.prepareStatement(showStatementString, Statement.RETURN_GENERATED_KEYS);
            rs = showStatement.executeQuery();

            while(rs.next()){       // while it finds rows
                fetchedClients.add(new Client(rs.getInt("id"),
                                      rs.getString("name"),
                                      rs.getString("email"),
                                      rs.getString("address"),
                                      rs.getString("telephone")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(showStatement);
            ConnectionFactory.close(dbConnection);
        }


        return fetchedClients;
    }
}
