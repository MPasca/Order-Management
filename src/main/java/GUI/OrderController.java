package GUI;


import BLL.*;
import Model.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Order controller.
 */
public class OrderController {
    /**
     * The Order view.
     */
    OrderView orderView;
    /**
     * The Order bll.
     */
    OrderBLL orderBLL = new OrderBLL();

    /**
     * Instantiates a new Order controller.
     *
     * @param orderView the order view
     */
    public OrderController(OrderView orderView){
        this.orderView = orderView;
        this.orderView.btnAdd.addActionListener(new AddListener());
        this.orderView.btnRemove.addActionListener(new DeleteListener());
        this.orderView.btnUpdate.addActionListener(new UpdateListener());
    }

    /**
     * Add order.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void addOrder() throws ExceptionIncorrectInput{
        if(orderView.cmbClients.getSelectedItem().equals("")){
            throw new ExceptionIncorrectInput(orderView.panelAdd, "orderView", "orderClientId");
        }
        int orderClientId = (int) orderView.cmbClients.getSelectedItem();

        if(orderView.cmbProducts.getSelectedItem().equals("")){
            throw new ExceptionIncorrectInput(orderView.panelAdd, "orderView", "orderProductId");
        }
        int orderProductId = (int) orderView.cmbProducts.getSelectedItem();

        if(orderView.txtAddQuantity.getText().isEmpty()){
            throw new ExceptionIncorrectInput(orderView.panelAdd,"orderView", "orderQuantity");
        }
        int orderQuantity = Integer.parseInt(orderView.txtAddQuantity.getText());

        Order newOrder = new Order(orderClientId, orderProductId, orderQuantity);
        int orderId = orderBLL.insertOrder(newOrder);

        JOptionPane.showMessageDialog(orderView.panelAdd, "The order with id: " + orderId + " has been added to the DataBase.");
    }

    /**
     * Generate combo boxes.
     */
    public void generateComboBoxes(){
        orderView.cmbClients.removeAllItems();
        ClientBLL clientBLL = new ClientBLL();
        List<Client> clientList = clientBLL.showAllClients();
        for(Client c: clientList){
            orderView.cmbClients.addItem(c.getID());
        }

        orderView.cmbProducts.removeAllItems();
        ProductBLL productBLL = new ProductBLL();
        List<Product> productList = productBLL.showAllProducts();
        for(Product p: productList){
            orderView.cmbProducts.addItem(p.getId());
        }
    }

    /**
     * The type Add listener.
     */
    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try {
                addOrder();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Delete order.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void deleteOrder() throws ExceptionIncorrectInput{
        if(orderView.txtRemoveSearchClientId.getText().isEmpty()){
            if(orderView.txtRemoveSearchID.getText().isEmpty()){
                throw new ExceptionIncorrectInput(orderView.panelRemove, "orderView", "removeSearchID");
            }
            int idToDelete = Integer.parseInt(orderView.txtRemoveSearchID.getText());
            JOptionPane.showMessageDialog(orderView.panelRemove, "The order with id: " + orderBLL.deleteOrder(idToDelete) + " has been successfully deleted.");
        }
    }

    /**
     * The type Delete listener.
     */
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deleteOrder();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Update order.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void updateOrder() throws ExceptionIncorrectInput{
        if(orderView.txtUpdateClientID.getText().isEmpty()){
            throw new ExceptionIncorrectInput(orderView.panelEdit, "orderView", "updateClientID");
        }
        if(orderView.txtUpdateQuantity.getText().isEmpty()){
            throw new ExceptionIncorrectInput(orderView.panelEdit, "orderView", "updateQuantity");
        }
        if(orderView.txtUpdateProductID.getText().isEmpty()){
            throw new ExceptionIncorrectInput(orderView.panelEdit, "orderView", "updateProductID");
        }
        if(orderView.txtUpdateID.getText().isEmpty()){
            throw new ExceptionIncorrectInput(orderView.panelEdit, "orderView", "updateID");
        }

        int clientID = Integer.parseInt(orderView.txtUpdateClientID.getText());
        int quantity = Integer.parseInt(orderView.txtUpdateQuantity.getText());
        int productID = Integer.parseInt(orderView.txtUpdateProductID.getText());
        int id = Integer.parseInt(orderView.txtUpdateID.getText());

        Order toUpdate = new Order(id, clientID, productID, quantity);
        JOptionPane.showMessageDialog(orderView.panelEdit, "The order with id: " + orderBLL.updateOrder(toUpdate) + " has been successfully updated.");
    }


    /**
     * The type Update listener.
     */
    class UpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                updateOrder();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Show all.
     */
    public void showAll(){
        String orderColumns[] = {"ID", "ClientId", "ProductId", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(orderColumns, 0);
        orderView.tableOrders.setModel(model);

        List<Order> allOrders = orderBLL.showAllOrders();
        model.addRow(orderColumns);
        for(Order o: allOrders){
            String[] currentOrder = {Integer.toString(o.getId()), Integer.toString(o.getClientID()), Integer.toString(o.getProductID()), Integer.toString(o.getQuantity())};
            model.addRow(currentOrder);
        }

        orderView.tableOrders.setBounds(20, 20, 400, 300);
        orderView.tableOrders.setBackground(orderView.element.colours.get(5));
        orderView.tableOrders.setFont(orderView.element.fonts.get(5));
        JScrollPane scrollPane = new JScrollPane(orderView.tableOrders);
        orderView.orderFrame.add(scrollPane);
    }

}
