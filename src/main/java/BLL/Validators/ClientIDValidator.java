package BLL.Validators;

import DataAccess.ClientDAO;
import Model.Client;
import Model.Order;

import java.util.NoSuchElementException;

public class ClientIDValidator implements Validator<Order> {
    ClientDAO clientDAO = new ClientDAO();
    @Override
    public void validate(Order order) {
        Client client = clientDAO.findById(order.getClientID());
        if (client == null){
            throw new NoSuchElementException("There is no client with id = " + order.getClientID());
        }
    }
}
