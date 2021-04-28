package BLL;

import BLL.Validators.ClientIDValidator;
import BLL.Validators.ProductIDValidator;
import BLL.Validators.QuantityValidator;
import BLL.Validators.Validator;
import DataAccess.OrderDAO;
import Model.Client;
import Model.Order;
import Model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        int orderID = OrderDAO.insertOrder(order);
        order.setId(orderID);
        try {
            printReceipt(order, orderID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderID;
    }

    FileWriter receipt;

    private void printReceipt(Order order, int orderID) throws IOException{
        receipt = new FileWriter("Receipt_" + orderID + ".txt");
        ClientBLL clientBLL = new ClientBLL();
        Client orderingClient = clientBLL.findClientByID(order.getClientID());

        ProductBLL productBLL = new ProductBLL();
        Product orderedProduct = productBLL.findProductByID(order.getProductID());
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        receipt.write("DATE: " + date.format(LocalDateTime.now()) + "\n");
        receipt.write("\n");

        receipt.write("Order " + order.getId());
        receipt.write(" _________________ ");
        receipt.write("ClientID: " + order.getClientID() + "\n");
        receipt.write("\t Name: " + orderingClient.getName() + "\n");
        receipt.write("\t Email: " + orderingClient.getEmail() + "\n");
        receipt.write("\t Address: " + orderingClient.getAddress() +  "\n");
        receipt.write("\t Telephone: " + orderingClient.getTelephone() +"\n");
        receipt.write("\n");

        receipt.write("Bought:\n");
        receipt.write(order.getProductID() + " _______________________ x" + order.getQuantity() + "\n");
        receipt.write(orderedProduct.getName() + " _____________ " + orderedProduct.getPrice() + "\n");
        receipt.write("\n");
        receipt.write("_________________________________________\n");
        receipt.write("TOTAL: " + order.getQuantity() * orderedProduct.getPrice() + "\n");
        receipt.close();
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
