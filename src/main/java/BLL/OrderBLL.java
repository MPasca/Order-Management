package BLL;

import BLL.Validators.ClientIDValidator;
import BLL.Validators.ProductIDValidator;
import BLL.Validators.QuantityValidator;
import BLL.Validators.Validator;
import DataAccess.OrderDAO;
import Model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderBLL {
    private List<Validator<Order>> validators;

    public OrderBLL(){
        validators = new ArrayList<Validator<Order>>();
        validators.add(new ClientIDValidator());
        validators.add(new ProductIDValidator());
    }

    public Order findOrderByID(int id){
        Order order = OrderDAO.findbyId(id);
        if(order == null){
            throw new NoSuchElementException("There is no order with id = " + id);
        }

        return order;
    }

    public Order findOrderByClient(int clientID){
        Order order = OrderDAO.findByClient(clientID);
        if(order == null){
            throw new NoSuchElementException("Client " + clientID + " had no orders.");
        }

        return order;
    }

    public Order findOrderByProduct(int productID){
        Order order = OrderDAO.findByProduct(productID);
        if(order == null){
            throw new NoSuchElementException("No product " + productID + " has been ordered.");
        }

        return order;
    }

    public int insertOrder(Order order){
        for(Validator<Order> v : validators){
            v.validate(order);
        }

        QuantityValidator quantityValidator = new QuantityValidator();
        quantityValidator.validate(order);

        return OrderDAO.insertOrder(order);
    }

    public int updateOrder(Order order){
        for(Validator<Order> v : validators){
            v.validate(order);
        }

        QuantityValidator quantityValidator = new QuantityValidator();
        quantityValidator.validate(order);

        return OrderDAO.updateOrder(order);
    }

    public int deleteOrder(int orderID){
        return OrderDAO.deleteOrder(orderID);
    }

    public List<Order> showAllOrders(){
        return OrderDAO.showAllOrders();
    }
}
