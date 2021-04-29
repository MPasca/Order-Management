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

/**
 * The type Order bll.
 */
public class OrderBLL {
    private List<Validator<Order>> validators;
    /**
     * The Order dao.
     */
    OrderDAO orderDAO = new OrderDAO();

    /**
     * Instantiates a new Order bll.
     */
    public OrderBLL(){
        validators = new ArrayList<Validator<Order>>();
        validators.add(new ClientIDValidator());
        validators.add(new ProductIDValidator());
    }

    /**
     * Find order by id order.
     *
     * @param id the id
     * @return order order
     */
    public Order findOrderByID(int id){
        Order order = orderDAO.findById(id);
        if(order == null){
            throw new NoSuchElementException("There is no order with id = " + id);
        }

        return order;
    }

    /**
     * Insert order int.
     *
     * @param order the order
     * @return int int
     */
    public int insertOrder(Order order){
        for(Validator<Order> v : validators){
            v.validate(order);
        }

        QuantityValidator quantityValidator = new QuantityValidator();
        quantityValidator.validate(order);

        int orderID = orderDAO.insert(order);
        order.setId(orderID);
        try {
            printReceipt(order, orderID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderID;
    }

    /**
     * The Receipt.
     */
    FileWriter receipt;

    /**
     *
     * @param order
     * @param orderID
     * @throws IOException
     */
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

    /**
     * Update order int.
     *
     * @param order the order
     * @return int int
     */
    public int updateOrder(Order order){
        for(Validator<Order> v : validators){
            v.validate(order);
        }

        QuantityValidator quantityValidator = new QuantityValidator();
        quantityValidator.validate(order);

        return orderDAO.update(order);
    }

    /**
     * Delete order int.
     *
     * @param orderID the order id
     * @return int int
     */
    public int deleteOrder(int orderID){
        return orderDAO.delete(orderID);
    }

    /**
     * Show all orders list.
     *
     * @return list list
     */
    public List<Order> showAllOrders(){
        return orderDAO.findAll();
    }
}
