package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

public class AbstractDAO<T>{
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    public AbstractDAO(){
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery(String field){
        return "SELECT * FROM `" + type.getSimpleName() + "` WHERE " + field + "=?";
    }

    public List<T> findAll(){
        String findAllQuery = "SELECT * FROM `" + type.getSimpleName() + "`";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(findAllQuery);
            resultSet = statement.executeQuery();

            List<T> fetchedElements = createObjects(resultSet);
            return fetchedElements;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    public T findById(int id){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String findByIdQuery = createSelectQuery("id");
        try {
            statement = connection.prepareStatement(findByIdQuery);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();

        try {
            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IntrospectionException | SQLException | InvocationTargetException | IllegalArgumentException | SecurityException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;

        String insertQuery = "INSERT INTO `" + type.getSimpleName() + "`";      // INSERT INTO ...
        StringBuilder insertColumns = new StringBuilder();                                               // (col1, col2, ...)
        StringBuilder insertValuesQuery = new StringBuilder();                                          // (?, ?, ...)

        List<Object> values = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();

        int insertedId = -1;
        try {
            for(Field field: fields){
                Object value = field.get(t);
                if(field.getName().equals("id")){
                    continue;
                }
                insertColumns.append(field.getName()).append(", ");
                insertValuesQuery.append("?, ");
                values.add(value);
            }

            insertColumns.replace(insertColumns.length() - 2, insertColumns.length() - 1, "");             // to get rid of the last comma
            insertValuesQuery.replace(insertValuesQuery.length() - 2, insertValuesQuery.length() - 1, ""); // to also get rid of the last comma

            insertQuery += "( " + insertColumns.toString() + ") VALUES (" + insertValuesQuery.toString() + ")";
            System.out.println(insertQuery);
            insertStatement = dbConnection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            for(int i = 0; i < values.size(); i++){
                insertStatement.setObject(i + 1, values.get(i));
            }

            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public int update(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        StringBuilder updateQuery = new StringBuilder("UPDATE `" +type.getSimpleName() + "` SET ");
        Field[] fields = t.getClass().getDeclaredFields();
        List<Object> valuesToUpdate = new ArrayList<>();
        int updatedId = -1;
        try{
            for(Field field : fields){
                Object value = field.get(t);
                if(field.getName().equals("id")){
                    updatedId = (int) value;
                }else{
                    updateQuery.append(field.getName()).append(" = ?, ");
                    valuesToUpdate.add(value);
                }
            }

            if(valuesToUpdate.isEmpty() || updatedId == -1){
                throw new IllegalArgumentException("Invalid id or no data found.");
            }

            updateQuery.replace(updateQuery.length() - 2, updateQuery.length() -1, " ");
            updateQuery.append("WHERE id = ?");
            valuesToUpdate.add(updatedId);

            updateStatement = dbConnection.prepareStatement(updateQuery.toString());
            for(int i = 0; i < valuesToUpdate.size(); i++){
                updateStatement.setObject(i+1 ,valuesToUpdate.get(i));
            }
            updateStatement.executeUpdate();
        } catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return updatedId;
    }

    public int delete(int toDeleteID){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        StringBuilder deleteQuery = new StringBuilder("DELETE FROM `" + type.getSimpleName().toString() + "` WHERE id=?");

        try {
            deleteStatement = dbConnection.prepareStatement(deleteQuery.toString());
            deleteStatement.setInt(1, toDeleteID);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toDeleteID;
    }
}
